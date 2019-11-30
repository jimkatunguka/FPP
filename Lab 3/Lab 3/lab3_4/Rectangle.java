package lab3_4;
public final class Rectangle{
    private final double length;
    private final double width;
    
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public double getLength() {
return length;
}
public double getWidth() {
return width;
}
public void ComputeArea(){
double Area = length * width;
System.out.printf("Area of rectangle is %.2f\n", Area);
    }
}