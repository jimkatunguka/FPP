package lab4_3.employeeinfo;

import lab4_3.AccountList;

import java.time.LocalDate;

public class Employee {

//	private Account savingsAcct;
//	private Account checkingAcct;
//	private Account retirementAcct;
	private AccountList accounts;
	private String name;
	private LocalDate hireDate;

	public Employee(String name, int yearOfHire,
	int monthOfHire, int dayOfHire){
	this.name = name;
	hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	this.accounts = new AccountList();
	}

	public void createNewChecking(double startAmount) {
		Account checkingAcct = new CheckingAccount(this, startAmount);
		this.accounts.add(checkingAcct);
	}
	
	public void createNewSavings(double startAmount) {
		Account savingsAcct = new SavingsAccount(this, startAmount);
		this.accounts.add(savingsAcct);
	}
	
	public void createNewRetirement(double startAmount) {
		Account retirementAcct = new RetirementAccount(this, startAmount);
		this.accounts.add(retirementAcct);
	}
	
	public void deposit(int accountIndex, double amt){
		Account selected = accounts.get(accountIndex);
		selected.makeDeposit(amt);
//		acc.makeDeposit(amt);
	}
	
	public void withdraw(int accountIndex, double amt){
		Account selected = accounts.get(accountIndex);
		selected.makeWithdrawal(amt);
//		acc.makeWithdrawal(amt);
	}

	public String getFormattedAcctInfo() {
		String output = "";
		for(Account x : this.accounts.getAccountArray()) {
			if(x instanceof CheckingAccount)
				output += "\n" + x.toString() ;
			if(x instanceof SavingsAccount)
				output += "\n" + x.toString() ;
			if(x instanceof RetirementAccount)
				output += "\n" + x.toString() ;
		}
		return output;
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}
	
	public AccountList getAccounts() {
		return accounts;
	}
	
	/*public Account getSavingsAcct() {
		return savingsAcct;
	}

	public Account getCheckingAcct() {
		return checkingAcct;
	}

	public Account getRetirementAcct() {
		return retirementAcct;
	}*/
	
}
