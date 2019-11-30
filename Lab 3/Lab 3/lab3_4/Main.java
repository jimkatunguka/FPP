package lab3_4;
public class Main{

     public static void main(String []args){
       Circle c = new Circle(7);
       c.ComputeArea();

       Rectangle r = new Rectangle(10, 40);
       r.ComputeArea();

       Triangle t = new Triangle(41, 20);
       t.ComputeArea();
     }
}