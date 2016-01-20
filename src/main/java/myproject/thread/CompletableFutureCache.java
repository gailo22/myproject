package myproject.thread;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureCache {

	private Map<String, Person> cache;

	public CompletableFuture<Person> get(String id) {
		try {
			Person cached = cache.get(id);
			if (cached != null) {
				return CompletableFuture.completedFuture(cached);
			}
			CompletableFuture<Person> future = new CompletableFuture<>();

//			databaseFetch(id, person -> {
//				cache.put(id, person);
//				future.complete(person);
//			});
			
			return future;
			
		} catch (Throwable e) {
			CompletableFuture<Person> future = new CompletableFuture<>();
			future.completeExceptionally(e);
			return future;
		}
	}

	private void databaseFetch(String id, Object object) {
		// TODO Auto-generated method stub
	}

	static class Person {
	}
}
