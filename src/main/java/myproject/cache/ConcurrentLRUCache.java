package myproject.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLRUCache<K, V> {

	private final int maxSize;
	private ConcurrentHashMap<K, V> map;
	private ConcurrentLinkedQueue<K> queue;
	
	public ConcurrentLRUCache(final int size) {
		this.maxSize = size;
		map = new ConcurrentHashMap<K, V>(size);
		queue = new ConcurrentLinkedQueue<K>();
	}
	
	public void put(final K key, final V value) {
		if (map.containsKey(key)) {
			queue.remove(key);
		}
		
		while (queue.size() >= maxSize) {
			K oldestKey = queue.poll();
			if (oldestKey != null) {
				map.remove(oldestKey);
			}
		}
		
		queue.add(key);
		map.put(key, value);
	}
	
	public V get(final K key) {
		return map.get(key);
	}
	
	public static void main(String[] args) {
		ConcurrentLRUCache<String, Integer> lru = new ConcurrentLRUCache<>(2);
		
		lru.put("1", 1);
		lru.put("2", 2);
		lru.put("3", 3);
		lru.put("4", 4);
		lru.put("1", 1);
		lru.put("1", 11);
		lru.put("3", 3);
		
		
	}
}
