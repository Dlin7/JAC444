package shapes;

public class Triangle implements Shape {
	private double[] width = new double[3];
	Area obj;
	
	public Triangle(double width1, double width2, double width3 ) {
		this.width[0] = width1;
		this.width[1] = width2;
		this.width[2] = width3;
	}
	
	public Triangle() {
		super();
	}
	
	public boolean validate(double side1, double side2, double side3) {
		if(side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Setters
	public void setWidth(double width1, double width2, double width3) {
		this.width[0] = width1;
		this.width[1] = width2;
		this.width[2] = width3;
	}
	
	public double getWidth1() {
		return this.width[0];
	}
	
	public double getWidth2() {
		return this.width[1];
	}
	
	public double getWidth3() {
		return this.width[2];
	}
	
	@Override
	public double perimeter() {
		return width[0] + width[1] + width[2];
	}
	
	public String toString() {
		return ("Triangle {s1=" + width[0] + ", s2=" + width[1] + ", s3=" + width[2] + "} perimeter = " + (Math.round(perimeter() *10000.0) / 10000.0) + "\n");
	}

	@Override
	public double getArea() {
		return obj.calculateArea();
	}

//	@Override
//	public double calculateArea(double x, double y, double z) {
//		// TODO Auto-generated method stub
//		return 0;
//	}



}
