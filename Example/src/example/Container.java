package example;

class Container extends Thread {
	private int sharedInt = 0;
	private boolean writeable = true;

	public synchronized void run() {
		while (!writeable) { 
			try { 
				System.out.println("Waiting for withdraw...");
				wait();  
			} catch ( InterruptedException e ) { 
				e.printStackTrace();
			}
		}

		System.out.println( Thread.currentThread().getName() + " deposit");
		sharedInt = 5;
		writeable = false;
		notify(); 
	}

//	public synchronized void run() {
//		while (writeable) {   
//			try { 
//				System.out.println("Waiting for deposit...");
//				wait();
//			} catch (InterruptedException e) { 
//				e.printStackTrace();
//			}
//		}
//		
//		System.err.println( Thread.currentThread().getName() + " withdraw");
//		sharedInt = 4;
//		writeable = true;
//		notify(); 
//
//
//	}
}