package lab3_2.employeeinfo;

public class Account {
	
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private Employee employee;
	AccountType accountType;
	
	Account(Employee employee, AccountType accountType, double balance){
		this.employee = employee;
		this.accountType =accountType;
		this.balance = balance;
	}
	
	Account(Employee emp, AccountType accountType){
		this(emp,accountType,DEFAULT_BALANCE);
	}
	
	public String toString() {
		return "Account type: " + accountType + "\nCurrent bal: " + balance;
	}
	
	public void makeDeposit(double deposit) {
		//implement
		double newBalance = this.balance + deposit;
		this.balance = newBalance;
	}
	
	public boolean makeWithdrawal(double amount) {
		//implement
		if(amount <= this.balance) {
			double acBalance = this.balance - amount;
			this.balance = acBalance;
			return true;
		}else
			return false;
	}

	public double getBalance() {
		return balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
}
