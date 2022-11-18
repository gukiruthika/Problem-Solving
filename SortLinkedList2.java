package GST;

import java.util.Scanner;

public class SortLinkedList2 {

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

	public static void main(String[] args) {
		SortLinkedList2 task = new SortLinkedList2();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		System.out.println("Enter the elements");
		Node list = null;
		for (int i = 0; i < length; i++) {
			int element = scan.nextInt();
			list = insert(list, element);
		}
		scan.close();
		getArranged(list);
	}

	private void getArranged(Node list) {
		int i = 0, n = 0;

		while (lastIndexOf(list, n) != i | n != 2) {
			list = add(list, i, remove(list, lastIndexOf(list, n)));
			System.out.println();
			display(list);
			i++;
			if (lastIndexOf(list, n) == i - 1) {
				n++;
				if (n == 2)
					break;
			}
		}
		System.out.println();
		display(list);
	}

	private void display(Node list) {
		Node currentNode = list;
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}

	private int get(Node list, int index) {
		Node current = list;
		for (int i = 0; i < size(list); i++) {
			if (i == index)
				return current.data;
			current = current.next;
		}
		return 0;
	}

	private int size(Node list) {
		int size = 0;
		Node currentNode = list;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
		}
		return size;
	}

	private int lastIndexOf(Node list, int n) {
		for (int i = size(list); i >= 0; i--) {
			if (get(list, i) == n)
				return i;
		}
		return 0;
	}

	private int remove(Node list, int index) {
		int data;
//		Node previousNode = list;
//		Node currentNode = list.next;
		if (index == 0) {
			data = list.data;
			list.data = currentNode.data;
			list.next = list.next.next;
			return data;
		}
		for (int i = 1; i < size(list); i++) {
			if (i == index) {
				data = currentNode.data;
				previousNode.next = currentNode.next;
				return data;
			}
		}
		return 0;
	}

	private Node add(Node list, int index, int element) {
		Node newNode = new Node(element);
		if (index == 0) {
			newNode.next = list;
			return newNode;
		}
		Node previousNode = list;
		for (int i = 1; i < size(list); i++) {
			if (i == index) {
				newNode.next = previousNode.next;
				previousNode.next = newNode;
				return list;
			}
		}
		return null;
	}

}
