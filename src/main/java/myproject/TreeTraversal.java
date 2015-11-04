package myproject;

import java.util.LinkedList;
import java.util.Queue;


public class TreeTraversal {

	public static void main(String[] args) {
		
		//             4
		//           /  \
		//          2    5
		//        /  \
		//       1    3
		TreeNode<Integer> root = new TreeNode<>(4, new TreeNode<>(2, new TreeNode<>(1, null, null), new TreeNode<>(3, null, null)), 
				                                   new TreeNode<>(5, null, null));
		
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		levelOrder(root);
		
	}
	
	private static void inOrder(TreeNode<Integer> node) {
		if (node != null) {
			inOrder(node.getLeft());
			node.visit();
			inOrder(node.getRight());
		}
	}
	
	private static void preOrder(TreeNode<Integer> node) {
		if (node != null) {
			node.visit();
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	private static void postOrder(TreeNode<Integer> node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			node.visit();
		}
	}
	
	private static void levelOrder(TreeNode<Integer> node) {
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		
		TreeNode<Integer> current = node;
		
		while (current != null) {
			
			// visit current
			current.visit();
			
			// keep left child in the queue
			TreeNode<Integer> left = current.getLeft();
			if (left != null) {
				queue.add(left);
			}
			
			// keep right child in the queue
			TreeNode<Integer> right = current.getRight();
			if (right != null) {
				queue.add(right);
			}
			
			current = queue.poll();
		}
		
		System.out.println(queue);
	}
	
	static class TreeNode<E> {
		E data;
		TreeNode<E> left;
		TreeNode<E> right;
		
		TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public TreeNode<E> getLeft() {
			return left;
		}

		public TreeNode<E> getRight() {
			return right;
		}

		public void visit() {
			System.out.print(data + " -> ");
		}
	}

}
