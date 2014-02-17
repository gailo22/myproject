package myproject.exp;

import java.util.Scanner;

/**
 * This application is an expression evaluator. The user can enter simple mathematical expressions using numbers, +, -,
 * *, /, and %. The expression must use postfix notation.
 * <p>
 * 
 * This application is part of lab 8 for CS 2420.
 * 
 * @author pajensen
 */
public class Evaluator {
	/**
	 * The application entry point.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		// Print the greeting message.

		System.out.println("Expression evaluator - This application will evaluate");
		System.out.println("postfix mathematical expressions.  Enter a blank line");
		System.out.println("to exit.");

		// Loop indefinitely prompting for input and evaluating expressions.
		//   The application exit will break this loop using a return statement.

		while (true) {
			// Prompt the user, input an expression.

			System.out.println();
			System.out.print("Enter a single-line expression: ");
			String expression = new Scanner(System.in).nextLine().trim();

			// If empty, exit the application.

			if (expression.length() == 0) {
				System.out.println("Goodbye.");
				return;
			}

			// Create an ExpressionTree using the expression.

			ExpressionTree tree = ExpressionTree.parsePostfixExpression(expression);

			// Print out various traversals of this expression:

			System.out.println("Prefix version:  " + tree.toPrefixString());
			System.out.println("Infix version:   " + tree.toInfixString());
			System.out.println("Postfix version: " + tree.toPostfixString());

			// Evaluate the expression. 

			double result = tree.evaluate();

			// Print the result.

			System.out.println("Result: " + result);
		}

		// Execution never reaches this point - see above.
	}
}
