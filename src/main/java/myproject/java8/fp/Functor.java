package myproject.java8.fp;

import java.util.function.Function;

@FunctionalInterface
public interface Functor<T> {

	/**
	 * f.apply(x)
	 * 
	 * Inverse
	 * 
	 * x.map(f)
	 * 
	 * Call x a functor
	 */
	<R> Functor<R> map(Function<T, R> f);
	
}
