package shapes;

public class Circle implements Shape {
	private double radius;
	private Area obj;
	
	public Circle(double radius) {
		this.radius = radius;
		obj = () -> Math.PI * (radius * radius);
	
	}
	public Circle() {
		super();
	}
	
	//Setters
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//Perimeter
	public double perimeter() {
		return radius * 2 * Math.PI;
	}
	
	public String toString() {
		return ("Circle {r=" + radius + "} area = " + Math.round(getArea() * 100.0) / 100.0 +"\n");
	}

	public double getArea() {
		return obj.calculateArea();
	}
	
}
