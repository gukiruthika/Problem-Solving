package GST;

import java.util.Scanner;

public class OddEvenIndex {

	public static void main(String[] args) {
		OddEvenIndex task = new OddEvenIndex();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the elements");
		for (int i = 0; i < length; i++)
			arr[i] = scan.nextInt();
		scan.close();
		arr = getArranged(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	private int[] getArranged(int[] arr) {
		int temp;
		for (int i = 0; i < arr.length; i = i + 2) {
			for (int j = i + 2; j < arr.length; j = j + 2) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				if (j + 1 < arr.length) {
					if (arr[i + 1] < arr[j + 1]) {
						temp = arr[i + 1];
						arr[i + 1] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		}
		return arr;
	}

}
