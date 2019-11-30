package lab2;
import java.util.*;
public class Prog2 {

	public static void main(String[] args) {
	
		int x = RandomNumbers.getRandomInt(1, 9);
		int y = RandomNumbers.getRandomInt(3, 14);
		
		System.out.printf("The random value of x is %d\n", x);
		System.out.printf("The value of π^x is %f\n\n", Math.pow(Math.PI, x));
		
		System.out.printf("The random value of y is %d\n", y);
		System.out.printf("The value of y^π is %f\n", Math.pow(y, Math.PI));
	
	}

}
