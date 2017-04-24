package myproject.processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class PBExample {

	public static void main(String[] args) throws InterruptedException, IOException {
		ProcessBuilder pb = new ProcessBuilder("echo", "This is ProcessBuilder Example");
		System.out.println("Run echo command");
		Process process = pb.start();
		int errCode = process.waitFor();
		System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
		System.out.println("Echo Output:" + output(process.getInputStream()));
	}

	private static String output(InputStream inputStream) throws IOException {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            return buffer.lines().collect(Collectors.joining(System.lineSeparator()));
        } 
	}
}
