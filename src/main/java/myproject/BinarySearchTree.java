package myproject;

public class BinarySearchTree<E extends Comparable<E>> {
	
	static class BTNode<E> {
		E data;
		BTNode left;
		BTNode right;
		
		BTNode(E element) {
			this.data = element;
		}
	}
	
	BTNode<E> root;
	
	BinarySearchTree() {
		root = null;
	}
	
	boolean contains(E target) {
		if (root == null) return false;
		
		BTNode<E> current = root;
		
		while (current != null) {
			int compareTo = target.compareTo(current.data);
			if (compareTo == 0) return true;
			else if (compareTo < 0) current = current.left;
			else current = current.right;
		}
		
		return false;
	}
	
	void add(E element) {
		root = add(root, element);
	}

	BTNode<E> add(BTNode<E> t, E element) {
		if (t == null) return new BTNode(element);
		
		int compareTo = element.compareTo(t.data);
		if (compareTo < 0) t.left = add(t.left, element);
		else if (compareTo > 0) t.right = add(t.right, element);
		
		return t;
	}

}
