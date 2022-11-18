package GSC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ZeroSumTriplets {

	public static void main(String[] args) {
		ZeroSumTriplets task = new ZeroSumTriplets();
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
		printTriplets(arr);
	}

	private void printTriplets(int[] num) {
		int[] temp = new int[3];
		String s;
		Set<String> list = new HashSet<>();
		for (int i = 0; i < num.length - 2; i++) {
			for (int j = i + 1; j < num.length - 1; j++) {
				for (int k = j + 1; k < num.length; k++) {
					if (i != j & i != k & j != k & num[i] + num[j] + num[k] == 0) {
						temp[0] = num[i];
						temp[1] = num[j];
						temp[2] = num[k];
						Arrays.sort(temp);
						list.add(Arrays.toString(temp));
					}
				}
			}
		}
		System.out.println(list);
	}
}
