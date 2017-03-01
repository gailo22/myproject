package myproject.java8.dp;

import java.util.function.Consumer;

public class ChattyLogger implements Logger3 {
	
	private final Consumer<String> printer;
	
	ChattyLogger(Consumer<String> printer) {
		this.printer = printer;
	}

	@Override
	public void error(String message) {
		printer.accept(message);
	}

	@Override
	public void warning(String message) {
		printer.accept(message);
	}

	@Override
	public Logger3 quiet() {
		return new QuietLogger(printer);
	}

	@Override
	public Logger3 chatty() {
		return this;
	}

}
