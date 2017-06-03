package myproject.java8.concurrent;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Function;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class CompletableFutureEx1 {
	
	private static final ScheduledExecutorService scheduler =
	        Executors.newScheduledThreadPool(
	                1,
	                new ThreadFactoryBuilder()
	                        .setDaemon(true)
	                        .setNameFormat("failAfter-%d")
	                        .build());

	public static void main(String[] args) {

		CompletableFuture<String> responseFuture = 
			within(asyncCode(), Duration.ofSeconds(1));

		responseFuture
			.thenAccept(send())
			.exceptionally(throwable -> {
				System.out.println("Unrecoverable error: " + throwable);
				return null;
			});

	}

	private static <T> CompletableFuture<T> within(CompletableFuture<T> future, Duration duration) {
	    CompletableFuture<T> timeout = failAfter(duration);
	    return future.applyToEither(timeout, Function.identity());
	}

	private static <T> CompletableFuture<T> failAfter(Duration duration) {
	    CompletableFuture<T> promise = new CompletableFuture<>();
	    scheduler.schedule(() -> {
	        TimeoutException ex = new TimeoutException("Timeout after " + duration);
	        return promise.completeExceptionally(ex);
	    }, duration.toMillis(), TimeUnit.MILLISECONDS);
	    return promise;
	}
	
	private static Consumer<? super String> send() {
		return null;
	}

	private static CompletableFuture<String> asyncCode() {
		return null;
	}

}
