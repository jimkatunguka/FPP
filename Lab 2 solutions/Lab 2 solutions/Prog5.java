package lab2;
import java.util.*;

public class Prog5 {

	public static void main(String[] args) {
		
	Scanner input = new Scanner(System.in);
	
	
	System.out.println("Enter any string");
	String word = input.next();
	
	System.out.println("The reverse of the string is");
	
	for(int i=word.length()-1; i>=0; i--) {
	System.out.print(word.charAt(i));
	}

	}

}
