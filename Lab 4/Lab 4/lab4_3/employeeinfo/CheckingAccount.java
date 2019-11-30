package lab4_3.employeeinfo;

public class CheckingAccount extends Account{
	
//	AccountType accountType;
	
	CheckingAccount(Employee emp, double balance) {
		super(emp, balance);
		this.accountType = AccountType.CHECKING;
	}

	public AccountType getAcctType() {
		return AccountType.CHECKING;
	}
	
	@Override
	public double getBalance() {
		//implementing the $5 monthly charge
		double tempBalance = super.getBalance();
		tempBalance = tempBalance - 5.0;
		return tempBalance;
	}
	
	public String toString() {
		return "Account type: " + getAcctType().toString() + "\nCurrent bal: " + getBalance();
	}

}
