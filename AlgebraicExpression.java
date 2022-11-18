package session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlgebraicExpression {

	public static void main(String[] args) {
		new AlgebraicExpression().process();
	}

	private void process() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
//		String input = "(2x+y)*(3x-5y)";
//		String input = "(2xy+4x^2y)*(2x^2y+6xy)";
//		String input = "(2x^2y+3xy^2z-xz^3)*(5xyz+3y^2z-2z)";
		solve(input);
	}

	private void solve(String input) {
		String[] terms = input.split("[*]");
		List<String> exp1 = getTermList(terms[0]);
		List<String> exp2 = getTermList(terms[1]);
		List<String> result = new ArrayList<>();
		System.out.println(exp1);
		System.out.println(exp2);
		for (int i = 0; i < exp1.size(); i += 2) {
			for (int j = 0; j < exp2.size(); j += 2) {
				result.add(String.valueOf(getNumber(exp1.get(i)) * getNumber(exp2.get(j))));
				result.add(getOrdered(getProduct(exp1.get(i + 1), exp2.get(j + 1))));
			}
		}
		System.out.println(getSimplified(result));
	}

	private List<String> getTermList(String input) {
		int start = 0;
		boolean flag = true;
		List<String> terms = new ArrayList<>();
		input = input.substring(1, input.length() - 1);
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) >= 'a' & input.charAt(j) <= 'z' & flag) {
				terms.add(input.substring(start, j));
				start = j;
				flag = false;
			}
			if (input.charAt(j) == '+' | input.charAt(j) == '-') {
				terms.add(input.substring(start, j));
				start = j;
				flag = true;
			}
			if (j == input.length() - 1) {
				terms.add(input.substring(start));
				flag = true;
			}
		}
		return terms;
	}

	private String getSimplified(List<String> input) {
		List<String> output = new ArrayList<>();
		int sum = 0;
		output.add(input.get(0));
		output.add(input.get(1));
		for (int i = 3; i < input.size(); i += 2) {
			if (output.contains(input.get(i))) {
				sum = Integer.valueOf(output.get(output.indexOf(input.get(i)) - 1)) + Integer.valueOf(input.get(i - 1));
				output.set(output.indexOf(input.get(i)) - 1, String.valueOf(sum));
			} else {
				output.add(input.get(i - 1));
				output.add(input.get(i));
			}
		}
		String result = "";
		for (int i = 0; i < output.size(); i++) {
			if (i != 0 & i % 2 == 0) {
				if(output.get(i).length()==1&&output.get(i).charAt(0) == '0') {
					i++;
					continue;
				}
				if(output.get(i).length()==2&&output.get(i).charAt(0) == '-'&&output.get(i).charAt(1) == '0') {
					i++;
					continue;
				}
					
				if (output.get(i).charAt(0) != '-')
					result += '+';
			}
			if(output.get(i).length()==1&&output.get(i).charAt(0) == '1') {
				continue;
			}
			if(output.get(i).length()==2&&output.get(i).charAt(0) == '-'&&output.get(i).charAt(1) == '1') {
				result += '-';
				continue;
			}
			result += output.get(i);
		}
		return result;
	}

	private String getOrdered(String product) {
		List<String> list = new ArrayList<>();
		int start = 0;
		for (int i = 1; i < product.length(); i++) {
			if ((product.charAt(i) >= 'a' & product.charAt(i) <= 'z')) {
				list.add(product.substring(start, i));
				start = i;
			}
		}
		list.add(product.substring(start));
		Collections.sort(list);
		String output = "";
		for (String i : list)
			output += i;
		return output;
	}

	private String getProduct(String t1, String t2) {
		String product = "";
		int power;
		char variable;
		for (int i = 0; i < t1.length(); i++) {
			for (int j = 0; j < t2.length(); j++) {
				power = 0;
				if (t1.charAt(i) == t2.charAt(j) & t1.charAt(i) > 96 & t1.charAt(i) < 123) {
					variable = t1.charAt(i);
					if ((i < t1.length() - 2) && (t1.charAt(i + 1) == '^')) {
						power += t1.charAt(i + 2) - '0';
						t1 = t1.substring(0, i) + "   " + t1.substring(i + 3);
					} else {
						power++;
						t1 = t1.substring(0, i) + " " + t1.substring(i + 1);
					}
					if ((j < t2.length() - 2) && (t2.charAt(j + 1) == '^')) {
						power += t2.charAt(j + 2) - '0';
						t2 = t2.substring(0, j) + "   " + t2.substring(j + 3);
					} else {
						power++;
						t2 = t2.substring(0, j) + " " + t2.substring(j + 1);
					}
					product += String.valueOf(variable) + (char) '^' + String.valueOf(power);
				}
			}
		}
		for (int i = 0; i < t1.length(); i++) {
			if (t1.charAt(i) != ' ')
				product += t1.charAt(i);
		}
		for (int i = 0; i < t2.length(); i++) {
			if (t2.charAt(i) != ' ')
				product += t2.charAt(i);
		}
		return product;
	}

	private int getNumber(String term) {
		if(term.length()==0)
			return 1;
		if (term.charAt(0) == '+') {
			if (term.length() == 1)
				return 1;
			return Integer.valueOf(term.substring(1));
		}
		if (term.charAt(0) == '-') {
			if (term.length() == 1)
				return -1;
			return -1 * Integer.valueOf(term.substring(1));
		}
		return Integer.valueOf(term);
	}

}
