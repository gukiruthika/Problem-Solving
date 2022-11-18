package Group1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberSystem {
	/*
	 * Form a number system with only 3 and 4. Find the nth number of the number
	 * system. Eg.) The numbers are: 3, 4, 33, 34, 43, 44, 333, 334, 343, 344, 433,
	 * 434, 443, 444, 3333, 3334, 3343, 3344, 3433, 3434, 3443, 3444 ….
	 */
	public static void main(String[] args) {
		NumberSystem numberSystem = new NumberSystem();
		System.out.println(numberSystem.getNthTerm());
	}

	String getNthTerm() {
		System.out.print("Enter n: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		List<String> numberList = new ArrayList<String>();
		numberList.add("3");
		numberList.add("4");
		for (int i = 0; i < numberList.size(); i++) {
			if (numberList.size() >= n)
				break;
			numberList.add(numberList.get(i) + "3");
			numberList.add(numberList.get(i) + "4");
		}
		return n + "th term -> " + numberList.get(n - 1);
	}

}
