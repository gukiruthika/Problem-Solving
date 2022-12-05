package com.logic;

public class WordReverse {

	public static void main(String[] args) {
		String sen = "one two three";
		System.out.println(reverse(sen,sen.length()-1,"",""));
	}

	private static String reverse(String sen,int index,String rev,String word) {
		if(index<0) {
			rev+=word + " ";
			return rev;
		}
		if(sen.charAt(index)==' ') {
			rev+=word + " ";
			return reverse(sen,index-1,rev,"");			
		}
		word=sen.charAt(index)+word;
		return reverse(sen,index-1,rev,word);
	}
}
