package myproject.java8.dp;

import java.util.function.Consumer;

public class QuietLogger implements Logger3 {
	
	private final Consumer<String> printer;
	
	QuietLogger(Consumer<String> printer) {
		this.printer = printer;
	}

	@Override
	public void error(String message) {
		printer.accept(message);
	}

	@Override
	public void warning(String message) {
		// empty
	}

	@Override
	public Logger3 quiet() {
		return this;
	}

	@Override
	public Logger3 chatty() {
		return new ChattyLogger(printer);
	}

}
