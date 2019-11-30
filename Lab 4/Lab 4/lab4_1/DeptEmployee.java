package lab4_1;

import java.time.LocalDate;

public class DeptEmployee {
	private String name;
	private LocalDate hireDate;
	private double salary;

	public DeptEmployee(String name, double salary, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		this.salary = salary;
		hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public double computeSalary() {
		return salary;
	}

}
