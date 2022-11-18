package GSC;

import java.util.Scanner;

public class ArrayProduct {

	public static void main(String[] args) {
		ArrayProduct task = new ArrayProduct();
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
		printProduct(arr);
	}

	private void printProduct(int[] arr) {
		int product;
		for (int i = 0; i < arr.length; i++) {
			product=1;
			for (int j = 0; j < arr.length; j++) {
				if(i!=j)
					product*=arr[j];
			}
			System.out.print(product+" ");
		}
		
	}
	
	
}
