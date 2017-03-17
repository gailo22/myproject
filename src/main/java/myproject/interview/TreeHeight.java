package myproject.interview;

public class TreeHeight {
	
	static int height(BTreeNode root) {
		if (root == null) return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		BTreeNode root = new BTreeNode(1, new BTreeNode(2, new BTreeNode(3), null), new BTreeNode(5));
		int height = height(root);
		System.out.println(height);
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}
