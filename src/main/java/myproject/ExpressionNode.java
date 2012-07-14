package myproject;

import java.util.Stack;

public class ExpressionNode {
	
	String value;
	ExpressionNode left;
	ExpressionNode right;
	
	ExpressionNode(String value) {
		this.value = value;
	}
	
	
	// to keep values in tree when do postorder transversal
	static Stack<Integer> values = new Stack<Integer>();
	
	private static boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") || str.equals("x") || str.equals("/");
	}
	
	// transverse the tree and evaluate values
	private static void evaluate(ExpressionNode node) {
		
		if (node != null) {
			evaluate(node.left);
			evaluate(node.right);


			// if not operators push into stack
			if (!isOperator(node.value)) {
				values.push(Integer.parseInt(node.value));
			} else {
				Integer rightValue = values.pop();
				Integer leftValue = values.pop();
				char op = node.value.charAt(0);
				System.out.println("(" + leftValue + " " + op + " " + rightValue+ ")");
				
				// push result back to stack
				values.push(compute(leftValue, rightValue, op));
			}
		}
		
	}

	private static int compute(Integer leftValue, Integer rightValue, char op) {
		// do calculation based on operator
		switch(op) {
			case '+' : return leftValue + rightValue;
			case '-' : return leftValue - rightValue;
			case 'x' : return leftValue * rightValue;
			case '/' : return leftValue / rightValue;
		}
		throw new IllegalArgumentException();
	}
	
	

	//- Part 1 – Design and implement the classes to represent expression trees 
	// Example 1:
    //	        + 
    //	    -     x 
	// 2     1  2    / 
    //	           4    2 
	//
	// Example 2:
    //	        + 
    //	    -      4 
	//    2     1 
	
    public static void main(String[] args) {
    	
    	// Ex 1.
    	// (2 - 1) + (2 x (4 / 2)) ---> 5
    	ExpressionNode node = new ExpressionNode("+");
        node.left = new ExpressionNode("-");
        node.right= new ExpressionNode("x");
        
        node.left.left = new ExpressionNode("2");
        node.left.right= new ExpressionNode("1");
        
        node.right.left = new ExpressionNode("2");
        node.right.right= new ExpressionNode("/");
        
        node.right.right.left = new ExpressionNode("4");
        node.right.right.right= new ExpressionNode("2");
        
        evaluate(node);
        System.out.println("Ex 1. ==> " + values.pop());
    	
    	// Ex 2.
        // (2 - 1) + 4 --> 5
    	node = new ExpressionNode("+");
        node.left = new ExpressionNode("-");
        node.right= new ExpressionNode("4");
        
        node.left.left = new ExpressionNode("2");
        node.left.right= new ExpressionNode("1");
        
        evaluate(node);
        System.out.println("Ex 2. ==> " + values.pop());
    }
}


