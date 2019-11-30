package lab3_1;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Employee employee = new Employee("Jack", "Boew", 100000, 2019, 8, 1);
		Date d = employee.getHireDay();
		
		Account C = new Account(employee, AccountType.CHECKING, 300);
		Account S = new Account(employee, AccountType.SAVINGS, 300);
		Account R = new Account(employee, AccountType.RETIREMENT, 300);
		
		System.out.println(C.toString());
		System.out.println(S.toString());
		System.out.println(R.toString());

	}

}
