package myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class SortedValuesInMap {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		map.put("1", 1);
		map.put("11", 11);
		map.put("3", 3);
		map.put("2", 2);
		map.put("5", 5);
		map.put("4", 4);
		map.put("6", 6);
		map.put("10", 10);
		map.put("9", 9);

		List<String> twoMax = getTwoMaxKeys(map);

		System.out.println(twoMax);

		List<String> twoMax2 = getTwoMaxKeys2(map);

		System.out.println(twoMax2);

	}

	private static List<String> getTwoMaxKeys2(Map<String, Integer> map) {
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		};

		TreeSet<Entry<String, Integer>> treeSet = new TreeSet<Entry<String, Integer>>(comparator);
		treeSet.addAll(entrySet);

		Iterator<Entry<String, Integer>> iterator = treeSet.iterator();
		Entry<String, Integer> first = iterator.next();
		Entry<String, Integer> second = iterator.next();

		return Arrays.asList(new String[] { first.getKey(), second.getKey() });
	}

	private static List<String> getTwoMaxKeys(Map<String, Integer> map) {

		List<Integer> list = new ArrayList<>(2);
		list.addAll(map.values());

		Collections.sort(list);
		Integer maxValue = list.get(list.size() - 1);
		Integer secondMaxValue = list.get(list.size() - 2);

		String maxKey = null;
		String secondMaxKey = null;

		List<String> result = new ArrayList<>();
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (maxValue.equals(e.getValue())) {
				maxKey = e.getKey();
			}
			if (secondMaxValue.equals(e.getValue())) {
				secondMaxKey = e.getKey();
			}
		}

		result.add(maxKey);
		result.add(secondMaxKey);

		return result;

	}

}
