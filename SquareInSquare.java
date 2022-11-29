package com.logic;

import java.util.Scanner;

public class SquareInSquare {

	public static void main(String args[]) {
		SquareInSquare pattern = new SquareInSquare();
		pattern.toPrintPattern1();
	}

	void toPrintPattern() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the number..");
			int n = scan.nextInt();
			int l = n * 2 - 1;
			int[][] ar = new int[l][l];
			int[][] visit = new int[l][l];
			int start = 0, end = l - 1;
			while (n > 0) {
				for (int i = 0; i < l; i++) {
					for (int j = 0; j < l; j++) {
						if ((visit[i][j] == 0) && (i == start | i == end | j == start | j == end)) {
							ar[i][j] = n;
							visit[i][j] = 1;
						}
					}
				}
				start++;
				end--;
				n--;
			}
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					System.out.print(ar[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private void toPrintPattern1() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the number..");
			int input = scan.nextInt();
			int length = 2 * input - 1;
			int i = 1, j = 1, number = input, numberOfElements=length * length;
//			for (int k = 1; k <= length * length; k++) {
			while(numberOfElements-- > 0) {
				System.out.print(number);
				if (i <= length / 2 + length % 2) {
					if (j < i) {
						number--;
					}
					if (length - j < i) {
						number++;
					}
				} else {
					if (j <= length - i) {
						number--;
					}
					if (length - j <= length - i) {
						number++;
					}
				}
				j++;
				if (((i-1)*length+j-1) % length == 0) {
					System.out.println();
					j = 1;
					i++;
					number = input;
				}
			}
		}
	}
	
	void toPrintPattern2() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the number..");
			int n = scan.nextInt();
			int l = 2 * n - 1;
			int noe = l * l, le = 1, ln = 1, m = n;
			for (int i = 1; i <= noe; i++) {
				System.out.print(n);
				n+=(ln <= l / 2 + l % 2)&&(le < ln)?-1:0;
				n+=(ln <= l / 2 + l % 2)&&(l - le < ln)?1:0;
				n+=(ln <= l / 2 + l % 2)?0:(le <= l - ln)?-1:0;
				n+=(ln <= l / 2 + l % 2)?0:(l - le <= l - ln)?1:0;
				le++;
				le=(i % l == 0)?0:le;
				ln+=(i % l == 0)?1:0;
				n=(i % l == 0)?m:n;
				if (i % l == 0)
					System.out.println();
			}
		}
	}
}
