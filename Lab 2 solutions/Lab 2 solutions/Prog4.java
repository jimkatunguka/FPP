package lab2;

import java.util.*;

public class Prog4 {

	public static void main(String[] args) {
		String myString = Data.records; 
		
        String[] arrOfStr = myString.split(",|:"); 
        
        for(int i=0; i<arrOfStr.length-5; i+=5) {
        	
        System.out.println(arrOfStr[i]);	
        }

	}

}
