package myproject.java8.dp;

import java.util.HashMap;
import java.util.function.Function;

public class Visitor<R> {
	private final HashMap<Class<?>, Function<Object, R>> map =
			new HashMap<>();
	
	public <T> Visitor<R> when(Class<T> type, Function<T, R> f) {
		map.put(type, object -> f.apply(type.cast(object)));
		return this;
	}
	
	public R accept(Object receiver) {
		return map.getOrDefault(receiver.getClass(), r -> {
			throw new IllegalArgumentException();
		}).apply(receiver);
	}
}
