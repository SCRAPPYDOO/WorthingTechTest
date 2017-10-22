package main.item;

public enum Item {
	APPLE(60),
	ORANGE(25);
	
	double price;
	
	Item(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}
