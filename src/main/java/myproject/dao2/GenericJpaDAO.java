package myproject.dao2;

import java.io.Serializable;

import myproject.domain.Foo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericJpaDAO<T extends Serializable> extends AbstractJpaDAO<T> implements IGenericDAO<T> {

	public Foo findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	//
}