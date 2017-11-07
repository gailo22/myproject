package myproject.java8.async;

import java.util.concurrent.Callable;

import myproject.java8.async.BaseTask.FinishTask;
import myproject.java8.async.BaseTask.FutureTask;

public final class Parallelize {
	
	protected static final String missingFinishMsg = "A new task cannot be " +
	        "created at the top-level of your program. It must be created from " +
	        "within a finish or another async. Please ensure that all asyncs, " +
	        "actor sends, parallel loops, and other types of " +
	        "parallelism-creating constructs are not called at the top-level of " +
	        "your program.";

	private Parallelize() {}
	
	public static void finish(final Runnable runnable) {
		BaseTask currentTask = Runtime.currentTask();
		FinishTask newTask = new FinishTask(runnable);
		if (currentTask == null) {
			Runtime.submitTask(newTask);
		} else {
			newTask.compute();
		}
		newTask.awaitCompletion();
	}
	
	public static void async(final Runnable runnable) {
		FutureTask<Void> newTask = createFutureTask(runnable);
		newTask.fork();
	}
	
	private static FutureTask<Void> createFutureTask(Runnable runnable) {
		BaseTask currentTask = Runtime.currentTask();
		if (currentTask == null) {
			throw new IllegalStateException(missingFinishMsg);
		}
		return createFutureTask(() -> {
			runnable.run();
			return null;
		},
		true);
	}

	private static <R> FutureTask<R> createFutureTask(Callable<R> body, boolean rethrowException) {
		BaseTask currentTask = Runtime.currentTask();
		if (currentTask == null) {
			throw new IllegalStateException(missingFinishMsg);
		}
		return new FutureTask<>(body, currentTask.ief(), rethrowException);
	}

	public static void main(String[] args) {
		final int[] result = new int[1];
		finish(() -> {
			async(() -> {
				result[0] = 10;
			});
		});
		
		System.out.println(result[0]);
	}
}
