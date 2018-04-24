
import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 

public class CarClient {
	public static void main(String[] args) { 
		try { 
			Car c = (Car)Naming.lookup("rmi://localhost:1099/CarServer"); 
			
			CarObj car = new CarObj();
			
			System.out.println(c.service1(car)); 
			
//			s.receiver(car);
			System.out.println("\nClient: Printing updated Car object with license plate\n");
			System.out.println(c.service1(car).toString());
		} 
		catch (MalformedURLException murle) { 
			System.out.println(); 
			System.out.println("MalformedURLException"); 
			System.out.println(murle); 
			} 
			catch (RemoteException re) { 
				System.out.println(); 	
				System.out.println("RemoteException"); 
				System.out.println(re); 
			} 
			catch (NotBoundException nbe) { 
				System.out.println();
				System.out.println( "NotBoundException"); 
				System.out.println(nbe); 
			} 
			catch (java.lang.ArithmeticException ae) { 
				System.out.println(); 
				System.out.println( "java.lang.ArithmeticException"); 
				System.out.println(ae); 
			} 

	}
}
