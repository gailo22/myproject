package myproject;

import java.util.Stack;

class MyStackQueue {
	public static void main(String[] args) {

		// Testing
		MyStackQueue myQueue = new MyStackQueue();
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.enQueue(3);
		myQueue.enQueue(2);
		myQueue.enQueue(1);

		while (!myQueue.isEmpty()) {
			System.out.println(myQueue.deQueue());
		}

	}

	// to keep FILO
	private Stack<Integer> s1 = new Stack<Integer>();
	// to keep FIFO
	private Stack<Integer> s2 = new Stack<Integer>();

	public void enQueue(Integer i) {
		// just push to s1
		s1.push(i);
	}

	public Integer deQueue() {
		// check empty
		if (s1.isEmpty() && s2.isEmpty()) {
			return -1;
		} else if (s2.isEmpty()) {
			// pop from s1 to s2
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		// return s2
		return s2.pop();
	}

	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

}