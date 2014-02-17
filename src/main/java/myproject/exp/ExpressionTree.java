package myproject.exp;

import java.util.Scanner;

/**
 * This class represents a binary expression. The class provides a helper method for parsing postfix expressions to
 * create an expression tree. The class contains three traversal methods that return prefix, infix, and postfix String
 * versions of the expression. Finally, expression trees can be evaluated to determine the result of the expression.
 * <p>
 * 
 * ExpressionTree objects are immutable.
 * 
 * @author Peter Jensen
 */
public class ExpressionTree {
	// Instance variables

	private Node root;

	/**
	 * This method parses a postfix expression and builds and returns the corresponding expression tree.
	 * 
	 * @param expression a postfix expression
	 * @return an expression tree representing the expression
	 * @throws IllegalExpressionException if the expression is illegal
	 */
	public static ExpressionTree parsePostfixExpression(String expression) {
		LabStack<Node> nodes = new LabStack<Node>();

		// Parse the tokens, push them onto a stack.

		Scanner expressionScanner = new Scanner(expression);
		while (expressionScanner.hasNext()) {
			String next = expressionScanner.next();
			Node node = new Node(next);
			if (node.token == ExpressionToken.UNKNOWN)
				throw new IllegalExpressionException(next);
			if (node.token != ExpressionToken.NUMBER) {
				if (nodes.size() < 2)
					throw new IllegalExpressionException("Not enough arguments for: " + next);
				node.right = nodes.pop();
				node.left = nodes.pop();
			}
			nodes.push(node);
		}

		// Check for errors and empty trees, build the tree.

		if (nodes.size() > 1)
			throw new IllegalExpressionException("More than one expression.");

		if (nodes.size() == 0)
			nodes.push(null);

		return new ExpressionTree(nodes.pop());
	}

	/**
	 * Creates an expression tree with the given root. The constructor is private - use the static parsing method to
	 * create ExpressionTree objects.
	 * 
	 * @param root the root node for this tree
	 */
	private ExpressionTree(Node root) {
		this.root = root;
	}

	/**
	 * Returns true if this tree is empty, false otherwise.
	 * 
	 * @return true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Returns the size of the expression tree.
	 * 
	 * @return the size of the expression tree
	 */
	public int size() {
		///// Stub - Add your code here. /////

		return 0;
	}

	/**
	 * Evaluates and returns the value of this expression.
	 * 
	 * @return the value of this expression
	 * @throws IllegalExpressionException if the expression is empty
	 */
	public double evaluate() {
		///// Stub - Add your code here. /////

		return 0.0;
	}

	/**
	 * Returns a string containing a prefix version of the expression. The prefix expression will be formed by
	 * performing a pre-order traversal of the tree.
	 * 
	 * @return a String containing a prefix version of the expression.
	 */
	public String toPrefixString() {
		///// Stub - Add your code here. /////

		return null;
	}

	/**
	 * Returns a string containing a infix version of the expression. The infix expression will be formed by performing
	 * an in-order traversal of the tree.
	 * 
	 * @return a String containing a prefix version of the expression.
	 */
	public String toInfixString() {
		///// Stub - Add your code here. /////

		return null;
	}

	/**
	 * Returns a string containing a postfix version of the expression. The postfix expression will be formed by
	 * performing a post-order traversal of the tree.
	 * 
	 * @return a String containing a postfix version of the expression.
	 */
	public String toPostfixString() {
		///// Stub - Add your code here. /////

		return null;
	}

	/**
	 * These nodes represent tokens in the expression and elements of the expression tree.
	 * <p>
	 * 
	 * Programmer note: Even though we know these nodes will only be used in an expression tree (which is a two-tree),
	 * null checks should be done on both the left and right nodes for safety.
	 */
	private static class Node {
		// Node instance variables.

		Node left, right;        // The left and right children of this node

		ExpressionToken token;   // A token object representing the data for this node

		double value;            // The numeric value for this token

		/**
		 * Constructor - Given a String, this constructor initializes the node with the correct expression token and
		 * value. The newly created node will not have any children.
		 * 
		 * @param token a String representing a single expression token
		 */
		Node(String token) {
			this.token = ExpressionToken.determineType(token);
			if (this.token == ExpressionToken.NUMBER)
				this.value = new Scanner(token).nextDouble();
			this.left = this.right = null;
		}

		/**
		 * Recursively computes and returns the size of this subtree.
		 * 
		 * @return the size of the subtree containing this node as a subroot
		 */
		int size() {
			///// Stub - Add your code here. /////

			return 0;
		}

		/**
		 * Returns a string containing a prefix version of this subtree. The prefix expression will be formed by
		 * performing a recursive pre-order traversal of this subtree.
		 * 
		 * @return a String containing a prefix version of the subtree.
		 */
		String toPrefixString() {
			///// Stub - Add your code here. /////

			return null;
		}

		/**
		 * Returns a string containing a infix version of this subtree. The infix expression will be formed by
		 * performing a recursive in-order traversal of this subtree.
		 * 
		 * @return a String containing a infix version of the subtree.
		 */
		String toInfixString() {
			///// Stub - Add your code here. /////

			return null;
		}

		/**
		 * Returns a string containing a postfix version of this subtree. The postfix expression will be formed by
		 * performing a recursive post-order traversal of this subtree.
		 * 
		 * @return a String containing a postfix version of the subtree.
		 */
		String toPostfixString() {
			///// Stub - Add your code here. /////

			return null;
		}

		/**
		 * Returns the numeric value that would result if this expression subtree were evaluated. If the node is a leaf
		 * node, the number in the leaf node is returned. If the node is an interior node, the operation in this node is
		 * applied to the values retrieved from the left and right subtrees.
		 * 
		 * @return the computed value for this expression (sub)tree.
		 */
		double evaluate() {
			return 0.0;  // Stub - remove this line and add your own code.
		}

		/**
		 * Returns the string representation for this node's type and value.
		 */
		public String toString() {
			if (token == ExpressionToken.NUMBER)
				return "" + value;
			return "" + token;
		}
	}

	/**
	 * An exception class for representing illegal expressions This is only used by the pop method.
	 */
	public static class IllegalExpressionException extends RuntimeException {
		public IllegalExpressionException(String message) {
			super("Illegal expression: " + message);
		}
	}
}
