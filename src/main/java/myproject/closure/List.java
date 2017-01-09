package myproject.closure;

public class List<T> {

	T head;
	List<T> tail;

	List(T x, List<T> xs) {
		this.head = x;
		this.tail = xs;
	}

	static <A, B> List<B> map(Func<B, A> f, List<A> xs) {
		if (xs == null) {
			return null;
		}
		return new List<B>(f.m(xs.head), map(f, xs.tail));
	}

	static <A> List<A> filter(Pred<A> f, List<A> xs) {
		if (xs == null) {
			return null;
		}

		if (f.m(xs.head)) {
			return new List<A>(xs.head, filter(f, xs.tail));
		}

		return filter(f, xs.tail);
	}

	static <A> int length(List<A> xs) {
		int ans = 0;
		while (xs != null) {
			++ans;
			xs = xs.tail;
		}

		return ans;
	}
	
	static <A> List<A> concat(List<A> xs, List<A> ys) {
		if (xs == null) {
			return ys;
		}
		
		return new List<A>(xs.head, concat(xs.tail, ys));
	}
	
	static <A, B> List<B> flatMap(Func2<B, A> f, List<A> xs) {
		if (xs == null) {
			return null;
		}
		return concat(f.m(xs.head), flatMap(f, xs.tail));
	}
}
