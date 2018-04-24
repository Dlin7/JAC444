package shapes;

public class Rectangle extends Parallelogram {
	private double width;
	private double length;
	Area obj;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.length = height;
		obj = () -> {
			return this.length * this.width;
		};
	}
	
	public Rectangle() {
		super();
	}
	
	
	//Setters
	public void setWidth(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	//Perimeter
	@Override
	public double perimeter() {
		return (width * 2) + (length * 2);
	}
	
//	public void objectSetter(Area recObjArea) {
//		obj = recObjArea;
//	}
	
	public double getArea() {
		return obj.calculateArea();
	}
	
	public String toString() {
		return ("Rectangle {w=" + width + ", " + "h=" + length + "} area = " + (Math.round(getArea() * 100.0) / 100.0) + "\n");
	}
	

	
}
