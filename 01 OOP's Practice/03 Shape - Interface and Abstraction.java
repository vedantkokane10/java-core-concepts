import java.util.*;

interface Shape{
    double calculateArea();
    double calculatePerimeter();
    String getShape();
}

class Circle implements Shape{
    private double radius;
    
    Circle(double radius){
        this.radius = radius;
    }
    
    @Override
    public double calculateArea(){
        return Math.PI * this.radius * this.radius;
    }
    
    
    @Override
    public double calculatePerimeter(){
        return 2 * Math.PI * this.radius;
    }
    
    @Override
    public String getShape(){
        return "Circle";
    }
    
}

class Triangle implements Shape{
    private double base;
    private double height;
    private double sideA;
    private double sideB;
    private double sideC;
    
    Triangle(double base, double height, double sideA, double sideB, double sideC){
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    @Override
    public double calculateArea(){
        return 0.5 * this.base * this.height;
    }
    
    @Override
    public double calculatePerimeter(){
        return this.sideA + this.sideB + this.sideC;
    }
    
    @Override
    public String getShape(){
        return "Triangle";
    }
}

class Rectangle implements Shape{
    private double length;
    private double width;
    
    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea(){
        return this.length * this.width;
    }
    
    @Override
    public double calculatePerimeter(){
        return 2 * (this.length + this.width);
    }
    
    @Override
    public String getShape(){
        return "Rectangle";
    }
}

public class Main
{
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Rectangle(10,5));
		shapes.add(new Triangle(9, 4.5, 8, 6, 9));
		shapes.add(new Circle(4));
		
		for(Shape x:shapes){
		    System.out.println("Area of " + x.getShape() + " is - "+ x.calculateArea());
		}
	}
}