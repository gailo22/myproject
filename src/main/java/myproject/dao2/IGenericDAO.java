package myproject.dao2;

import java.util.List;

public interface IGenericDAO<T> {

	T findOne(final Long id);

	List<T> findAll();

	void save(final T entity);

	void update(final T entity);

	void delete(final T entity);

}
