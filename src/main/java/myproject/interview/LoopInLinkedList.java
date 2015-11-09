package myproject.interview;

public class LoopInLinkedList {

	public static void main(String[] args) {

		insert(5);
		insert(4);
		insert(3);
		insert(2);
		insert(1);

		System.out.println(hasLoop(head));
		makeLoop();
		System.out.println(hasLoop(head));
	}

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int i) {
			this.data = i;
		}
	}

	static void insert(int i) {
		if (head == null) {
			head = new Node(i);
		} else {
			Node newNode = new Node(i);
			newNode.next = head;
			head = newNode;
		}
	}

	static void makeLoop() {
		Node cur = head;
		Node node2 = null;
		int i = 0;
		while (cur.next != null) {
			cur = cur.next;

			if (i == 1) {
				node2 = cur;
			}
			i++;
		}

		cur.next = node2;
	}

	static boolean hasLoop(Node first) {
		if (first == null)
			return false;

		Node slow, fast;
		slow = fast = first;

		while (true) {
			slow = slow.next;

			if (fast.next != null)
				fast = fast.next.next;
			else
				return false;

			if (slow == null || fast == null)
				return false;

			if (slow == fast)
				return true;
		}
	}

}
