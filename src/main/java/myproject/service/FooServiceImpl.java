package myproject.service;

import myproject.dao2.IFooJpaDAO;
import myproject.domain.Foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class FooServiceImpl extends AbstractService<Foo> implements IFooService {

	@Autowired
	IFooJpaDAO dao;

	FooServiceImpl() {
		super(Foo.class);
	}

	@Override
	public Foo getCurrentFoo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Foo findByName(final String name) {
		return dao.findByName(name);
	}

	@Override
	protected final IFooJpaDAO getDao() {
		return dao;
	}

}
