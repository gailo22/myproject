package myproject.java8.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example1 {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Consumer<String> println = System.out::println;
		Consumer<String> doublePrintln = println.andThen(println);
		println.accept("hi");
		doublePrintln.accept("hello");
		
		Supplier<String> greeting = () -> "Greetings!!";
		System.out.println(greeting.get());
		
		Predicate<Integer> pred = x -> x == 42;
		System.out.println(pred.test(10));
		System.out.println(pred.test(42));
		
		Function<Integer, Integer> add1 = x -> x + 1;
		Function<Integer, Integer> add2 = add1.andThen(add1);
		System.out.println(add1.apply(1));
		System.out.println(add2.apply(1));
		
		Function<Integer, Function<Integer, Function<Integer, Integer>>> fn = x -> y -> z -> x + y + z;
		System.out.println(fn.apply(1).apply(2).apply(3));
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
	
	
}
