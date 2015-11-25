package myproject.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class CommonPath {

	public static void main(String[] args) {

		List<String> logList = new ArrayList<>();

		logList.add("1,/home");
		logList.add("1,/search");
		logList.add("2,/home");
		logList.add("1,/list");
		logList.add("2,/search");
		logList.add("2,/list");
		logList.add("john,/home");
		logList.add("john,/list");
		logList.add("john,/add");
		logList.add("jane,/home");
		logList.add("jane,/add");

		String commonPath = commonPath(logList);

		System.out.println("commonPath: " + commonPath);
	}

	private static String commonPath(List<String> logList) {
		Map<String, List<String>> userPathMap = new HashMap<>();

		for (String log : logList) {
			String[] split = log.split(",");
			String userId = split[0];
			String path = split[1];

			System.out.println("userId: " + userId + ", path: " + path);

			List<String> list = userPathMap.get(userId);
			if (list == null) {
				List<String> pathList = new ArrayList<>();
				pathList.add(path);
				userPathMap.put(userId, pathList);
			} else if (list.size() < 3) {
				list.add(path);
				userPathMap.put(userId, list);
			}
		}

		System.out.println("userPathMap: " + userPathMap);

		Map<String, Integer> countMap = new HashMap<>();

		for (String key : userPathMap.keySet()) {
			List<String> pathList = userPathMap.get(key);
			String joinKey = String.join("->", pathList);

			Integer count = countMap.get(joinKey);
			if (count == null) {
				countMap.put(joinKey, 1);
			} else {
				countMap.put(joinKey, count + 1);
			}
		}

		System.out.println("countMap: " + countMap);

//		Map<String, Integer> sortByValueMap = sortByValue(countMap);
//
//		System.out.println("sortByValueMap: " + sortByValueMap);
//
//		return sortByValueMap.entrySet().iterator().next().getKey();
		
		PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
				countMap.size(), new Comparator<Entry<String, Integer>>() {

					@Override
					public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
						return arg1.getValue().compareTo(arg0.getValue());
					}
				});
		
		pq.addAll(countMap.entrySet());
//		while (!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		return pq.poll().getKey();
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
