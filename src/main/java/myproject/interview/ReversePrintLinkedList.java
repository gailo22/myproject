package myproject.interview;

public class ReversePrintLinkedList {

	public static void main(String[] args) {

		insert(3);
		insert(2);
		insert(1);

		reversePrint(head);

	}

	static class Node {
		int data;
		Node next;

		Node(int i) {
			this.data = i;
		}
	}

	static Node head;

	static void insert(int i) {
		if (head == null) {
			head = new Node(i);
		} else {
			Node newNode = new Node(i);
			newNode.next = head;
			head = newNode;
		}
	}

	static void reversePrint(Node root) {
		if (root == null)
			return;

		reversePrint(root.next);
		System.out.println(root.data + " ");
	}

}
