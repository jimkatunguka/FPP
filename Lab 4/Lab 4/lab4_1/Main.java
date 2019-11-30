package lab4_1;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Professor P1 = new Professor("Jim Daley", 15000, 2000, 9, 4);
		Professor P2 = new Professor("Bob Reuben", 12000, 1998, 1, 5);
		Professor P3 = new Professor("Susan Randolph", 10000, 1997, 2, 13);
		P1.setNumberOfPublications(10);
		P2.setNumberOfPublications(10);
		P3.setNumberOfPublications(10);
		
		Secretary S1 = new Secretary("Meghan Chi", 8000, 2012, 10, 6);
		Secretary S2 = new Secretary("John Roberts", 7500, 2009, 5, 16);
		S1.setOvertimeHours(200);
		S2.setOvertimeHours(200);
		
		DeptEmployee[] department = new DeptEmployee[5];
		department[0] = P1;
		department[1] = P2;
		department[2] = P3;
		department[3] = S1;
		department[4] = S2;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("See the sum of all salaries in the department? (y/n)");
		String answer = sc.next();
		double sumSalary = 0;
		if(answer.equalsIgnoreCase("y")){
			for(DeptEmployee e: department) {
				sumSalary+= e.computeSalary();
			}
			System.out.println(sumSalary);
		}
	}

	}
