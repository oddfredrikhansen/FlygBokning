package Airline;
import java.util.ArrayList;

public class Airbus extends Aircraft {
	
	private ArrayList<String> seatList;
	
	private String name ;
	private int numberOfSeats=20;
	int lastFirstClassRow=10;
	
	public Airbus(String name){
		seatList = new ArrayList<String>(numberOfSeats);
		this.name = name;
		initiateSeatList();
	}
	
	private void initiateSeatList(){
		for(int i=1;i<numberOfSeats+1;i++){
			seatList.add(""+i);
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public void addBooking(int index, int seat){
		seatList.set(index-1, ""+0);
	}
	
	public void removeBooking(int index){
		seatList.set(index, ""+0);
	}
	
	public ArrayList<String> getAvailibleSeats(String cabinclass){
		ArrayList<String> temp = new ArrayList<>();
		for(String i:seatList){
			int ii = Integer.parseInt(i.trim());
			
			if(ii<=10 && cabinclass.contains(CabinClass.FIRST.toString())){
				if(ii!=0)
					temp.add(i);	
			}
			if(ii>10 && cabinclass.contains(CabinClass.ECONOMY.toString())){
				if(ii!=0)
					temp.add(i);	
			}
			
		}
		System.out.println("Airbus :"+seatList.size()+" returns :"+temp.size());
		return temp;
	}

	@Override
	public String toString() {
		String res="";
		for(String str:seatList){
			res = res+" "+str;
		}
		return "Airbus [seatList=" + res + "]";
	}
	
	

}
