package Airline;


public class Customer {

	private static int customerID;         
	private String name;
	private int age;
	private String telephone;
	private String socialNumber;
	private int customerIndex;
	
	
	public Customer(String name, int age, String telephone, String socialNumber) {
		
		this.name =  name;
		this.age = age;
		this.telephone = telephone;
		this.socialNumber = socialNumber;
		customerIndex=customerID++; 
	
	}


	public static int getCustomerID() {
		return customerID;
	}
	
	public int getCustomerIndex() {
		return customerIndex;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public String getTelephone() {
		return telephone;
	}


	public String getSocialNumber() {
		return socialNumber;
	}
	
	
	
	
	
}
