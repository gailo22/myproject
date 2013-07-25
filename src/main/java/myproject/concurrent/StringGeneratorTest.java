package myproject.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class StringGeneratorTest {

	public static void main(final String[] args) {

		//Create an array to store the future objects.
		final ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			//Create the instance of the Callable task
			final Callable<String> stringGenerator = new StringGenerator();

			//create the object of FutureTask
			final FutureTask<String> task = new FutureTask<String>(stringGenerator);

			//Add to the list
			results.add(task);

			//Create a thread object using the task object created
			final Thread t = new Thread(task);

			//Start the thread as usual
			t.start();

		}

		//Compute the results now.
		final StringBuilder resultStr = new StringBuilder();

		final long start = System.currentTimeMillis();

		for (final Future<String> result : results) {
			try {
				//The blocking get call
				resultStr.append(result.get());
				resultStr.append(" ");

			} catch (final InterruptedException e) {
				e.printStackTrace();
			} catch (final ExecutionException e) {
				e.printStackTrace();
			}
		}

		final long end = System.currentTimeMillis();

		System.out.println("The returned string is:\n" + resultStr);
		System.out.println("Execution time:" + (end - start));
	}
}
