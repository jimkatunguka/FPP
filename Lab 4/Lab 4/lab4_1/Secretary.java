package lab4_1;

public class Secretary extends DeptEmployee {
	private double overtimeHours;
	
	public Secretary(String name, double salary, int yearOfHire, int monthOfHire, int dayOfHire) {
		super(name, salary, yearOfHire, monthOfHire, dayOfHire);
		
	}

	public double getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	public double computeSalary() {
		double secSalary = super.computeSalary() + (12*overtimeHours);
		return secSalary;
	}

}
