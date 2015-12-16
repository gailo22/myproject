package myproject.berlinclock;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BerlinClock {

	private static final String PATTERN = "\\d{2}:\\d{2}:\\d{2}";

	public static void main(String[] args) {

		String timeStr = "13:17:01";
//		String timeStr = "23:59:59";

		boolean validated = validateInput(timeStr);
		
		if (!validated) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		List<Integer> parts = splitParts(timeStr);

		System.out.println(parts);
		
		System.out.println("Seconds: " + getDisplayColors(new Second(), parts.get(2)));

		System.out.println("Top Hours: " + getDisplayColors(new Hour((a, b) -> a/b), parts.get(0)));
		System.out.println("Bottom Hours: " + getDisplayColors(new Hour((a, b) -> a%b), parts.get(0)));

		System.out.println("Top Minutes: " + getDisplayColors(new Minute(Minute.Type.TOP, (a, b) -> a/b), parts.get(1)));
		System.out.println("Bottom Minutes: " + getDisplayColors(new Minute(Minute.Type.BOTTOM, (a, b) -> a%b), parts.get(1)));

//		
//		Seconds: O
//		Top Hours: RROO
//		Bottom Hours: RRRO
//		Top Minutes: YYROOOOOOOO
//		Bottom Minutes: YYOO
	}

//	private static String getHours(Lamp hour, BiFunction<Integer, Integer, Integer> partitioner, Integer time) {
//		return hour.getColors(partitioner, time);
//	}
//	
//	private static String getMinutes(Lamp minute, BiFunction<Integer, Integer, Integer> partitioner, Integer time) {
//		return minute.getColors(partitioner, time);
//	}
//
//	private static String getSeconds(Second second, Integer time) {
//		return second.getColors(null, time);
//	}
	
	private static String getDisplayColors(Lamp lamp, Integer time) {
		return lamp.getColors(time);
	}

	private static List<Integer> splitParts(String timeStr) {
		return Stream.of(timeStr)
				     .map(s -> s.split(":"))
				     .flatMap(Arrays::stream)
				     .map(Integer::valueOf)
				     .collect(Collectors.toList());
	}
	
	private static boolean validateInput(String timeStr) {
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(timeStr);
		return matcher.matches();
	}

}
