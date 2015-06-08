package myproject.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {
		
		Stream.of("apple", "banana", "mango").forEach(x -> {
			System.out.println(x + "_x");
		});
		
		IntStream.of(1,2,3,4,5)
		         .forEach(System.out::println);
		
		IntStream.iterate(0, i -> i + 2)
		         .limit(100)
		         .forEach(System.out::println);
		
		IntStream.rangeClosed(1, 10)
		         .forEach(System.out::println);
		
		System.out.println("-------------");
		IntStream.rangeClosed(1, 4)
                 .flatMap(i -> IntStream.iterate(i, j -> i + j).limit(i))
		         .forEach(System.out::println);
	
	}

}
