package lab4_4;

public class Test2 {

	public static void main(String[] args) {
		Polygon[] objects = {
				new Square(3),
                new Triangle(4,5,6),
                new Rectangle(3,4),
				};
	
		//compute sides and perimeter
 
     for(Polygon p : objects){
    	   System.out.print("For this ");
    	   System.out.println(p.getClass().getSimpleName());
    	   System.out.printf("\tNumber of sides =");
    	   System.out.println(p.getNumberOfSides());
    	   System.out.printf("\tPerimeter =");
    	   System.out.println(p.computePerimeter());
    	 }
   
	}

}

