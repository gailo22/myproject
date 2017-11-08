package myproject.java8.fpinjava.common;

public abstract class Stream<A> {
	
	private static Stream EMPTY = new Empty();
	public abstract Tuple<A, Stream<A>> head();
	public abstract Stream<A> tail();
	public abstract Boolean isEmpty();
	public abstract Tuple<Result<A>, Stream<A>> headOption();
	public abstract Stream<A> take(int n);
	public abstract Stream<A> drop(int n);
	public abstract Stream<A> takeWhile_(Function<A, Boolean> f);
	public abstract <B> B foldRight(Supplier<B> z, Function<A, Function<Supplier<B>, B>> f);
	
	private static class Cons<A> extends Stream<A> {

		private final Supplier<A> head;
		private final Result<A> h;
		private final Supplier<Stream<A>> tail;

		private Cons(Supplier<A> h, Supplier<Stream<A>> t) {
			head = h;
			tail = t;
			this.h = Result.empty();
		}

		private Cons(A h, Supplier<Stream<A>> t) {
			head = () -> h;
			tail = t;
			this.h = Result.success(h);
		}

		@Override
		public Tuple<Result<A>, Stream<A>> headOption() {
			Tuple<A, Stream<A>> t = head();
			return new Tuple<>(Result.success(t._1), t._2);
		}

		@Override
		public myproject.java8.fpinjava.common.Tuple<A, Stream<A>> head() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> tail() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean isEmpty() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> take(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> drop(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> takeWhile_(myproject.java8.fpinjava.common.Function<A, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> B foldRight(myproject.java8.fpinjava.common.Supplier<B> z,
				myproject.java8.fpinjava.common.Function<A, myproject.java8.fpinjava.common.Function<myproject.java8.fpinjava.common.Supplier<B>, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	private static class Empty<A> extends Stream<A> {

		@Override
		public myproject.java8.fpinjava.common.Tuple<A, Stream<A>> head() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> tail() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean isEmpty() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public myproject.java8.fpinjava.common.Tuple<myproject.java8.fpinjava.common.Result<A>, Stream<A>> headOption() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> take(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> drop(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> takeWhile_(myproject.java8.fpinjava.common.Function<A, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> B foldRight(myproject.java8.fpinjava.common.Supplier<B> z,
				myproject.java8.fpinjava.common.Function<A, myproject.java8.fpinjava.common.Function<myproject.java8.fpinjava.common.Supplier<B>, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
