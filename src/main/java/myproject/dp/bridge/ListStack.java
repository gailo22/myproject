package myproject.dp.bridge;

import java.util.ArrayList;
import java.util.List;

public class ListStack implements MyStack {

	private List<Integer> elems = new ArrayList<>();
	private int index = 0;
	
	@Override
	public int push(int elem) {
		elems.add(elem);
		return elem;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		index--;
		return elems.get(index);
	}

	@Override
	public boolean isEmpty() {
		return elems.size() == 0;
	}

}
