package myproject.dp.bridge;

public class ArrayStack implements MyStack {
	
	private int[] elems = new int[5];
	private int index = 0;
	
	@Override
	public int push(int elem) {
		if (index == elems.length) {
			throw new RuntimeException("Stack is full");
		}
		elems[index++] = elem;
		return elem;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return elems[index--];
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

}
