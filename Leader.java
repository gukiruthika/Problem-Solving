package Group3;

import java.util.Scanner;

public class Leader {

	public static void main(String[] args) {
		Leader task = new Leader();
		task.process();
	}

	void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the elements");
		for (int i = 0; i < length; i++)
			arr[i] = scan.nextInt();
		scan.close();
		getLeader(arr);
	}

	void getLeader(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					arr[i] = 0;
					break;
				}
			}
			if (arr[i] != 0)
				System.out.print(arr[i]+" ");
		}
	}

}
