package myproject.exptree;

import java.util.Stack;
import java.util.StringTokenizer;

public class RPNTest {


	public static void main(String[] args) {

		Stack<Integer> outputStack = new Stack<Integer>();

		String str = "5 1 2 + 4 * + 3 -";

		StringTokenizer tokenizer = new StringTokenizer(str);

		while (tokenizer.hasMoreTokens()) {
			String nextToken = tokenizer.nextToken();
			if (isOperator(nextToken)) {
				Integer r = outputStack.pop();
				Integer l = outputStack.pop();
				Integer result = calWithOperator(l, r, nextToken);
				outputStack.push(result);
			} else {
				outputStack.push(new Integer(nextToken));
			}
		}

		System.out.println("result: " + outputStack.pop());
		// 14

	}

	private static Integer calWithOperator(Integer l, Integer r, String nextToken) {
		if ("+".equals(nextToken)) {
			return l + r;
		} else if ("-".equals(nextToken)) {
			return l - r;
		} else if ("*".equals(nextToken)) {
			return l * r;
		} else if ("/".equals(nextToken)) {
			return l / r;
		}

		throw new UnsupportedOperationException();

	}

	private static boolean isOperator(String nextToken) {
		return "+".equals(nextToken) || "-".equals(nextToken) || "*".equals(nextToken) || "/".equals(nextToken);
	}

}
