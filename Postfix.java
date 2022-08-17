//////////////////////////////
//	*************************
//	* Auth:twitter.com/l79l *
//	*************************
//////////////////////////////

import java.util.Stack;
import java.util.Locale;
import java.util.Scanner;

public class MyPostfix {

	static double evaluatePostfix(String exp) {
		Stack<Double> stack = new Stack<Double>();
		Scanner tokenx = new Scanner(exp).useLocale(Locale.US);

		while (tokenx.hasNext()) {

			if (tokenx.hasNextDouble()) {
				stack.push(tokenx.nextDouble());

			} else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				String op = tokenx.next();

				switch (op) {
				case "+":
					stack.push(num1 + num2);
					break;

				case "-":
					stack.push(num1 - num2);
					break;

				case "*":
					stack.push(num1 * num2);
					break;

				case "/":
					stack.push(num1 / num2);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Input an expression: ");
		String exp = sc.nextLine();
		System.out.println("Result = " + evaluatePostfix(exp));

	}
}
