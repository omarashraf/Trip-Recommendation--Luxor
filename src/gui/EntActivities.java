package gui;

public class EntActivities {
	
	private String name;
	private double price;
	private double duartion;
	
	public EntActivities(String name, double price, double duration) {
		this.name = name;
		this.price = price;
		this.duartion = duration;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setDuration(double duration) {
		this.duartion = duration;
	}
	
	public double getDuration() {
		return this.duartion;
	}
	
}
