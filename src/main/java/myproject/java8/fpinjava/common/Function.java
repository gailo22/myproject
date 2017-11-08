package myproject.java8.fpinjava.common;

public interface Function<T, U> {

	U apply(T t);
	
	default <V> Function<V, U> compose(Function<V, T> f) {
		return x -> apply(f.apply(x));
	}
	
	default <V> Function<T, V> andThen(Function<U, V> f) {
		return x -> f.apply(apply(x));
	}
	
	static <T> Function<T, T> identity() {
		return t -> t;
	}
	
	static <T, U, V> Function<V, U> compose(Function<T, U> f, Function<V, T> g) {
		return x -> f.apply(g.apply(x));
	}
	
	static <T, U, V> Function<T, V> andThen(Function<T, U> f, Function<U, V> g) {
		return x -> g.apply(f.apply(x));
	}
}
