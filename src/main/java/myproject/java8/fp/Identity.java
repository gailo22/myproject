package myproject.java8.fp;

import java.util.function.Function;

public class Identity<T> implements Functor<T> {

	private final T value;
	
	Identity(T value) { this.value = value; }
	
	@Override
	public <R> Functor<R> map(Function<T, R> f) {
		final R result = f.apply(value);
		return new Identity<>(result);
	}

}
