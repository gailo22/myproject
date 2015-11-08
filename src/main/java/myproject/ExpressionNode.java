package myproject;

import java.util.Stack;

public class ExpressionNode {
	
	String value;
	ExpressionNode left;
	ExpressionNode right;
	
	ExpressionNode(String value) {
		this.value = value;
	}
	
	ExpressionNode(String value, ExpressionNode left, ExpressionNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
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
	
	

	// Part 1 Design and implement the classes to represent expression trees 
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
    	ExpressionNode node = new ExpressionNode("+", new ExpressionNode("-", new ExpressionNode("2"), 
    			                                                              new ExpressionNode("1")),
    			                                      new ExpressionNode("x", new ExpressionNode("2"), 
    			                                    		                  new ExpressionNode("/", new ExpressionNode("4"), 
    			                                    		                                          new ExpressionNode("2"))));
        
        evaluate(node);
        System.out.println("Ex 1. ==> " + values.pop());
    	
    	// Ex 2.
        // (2 - 1) + 4 --> 5
    	node = new ExpressionNode("+", new ExpressionNode("-", new ExpressionNode("2"), 
    			                                               new ExpressionNode("1")), 
    			                       new ExpressionNode("4"));
        
        evaluate(node);
        System.out.println("Ex 2. ==> " + values.pop());
    }
}


