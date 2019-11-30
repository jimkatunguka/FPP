package lab4_3;

import java.util.Scanner;

import lab4_3.employeeinfo.Employee;

public class Main {
	Employee[] emps = null;
	public static void main(String[] args) {
		new Main();
	}
	Main(){
		emps = new Employee[3];
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2,13);
		
		//adding Employee names to array in MyStringList
		MyStringList myNamwList = new MyStringList();
		myNamwList.add(emps[0].getName());
		myNamwList.add(emps[1].getName());
		myNamwList.add(emps[2].getName());
		
		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);	
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);	
		
				
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A. See a report of all accounts.\r\n" + 
				"B. Make a deposit.\r\n" + 
				"C. Make a withdrawal.\r\n" + 
				"Make a selection (A/B/C): ");
		String answer = sc.next();
		
		if(answer.equalsIgnoreCase("A")){
			String info = getFormattedAccountInfo();
			System.out.println(info);
		}
		else if(answer.equalsIgnoreCase("B")) {
			for(int i=0 ; i < myNamwList.getStrArray().length ; i++) {
				System.out.println(i + ". " +myNamwList.getStrArray()[i]);
			}
			System.out.print("Select an employee: (type a number): ");
			int answer2 = sc.nextInt();
			Employee tempEmp = new Employee("John Doe", 2000, 1, 1);
			switch(answer2){
				case 0:
					tempEmp = emps[0];
					break;
				case 1:
					tempEmp = emps[1];
					break;
				case 2:
					tempEmp = emps[2];
					break;
				default:
		 			System.out.println("Invalid input!");
		 			System.exit(0);
			}
			System.out.print("0. checking\r\n" + 
					"1. savings\r\n" + 
					"2. retirement\r\n" + 
					"Select an account: (type a number): ");
			int accIndex = sc.nextInt();
			System.out.print("Deposit amount: ");
			double depAmount = sc.nextDouble();
			switch(accIndex){
			case 0:
				tempEmp.deposit(0, depAmount);
				break;
			case 1:
				tempEmp.deposit(1, depAmount);
				break;
			case 2:
				tempEmp.deposit(2, depAmount);
				break;
			default:
				System.out.println("Invalid input!");
				System.exit(0);
			}
			System.out.println("$" + depAmount + " has been deposited in the " + 
								tempEmp.getAccounts().getAccountArray()[accIndex].getAcctType().toString()+
								" account of " + tempEmp.getName());
			
		}
		else if(answer.equalsIgnoreCase("C")) {
			
		}
		else {
			System.out.println("Invalid input!");
			System.exit(0);
		}
		sc.close();
	}
	String getFormattedAccountInfo(){
		String output = "";
		for(Employee e : emps) {
			output += "ACCOUNT INFO FOR " + e.getName() + " :\n";
			output += e.getFormattedAcctInfo() + "\n\n";
		}
		return output;
	}
}
