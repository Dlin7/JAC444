
import java.rmi.Naming;

public class CarServer {	
	CarObj obj;
	
	public CarServer() {
		try {
			
			Car c = new CarImpl();
			System.out.println("Server: Adding car implement to registry");
			Naming.rebind("rmi://localhost:1099/CarServer", c);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		System.out.println("new server");
		new CarServer();
		System.out.println("CarServer is running");
		
	
	}
	
//	public void receiver(CarObj Car) {
//		this.obj = Car;
//		this.obj.plate = Car.hashCode();
//	}
//	
//	public CarObj getter() {
//		return this.obj;
//	}

}

