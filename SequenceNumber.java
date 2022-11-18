package Group1;

import java.util.Scanner;

public class SequenceNumber {
	/*
	 * Given a sequence of length <= 8 consisting of I and D, where I denotes the
	 * increasing sequence and D denotes the decreasing sequence, decode the
	 * sequence to construct a minimum number without repeated digits.
	 * 
	 * For example,
	 * 
	 * sequence output
	 * 
	 * IIDDIDID ——> 125437698 IDIDII ——> 1325467 DDDD ——> 54321 IIII ——> 12345
	 * 
	 */
	public static void main(String[] args) {
		SequenceNumber task = new SequenceNumber();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a sequence : ");
		String sequence = scan.nextLine();
		scan.close();
		getNumber(sequence);
	}

	private void getNumber(String sequence) {
		int number = 0;
		int[] arr = new int[sequence.length() + 1];
		for (int i = 0; (i <= sequence.length() & number < sequence.length() + 1); i++) {
			if (i == sequence.length() || sequence.charAt(i) == 'I') {
				arr[i] = ++number;
				for (int j = i - 1; (j >= 0 && arr[j] == 0); j--) {
					arr[j] = ++number;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
