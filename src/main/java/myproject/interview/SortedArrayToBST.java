package myproject.interview;

import java.util.Stack;

public class SortedArrayToBST {

	static class Node {
		Node left;
		Node right;
		int data;
	}

	public static void main(String[] args) {

		int[] sortedArray = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		SortedArrayToBST s = new SortedArrayToBST();
		Node node = s.sortedArrayToBST(sortedArray, 11);

		displayTree(node);
	}

	private static void printTree(Node node) {
		if (node == null)
			return;

		printTree(node.left);
		System.out.print(node.data + " ");
		printTree(node.right);
	}

	public static void displayTree(Node root) {
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println("......................................................");
	} 

	Node sortedArrayToBST(int[] a, int n) {
		return sortedArrayToBST(a, 0, n - 1);
	}

	private Node sortedArrayToBST(int[] a, int start, int end) {
		if (start > end)
			return null;

		int mid = start + (end - start) / 2;
		Node node = new Node();
		node.data = a[mid];
		node.left = sortedArrayToBST(a, start, mid - 1);
		node.right = sortedArrayToBST(a, mid + 1, end);

		return node;
	}

}
