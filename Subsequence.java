package GSC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Subsequence {

	public static void main(String[] args) {
		Subsequence task = new Subsequence();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		String input = scan.nextLine();
		scan.close();
		System.out.println(getRepeatedSubsequence(input));
	}

	private int getRepeatedSubsequence(String input) {
		int count=0;String temp;
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		findSubsequences(list,input,"");
		System.out.println(list.size()-1);
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			temp=list.remove(i);
			if(list.contains(temp)) {
				list2.add(temp);
				list.removeAll(Collections.singleton(temp));
			}
			
		}
//		System.out.println(list2);
		return count;
	}

	private static void findSubsequences(List<String> list,String s, String ans) {
		if (s.length() == 0) {
            list.add(ans);
            return;
        }
		findSubsequences(list,s.substring(1), ans + s.charAt(0));
		findSubsequences(list,s.substring(1), ans);
	}

}
