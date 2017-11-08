package myproject.java8.fpinjava.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionUtilities {
	
	public static <T> List<T> list() {
		return Collections.emptyList();
	}
	
	public static <T> List<T> list(T t) {
		return Collections.singletonList(t);
	}
	
	public static <T> List<T> list(List<T> ts) {
		return Collections.unmodifiableList(new ArrayList<>(ts));
	}
	
	public static <T> List<T> list(T... ts) {
		return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(ts, ts.length)));
	}
	
	public static <T> T head(List<T> list) {
		if (list.size() == 0) {
			throw new IllegalStateException("head of empty list");
		}
		return list.get(0);
	}
	
	private static <T> List<T> copy(List<T> ts) {
		return new ArrayList<>(ts);
	}
	
	public static <T> List<T> tail(List<T> ts) {
		if (ts.size() == 0) {
			throw new IllegalStateException("tail of empty list");
		}
		List<T> workList = copy(ts);
		workList.remove(0);
		return Collections.unmodifiableList(workList);
	}
	
	public static <T, U> U foldLeft(List<T> ts,
			                        U identity,
			                        Function<U, Function<T, U>> f) {
		U result = identity;
		for (T t : ts) {
			result = f.apply(result).apply(t);
		}
		return result;
	}
	
	public static <T, U> U foldRight(List<T> ts,
			                         U identity,
			                         Function<T, Function<U, U>> f) {
		return ts.isEmpty()? identity : f.apply(head(ts))
				                         .apply(foldRight(tail(ts), identity, f));
	}
}
