package Airline;
import java.util.ArrayList;
import java.util.HashMap;

public class AirlineBookingController implements PricingInterface{
	
	public static int CompanyBalance = 0;
	
	//TODO Skapa flygplan, skapa Customer, hantera uppdateringar.....
	
	
	public static ArrayList<AirlineBookingController> bookingList = new ArrayList<>();
	public static ArrayList<Aircraft> aircraftsList = new ArrayList<Aircraft>();
	public static ArrayList<Customer> customerList = new ArrayList<Customer>();
	public static ArrayList<String> cabinClass = new ArrayList<>();
	
	
	
	// Customer c = new Customer("","","","","");
	//Boing737 flyg1 = new Boing737();
	//flyg.addBooking(c, seatPosition);
	
	public void initSystem(){
		//Skapa alla flygplan.
		Aircraft flyg1 = new Boing737("sk121");
		Aircraft flyg2 = new Boing737("sk122");
		Aircraft flyg3 = new Boing737("sk123");
		Aircraft flyg4 = new Boing737("sk124");
		Aircraft flyg5 = new Boing737("sk125");
		Aircraft flyg6 = new Airbus("dk301");
		Aircraft flyg7 = new Airbus("dk302");
		Aircraft flyg8 = new Airbus("dk303");
		
		aircraftsList.add(flyg1);
		aircraftsList.add(flyg2);
		aircraftsList.add(flyg3);
		aircraftsList.add(flyg4);
		aircraftsList.add(flyg5);
		aircraftsList.add(flyg6);
		aircraftsList.add(flyg7);
		aircraftsList.add(flyg8);
	}
	
	
	/**
	 * This method will create the booking, set the balance allocate the seat
	 * @param name
	 * @param age
	 * @param phone
	 * @param socialNumber
	 * @param flight
	 * @param cabinclass
	 * @param seat
	 */
	public void addBooking(String name ,int age, String phone , String socialNumber, String flight, String cabinclass, int seat, String food, int foodPrice){
		for(Aircraft ac:aircraftsList){
			if(ac.getName().equals(flight)){
				ac.addBooking(seat, seat);
				System.out.println(ac.toString());
			}
		}
		CompanyBalance = CompanyBalance+calculateTotalPrice(cabinclass, foodPrice);
		
	}
	
	public int getBalance(){
		return CompanyBalance;
	}
	
	/**
	 * 
	 * @param cc
	 * @param meal
	 * @return
	 */
	private int calculateTotalPrice(String cc, int foodPrice){
		System.out.println("Food :"+foodPrice);
		int price=0;
		if(cc.equals(CabinClass.FIRST.toString())){
			price+=PricingInterface.FIRST_CLASS_PRICE;
			if(foodPrice!=0)
				price+=foodPrice;
		}
		else if (cc.equals(CabinClass.ECONOMY.toString())){
			price+=PricingInterface.ECONOMY_CLASS_PRICE;
			if(foodPrice!=0)
				price+=foodPrice;
		}
		System.out.println("Price :"+price);			
		return price;
	}
	/**
	 * 
	 * @param cc
	 * @return
	 */
	public int getMealPrice(String cc){
		if (cc.equals(CabinClass.ECONOMY.toString()))
			return PricingInterface.ECONOMY_CLASS_MEAL;
		else
			return PricingInterface.FIRST_CLASS_MEAL;
	}
	
	/**
	 * 
	 * @param cc
	 * @return
	 */
	public int getFoodPrice(String item, String cc){	

			int ret=0;
			if(true){
				FoodList fl = new FoodList();
				ret = fl.getFoodPrice(item, cc);
			}


			return ret;
	}
	
	
	
	public int getCabinPrice(String cc){
		System.out.println("PP :" +cc);
		if (cc.equals(CabinClass.ECONOMY.toString()))
			return PricingInterface.ECONOMY_CLASS_PRICE;
		else
			return PricingInterface.FIRST_CLASS_PRICE;
	}
	
	public HashMap<FoodItem, CabinClass> getFoodItemsList(String cabinclass){
		FoodList fl = new FoodList();
		if(cabinclass.contains(CabinClass.FIRST.toString()))
			return fl.getFoodItemsList(CabinClass.FIRST);
		else
			return fl.getFoodItemsList(CabinClass.ECONOMY);
	}
	public ArrayList<String> getSeatFromAircraft(String flight, String cabinclass){
		for(Aircraft plane:aircraftsList){
			if(plane.getName().equals(flight)){
			
				return plane.getAvailibleSeats(cabinclass);
			}
		}
		return null;
	}
	
	@Override
	public String toString(){
		String str="";
		for(Aircraft ac:aircraftsList){
			str = "\n"+str+" "+ac.getName();
		}
		return str;
	}
	
	

}
