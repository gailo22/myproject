package myproject.java8.async;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BaseTask extends CountedCompleter<Void> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Fetch the immediately enclosing finish of a task.
	 */
	public abstract FinishTask ief();
	
	public static final class FinishTask extends BaseTask {

		private static final long serialVersionUID = 1L;
		
		protected static final AtomicLong TASK_COUNTER = new AtomicLong();
		
		private final Runnable runnable;
		
		private final CountDownLatch countDownLatch;
		
		private List<Throwable> exceptionList;
		
		public FinishTask(Runnable setRunnable) {
			super();
			this.runnable = setRunnable;
			this.countDownLatch = new CountDownLatch(1);
			this.exceptionList = null;
			TASK_COUNTER.incrementAndGet();
		}

		@Override
		public void compute() {
			Runtime.pushTask(this);
			try {
				runnable.run();
			} catch (Throwable th) {
				pushException(th);
			} finally {
				tryComplete();
				Runtime.popTask();
				awaitCompletion();
			}
		}

		@Override
		public void onCompletion(CountedCompleter<?> caller) {
			countDownLatch.countDown();
		}

		public void awaitCompletion() {
			try {
				countDownLatch.await();
			} catch (InterruptedException ex) {
				pushException(ex);
			}
			
			List<Throwable> finalExceptionList = exceptions();
			if (!finalExceptionList.isEmpty()) {
				if (finalExceptionList.size() == 1) {
					Throwable t = finalExceptionList.get(0);
					if (t instanceof Error) {
						throw (Error) t;
					} else if (t instanceof RuntimeException) {
						throw (RuntimeException) t;
					}
				}
				throw new MultiException(finalExceptionList);
			}
		}
		
		private List<Throwable> exceptions() {
			if (exceptionList == null) {
				return Collections.emptyList();
			}
			return exceptionList;
		}

		private void pushException(Throwable th) {
			synchronized (this) {
				this.exceptions().add(th);
			}
		}

		@Override
		public FinishTask ief() {
			return this;
		}
	}
	
	public static final class FutureTask<R> extends BaseTask {

		private static final long serialVersionUID = 1L;
		
		protected static final AtomicLong TASK_COUNTER = new AtomicLong();
		
		private final Runnable runnable;
		
		private final FinishTask immediatelyEnclosingFinish;
		
		private final AtomicBoolean cancellationFlag = new AtomicBoolean(false);
		
		private final CompletableFuture<R> completableFuture = 
			new CompletableFuture<R>() {

				@Override
				public boolean cancel(boolean mayInterruptIfRunning) {
					return cancellationFlag.compareAndSet(false, true)
					    && super.cancel(mayInterruptIfRunning);
				}
		};
		
		public FutureTask(Callable<R> setRunnable, 
				FinishTask setImmediatelyEnclosingFinish, 
				boolean rethrowException) {
			super();
			if (setImmediatelyEnclosingFinish == null) {
				throw new IllegalStateException("Async is not executing inside a finish!");
			}
			
			this.runnable = () -> {
				try {
					R result = setRunnable.call();
					completableFuture.complete(result);
				} catch (Exception ex) {
					completableFuture.completeExceptionally(ex);
					if (rethrowException) {
						if (ex instanceof RuntimeException) {
							throw (RuntimeException) ex;
						} else {
							throw new RuntimeException("Error in executing callable", ex);
						}
					}
				}
			};
			
			this.immediatelyEnclosingFinish = setImmediatelyEnclosingFinish;
			this.immediatelyEnclosingFinish.addToPendingCount(1);
			TASK_COUNTER.incrementAndGet();
		}

		@Override
		public void compute() {
			Runtime.pushTask(this);
			try {
				if (!cancellationFlag.get()) {
					runnable.run();
				}
			} catch (Throwable th) {
				immediatelyEnclosingFinish.pushException(th);
			} finally {
				immediatelyEnclosingFinish.tryComplete();
				Runtime.popTask();
			}
		}

		@Override
		public FinishTask ief() {
			return immediatelyEnclosingFinish;
		}
		
		public CompletableFuture<R> future() {
			return completableFuture;
		}
		
	}

}
