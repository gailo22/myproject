package myproject;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements MyList<E> {

	// NOTE: need to use parameter for type of node
	private Node<E> head;
	private int numElements;

	public SinglyLinkedList() {
		head = null;
		numElements = 0;
	}

	public int size() {
		return numElements;
	}

	private void addFirst(E value) {
		head = new Node<E>(value, head);
		numElements++;
	}

	private E getFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	private E removeFirst() {
		E oldData = getFirst();
		head = head.next;

		numElements--;
		return oldData;
	}

	public String toString() {
		if (head == null)
			return "";

		String s = head.data.toString();

		Node<E> current = head.next;
		while (current != null) {
			s = s + " ==> " + current.data;
			current = current.next;
		}

		return s;
	}

	public boolean add(Object obj) {
		E element = (E) obj;

		if (head == null) {
			addFirst(element);
			return true;
		}

		Node<E> last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = new Node<E>(element, null);
		numElements++;
		return true;
	}

	public void add(int index, E element) {
		if (index < 0 || index > numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		if (index == 0) {
			addFirst(element);
			return;
		}

		Node<E> nodeBefore = head;
		for (int i = 0; i < index - 1; i++) {
			nodeBefore = nodeBefore.next;
		}
		nodeBefore.next = new Node<E>(element, nodeBefore.next);
		numElements++;

	}

	public E remove(int index) {
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		if (index == 0)
			return removeFirst();

		Node<E> nodeBefore = head;
		for (int i = 0; i < index - 1; i++) {
			nodeBefore = nodeBefore.next;
		}
		Node<E> nodeToRemove = nodeBefore.next;
		nodeBefore.next = nodeToRemove.next;
		numElements--;
		return nodeToRemove.data;
	}

	public E set(int index, E element) {
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException("" + index);
		}

		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		E oldData = current.data;
		current.data = element;
		return oldData;
	}

	private static class Node<E> {
		private E data;
		private Node<E> next;

		private Node(E element, Node<E> nodeRef) {
			data = element;
			next = nodeRef;
		}
	}

	public static void main(String[] args) {

		SinglyLinkedList<String> nameList = new SinglyLinkedList<String>();

		nameList.addFirst("Dave");
		nameList.add(0, "Ann");
		nameList.add(1, "Bob");
		nameList.add("Tom");
		nameList.add(2, "Margaret");
		System.out.println(nameList);
		System.out.println(nameList.size());

		System.out.println(nameList.get(0));
		System.out.println(nameList.get(1));
		nameList.set(3, "Davide");
		System.out.println(nameList.get(3));

		nameList.remove("Ann");
		System.out.println(nameList);
		nameList.remove("foo");
		System.out.println(nameList);
		nameList.removeFirst();
		System.out.println(nameList);
		nameList.remove(3);
		System.out.println(nameList);
		nameList.remove(1);
		System.out.println(nameList);
	}

	private void remove(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}