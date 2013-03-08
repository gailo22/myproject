package myproject.service;


public interface INameSupport<T extends INameableEntity> {

	T findByName(final String name);
}
