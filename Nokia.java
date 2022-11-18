package Group2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nokia {

	public static void main(String[] args) {
		new Nokia().process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.println(printOutput(input));
	}

	private String printOutput(String input) {
		String out="";
		boolean isCaps = false;
		if(input.charAt(0)=='#') {
			input=input.substring(1);
			isCaps=true;
		}
		String[] output = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		String[] arr = input.split("-");
		for (int i = 0; i < arr.length; i++)
			out+=output[arr[i].charAt(0)-'2'].charAt(arr[i].length()-1);
		if(isCaps)
			out = out.toUpperCase();
		return out;
	}
}
