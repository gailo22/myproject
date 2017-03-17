package myproject.interview;

import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {
	
	static void level(BTreeNode root) {
		if (root == null) return;
		
		Queue<BTreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			root = q.poll();
			System.out.print(root.val + " -> ");
			if (root.left != null) {
				q.add(root.left);
			}
			if (root.right != null) {
				q.add(root.right);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		BTreeNode root = new BTreeNode(1, new BTreeNode(2, new BTreeNode(3), new BTreeNode(4)), new BTreeNode(5));
		level(root);
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}
