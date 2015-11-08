package myproject;

// Part 1 - Design and implement the classes to represent expression trees 
//Example 1:
//      + 
//  -     x 
//2     1 2    / 
//           4 2 
//
//Example 2:
//      + 
//  -     4 
//2     1 

class ExpTreeNode {
	char value;
	ExpTreeNode left;
	ExpTreeNode right;
	boolean leaf;
	char operator;

	ExpTreeNode(char c, boolean leaf) {
		value = c;
		this.leaf = leaf;
		operator = c;
	}

	public boolean isLeaf() {
		return leaf;
	}
}

class ExpTreeNodeTest {

	public static void main(String[] args) {
		ExpTreeNode node = new ExpTreeNode('+', false);
		node.left = new ExpTreeNode('-', false);
		node.right = new ExpTreeNode('4', true);

		node.left.left = new ExpTreeNode('2', true);
		node.left.right = new ExpTreeNode('1', true);

		System.out.println(evaluate(node));
	}

	private static int evaluate(ExpTreeNode node) {

		int result = 0;
		if (node.isLeaf()) {
			result = Integer.valueOf("" + node.value);
		} else {
			int left;
			int right;

			char op = node.operator;

			left = evaluate(node.left);
			right = evaluate(node.right);

			switch (op) {
			case '+':
				result = left + right;
				break;
			case '-':
				result = left - right;
				break;
			case 'x':
				result = left * right;
				break;
			case '/':
				result = left / right;
				break;

			}
		}

		return result;

	}

}