package myproject.java8.dp;

import static java.util.function.Function.identity;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Logger4 {

	private final Consumer<String> error, warning;
	private final Logger4 quiet, chatty;
	
	private Logger4(Consumer<String> error, 
			        Consumer<String> warning,
			        Function<Logger4, Logger4> quietFactory,
			        Function<Logger4, Logger4> chattyFactory) {
		this.error = error;
		this.warning = warning;
		this.quiet = quietFactory.apply(this);
		this.chatty = chattyFactory.apply(this);
	}
	
	public void error(String message) { error.accept(message); }
	public void warning(String message) { warning.accept(message); }
	
	public Logger4 quiet() { return quiet; }
	public Logger4 chatty() { return chatty; }
	
	public static Logger4 logger(Consumer<String> consumer) {
		Objects.requireNonNull(consumer);
		return new Logger4(consumer, consumer,
				chatty -> new Logger4(consumer, msg -> {}, identity(), it -> chatty),
				identity());
	}
}
