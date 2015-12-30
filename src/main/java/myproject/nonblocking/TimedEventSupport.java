package myproject.nonblocking;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

public class TimedEventSupport {
	
	private static final Timer timer = new Timer();

	public static <T> CompletableFuture<T> delayedSuccess(int delay, T value) {
		CompletableFuture<T> future = new CompletableFuture<T>();
		TimerTask task = new TimerTask() {
			public void run() {
				future.complete(value);
			}
		};
		
		timer.schedule(task, delay * 1000);
		return future;
	}

	public static <T> CompletableFuture<T> delayedFailure(int delay, Throwable t) {
		CompletableFuture<T> future = new CompletableFuture<T>();
		TimerTask task = new TimerTask() {
			public void run() {
				future.completeExceptionally(t);
			}
		};
		
		timer.schedule(task, delay * 1000);
		return future;
	}
}
