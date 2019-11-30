package lab7_1;

public class Exponential {

	public static void main(String[] args) {
		Exponential exp = new Exponential();
		System.out.println(exp.power(2,10));
	}
	
	double power(double x,int n) {
		if(n == 1) {
			return x * n;
		}
		return x*power(x,n-1) ;
	}

}
