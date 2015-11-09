package myproject.interview;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {

		System.out.println(areAnagrams("live", "evil"));
		System.out.println(areAnagrams("them", "then"));
	}
	
	static boolean areAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		Map<Character, Integer> times = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			Character ch = str1.charAt(i);
			if (times.containsKey(ch)) {
				times.put(ch, times.get(ch) + 1);
			} else {
				times.put(ch, 1);
			}
		}
		
		for (int i = 0; i < str2.length(); i++) {
			Character ch = str2.charAt(i);
			
			if (!times.containsKey(ch)) return false;
			
			if (times.get(ch) == 0) return false;
			
			times.put(ch, times.get(ch) - 1);
		}
		return true;
	}

}
