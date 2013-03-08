package myproject.service;

import myproject.domain.Foo;

public interface IFooService extends IService<Foo> {

	Foo getCurrentFoo();

}
