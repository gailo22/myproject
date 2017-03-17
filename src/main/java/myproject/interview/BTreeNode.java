package myproject.interview;

public class BTreeNode {

	int val;
	BTreeNode left;
	BTreeNode right;
	
	BTreeNode(int x) { val = x; }
	BTreeNode(int x, BTreeNode l, BTreeNode r) { 
		val = x;
		left = l;
		right = r;
	}
}
