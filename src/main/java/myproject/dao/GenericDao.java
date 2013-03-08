package myproject.dao;

import java.util.List;

public interface GenericDao<E, K> {
	
	void add(E entiry);
	
	void update(E entity);
	
	void remove(E entity);
	
	E find(K key);
	
	List<E> list();
}
