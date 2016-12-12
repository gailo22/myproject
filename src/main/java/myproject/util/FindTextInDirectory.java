package myproject.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTextInDirectory {
	public static void main(String[] args) throws IOException {
		List<Path> filePaths = getFilePaths();
		
		System.out.println("all files: " + filePaths.size());
		
		filePaths.stream()
		         .flatMap(FindTextInDirectory::readAllLines) // <-- Stream of List<String>
		         .flatMap(lines -> {
		        	 return lines.stream();    // <-- Stream of String
		         })
		         .filter(line -> line.contains("/Kuder") || line.contains("/Ind"))
		         .map(line -> {
		        	 return line.substring(line.indexOf("=") + 2, line.length() - 1);
		         })
		         .sorted()
		         .forEach(System.out::println);
		
	}

	private static Stream<? extends List<String>> readAllLines(Path path) {
		List<String> readAllLines = new ArrayList<>();
		try {
			readAllLines = Files.readAllLines(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return Stream.of(readAllLines);
	}

	private static List<Path> getFilePaths() throws IOException {
		try (Stream<Path> paths = Files.walk(Paths.get("C:\\dev\\project\\wda\\portal\\portal-config\\src\\main\\content\\jcr_root\\apps\\portal\\runmodes\\config.author"))) {
			return paths.filter(filePath -> Files.isRegularFile(filePath) && filePath.toString().endsWith("config"))
			            .collect(Collectors.toList());
		}
	}
}
