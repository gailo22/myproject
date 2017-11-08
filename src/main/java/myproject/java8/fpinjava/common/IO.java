package myproject.java8.fpinjava.common;

public interface IO<A> {

	IO<Nothing> empty = () -> Nothing.instance;
	
	A run();
	
	default <B> IO<B> map(Function<A, B> f) {
		return () -> f.apply(this.run());
	}
	
	default <B> IO<B> flatMap(Function<A, IO<B>> f) {
		return () -> f.apply(this.run()).run();
	}
	
	static <B> IO<B> unit(B b) {
		return () -> b;
	}
	
	static <A, B, C> IO<C> map2(IO<A> ioa, IO<B> iob, Function<A, Function<B, C>> f) {
		return ioa.flatMap(a -> iob.map(b -> f.apply(a).apply(b)));
	}
}
