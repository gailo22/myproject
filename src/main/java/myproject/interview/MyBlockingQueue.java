package myproject.interview;

import java.util.LinkedList;
import java.util.Queue;


public class MyBlockingQueue<T> {

	private Queue<T> queue = new LinkedList<T>();
	private int capacity;
	
	public MyBlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void put(T elem) throws InterruptedException {
		while (queue.size() == capacity) {
			wait();
		}
		
		queue.add(elem);
		notify();
	}
	
	public synchronized T take() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}
		
		T item = queue.remove();
		notify();
		
		return item;
	}
	
	public static void main(String[] args) {

	}

}
