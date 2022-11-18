package GSC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Knight {

	public static void main(String[] args) {
		Knight task = new Knight();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n");
		int n = scan.nextInt();
		System.out.println("Enter row");
		int row = scan.nextInt();
		System.out.println("Enter column");
		int column = scan.nextInt();
		System.out.println("Enter k");
		int k = scan.nextInt();
		scan.close();
		System.out.println(getProbability(n, row, column, k));
	}

	private double getProbability(int n, int row, int column, int k) {
		int onBoardPossibilities = getOnBoardPossibilities(n, row, column, k);
//		double totalPossibilities = Math.pow(8, k);
		System.out.println(onBoardPossibilities);
		return onBoardPossibilities / Math.pow(8, k);
	}

	private int getOnBoardPossibilities(int n, int row, int column, int k) {
		Queue<List<Integer>> possibilities = new LinkedList<>();
		List<Integer> oldPosition = new ArrayList<>();
		oldPosition.add(row);
		oldPosition.add(column);
		possibilities.add(oldPosition);
		int count;
		while (k-- > 0) {
			count = possibilities.size();
			for (int i = 0; i < count; i++) {
				possibilities.addAll(getNewPositions(possibilities.poll(),n));
			}
		}
		return possibilities.size();
	}

	private Queue<List<Integer>> getNewPositions(List<Integer> oldPosition,int n) {
		Queue<List<Integer>> newPositions = new LinkedList<>();
		int[][] position = { { -1, -2 }, { -2, -1 }, { -1, 2 }, { -2, 1 }, { 1, -2 }, { 2, -1 }, { 1, 2 }, { 2, 1 } };
		for (int j = 0; j < 8; j++) {
			List<Integer> newPosition = new ArrayList<>();
			newPosition.add(oldPosition.get(0) + position[j][0]);
			newPosition.add(oldPosition.get(1) + position[j][1]);
			if(newPosition.get(0) >= 0 & newPosition.get(0) < n & newPosition.get(1) >= 0 & newPosition.get(1) < n)
				newPositions.add(newPosition);
		}
		return newPositions;
	}
}
