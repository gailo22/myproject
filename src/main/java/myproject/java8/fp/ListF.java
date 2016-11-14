package myproject.java8.fp;

import java.util.ArrayList;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;

public class ListF<T> implements Functor<T> {

	private final ImmutableList<T> list;
	 
	ListF(Iterable<T> value) {
        this.list = ImmutableList.copyOf(value);
    }
    
	@Override
	public <R> Functor<R> map(Function<T, R> f) {
		ArrayList<R> result = new ArrayList<R>(list.size());
        for (T t : list) {
            result.add(f.apply(t));
        }
        return new ListF<>(result);
	}

}
