package Airline;

public class Airline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AirlineBookingController ac = new AirlineBookingController();
		

	       javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	
	    			ac.initSystem();
	            	AirlineGui aGui = new AirlineGui();
	            	
	            	
	            }
	        });
		
	       
	    
		
	}
	
	


	

}
