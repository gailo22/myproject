package myproject.berlinclock2;

import java.util.ArrayList;
import java.util.List;

public class BerlinClock2 {

	public static void main(String[] args) {
		String timeStr = "13:17:01";
		// String timeStr = "00:00:00";

		
		List<Row> rows = buildRows(timeStr);
		
		StringBuilder time = generateTime(rows);

		System.out.println(time.toString());

	}

	private static StringBuilder generateTime(List<Row> rowList) {
		StringBuilder builder = new StringBuilder();
		for (Row row : rowList) {
			builder.append(row.showColors());
			builder.append(System.lineSeparator());
		}
		return builder;
	}

	private static List<Row> buildRows(String timeStr) {
		String[] split = timeStr.split(":");
		Integer hour = Integer.valueOf(split[0]);
		Integer min = Integer.valueOf(split[1]);
		Integer sec = Integer.valueOf(split[2]);

		List<Row> list = new ArrayList<>();
		list.add(new Second(sec));
		list.add(new Hour(hour, TypeEnum.TOP));
		list.add(new Hour(hour, TypeEnum.BOTTOM));
		list.add(new Minute(min, TypeEnum.TOP));
		list.add(new Minute(min, TypeEnum.BOTTOM));

		return list;
	}
}
