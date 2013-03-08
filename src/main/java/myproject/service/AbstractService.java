package myproject.service;


public abstract class AbstractService<T extends INameableEntity> extends AbstractRawService<T> implements IService<T> {

	public AbstractService(Class<T> clazzToSet) {
		super(clazzToSet);
	}

}
