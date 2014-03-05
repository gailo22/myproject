package myproject.memory;

import java.util.HashMap;

public class ObjectCreateTest {

	public static void main(String[] args) {
		ObjectCreateInner objectCreateInner = new ObjectCreateInner();

	}

	public static class ObjectCreateInner {
		HashMap map1 = new HashMap();

		ObjectCreateInner() {
			map1.put("abc", "hello");
		}
	}
}

