package GSC;

import java.util.Arrays;
import java.util.Scanner;

public class GreaterNode2 {

	private class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node insert(Node head, int data) {
		if (head == null) {
			return new Node(data);
		}
		Node newNode = head;
		while (newNode.next != null) {
			newNode = newNode.next;
		}
		newNode.next = new Node(data);
		return head;
	}

	private int size(Node head) {
		int size = 0;
		Node currentNode = head;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}

	private int get(Node head, int index) {
		Node current = head;
		for (int i = 0; i < size(head); i++) {
			if (i == index)
				return current.data;
			current = current.next;
		}
		return 0;
	}

	public static void main(String[] args) {
		GreaterNode2 task = new GreaterNode2();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		System.out.println("Enter the elements");
		Node head = null;
		while (length-- > 0) {
			int element = scan.nextInt();
			head = insert(head, element);
		}
		System.out.println(Arrays.toString(getGreaterNode(head)));
		scan.close();
	}

	private int[] getGreaterNode(Node head) {
		int[] greaterNode = new int[size(head)];
		int max;
		for (int i = 0; i < size(head); i++) {
			max = get(head, i);
			for (int j = i + 1; j < size(head); j++) {
				if (max < get(head, j)) {
					greaterNode[i] = max = get(head, j);
				}
			}
		}
		return greaterNode;
	}
}
