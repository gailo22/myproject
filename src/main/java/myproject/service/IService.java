package myproject.service;


public interface IService<T extends INameableEntity> extends IRawService<T>, INameSupport<T> {

}
