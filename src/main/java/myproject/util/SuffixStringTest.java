package myproject.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuffixStringTest {

	public static void main(String[] args) {

		String hello = "Hello world";

		List<String> list = new ArrayList<String>();

		int len = hello.length();
		for (int i = 0; i < len; i++) {
			list.add(hello.subSequence(i, len).toString());
		}

		System.out.println("List: " + list);
		Collections.sort(list);
		System.out.println("List sorted: " + list);

		String prefix = "l";

		for (String s : list) {
			if (s.startsWith(prefix)) {
				System.out.println(s);
			}
		}

	}
}
