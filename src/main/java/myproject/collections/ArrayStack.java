package myproject.collections;

// non-thread-safe stack implementation
public class ArrayStack implements Stack {

	private final int MAX_ELEMENTS = 10;

	private int[] stack;

	private int index;

	public ArrayStack() {
		this.stack = new int[MAX_ELEMENTS];
		this.index = -1;
	}

	@Override
	public void push(int elt) {
		if (index != stack.length - 1) {
			index++;                        //1
			stack[index] = elt;             //2
		} else {
			throw new IllegalStateException("stack overflow");
		}
	}

	@Override
	public int pop() {
		if (index != -1) {
			int elt = stack[index];
			index--;
			return elt;
		} else {
			throw new IllegalStateException("stack overflow");
		}
	}

	@Override
	public boolean isEmpty() {
		return index == -1;
	}

}
