package Group3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Anagram task = new Anagram();
		task.process();
	}

	void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of test case");
		int testCase = scan.nextInt();
		scan.nextLine();
		while (testCase-- > 0) {
			System.out.println("Enter the string");
			String str = scan.nextLine();
			System.out.println(getCount(str));
		}
		scan.close();
	}

	int getCount(String str) {
		Queue<String> list = new LinkedList<String>();
		int count=0;
		String temp;
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				list.add(str.substring(i,j));
			}
		}
		
		while(list.size()>0) {
			temp=list.poll();
			for(String word:list) {
				if(isAnagram(temp,word))
					count++;
			}
		}
		return count;
	}
	
	boolean isAnagram(String str1,String str2) {
		if(str1.length()!=str2.length())
			return false;
		int[] frequency = new int[26];
		for (int i = 0; i < str1.length(); i++) {
			frequency[str1.charAt(i)-'a']++;
			frequency[str2.charAt(i)-'a']--;
		}
		for (int i:frequency) {
			if(i!=0)
				return false;
		}
		return true;
	}

}
