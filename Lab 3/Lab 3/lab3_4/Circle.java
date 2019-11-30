package lab3_4;
public final class Circle{
    private final double radius;
    
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius() {
return radius;

    }
    public void ComputeArea(){
double Area = Math.PI * radius * radius;
System.out.printf("Area of circle is %.2f\n", Area);
    }
}