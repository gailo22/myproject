package myproject.java8.fp;

import java.util.function.Function;

public class OptionF<T> implements Functor<T, OptionF<?>> {

	private final T valueOrNull;

	OptionF(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

	@Override
	public <R> OptionF<R> map(Function<T, R> f) {
		if (valueOrNull == null)
			return empty();
		else
			return of(f.apply(valueOrNull));
	}

	public static <T> OptionF<T> of(T a) {
		return new OptionF<T>(a);
	}

	public static <T> OptionF<T> empty() {
		return new OptionF<T>(null);
	}

}
