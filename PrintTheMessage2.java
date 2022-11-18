package GST;

import java.util.Scanner;
import java.util.TreeMap;

public class PrintTheMessage2 {

	public static void main(String[] args) {
		PrintTheMessage2 task = new PrintTheMessage2();
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
		TreeMap<Integer, String> buffer = new TreeMap<>();
		String maxLength = "";
		String[] temp;
		int order = 1, maxLengthIndex = 0;
		System.out.print("Message: ");
		for (int i = 0; i < packets.length; i++) {
			packets[i] = packets[i].substring(1, packets[i].length() - 1);
			temp = packets[i].split("-");
			if (Integer.valueOf(temp[0]) == order) {
				System.out.print(temp[1]);
				order++;
			} else {
				if (maxLength.length() < packets[i].length()) {
					maxLength = packets[i];
					maxLengthIndex = i;
				}

				buffer.put(Integer.valueOf(temp[0]), temp[1]);
			}
		}

		for (String s : buffer.values()) {
			System.out.print(s);
		}

//		System.out.println("\nBuffer size -> " + buffer.size());
		if (buffer.size() > 0)
			System.out.println("\nBuffered packet with maximum length: " + (maxLength.length()) + " - For P"
					+ (maxLengthIndex + 1) + ": " + '"' + maxLength + '"');
		else
			System.out.println("\nBuffer is empty");

	}

}
