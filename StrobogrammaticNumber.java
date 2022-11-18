package Group1;

import java.util.Scanner;

public class StrobogrammaticNumber {
	/*
	 * Find the given number is Strobogrammatic or not. [A strobogrammatic number is
	 * a number whose numeral is rotationally symmetric, so that it appears the same
	 * when rotated 180 degrees. In other words, the numeral looks the same
	 * right-side up and upside down (e.g., 69, 96, 1001).]
	 */
	public static void main(String[] args) {
		StrobogrammaticNumber task = new StrobogrammaticNumber();
		task.process();
	}

	void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number : ");
		String number = scan.nextLine();
		scan.close();
		System.out.println(isStrobogrammatic(number));
	}

	String isStrobogrammatic(String number) {
		if (number.matches("[23457]"))
			return "It is not strobogrammatic number";
		int start = 0, end = number.length() - 1;
		while (start <= end) {
			if (number.charAt(start) != getStrobogrammatic(number.charAt(end)))
				return "It is not strobogrammatic number";
			start++;
			end--;
		}
		return "It is strobogrammatic number";
	}

	char getStrobogrammatic(char number) {
		switch (number) {
		case '1':
			return '1';
		case '0':
			return '0';
		case '8':
			return '8';
		case '6':
			return '9';
		case '9':
			return '6';
		default:
			return ' ';
		}
	}
}
