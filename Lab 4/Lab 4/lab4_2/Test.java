package lab4_2;

class Test {
  public static void main(String[] args) {
    ClosedCurve[] objects = {
                 new Triangle(4,5,6),
                 new Rectangle(3,7),
				 new Square(3),
				 new Circle(3)};

		//compute areas
    for(ClosedCurve cc : objects){
  	   System.out.print("The area of this ");
  	   System.out.print(cc.getClass().getSimpleName());
  	   System.out.print(" is ");
  	   System.out.println(cc.computeArea());
  	 }
	}
  }