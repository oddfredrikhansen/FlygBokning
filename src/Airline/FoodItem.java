package Airline;

public class FoodItem {

	private String foodName;
	private double price;
	
	
		
	public FoodItem(String foodName, double price) {
	
		this.foodName = foodName;
		this.price = price;
	}

	
	
	
	public String getFoodName() {
		return foodName;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "FoodItem: " + foodName + ", price: " + price;
	}
	
		
	
	
}
