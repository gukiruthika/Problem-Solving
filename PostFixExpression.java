package Group1;

import java.util.Scanner;
import java.util.Stack;

public class PostFixExpression {
	/*
	 * Write code to evaluate a given postfix expression efficiently.
	 * 
	 * For example,
	 * 
	 * 82/ will evaluate to 4 (8/2)
	 * 
	 * 138*+ will evaluate to 25 (1+8*3)
	 * 
	 * 545*+5/ will evaluate to 5 ((5+4*5)/5) Assume that the postfix expression
	 * contains only single-digit numeric operands, without any whitespace.
	 */
	public static void main(String[] args) {
		PostFixExpression task = new PostFixExpression();
		task.getInput();
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("PostFixExpression : ");
		String expression = scan.nextLine();
		scan.close();
		System.out.println(getResult(expression));
	}

	private int getResult(String expression) {
		int result = 0;
		Stack<Integer> equation = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i))) {
				equation.push(expression.charAt(i) - 48);
			} else {
				result = solve(equation.pop(), equation.pop(), expression.charAt(i));
				equation.push(result);
			}
		}
		return result;
	}

	private int solve(int number2, int number1, char operator) {
		switch (operator) {
		case '+':
			return (number1 + number2);
		case '-':
			return (number1 - number2);
		case '*':
			return (number1 * number2);
		case '/':
			return (number1 / number2);
		default:
			return 0;
		}
	}

}
