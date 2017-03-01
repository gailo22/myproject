package myproject.java8.dp;

import java.util.HashMap;
import java.util.function.Supplier;

public class MyFactoryKit {
	
	private final HashMap<String, Supplier<Vehicle>> map = new HashMap<>(); 
	
	public void register(String name, Supplier<Vehicle> supplier) {
		map.put(name, supplier);
	}
	
	public Vehicle create(String name) {
		return map.getOrDefault(name, () -> { throw new IllegalArgumentException(); })
				.get();
	}
	
	public static void main(String[] args) {
		
		MyFactoryKit factory = new MyFactoryKit();
		factory.register("car", Car::new);
		//factory.register("moto", Moto::new);
		
		// make moto a singleton
		Moto singleton = new Moto();
		factory.register("moto", () -> singleton); 
		
	}

}
