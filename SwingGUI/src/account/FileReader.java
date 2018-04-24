package account;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;

public class FileReader {
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private JFrame newFrame;
	private JLabel header;
	private JLabel status;
	private JPanel controlPanel;
	
	public static void main(String[] args) {
		FileReader GUI = new FileReader();
		//GUI.openFileOutput();
		//GUI.populateLayout();
		
		GUI.openFileInput();
	}
	
	public FileReader() {
		layout();
	}
	
	public void layout() {
		newFrame = new JFrame("Accounts");
		newFrame.setSize(300, 300);
		newFrame.setLayout(new GridLayout(3, 1));
		
		header = new JLabel("", JLabel.CENTER);
		status = new JLabel("", JLabel.CENTER);
		status.setSize(350, 100);
		
		newFrame.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		newFrame.add(header);
		newFrame.add(controlPanel);
		newFrame.add(status);
		newFrame.setVisible(true);
	}
	
	void populateLayout() {
		header.setText("Control in action: Button");
		JLabel AccNum = new JLabel("Account: ", JLabel.RIGHT);
		JLabel FName = new JLabel("First Name: ", JLabel.CENTER);
		JLabel LName = new JLabel("Last Name: ", JLabel.LEFT);
		JLabel Balance = new JLabel("Balance: ", JLabel.LEFT);
		
		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");
		
		final JTextArea area = new JTextArea();
		final JTextField AccNumTxt = new JTextField(6);
		final JTextField FNameTxt = new JTextField(6);      
	    final JTextField LNameTxt = new JTextField(6);
	    final JTextField BalTxt = new JTextField(6);   
	    

	    submit.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {     
	        	if(validateFields()) {

      

		        	String data = AccNumTxt.getText();
		 	        data += new String(FNameTxt.getText());
		 	        data +=  new String(LNameTxt.getText());
		 	        data +=  new String(BalTxt.getText());
		 	             	  

		    			Scanner input = new Scanner(System.in);
		    	        System.out.printf("%s%n%s%n","","");
		    		

			    		   try{
			    			Account record = new Account(Integer.parseInt(AccNumTxt.getText()), FNameTxt.getText(), 
			    					LNameTxt.getText(), Integer.parseInt(BalTxt.getText()));
			    			//serialize record object into file
			    			output.writeObject(record);
			    			
				            status.setText("data has been added");  
				            AccNumTxt.setText("");
					     	FNameTxt.setText("");
					     	LNameTxt.setText("");
					     	BalTxt.setText("");
			    		     }catch (NoSuchElementException elementException){
			    			System.err.println("Invalid input. Please try again.");
			    			input.nextLine(); 
			    			}catch (IOException ioException){
			    			System.err.println("Error writing to file. Terminating.");
			    			} System.out.print(" ");
			    		

		             
		 	         	             

	             
	        	}
	        	  
	          }
	          public boolean validateFields() {
					// TODO Auto-generated method stub
					
					boolean validint = !validateInteger(AccNumTxt, "Please Enter an integer value in Account");
					boolean validfield = !validateField(FNameTxt, "Please Enter a first Name");
					boolean validfield2 = !validateField(LNameTxt, "Please Enter a Last Name");
					boolean validdouble = !validatedouble(BalTxt, "Please Enter a double amount in balance");
					
					
					if ( validint)
					{
						if (validfield)
						{
							if(validfield2)
							{
								if (validdouble)
								{
									return false;
								}
								else
								{   return false;}
							}
							else
							{   return false;}
						}
						else
						{   return false;}
					}
					else 
						return true;
				}

				private boolean validateField(JTextField f, String str) {
					// TODO Auto-generated method stub
					if(f.getText().equals(""))
			    		  return failedMessage(f,str);
			    	  else 
			    		  return true;
				}
				
				public boolean validateInteger( JTextField f, String errormsg )
				{
				  try
				  { 
				    int i = Integer.parseInt(f.getText());

				    if ( i > 0 )
				      return true; // success, validation succeeded
				   }
				   catch(Exception e)
				   {
				      // if conversion failed, or input was <= 0,
				      // fall-through and do final return below
				   }
				   return failedMessage( f, errormsg );
				}
				
				public boolean validatedouble( JTextField f, String errormsg )
				{
				  try
				  {  // try to convert input to integer
				    double i = Double.parseDouble(f.getText());

				    // input must be greater then 0
				    // if it is, success
				    if ( i > 0.0 )
				      return true; // success, validation succeeded
				   }
				   catch(Exception e)
				   {
				      // if conversion failed, or input was <= 0,
				      // fall-through and do final return below
				   }
				   return failedMessage( f, errormsg );
				}
				

				private boolean failedMessage(JTextField f, String str) {
					// TODO Auto-generated method stub
					
					JOptionPane.showMessageDialog(null, str); // give user feedback
					  f.requestFocus(); // set focus on field, so user can change
					  return false; 
				}

				
		       });
		      
		      
		      
		      cancel.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {
		    		  String data = "Cancelled"; 
		    		  status.setText(data);
		    	  }
		      });

		      controlPanel.add(AccNum);
		      controlPanel.add(AccNumTxt);
		      
		      controlPanel.add(FName);
		      controlPanel.add(FNameTxt);
		      
		      controlPanel.add(LName);
		      controlPanel.add(LNameTxt);
		      
		      controlPanel.add(Balance);
		      controlPanel.add(BalTxt);
		      
		      controlPanel.add(submit);
		      controlPanel.add(cancel);       

		      newFrame.setVisible(true);  
		   }
		   
		   
		   
		protected void openFileInput() {
			try{
				Path p  = Paths.get("clients.ser");
	   		    input = new ObjectInputStream(Files.newInputStream(p));
			}catch (IOException ioException){
			    System.err.println("Error opening file. Terminating.");
			    System.exit(1);
			}

			readRecords();
//			Account record;
//			try {
//				record = (Account) input.readObject();
//				
//				header.setText("Control in action: Button");
//				JLabel AccNum = new JLabel("Account: " + record.getAccount(), JLabel.RIGHT);
//				JLabel FName = new JLabel("First Name: " + record.getFName(), JLabel.CENTER);
//				JLabel LName = new JLabel("Last Name: " + record.getLName(), JLabel.LEFT);
//				JLabel Balance = new JLabel("Balance: " + record.getBalance(), JLabel.LEFT);
//				
//				controlPanel.add(AccNum);
//				controlPanel.add(FName);
//				controlPanel.add(LName);
//				controlPanel.add(Balance);
//				
//				
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			

			
			
			

			
			newFrame.setVisible(true); 
		}
		
		protected void openFileOutput() {
			try {
				output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser")));
			} catch (IOException e) {
			    System.err.println("Error opening file. Terminating.");
			    System.exit(1);
			}
		}
		
		protected void readRecords() {
			try{
			     while (true){ 
			    	 Account record = (Account) input.readObject(); 

			     
					JLabel AccNum = new JLabel("Account: " + record.getAccount(), JLabel.RIGHT);
					JLabel FName = new JLabel("First Name: " + record.getFName(), JLabel.CENTER);
					JLabel LName = new JLabel("Last Name: " + record.getLName(), JLabel.LEFT);
					JLabel Balance = new JLabel("Balance: " + record.getBalance(), JLabel.LEFT);

					
					controlPanel.add(AccNum);
					controlPanel.add(FName);
					controlPanel.add(LName);
					controlPanel.add(Balance);}
			     
			     	
			 		}catch (EOFException endOfFileException) {
			 			System.out.printf("No more records\n");
			 		}catch (ClassNotFoundException classNotFoundException){
			 		     System.err.println("Invalid object type. Terminating.");
			 		}catch (IOException ioException){
			 		  System.err.println("Error reading from file. Terminating.");
			 		}
		} // end method readRecords


		

			
		protected void addRecords() {
			// TODO Auto-generated method stub
			Scanner input = new Scanner(System.in);
	        System.out.printf("%s%n%s%n","","");
		
		while (input.hasNext()) // loop until end-of-file indicator
		{
		   try{
			// create new record; this example assumes valid input
			Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());

			//serialize record object into file
			output.writeObject(record);
		     }catch (NoSuchElementException elementException){
			System.err.println("Invalid input. Please try again.");
			input.nextLine(); // discard input so user can try again
			}catch (IOException ioException){
			System.err.println("Error writing to file. Terminating.");
				break;
			} System.out.print(" ");
		}
		}
		
		
		
		protected void closeFile() {
			// TODO Auto-generated method stub
			try{
			    if (output != null)
			      output.close();} catch (IOException ioException){
			    		 System.err.println("Error closing file. Terminating.");
			        }

		}
	}


