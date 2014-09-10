package myproject.interview;

public class QueueUsingNode<T> {
	
	static class Node<T> {
		final T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
		}
	}
	
	Node<T> first, last;
	
	void enqueue(T item) {
		if (first == null) {
			last = new Node<T>(item);
			first = last;
		} else {
			last.next = new Node<T>(item);
			last = last.next;
		}
	}
	
	T dequeue() {
		if (first != null) {
			T item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}

	public static void main(String[] args) {

		QueueUsingNode<Integer> q = new QueueUsingNode<Integer>();
		q.enqueue(100);
		q.enqueue(200);
		q.enqueue(300);
		
		System.out.println("value: " + q.dequeue());
		System.out.println("value: " + q.dequeue());
	}

}
