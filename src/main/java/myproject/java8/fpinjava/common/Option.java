package myproject.java8.fpinjava.common;

public abstract class Option<A> {

	public abstract <B> Option<B> map(Function<A, B> f);
	protected abstract A getOrThrow();
	public abstract A getOrElse(Supplier<A> defaultValue);
	public abstract A getOrElse(A defaultValue);
	public abstract boolean isSome();

	public <B> Option<B> flatMap(Function<A, Option<B>> f) {
		return map(f).getOrElse(None::new);
	}
	
	public Option<A> orElse(Supplier<Option<A>> defaultValue) {
		return map(Option::some).getOrElse(defaultValue);
	}
	
	public Option<A> filter(Function<A, Boolean> f) {
		return flatMap(x -> f.apply(x) ? some(x) : none());
	}

	@SuppressWarnings("rawtypes")
	private static Option none = new None();

	private Option() {}

	public static <A> Option<A> some(A a) {
		return new Some<>(a);
	}

	@SuppressWarnings("unchecked")
	public static <A> Option<A> none() {
		return none;
	}

	public static <A, B> Function<Option<A>, Option<B>> lift(Function<A, B> f) {
		return x -> x.map(f);
	}

	public static <A, B, C> Option<C> map2(Option<A> a, Option<B> b, Function<A, Function<B, C>> f) {
		return a.isSome() && b.isSome() ? some(f.apply(a.getOrThrow()).apply(b.getOrThrow())) : none();
	}
	
	private static class None<A> extends Option<A> {

		private None() {}

		@Override
		public String toString() {
			return "None";
		}

		@SuppressWarnings("unchecked")
		@Override
		public <B> Option<B> map(Function<A, B> f) {
			return none;
		}

		@Override
		protected A getOrThrow() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public A getOrElse(Supplier<A> defaultValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public A getOrElse(A defaultValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isSome() {
			// TODO Auto-generated method stub
			return false;
		}
	}

	private static class Some<A> extends Option<A> {

		private final A value;

		private Some(A a) {
			this.value = a;
		}

		@Override
		public String toString() {
			return String.format("Some(%s)", this.value);
		}

		@Override
		public <B> Option<B> map(Function<A, B> f) {
			return new Some<>(f.apply(this.value));
		}

		@Override
		protected A getOrThrow() {
			return this.value;
		}

		@Override
		public A getOrElse(Supplier<A> defaultValue) {
			return this.value;
		}

		@Override
		public boolean isSome() {
			return true;
		}

		@Override
		public A getOrElse(A defaultValue) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
}
