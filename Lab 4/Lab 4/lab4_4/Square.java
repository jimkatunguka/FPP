package lab4_4;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}
	public int getNumberOfSides() {
		double side1, side2, side3, side4;
		side1=side2=side3=side4=side;
		double sides[] = {side1, side2, side3, side4};
		int sidesum = sides.length;
		return sidesum;
	}
	
	public double computePerimeter() {
		double perimeter = side*getNumberOfSides();
		return perimeter;
	}
}

