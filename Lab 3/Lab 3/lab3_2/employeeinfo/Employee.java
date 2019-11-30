package lab3_2.employeeinfo;

import java.time.LocalDate;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	public Employee(String name, int yearOfHire,
	int monthOfHire, int dayOfHire){
	this.name = name;
	hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	public void createNewChecking(double startAmount) {
		this.checkingAcct = new Account(this,AccountType.CHECKING, startAmount);
	}
	
	public void createNewSavings(double startAmount) {
		this.savingsAcct = new Account(this,AccountType.SAVINGS, startAmount);
	}
	
	public void createNewRetirement(double startAmount) {
		this.retirementAcct = new Account(this,AccountType.RETIREMENT, startAmount);
	}
	
	public void deposit(AccountType acctType, double amt){
		if(acctType.equals(this.checkingAcct.getAccountType())) {
			this.checkingAcct.makeDeposit(amt);
		}else if(acctType.equals(this.savingsAcct.getAccountType())) {
			this.savingsAcct.makeDeposit(amt);
		}else
			this.retirementAcct.makeDeposit(amt);
	}
	public boolean withdraw(AccountType acctType, double amt){
		if(acctType.equals(this.checkingAcct.getAccountType())) {
			this.checkingAcct.makeWithdrawal(amt);
		}else if(acctType.equals(this.savingsAcct.getAccountType())) {
			this.savingsAcct.makeWithdrawal(amt);
		}else
			this.retirementAcct.makeWithdrawal(amt);
		return true;
	}

	public String getFormattedAcctInfo() {
		return 
		savingsAcct.toString() + "\n" +
		checkingAcct.toString() + "\n" +
		retirementAcct.toString();
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}
	
}
