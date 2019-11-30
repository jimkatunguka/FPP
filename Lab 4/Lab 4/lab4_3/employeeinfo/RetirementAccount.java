package lab4_3.employeeinfo;

public class RetirementAccount extends Account{
	
	public RetirementAccount(Employee emp, double balance) {
		super(emp, balance);
		this.accountType = AccountType.RETIREMENT;
	}
	
	public AccountType getAcctType() {
		return AccountType.RETIREMENT;
	}
	
	@Override
	public void makeWithdrawal(double amount) {
		double tempBalance = super.getBalance();
		if(amount <= tempBalance) {
			tempBalance = tempBalance - (2/100.0) * tempBalance;
			tempBalance = tempBalance - amount;
			super.setBalance(tempBalance);
		}else
			System.out.println("Can't withdraw funds from this account due to insufficient balance!");
	}
	
	public String toString() {
		return "Account type: " + getAcctType().toString() + "\nCurrent bal: " + getBalance();
	}

}
