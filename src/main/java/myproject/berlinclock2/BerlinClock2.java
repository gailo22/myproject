package myproject.berlinclock2;

import java.util.ArrayList;
import java.util.List;

public class BerlinClock2 {
	
	public static void main(String[] args) {
		String timeStr = "13:17:01";
		String[] split = timeStr.split(":");
		List<Row> rowList = buildRow(split);
		
		StringBuilder builder = new StringBuilder();
		for (Row row : rowList) {
			builder.append(row.showColor());
			builder.append(System.lineSeparator());
		}
		
		System.out.println(builder.toString());
		
	}

	private static List<Row> buildRow(String[] split) {
		List<Row> list = new ArrayList<>(5);
		list.add(getSeconds(split[2]));
		list.add(getFiveHours(split[0]));
		list.add(getSingleHours(split[0]));
		list.add(getFiveMinutes(split[1]));
		list.add(getSingleMinutes(split[1]));
		return list;
	}

	private static Row getSeconds(String string) {
		return new Second();
	}

	private static Row getFiveHours(String string) {
		return new Hour();
	}

	private static Row getSingleHours(String string) {
		return new Hour();
	}

	private static Row getFiveMinutes(String string) {
		return new Minute();
	}

	private static Row getSingleMinutes(String string) {
		return new Minute();
	}

}
