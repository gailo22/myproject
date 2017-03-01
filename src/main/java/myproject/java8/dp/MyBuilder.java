package myproject.java8.dp;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

interface MyBuilder {
	void register(String name, Supplier<Vehicle> supplier);
}

interface VehicleFactory {
	Vehicle create(String name);
	
	static VehicleFactory factory(Consumer<MyBuilder> consumer) {
		HashMap<String, Supplier<Vehicle>> map = new HashMap<>();
		consumer.accept(map::put);
		return name -> map.getOrDefault(name, () -> { throw new IllegalArgumentException(); })
				.get();
	}
	
	static <K, T> Function<K, T> factoryKit(
			Consumer<BiConsumer<K, T>> consumer,
			Function<K, T> ifAbsent) {
		HashMap<K, T> map = new HashMap<>();
		consumer.accept(map::put);
		return key -> map.computeIfAbsent(key, ifAbsent);
	}
}

class App {
	public static void main(String[] args) {
		// factory
		VehicleFactory factory = VehicleFactory.factory(builder -> {
			builder.register("car", Car::new);
			builder.register("moto", Moto::new);
		});
		Vehicle car = factory.create("car");
		
		// factorykit
		Function<String, Supplier<Vehicle>> factoryKit = VehicleFactory.factoryKit(builder -> {
			builder.accept("car", Car::new);
			builder.accept("moto", Moto::new);
		}, name -> { throw new IllegalArgumentException(); });
		Vehicle car2 = factoryKit.apply("car").get();
	}
}