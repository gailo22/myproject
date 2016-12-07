package myproject.java8.fp;

import java.util.function.Function;

public class Identity<T> implements Functor<T, Identity<?>> {

	private final T value;
	
	Identity(T value) { this.value = value; }
	
	@Override
	public <R> Identity<R> map(Function<T, R> f) {
		final R result = f.apply(value);
		return new Identity<>(result);
	}

}
