package main.item;

public enum Item {
	APPLE(60, DiscountType.TWO_FOR_ONE),
	ORANGE(25, DiscountType.THREE_FOR_TWO);
	
	private double price;
	private DiscountType discountType;
	
	Item(double price, DiscountType discountType) {
		this.price = price;
		this.discountType = discountType;
	}
	
	public double getPrice() {
		return price;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}
}
