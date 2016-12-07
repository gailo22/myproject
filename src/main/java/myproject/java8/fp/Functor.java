package myproject.java8.fp;

import java.util.function.Function;

@FunctionalInterface
public interface Functor<T, F extends Functor<?, ?>> {

	/**
	 * f.apply(x)
	 * 
	 * Inverse
	 * 
	 * x.map(f)
	 * 
	 * Call x a functor
	 */
	<R> F map(Function<T, R> f);
	
}
