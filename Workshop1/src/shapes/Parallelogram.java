package shapes;

public class Parallelogram implements Shape {
	double width;
	double length;
	Area obj;
	
	public Parallelogram(double width, double height) {
		this.width = width;
		this.length = height;
	}
	
	public Parallelogram() {
		super();
	}
	
	//Setters
	public void setWidth(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getLength() {
		return this.length;
	}

	//Perimeter
	@Override
	public double perimeter() {
		return (width * 2) + (length * 2);
	}
	
	public double calculateArea() {
		return getWidth() * getLength();
	}
	
	public double getArea() { return 1; }
	
	public void objectSetter(Area parObjArea) {
		obj = parObjArea;
	}
	
	public String toString() {
		return ("Parallelogram {w=" + width + ", " + "h=" + length + "} perimeter = " + (Math.round(perimeter() *10000.0) / 10000.0) + "\n");
	}

	
}
