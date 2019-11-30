package lab4_5;
public class Test3 {

	public static void main(String[] args) {
		Polygon[] objects = {
                new Triangle(4,5,6),
                new Rectangle(3,4),
				new Square(3),};
	
//compute sides and perimeter.
 for(Polygon p : objects){
   System.out.print("For this ");
   System.out.println(p.getClass().getSimpleName());
   System.out.printf("\tPerimeter =");
   System.out.println(p.computePerimeter());
 }
	}

}

