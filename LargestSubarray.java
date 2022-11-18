package Group3;

import java.util.Scanner;

public class LargestSubarray {

	public static void main(String[] args) {
		LargestSubarray task = new LargestSubarray();
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
		System.out.println(lengthOfLargestSubarray(arr));
	}

	int lengthOfLargestSubarray(int[] arr) {
		int maxLength = 0,sum;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<=arr.length;j++) {
				sum=0;
				for (int k = i; k < j; k++)
					sum+=arr[k];
				if(sum==0)
					maxLength=Math.max(maxLength, j-i);
			}
		}
		return maxLength;
	}

}
