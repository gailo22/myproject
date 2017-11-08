package myproject.java8.fpinjava.common;

import java.io.Serializable;
import java.util.function.Supplier;

public abstract class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Result() {}
	
	public abstract Boolean isSuccess();
	public abstract Boolean isFailure();
	public abstract Boolean isEmpty();
	public abstract T getOrElse(final T defaultValue);
	public abstract T getOrElse(final Supplier<T> defaultValue);
	public abstract <V> V foldLeft(final V identity, Function<V, Function<T, V>> f);
	public abstract <V> V foldRight(final V identity, Function<T, Function<V, V>> f);
	public abstract T successValue();
	public abstract Exception failureValue();
	public abstract void forEach(Effect<T> c);
	public abstract void forEachOrThrow(Effect<T> c);
	public abstract Result<String> forEachOrFail(Effect<T> e);
	public abstract Result<RuntimeException> forEachOrException(Effect<T> e);
	public abstract Result<T> filter(Function<T, Boolean> f);
	public abstract Result<T> filter(Function<T, Boolean> p, String message);
	public abstract <U> Result<U> map(Function<T, U> f);
	public abstract Result<T> mapFailure(String s, Exception e);
	public abstract Result<T> mapFailure(String s);
	public abstract Result<T> mapFailure(Exception e);
	public abstract Result<T> mapFailure(Result<T> v);
	public abstract Result<Nothing> mapEmpty();
	public abstract <U> Result<U> flatMap(Function<T, Result<U>> f);
	public abstract Boolean exists(Function<T, Boolean> f);
	public abstract IO<Nothing> tryIO(Function<T, IO<Nothing>> success, Function<String, IO<Nothing>> failure);
	
	public Result<T> orElse(Supplier<Result<T>> defaultValue) {
		return map(x -> this).getOrElse(defaultValue);
	}

	public static <T, U> Result<T> failure(Failure<U> failure) {
		return new Failure<>(failure.exception);
	}

	public static <T> Result<T> failure(String message) {
		return new Failure<>(message);
	}

	public static <T> Result<T> failure(String message, Exception e) {
		return new Failure<>(new IllegalStateException(message, e));
	}

	public static <V> Result<V> failure(Exception e) {
		return new Failure<>(e);
	}

	public static <T> Result<T> success(T value) {
		return new Success<>(value);
	}

	public static <T> Result<T> empty() {
		return new Empty<>();
	}

	public static <T> Result<T> flatten(Result<Result<T>> result) {
		return result.flatMap(x -> x);
	}
	  
	private static class Empty<T> extends Result<T> {

		@Override
	    public Boolean isSuccess() {
	      return false;
	    }

	    @Override
	    public Boolean isFailure() {
	      return false;
	    }

	    @Override
	    public Boolean isEmpty() {
	      return true;
	    }

		@Override
		public T getOrElse(T defaultValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T getOrElse(Supplier<T> defaultValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <V> V foldLeft(V identity, Function<V, Function<T, V>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <V> V foldRight(V identity, Function<T, Function<V, V>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T successValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Exception failureValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void forEach(Effect<T> c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void forEachOrThrow(Effect<T> c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Result<String> forEachOrFail(Effect<T> e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<RuntimeException> forEachOrException(Effect<T> e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> filter(Function<T, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> filter(Function<T, Boolean> p, String message) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> Result<U> map(Function<T, U> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(String s, Exception e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(String s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(Exception e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(Result<T> v) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<Nothing> mapEmpty() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> Result<U> flatMap(Function<T, Result<U>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean exists(Function<T, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IO<Nothing> tryIO(Function<T, IO<Nothing>> success, Function<String, IO<Nothing>> failure) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	private static class Failure<T> extends Empty<T> {
		
		private final RuntimeException exception;

	    private Failure(String message) {
	      super();
	      this.exception = new IllegalStateException(message);
	    }

	    private Failure(RuntimeException e) {
	      super();
	      this.exception = e;
	    }

	    private Failure(Exception e) {
	      super();
	      this.exception = new IllegalStateException(e);
	    }
	    
	    @Override
	    public Boolean isSuccess() {
	      return false;
	    }

	    @Override
	    public Boolean isFailure() {
	      return true;
	    }
	}
	
	private static class Success<T> extends Result<T> {
	    private final T value;

	    public Success(T value) {
	      super();
	      this.value = value;
	    }

	    @Override
	    public Boolean isSuccess() {
	      return true;
	    }

	    @Override
	    public Boolean isFailure() {
	      return false;
	    }

		@Override
		public Boolean isEmpty() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T getOrElse(T defaultValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T getOrElse(Supplier<T> defaultValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <V> V foldLeft(V identity, Function<V, Function<T, V>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <V> V foldRight(V identity, Function<T, Function<V, V>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T successValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Exception failureValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void forEach(Effect<T> c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void forEachOrThrow(Effect<T> c) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Result<String> forEachOrFail(Effect<T> e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<RuntimeException> forEachOrException(Effect<T> e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> filter(Function<T, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> filter(Function<T, Boolean> p, String message) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> Result<U> map(Function<T, U> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(String s, Exception e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(String s) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(Exception e) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<T> mapFailure(Result<T> v) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<Nothing> mapEmpty() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> Result<U> flatMap(Function<T, Result<U>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean exists(Function<T, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IO<Nothing> tryIO(Function<T, IO<Nothing>> success, Function<String, IO<Nothing>> failure) {
			// TODO Auto-generated method stub
			return null;
		}
	    
	}

}
