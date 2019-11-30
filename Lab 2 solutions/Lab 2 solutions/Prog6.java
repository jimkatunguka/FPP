package lab2;

import java.util.Arrays;

public class Prog6 {

	public static void main(String[] args) {
		String[] m = {"cow", "goat", "cow", "hen"};
		System.out.println(Arrays.toString(removeDups(m)));
		
	}
		
	public static String[] removeDups(String [] oldArray) {
		for(int j=0; j<oldArray.length; j++) {
			for(int k=j+1; k<oldArray.length; k++) {
				if(oldArray[j]==oldArray[k]) {
					oldArray[k]= " ";
				}
			}
		}
		int arraySize = 0;
		for(String i : oldArray ) {
			if(i !=" ")
				++arraySize;
		}
		String[]newArray = new String[arraySize];
		for(int i=0, j=0; i<oldArray.length && j<newArray.length; i++) {
			if(oldArray[i] != " ") {
				 newArray[j] = oldArray[i];
				   j++;
			}
			  
		}
		return newArray;
		
		}
		
	}


