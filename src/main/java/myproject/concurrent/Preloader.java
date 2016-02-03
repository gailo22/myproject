package myproject.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {
	
	private final FutureTask<ProductInfo> future =
			new FutureTask<>(new Callable<ProductInfo>() {

				@Override
				public ProductInfo call() throws Exception {
					return loadProductInfo();
				}

				private ProductInfo loadProductInfo() {
					// TODO Auto-generated method stub
					return null;
				}
				
			});
	
	static class ProductInfo {}
	static class DataLoadException extends Exception {}
	
	private final Thread thread = new Thread(future);
	
	public void start() { thread.start(); }

	public ProductInfo get() throws Exception {
			try {
				return future.get();
			} catch (ExecutionException e) {
				Throwable cause = e.getCause();
				if (cause instanceof DataLoadException)
					throw (DataLoadException) cause;
				else
					throw launderThrowable(cause);
			}
	}

	private RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException)
			return (RuntimeException) t;
		else if (t instanceof Error)
			throw (Error) t;
		else
			throw new IllegalStateException("Not unchecked", t);
	}
}
