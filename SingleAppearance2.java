package Group1;

import java.util.Scanner;

public class SingleAppearance2 {

	public static void main(String[] args) {
		new SingleAppearance2().process();
	}
	
	static int timeComplexity=0;
	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int[] arr = new int[scan.nextInt()];
		System.out.println("Enter elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		System.out.println(getSingleAppearance(arr, 0, arr.length)+" - Time Complexity -> "+timeComplexity);

	}

	int getSingleAppearance(int[] arr, int start, int end) {
		timeComplexity++;
		if (end - start < 3) {
			return arr[end-1];
		}
		int mid = start + (end - start) / 2;
		if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
			return arr[mid];
		else if ((arr[mid] == arr[mid - 1] && mid % 2 == 0) || (arr[mid] == arr[mid + 1] && mid % 2 != 0))
			return getSingleAppearance(arr, start, mid);
		else
			return getSingleAppearance(arr, mid, end);
	}
}
