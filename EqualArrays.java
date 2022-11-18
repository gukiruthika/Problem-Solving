package Group3;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {

	public static void main(String[] args) {
		EqualArrays task = new EqualArrays();
		task.process();
	}

	void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		int[] arr1 = new int[length];
		System.out.println("Enter the elements of array 1");
		for (int i = 0; i < length; i++)
			arr1[i] = scan.nextInt();
		int[] arr2 = new int[length];
		System.out.println("Enter the elements of array 2");
		for (int i = 0; i < length; i++)
			arr2[i] = scan.nextInt();
		scan.close();
		System.out.println(isEqualArray(arr1,arr2));
	}

	private boolean isEqualArray(int[] arr1, int[] arr2) {
		if(arr1.length!=arr2.length)
			return false;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < arr2.length; i++) {
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}
	
	

}
