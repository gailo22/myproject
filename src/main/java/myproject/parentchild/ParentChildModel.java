package myproject.parentchild;


public interface ParentChildModel<T> {
	
	T getParent();
	T getChild();
	
	T getCurrent();
	void setCurrent(T t);
	
	void add(T t);

}
