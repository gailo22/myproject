package myproject.java8.async;

import java.util.ArrayList;
import java.util.List;

public final class MultiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final List<Throwable> exceptions;

	public MultiException(List<Throwable> inputThrowableList) {
		List<Throwable> throwableList = new ArrayList<>();
		for (Throwable th : inputThrowableList) {
			if (th instanceof MultiException) {
				MultiException me = (MultiException) th;
				throwableList.addAll(me.exceptions);
			} else {
				throwableList.add(th);
			}
		}
		this.exceptions = throwableList;
	}
}
