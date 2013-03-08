package myproject.service;

import java.util.List;

import myproject.dao2.IGenericDAO;

import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

@Transactional
public abstract class AbstractRawService<T extends IEntity> implements IRawService<T> {

	private final Class<T> clazz;

	public AbstractRawService(final Class<T> clazzToSet) {
		super();
		clazz = clazzToSet;
	}

	@Override
	@Transactional(readOnly = true)
	public T findOne(long id) {
		return getDao().findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return Lists.newArrayList(getDao().findAll());
	}

	@Override
	public T create(T entity) {
		// Validate
		Preconditions.checkNotNull(entity);
		// TODO before save
		getDao().save(entity);
		final T persistedEntity = getDao().findOne(entity.getId());
		// TODO ater save
		return persistedEntity;
	}


	@Override
	public List<T> findAllSorted(String sortBy, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(final T entity) {
		Preconditions.checkNotNull(entity);

		// TODO before update
		getDao().save(entity);
		// TODO after update
	}


	@Override
	public void delete(long id) {
		final T entity = getDao().findOne(id);
		ServicePreconditions.checkEntityExists(entity);

		// TODO before update
		getDao().delete(entity);
		// TODO after update
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	// Template methods
	protected abstract IGenericDAO<T> getDao();

}
