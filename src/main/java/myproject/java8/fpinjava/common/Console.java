package myproject.java8.fpinjava.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static IO<String> readLine(Nothing nothing) {
		return () -> {
			try {
				return br.readLine();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		};
	}
	
	public static IO<String> readLine() {
		return readLine(Nothing.instance);
	}
	
	public static IO<String> readLine(String prompt) {
		return printLine(prompt).flatMap(x -> readLine(Nothing.instance));
	}
	
	public static IO<Nothing> printLine(Result<Object> r) {
		return () -> {
			r.forEachOrFail(System.out::println)
			 .forEach(System.out::println);
			return Nothing.instance;
		};
	}
	
	public static IO<Nothing> printLine(Object o) {
		return () -> {
			System.out.println(o);
			return Nothing.instance;
		};
	}
	
	public static IO<Nothing> print(Object o) {
		return () -> {
			System.out.print(o);
			return Nothing.instance;
		};
	}
}
