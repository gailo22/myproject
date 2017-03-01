package myproject.java8.dp;

import java.util.function.Consumer;

// state design pattern
public interface Logger3 {
	void error(String message);
	void warning(String message);
	
	Logger3 quiet();
	Logger3 chatty();
	
	static Logger3 logger(Consumer<String> printer) {
		return new ChattyLogger(printer);
	}
	
	public static void main(String[] args) {
		Logger3 logger = Logger3.logger(System.out::println);
		logger.warning("WARNING");
		
		Logger3 quiet = logger.quiet();
		quiet.warning("WARNING");
	}

}
