package lab4_1;

public class Professor extends DeptEmployee {
	private int numberOfPublications;
	
	public Professor(String name, double salary, int yearOfHire, int monthOfHire, int dayOfHire) {
		super(name, salary, yearOfHire, monthOfHire, dayOfHire);
	}

	public int getNumberOfPublications() {
		return numberOfPublications;
	}

	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}

	

}
