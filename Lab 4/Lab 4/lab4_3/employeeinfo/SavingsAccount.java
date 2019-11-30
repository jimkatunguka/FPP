package lab4_3.employeeinfo;

public class SavingsAccount extends Account{
	
	private static final double rate = 0.25/100;
	
	SavingsAccount(Employee emp, double balance) {
		super(emp, balance);
		this.accountType = AccountType.SAVINGS;
	}

	public AccountType getAcctType() {
		return AccountType.SAVINGS;
	}
	
	@Override
	public double getBalance() {
		//implementing the 0.25% interest on savings account
		double tempBalance = super.getBalance();
		tempBalance = tempBalance + rate * tempBalance;
		return tempBalance;
	}
	
	public String toString() {
		return "Account type: " + getAcctType().toString() + "\nCurrent bal: " + getBalance();
	}

}
