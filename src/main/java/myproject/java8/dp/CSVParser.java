package myproject.java8.dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

interface Observer {
	void data(double value);
}

public class CSVParser {
	
	public static void parse(Path path, Observer observer) throws IOException {
		try (Stream<String> lines = Files.lines(path)) {
			lines.flatMap(Pattern.compile(",")::splitAsStream)
			     .mapToDouble(Double::parseDouble)
			     .forEach(observer::data);
		}
	}

}
