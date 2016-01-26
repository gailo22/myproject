package myproject.search;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchMain {
	
	static String[] source = { "Hello World", "Hello Earth", "Goodbye", "Goodbye Mars", 
		                       "Good", "Bad", "good will hunting", "go daddy" };
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			doSearch(scanner.next());
		}
	}

	private static void doSearch(final String searchString) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		for (String sourceSting : source) {
			pool.submit(newTask(sourceSting, searchString));
		}
		
		pool.shutdown();
	}

	private static Runnable newTask(String sourceString, String searchString) {
		return new Runnable() {
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				if (sourceString.startsWith(searchString)) {
					System.out.println(threadName + ": " + sourceString);
				}
			}
		};
	}

}
