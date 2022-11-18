package GST;

import java.util.LinkedList;
import java.util.Scanner;

public class SortLinkedList {
	
	public static void main(String[] args) {
		SortLinkedList task = new SortLinkedList();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		LinkedList<T> list = new LinkedList<>();
		System.out.println("Enter the elements");
		for (int i = 0; i < length; i++)
			list.add(scan.nextInt());
		scan.close();
		getArranged(list);

	}

	private void getArranged(LinkedList<Integer> list) {
		int i = 0, n = 0;

		while (list.lastIndexOf(n) != i | n != 2) {
			list.add(i, list.remove(list.lastIndexOf(n)));
			i++;
			if (list.lastIndexOf(n) == i - 1) {
				n++;
				if (n == 2)
					break;
			}
		}
		System.out.println(list);
	}

}
