package myproject.concurrent;

import java.util.concurrent.Callable;

import static java.lang.Math.random;

public class StringGenerator implements Callable<String> {

	@Override
	public String call() throws Exception {
		final String[] allStrings = { "Apple", "Ball", "Cat", "Dog", "Elephant", "Flower", "Grape", "Horse", "Ink",
				"Joker" };
		final int index = (int) (random() * 100) / 10;

		//Let's wait for sometime
		Thread.sleep(1000);
		return allStrings[index];
	}
}
