package myproject.interview;

public class TreeDepth {

	static class Node {
		Node left;
		Node right;
		int data;
		
		Node(Node l, Node r, int d) {
			this.left = l;
			this.right = r;
			this.data = d;
		}
	}
	
	
	public static void main(String[] args) {
		
		Node root = new Node(new Node(new Node(null, null, 3), null, 2), 
							new Node(null, new Node(null, null, 5), 4), 1);
		
		System.out.println(height(root));

	}
	
	public static int height(Node node) {
		if (node == null) {
			return 0;
		}
		
		int hLeft = height(node.left);
		int hRight = height(node.right);
		int height = 1 + Math.max(hLeft, hRight);
		
		return height;
	}
	

}
