package myproject.cache;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = -827666472349978520L;
	
	private final int maxEntries;
	
	public LRUCache(int cacheSize) {
		super(cacheSize);
		this.maxEntries = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > maxEntries;
	}

	@Override
	public V get(Object key) {
		synchronized(this) {
			return super.get(key);
		}
	}

	@Override
	public V put(K key, V value) {
		synchronized(this) {
			return super.put(key, value);
		}
	}

}
