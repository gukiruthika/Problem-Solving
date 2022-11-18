package GSC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class GreaterNode {

	public static void main(String[] args) {
		GreaterNode task = new GreaterNode();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		System.out.println("Enter the elements");
		for (int i = 0; i < length; i++)
			list.add(scan.nextInt());
		scan.close();
		System.out.println(Arrays.toString(getGreaterNode(list)));
	}

	private int[] getGreaterNode(LinkedList<Integer> list) {
		int[] greaterNode = new int[list.size()];
		int max;
		for (int i = 0; i < list.size(); i++) {
			max = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (max < list.get(j)) {
					greaterNode[i] = max = list.get(j);
				}
			}
		}
		return greaterNode;
	}

}
