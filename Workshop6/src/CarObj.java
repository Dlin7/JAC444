
import java.io.Serializable;
import java.rmi.RemoteException;

public class CarObj implements Serializable {
	String model;
	String color;
	double mileage;
	int plate;
	
	public CarObj() throws RemoteException {
		model = "ford";
		color = "blue";
		mileage = 245;
	}
	
	public String toString() {
		return "Model: " + model + "\n" + "Color: " + color + "\n" + "Mileage: " + mileage + "\n" + "Plate: " + plate;
	}
}
