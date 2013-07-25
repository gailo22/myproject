package myproject.util;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestReadFile {

	public static void main(final String[] args) throws Exception {

		final List<String> lines = FileUtils.readLines(new File(
				"C:\\dev\\dev_project\\git\\myproject\\src\\main\\resources\\country.sql"));
		for (final String line : lines) {
			final StringBuilder builder = new StringBuilder();
			if (line.startsWith("'")) {
				builder.append("(");
				builder.append(line);
			}
			else if (line.startsWith(",'")) {
				builder.append(line.replaceFirst(",'", ",('"));
			}
			else {
				builder.append(line);
			}
			if (line.endsWith("'")) {
				builder.append(" )");
			}
			System.out.println(builder.toString());
		}
	}

}
