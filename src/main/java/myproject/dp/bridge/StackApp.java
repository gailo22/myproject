package myproject.dp.bridge;

import java.util.stream.IntStream;

public class StackApp {
	
	private MyStack stack;
	
	public StackApp() {
		stack = new ArrayStack();
	}
	
	public StackApp(boolean isNotLimited) {
		stack = isNotLimited? new ListStack() : new ArrayStack();
	}
	
	public int pushStack(int elem) {
		return stack.push(elem);
	}
	
	public int popStack() {
		return stack.pop();
	}
	
	public static void main(String[] args) {
		
		StackApp app = new StackApp();
		IntStream.rangeClosed(1, 5)
			.forEach(i -> {
				app.pushStack(i);
			});
		
		StackApp app2 = new StackApp(true);
		IntStream.rangeClosed(1, 10)
			.forEach(i -> {
				app2.pushStack(i);
			});
		
	}

}
