package lab4_3.employeeinfo;

public class Account {
	
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private Employee employee;
	AccountType accountType;
	
	Account(Employee emp, double balance){
		employee = emp;
		this.balance = balance;
	}

	Account(Employee emp){
		this(emp,DEFAULT_BALANCE);
	}
	
	public void makeDeposit(double deposit) {
		double newBalance = this.balance + deposit;
		this.balance = newBalance;
	}
	
	public void makeWithdrawal(double amount) {
		if(amount <= this.balance) {
			balance = balance - amount;
		}else
			System.out.println("Can't withdraw funds from this account due to insufficient balance!");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public AccountType getAcctType() {
		return AccountType.CHECKING;
	}

}
