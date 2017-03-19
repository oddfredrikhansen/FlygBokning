package Airline;


public class Booking {
	
	private Customer cus;
	private String ac;
	private String cabinclass;
	private int seatNumber;
	
	public Booking(Customer cus, String ac, String cabinclass, int seatNumber){
		this.cus = cus;
		this.ac = ac;
		this.cabinclass = cabinclass;
		this.seatNumber = seatNumber;
	}

	public Customer getCus() {
		return cus;
	}

	public String getAc() {
		return ac;
	}

	public String getCabinclass() {
		return cabinclass;
	}

	public int getSeatNumber() {
		return seatNumber;
	}


}
