package gui;

public class HistActivities {
	
	private String name;
	private double price;
	private double ranking;
	
	public HistActivities(String name, double price, double ranking) {
		this.name = name;
		this.price = price;
		this.ranking = ranking;
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
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public double getRanking() {
		return this.ranking;
	}
	
}
