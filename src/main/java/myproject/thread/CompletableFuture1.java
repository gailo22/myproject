package myproject.thread;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

public class CompletableFuture1 {
	
	public static void main(String[] args) {
		CompletableFuture<BigInteger> future = new CompletableFuture<>();
		
		new Thread(() -> {
			BigInteger bi1 = new BigInteger("45435345345345345");
			BigInteger bi2 = new BigInteger("345345");
			
			future.complete(bi1.gcd(bi2));
		}).start();
		
		System.out.println("GCD: " + future.join());
	}

}
