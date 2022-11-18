package Group3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstElement {

	public static void main(String[] args) {
		FirstElement task = new FirstElement();
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
		System.out.println("Enter the number of times");
		int k = scan.nextInt();
		scan.close();
		System.out.println(getFirstNumber(arr,k));
	}

	private int getFirstNumber(int[] arr,int k) {
		Map<Integer,Integer> frequency = new HashMap<>();
		for(int i:arr) {
			if(frequency.containsKey(i)) {
				frequency.put(i, frequency.get(i)+1);
				if(frequency.get(i)==k)
					return i;
			}
			else {
				frequency.put(i, 1);
			}
		}
		return 0;
	}

}
