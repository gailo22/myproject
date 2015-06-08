package myproject.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Loop2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (;;) {
			String line = in.readLine();
			if (line == null || "quit".equalsIgnoreCase(line)) {
				System.out.println("quiting... ");
				break;
			}

			System.out.println("hello, > " + line);
		}
	}
}
