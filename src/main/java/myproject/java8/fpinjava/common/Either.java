package myproject.java8.fpinjava.common;

public abstract class Either<E, A> {
	
	public abstract <B> Either<E, B> map(Function<A, B> f);
	public abstract <B> Either<E, B> flatMap(Function<A, Either<E, B>> f);
	public abstract Either<E, A> orElse(Supplier<Either<E, A>> a);
	public abstract boolean isLeft();
	public abstract boolean isRight();
	public abstract E left();
	public abstract A right();
	
	private static class Left<E, A> extends Either<E, A> {

		private final E value;

	    private Left(E value) {
	      this.value = value;
	    }
	    
		@Override
		public <B> Either<E, B> map(Function<A, B> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> Either<E, B> flatMap(Function<A, Either<E, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Either<E, A> orElse(Supplier<Either<E, A>> a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isLeft() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isRight() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E left() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public A right() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	private static class Right<E, A> extends Either<E, A> {

	    private final A value;

	    private Right(A value) {
	      this.value = value;
	    }

		@Override
		public <B> Either<E, B> map(Function<A, B> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> Either<E, B> flatMap(Function<A, Either<E, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Either<E, A> orElse(Supplier<Either<E, A>> a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isLeft() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isRight() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E left() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public A right() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public static <E, A> Either<E, A> left(E value) {
		return new Left<>(value);
	}

	public static <E, A> Either<E, A> right(A value) {
		return new Right<>(value);
	}
}
