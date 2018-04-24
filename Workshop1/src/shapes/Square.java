package shapes;

public class Square extends Rectangle {
	double width;
	Area obj;
	
	public Square(double width) {
		this.width = width;

	}
	
	public Square() {
		super();
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double perimeter() {
		return width * 4;
	}
	
	public void objectSetter(Area squObjArea) {
		obj = squObjArea;
	}
	
	public String toString() {
		return ("Square {w=" + width + "} area = " + Math.round(calculateArea() * 100.0) / 100.0 + "\n");
	}
}
