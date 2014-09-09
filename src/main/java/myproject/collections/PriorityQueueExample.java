package myproject.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<String>(10, new Comparator<String>() {
			
			@Override
			public int compare(String str1, String str2) {
				if (str1.length() > str2.length()) {
					return 1;
				} else if (str1.length() < str2.length()) {
					return -1;
				}
				
				return 0;
			}
		});
		
		queue.add("Hello");
		queue.add("Hello world");
		queue.add("what's up");
		
		
		while (queue.size() != 0) {
			String str = queue.remove();
			System.out.println(str);
		}
	}

}
