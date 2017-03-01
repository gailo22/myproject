package myproject.java8.dp;

import java.util.HashMap;
import java.util.function.Function;

public class Visitor<R> {
	private final HashMap<Class<?>, Function<Object, R>> map =
			new HashMap<>();
	
	public <T> Visitor<R> when(Class<T> type, Function<T, R> f) {
//		map.put(type, object -> f.apply(type.cast(object)));
		map.put(type, f.compose(type::cast));
		return this;
	}
	
	public R accept(Object receiver) {
		return map.getOrDefault(receiver.getClass(), r -> {
			throw new IllegalArgumentException();
		}).apply(receiver);
	}
	
	public static void main(String[] args) {
		Visitor<String> visitor = new Visitor<>();
		
		visitor.when(Car.class, car -> "car")
		       .when(Moto.class, moto -> "moto");
		
		Vehicle vehicle = new Car();
		String car = visitor.accept(vehicle);
		Vehicle vehicle2 = new Moto();
		String moto = visitor.accept(vehicle2);
		
		System.out.println(car);
		System.out.println(moto);
		
	}
}
