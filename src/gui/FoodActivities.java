package gui;

public class FoodActivities {
	
	private String name;
	private String cuisine;
	private double price;
	private int rating;
	
	public FoodActivities(String name, String cuisine, double price, int rating) {
		this.name = name;
		this.cuisine = cuisine;
		this.price = price;
		this.rating = rating;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	
	public String getCuisine() {
		return this.cuisine;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return this.rating;
	}
	
}
