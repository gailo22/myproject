package myproject.memory;

import java.util.Map;

public class MemLeak {
	public final String key;

	public MemLeak(String key) {
		this.key = key;
	}

	public static void main(String args[]) {
		try {
			Map map = System.getProperties();

			for (;;) {
				System.out.println("...");
				map.put(new MemLeak("key"), "value");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
