
import java.rmi.RemoteException;

public class CarImpl extends java.rmi.server.UnicastRemoteObject implements Car {
	
	protected CarImpl() throws RemoteException {
		super();	
	}
	
	public CarObj service1(CarObj car) throws RemoteException {
//		System.out.println("Server: Received in car implement");
		car.plate = car.hashCode();
//		System.out.println("\nClient: Sending Car object to Server");
		return car;
	}


}
