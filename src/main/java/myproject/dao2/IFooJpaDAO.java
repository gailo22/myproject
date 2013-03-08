package myproject.dao2;

import myproject.domain.Foo;


public interface IFooJpaDAO extends IGenericDAO<Foo> {
	Foo findByName(final String name);

}
