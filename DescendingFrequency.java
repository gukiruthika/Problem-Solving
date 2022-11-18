package GST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DescendingFrequency {

	public static void main(String[] args) {
		DescendingFrequency task = new DescendingFrequency();
		task.process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int length = scan.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the elements");
		for (int i = 0; i < length; i++)
			arr[i] = scan.nextInt();
		scan.close();
		getArranged(arr);
	}

	private void getArranged(int[] arr) {
		int temp;
		List<Integer> frequency = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i : arr) {
			if (numbers.contains(i)) {
				frequency.set(numbers.indexOf(i), frequency.get(numbers.indexOf(i)) + 1);
			} else {
				numbers.add(i);
				frequency.add(numbers.indexOf(i), 1);
			}
		}
		for (int i = 0; i < frequency.size(); i++) {
			for (int j = i + 1; j < frequency.size(); j++) {
				if (frequency.get(i) < frequency.get(j)) {
					temp = frequency.get(i);
					frequency.set(i, frequency.get(j));
					frequency.set(j, temp);
					temp = numbers.get(i);
					numbers.set(i, numbers.get(j));
					numbers.set(j, temp);
				}
			}
		}
		for (int i = 0; i < frequency.size(); i++) {
			for (int j = 0; j < frequency.get(i); j++) {
				System.out.print(numbers.get(i));
			}
		}
//		TreeMap<Integer,Integer> frequency = new TreeMap<>();
//		for(int i:arr)
//			frequency.put(i, frequency.getOrDefault(i, 0));
//		List<Integer> list = Arrays.asList(arr); 
//		Collections.sort(list, new Comparator<Integer>() {
//			 public int compare(Integer n1, Integer n2)
//	            {
//	                int freq1 = frequency.get(n1);
//	                int freq2 = frequency.get(n2);
//	                if (freq1 != freq2) {
//	                    return freq2 - freq1;
//	                }
//	                else {
//	                    return n2-n1; 
//	                }
//	            }
//		});
//		System.out.println(list);
	}

}
