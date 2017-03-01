package myproject.java8.dp;

import java.util.Objects;
import java.util.function.Predicate;

public interface Logger {

	void log(String message);
	
	default Logger filter(Predicate<String> filter) {
		Objects.requireNonNull(filter);
		return message -> {
			if (filter.test(message)) {
				log(message);
			}
		};
	}
}
