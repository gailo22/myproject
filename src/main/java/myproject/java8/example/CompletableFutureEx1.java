package myproject.java8.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureEx1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future1 = CompletableFuture.completedFuture("Hello");
		System.out.println(future1.get());
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Hello");
		System.out.println(future2.get());
		
		CompletableFuture<String> future3 = future2.thenApply(s -> s + " World");
		System.out.println(future3.get());
		
		CompletableFuture<Void> future4 = future3.thenAccept(s -> System.out.println("Computation returned: " + s));
		System.out.println(future4.get());
		
		CompletableFuture<Void> future5 = future3.thenRun(() -> System.out.println("Computation finished."));
		System.out.println(future5.get());
		
		CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> "Hello")
		    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
		System.out.println(future6.get());
		
		CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future8 = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future9 = CompletableFuture.supplyAsync(() -> "World");

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future7, future8, future9);
		System.out.println(combinedFuture.get());
		
		if (future7.isDone()) {
			System.out.println("future7 is done");
		}
		
		String combinedFutures = Stream.of(future7, future8, future9)
				.map(CompletableFuture::join)
				.collect(Collectors.joining(" "));
		System.out.println(combinedFutures);
		
		combinedFuture.completeExceptionally(new RuntimeException("Calculation failed!"));
		
	}

}
