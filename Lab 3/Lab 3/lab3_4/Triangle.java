package lab3_4;
public final class Triangle{
    private final double base;
    private final double height;
    
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    public double getBase() {
return base;
}
public double getHeight() {
return height;
}
public void ComputeArea(){
double Area = base * height * 1/2;
System.out.printf("Area of triangle is %.2f\n", Area);
    }
}