package Group1;

import java.util.Scanner;

public class SnakeMatrix {

	public static void main(String[] args) {
		new SnakeMatrix().process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number..");
		int input = scan.nextInt();
		scan.close();
		printSnakeMatrix(input);
	}

	private void printSnakeMatrix(int input) {
		int value = 1, space = input - 1, line = input;
		for (int i = 0; i < input / 2 + 1; i++) {
			for (int j = 0; j < space; j++)
				System.out.print("  ");
			for (int j = 0; j < input && line > 0; j++)
				System.out.print(value++ + " ");
			System.out.println();
			line--;
			space--;
			value += input - 1;
			for (int j = 0; j < space; j++)
				System.out.print("  ");
			for (int j = 0; j < input && line > 0; j++)
				System.out.print(value-- + " ");
			System.out.println();
			line--;
			space--;
			value += input + 1;
		}
	}

}
