package la12_1;
import la4_1.Employee;

public class ExceptionHandling {

	Employee emp;
	public void handleException1() throws NullPointerException { // handles the exception where it's caught.
		try {
			String name = emp.getName();
			System.out.println(name);
		} catch (NullPointerException x) {
			System.out.println(x);
		}
	}

	public void handleException2() throws NullPointerException {// handles the exception where it's caught and throws it again.
		try {
			String name = emp.getName();
			System.out.println(name);
		} catch (NullPointerException y) {
			System.out.println(y);
			throw y;
		}
	}

	public void handleException3() throws NullPointerException {// throws a new exception in catch block.
		try {
			String name = emp.getName();
			System.out.println(name);
		} catch (NullPointerException z) {
			System.out.println(z);
			try {
				int num= Integer.parseInt("AAAA");
				System.out.println(num);
			} catch (NumberFormatException n) {
				System.out.println(n);
				throw new NumberFormatException();
			}
		}
	}

	// EXPERIMENT WITH THROWING AN EXCEPTION IN THE FINALLY BLOCK.
	public void handleException4() throws NullPointerException {
		try {
			String name = emp.getName();
			System.out.println(name);
		} catch (NullPointerException ex) {
			System.out.println("There is a " + ex + " in your method");
		} finally {
			try {
				int errorCode = Integer.parseInt("AAAA");
				System.out.println(errorCode);
			} catch (NumberFormatException e) {
				System.out.println("There is another " + e + " in your method");
				throw new NumberFormatException();
			}
		}
	}

	// WHEN A SPECIFIC EXCEPTIONS TYPES IN THE CATCH BLOCK IS WRONG THE COMPILER
	// THROWS THE CORRECT ONE AND IGNORES THE ONE IN THE TRY BLOCK
	public void handleException5() throws NullPointerException {
		try {
			int errorCode = Integer.parseInt("AAAA");
			System.out.println(errorCode);
		} catch (NullPointerException e) {
			System.out.println("There is another " + e + " in your method");
			throw new NullPointerException();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExceptionHandling eh = new ExceptionHandling();
		// eh.handleException1();
		// eh.handleException2();
		// eh.handleException3();
		// eh.handleException4();
		eh.handleException5();
	}

}
