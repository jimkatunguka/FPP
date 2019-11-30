package lab2;

public class Prog3 {

	public static void main(String[] args) {
	float x = (float) 1.27;
	float y = (float) 3.881;
	float z = (float) 9.6;
	int sum1 = (int) (x+y+z);
	
	int sum2 = Math.round(x+y+z);
	
	System.out.printf("Sum1 is %d\n", sum1);
	System.out.printf("Sum2 is %d\n", sum2);
	
	}
	

}
