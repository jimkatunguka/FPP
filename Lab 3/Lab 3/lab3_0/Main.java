package lab3_0;
public class Main {

	public static void main(String[] args) {
		
		Address add1B = new Address("10 Adams", "Chicago", "IL", "60656");
		Address add1S = new Address("110 Darlington", "Chicago", "IL", "60656");
		Address add2B = new Address("322 Harrison", "Princeton", "NJ", "07003");
		Address add2S = new Address("2210 Burlington", "Fairfield", "IA", "52556");
		
		Customer c1 = new Customer("Joe", "Smith", "332-221-4444");
		c1.setbillingAddress(add1B);
		c1.setshippingAddress(add1S);
		
		Customer c2 = new Customer("Barack", "Obama", "654-786-1256");
		c2.setbillingAddress(add2B);
		c2.setshippingAddress(add2S);
		
		Customer[] empArray = {c1,c2};
		
		
		for(Customer i: empArray) {
			if(i.getbillingAddress().getCity().equalsIgnoreCase("Chicago"))
					 {
				System.out.println("Customer: "+ i);
				System.out.println("Billing Address: " + i.getbillingAddress());		
			}
			
		}

		
	}

}
