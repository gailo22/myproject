package myproject.parentchild;

import java.util.LinkedList;
import java.util.List;


public class ParentChildModelImpl<T> implements ParentChildModel<T> {
	
	private List<T> list = new LinkedList<>();
	private T current;

	@Override
	public T getParent() {
		T c = getCurrent();
		if (c != null) {
			int index = list.indexOf(c) - 1;
			if (index >= 0 && index < list.size()) {
				return list.get(index);
			}
		}
		return null;
	}

	@Override
	public T getChild() {
		T c = getCurrent();
		if (c != null) {
			int index = list.indexOf(c) + 1;
			if (index >= 0 && index < list.size()) {
				return list.get(index);
			}
		}
		return null;
	}

	@Override
	public T getCurrent() {
		return current;
	}

	@Override
	public void setCurrent(T t) {
		this.current = t;
	}
	
	@Override
	public void add(T t) {
		list.add(t);
		
	}
}
