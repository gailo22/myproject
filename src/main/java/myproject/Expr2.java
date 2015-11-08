package myproject;

import java.util.Stack;

public class Expr2 {
	
	static Stack<Integer> values = new Stack<Integer>();

	public static void main(String[] args) {
		
		// 1 + 2 - 4
		Node node = new Op("-", new Op("+", new Int(1), 
				                                new Int(2)), 
				                  new Int(4));
		
		eval(node);
		
		System.out.println("Result ==> " + values.pop());

	}
	
	private static void eval(Node node) {
		if (node != null) {
			eval(node.left);
			eval(node.right);
			
			if (!(node instanceof Op)) {
				values.push(node.value);
			} else {
				Integer right = values.pop();
				Integer left = values.pop();
				String op = node.op;
				System.out.println("(" + left + " " + op + " " + right+ ")");
				
				// push result back to stack
				values.push(compute(left, right, op));
			}
		}
	}
	
	private static int compute(Integer leftValue, Integer rightValue, String op) {
		// do calculation based on operator
		switch(op) {
			case "+" : return leftValue + rightValue;
			case "-" : return leftValue - rightValue;
			case "x" : return leftValue * rightValue;
			case "/" : return leftValue / rightValue;
		}
		throw new IllegalArgumentException();
	}

	static class Node {
		Integer value;
		Node left;
		Node right;
		String op;
		
		Node() {}
		
	}
	
	static class Int extends Node {

		Int(Integer value) {
			this.value = value;
		}
	}
	
	static class Op extends Node {

		Op(String op, Node left, Node right) {
			this.op = op;
			this.left = left;
			this.right = right;
		}
	}

}
