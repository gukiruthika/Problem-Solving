package GST;

import java.util.Scanner;

public class PrintPattern {

	public static void main(String[] args) {
		PrintPattern task = new PrintPattern();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		String input = scan.nextLine();
		System.out.println("Enter number of rows");
		int row = scan.nextInt();
		printPattern(input, row);
		scan.close();
	}

	private void printPattern(String input, int row) {
		int length = input.length();
		char[][] pattern = new char[row][length/2+1];
		int index = 0, columnIndex = 0, rowIndex;
		while (index < length) {
			for (rowIndex = 0; rowIndex < row & index < length; rowIndex++) {
				pattern[rowIndex][columnIndex] = input.charAt(index++);
			}
			rowIndex--;
			columnIndex++;
			while (rowIndex > 1 & index < length) {
				pattern[--rowIndex][columnIndex++] = input.charAt(index++);
			}
		}
		for (rowIndex = 0; rowIndex < row; rowIndex++) {
			for (columnIndex = 0; columnIndex < length/2+1; columnIndex++) {
				System.out.print(pattern[rowIndex][columnIndex]);
			}
			System.out.println();
		}
	}
}
