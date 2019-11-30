package lab7_3;

import java.util.Arrays;
import java.util.Scanner;

public class BinSearch {

	public static void main(String[] args) {
		
		BinSearch binSearch = new BinSearch();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter string here: \n");
		String input = sc.next();
		
		//sorting the input string
		char[]charInput = input.toCharArray();
		Arrays.sort(charInput);
		String sortedInput = new String(charInput);
		
		System.out.print("Enter character to search here: \n");
		char c = sc.next().charAt(0);
		System.out.println(binSearch.search(sortedInput, c));
		sc.close();
	}
	
	boolean search(String s, char c){
		if(s.length() == 1) {
			if(s.charAt(0) == c)
				return true;
			else
				return false;
		}
		if(s.length() == 2) {
			if((s.charAt(0) == c)||(s.charAt(1) == c))
				return true;
			else
				return false;
		}
		else {
			int len = s.length();
			char[] charS = s.toCharArray();
			int m = len/2;
			char ch = charS[m];

			if(c == ch)
				return true;

			else if(c < ch) {
				char[] temp = new char[m];
				System.arraycopy(charS, 0, temp, 0, m);
				String leftHalfString = new String(temp);
				return search(leftHalfString, c);
			}
			else if(c > ch){
				char[] temp = new char[len - (m + 1)];
				System.arraycopy(charS, m+1, temp, 0, len - (m + 1));
				String rightHalfString = new String(temp);
				return search(rightHalfString, c);
			}
			return false;
		}
	}

}
