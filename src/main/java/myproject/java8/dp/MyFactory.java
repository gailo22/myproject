package myproject.java8.dp;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface Vehicle {}
class Car implements Vehicle {
	Car() {}
	Car(Color color) {}
}
class Moto implements Vehicle {
	Moto() {}
	Moto(Color color) {}
}
enum Color { RED, BLUE }

public class MyFactory {
	
	public static List<Vehicle> create5(Supplier<Vehicle> factory) {
		return IntStream.range(0, 5)
				.mapToObj(i -> factory.get())
				.collect(Collectors.toList());
	}
	
	public static <T, R> Supplier<R> partial(Function<T, R> function, T value) {
		return () -> function.apply(value);
	}
	
	public static void main(String[] args) {
		
		List<Vehicle> redCars = create5(partial(Car::new, Color.RED));
		List<Vehicle> blueMotos = create5(partial(Moto::new, Color.BLUE));
		
	}
}
