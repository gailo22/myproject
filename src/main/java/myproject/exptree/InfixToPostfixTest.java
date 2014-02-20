package myproject.exptree;

import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPostfixTest {

	private static final String OPERATORS = "+-*/^";

	public static void main(String[] args) {

		String str = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";

		StringTokenizer tokenizer = new StringTokenizer(str);

		Stack<String> opStack = new Stack<String>();
		StringBuilder outputStr = new StringBuilder();

		int currentprecedence = 0;

		while (tokenizer.hasMoreTokens()) {
			String nextToken = tokenizer.nextToken();
			if (isOperator(nextToken)) {
				int precedence = getPrecedence(nextToken);
				if (precedence > currentprecedence || !isLeftAssociativity(nextToken)) {
					opStack.push(nextToken);
				} else {
					String op = opStack.pop();
					outputStr.append(op + " ");
					opStack.push(nextToken);
				}

				currentprecedence = precedence;

			} else if (isOpenBracket(nextToken)) {
				opStack.push(nextToken);
				currentprecedence = 0;
			} else if (isCloseBracket(nextToken)) {
				String op = opStack.pop();
				outputStr.append(op + " ");

				// Repeated until "(" found
				while (!isOpenBracket(op)) {
					op = opStack.pop();
					if (!isOpenBracket(op)) {
						outputStr.append(op + " ");
					}
				}
			} else {
				outputStr.append(nextToken + " ");
			}
		}

		// Pop entire stack to output
		while (!opStack.isEmpty()) {
			outputStr.append(opStack.pop() + " ");
		}

		System.out.println("output: " + outputStr.toString());
		// 3 4 2 * 1 5 − 2 3 ^ ^ / +

	}

	private static boolean isCloseBracket(String nextToken) {
		return ")".equals(nextToken);
	}

	private static boolean isOpenBracket(String nextToken) {
		return "(".equals(nextToken);
	}

	private static boolean isOperator(String nextToken) {
		return OPERATORS.contains(nextToken);
	}

	private static int getPrecedence(String nextToken) {
		if ("^".equals(nextToken)) {
			return 4;
		} else if ("*".equals(nextToken) || "/".equals(nextToken)) {
			return 3;
		} else if ("+".equals(nextToken) || "-".equals(nextToken)) {
			return 2;
		}

		throw new UnsupportedOperationException();
	}

	private static boolean isLeftAssociativity(String nextToken) {
		if ("^".equals(nextToken)) {
			return false;
		}

		return true;
	}

}
