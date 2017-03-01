package myproject.java8.dp;

enum Level { DEBUG, INFO }

public interface Logger2 {
	void log(Level level, String message);
	
	default Logger level(Level level) {
		return message -> log(level, message);
	}
}
