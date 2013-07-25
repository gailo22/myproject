package myproject.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(final String[] args) throws Exception {
		final ExecutorService service = Executors.newFixedThreadPool(5);
		final List<Future<java.lang.String>> futureList = service.invokeAll(Arrays.asList(new Task1<String>(),
				new Task2<String>()));

		System.out.println(futureList.get(1).get());
		System.out.println(futureList.get(0).get());
	}

	private static class Task1<String> implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(1000 * 10);
			return (String) "1000 * 5";
		}

	}

	private static class Task2<String> implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(1000 * 2);
			final int i = 3;
			if (i == 3)
				throw new RuntimeException("Harami ");
			return (String) "1000 * 2";
		}

	}

}
