package GST;

import java.util.Scanner;

public class PrintTheMessage {

	public static void main(String[] args) {
		PrintTheMessage task = new PrintTheMessage();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of packets");
		int number = scan.nextInt();
		scan.nextLine();
		String[] packets = new String[number];
		for (int i = 1; i <= packets.length; i++) {
			System.out.print("P" + i + ":");
			packets[i - 1] = scan.nextLine();
		}
		printTheMessage(packets);
		scan.close();
	}

	private void printTheMessage(String[] packets) {
		int maxLength = 0, n = 1, maxLengthIndex = 0;
		char checkOrder = '1', temp;
		String message = "", regex;
		for (int i = 0; i < packets.length;) {
			regex = (n) + "[-].+";
			if (packets[i].substring(1, packets[i].length() - 1).matches(regex)) {
				message = message + packets[i].substring(3, packets[i].length() - 1);
				n++;
				i = 0;
			} else
				i++;
		}

		for (int i = 0; i < packets.length; i++) {
			temp = packets[i].charAt(1);
			if (temp == checkOrder)
				packets[i] = "";
			if (maxLength <= packets[i].length()) {
				maxLength = packets[i].length();
				maxLengthIndex = i;
			}
			checkOrder = (char) (temp + 1);
		}

		System.out.println("Message: " + message);
		if (maxLength - 2 > 0)
			System.out.println("Buffered packet with maximum length:" + (maxLength - 2) + " -For P"
					+ (maxLengthIndex + 1) + ": " + packets[maxLengthIndex]);
		else
			System.out.println("No packets in Buffered packet");

	}

}
