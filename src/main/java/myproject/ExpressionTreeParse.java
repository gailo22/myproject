package myproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionTreeParse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String stringExpr = "(5+2)*7";

		ExpressionTreeParse parser = new ExpressionTreeParse();

		int result = parser.expr(stringExpr);
		
		System.out.println(result);

	}

	public int expr(String stringExpr) {
		List<String> parseExp = parse(stringExpr);

		BinaryTreeNode<String> node = buildTreeNode(parseExp);

		return perfromExpression(node);
	}
	
	public List<String> parse(String stringExpr) {
		List<String> result = new ArrayList<String>();
		Stack<String> opStack = new Stack<String>();
		for (int i = 0; i < stringExpr.length(); i++) {
			String c = String.valueOf(stringExpr.charAt(i));
			if (!"(".equals(c)) {
				if (isOperator(c)) {
					opStack.push(c);
				} else if (")".equals(c)) {
					String op = opStack.pop();
					result.add(op);
				} else {
					result.add(c);
				}
			}
		}
		result.add(opStack.pop());
		return result;
	}

	public BinaryTreeNode<String> buildTreeNode(List<String> parseExp) {
		// TODO: build binary tree node
		BinaryTreeNode<String> treeNode = new BinaryTreeNode<String>(null, null, null);
		
		return null;
	}
	
	public int perfromExpression(BinaryTreeNode<String> node) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean isOperator(String c) {
		return OP.PLUS.getCode().equals(c) || OP.MULT.getCode().equals(c)
				|| OP.MINUS.getCode().equals(c) || OP.DIV.getCode().equals(c);
	}

	private void expr(Stack<String> stack) {
		int val1 = Integer.parseInt(stack.pop());
		String op = stack.pop();
		int val2 = Integer.parseInt(stack.pop());
		stack.pop();

		if (OP.PLUS.getCode().equals(op)) {
			int sum = val1 + val2;
			stack.push(String.valueOf(sum));
		} else if (OP.MULT.getCode().equals(op)) {
			int mul = val1 * val2;
			stack.push(String.valueOf(mul));
		} else if (OP.MINUS.getCode().equals(op)) {
			int minus = val1 - val2;
			stack.push(String.valueOf(minus));
		} else if (OP.DIV.getCode().equals(op)) {
			int div = val1 / val2;
			stack.push(String.valueOf(div));
		}

	}

	enum OP {
		PLUS('+'), MINUS('-'), MULT('*'), DIV('/');

		char op;

		OP(char op) {
			this.op = op;
		}

		public String getCode() {
			return String.valueOf(op);
		}
	}

}
