package Group2;

public class Leet2code {

	public static void main(String[] args) {
		String input = "leet2code3";
		toPrint(input,10);
	}
	static void toPrint(String input,int k) {
		String output="";
		for(int i=0;i<input.length();i++) {
			if(Character.isDigit(input.charAt(i))) {
				int n=Integer.valueOf(input.substring(i, i+1));
				String temp = output;
				while(n-- >1) {
					output+=temp;
				}
			}
			else {
				output=output+input.charAt(i);
			}
		}
		System.out.println(output.charAt(k-1));
	}

}
