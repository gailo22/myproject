package myproject.primes;

import java.util.ArrayList;
import java.util.List;

public class Sieve {

	public static void main(String[] args) {
		List<Integer> primes = getPrimes(100);

		System.out.println(primes);
	}

	private static List<Integer> getPrimes(int limit) {
		List<Integer> localPrimes = new ArrayList<>();
		localPrimes.add(2);
		for (int i = 3; i <= limit; i++) {
			checkPrime(i, localPrimes);
		}
		return localPrimes;
	}

	private static void checkPrime(int candidate, List<Integer> primesList) {
		boolean isPrime = true;
		int s = primesList.size();
		for (int i = 0; i < s; i++) {
			Integer loopPrime = primesList.get(i);
			if (candidate % loopPrime.intValue() == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			primesList.add(candidate);
		}
	}
}
