package myproject.exptree2;

import java.util.Stack;

public class ExpressionTree2 {
	
	private static class Node {
		String value;
		Node left;
		Node right;
		
		Node(String value) {
			this.value = value;
		}
	}
	
	private Stack<Integer> values = new Stack<>();
	
	public boolean isOperator(String value) {
		return "+-*/".indexOf(value) != -1;
	}
	
	public int compute(String op, Integer a, Integer b) {
		switch (op) {
			case "+": return a + b;
			case "-": return a - b;
			case "*": return a * b;
			case "/": return a / b;
		}
		
		throw new IllegalArgumentException("Operation is not support: " + op);
	}
	
	public void compute(Node node) {
		if (node != null) {
			compute(node.left);
			compute(node.right);
			
			if (isOperator(node.value)) {
				int a = values.pop();
				int b = values.pop();
				String op = node.value;
				
				values.push(compute(op, b, a));
			} else {
				values.push(Integer.valueOf(node.value));
			}
		}
	}
	
	public static void main(String[] args) {
		// 2 * 3 + 4 - 1
		//       -
		//      / \
		//     +   1
		//    / \
		//   *   4
		//  / \
		// 2   3
		
		Node root = new Node("-");
		root.right = new Node("1");
		root.left = new Node("+");
		root.left.right = new Node("4");
		root.left.left = new Node("*");
		root.left.left.right = new Node("3");
		root.left.left.left = new Node("2");
		
		ExpressionTree2 ex = new ExpressionTree2();
		ex.compute(root);
		System.out.println(ex.values.pop()); // 9
		
	}

}
