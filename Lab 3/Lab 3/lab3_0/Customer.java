package lab3_0;
public class Customer {
	private String firstName;
	private String lastName;
	private String socSecurityNum;
	private Address billingAddress;
	private Address shippingAddress;
	
	public Customer(String fName, String lName, String ssn) {
		firstName = fName;
		lastName = lName;
		socSecurityNum = ssn;
	}
	public String toString() {
		return "[" + firstName + ", " + lastName + ", ssn: " + socSecurityNum + "]";
	}
	public Address getbillingAddress() {
		return billingAddress;
	}
	public void setbillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getshippingAddress() {
		return shippingAddress;
	}
	public void setshippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
}
