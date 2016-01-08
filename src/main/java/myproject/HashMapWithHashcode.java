package myproject;

import java.util.HashMap;
import java.util.Map;


public class HashMapWithHashcode {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		// put in the same bucket
		Map<Object, Integer> map1 = new HashMap<>();
		map1.put(new Obj(1), 1);
		map1.put(new Obj(1), 2);
		map1.put(new Obj(1), 3);
		
		// put in the different bucket
		Map<Object, Integer> map2 = new HashMap<>();
		map2.put(new Obj(1), 1);
		map2.put(new Obj(2), 2);
		map2.put(new Obj(3), 3);
		
		System.out.println("map1:" + map1);
		System.out.println("map2:" + map2);
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
	
	static class Obj {

		int id;
		
		public Obj(int id) {
			this.id = id;
		}
		
		@Override
		public int hashCode() {
			return id;
		}
		
	}
}
