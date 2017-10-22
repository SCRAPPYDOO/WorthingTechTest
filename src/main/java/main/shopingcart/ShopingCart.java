package main.shopingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.item.Item;

public class ShopingCart {
	private List<Item> listOfItems = new ArrayList<Item>();

	public List<Item> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public void setListOfItems(String... items) {
		List<Item> temp = new ArrayList<Item>();

		for (String item : items) {
			item = item.toUpperCase().trim();
			try {
				temp.add(Item.valueOf(item));
			} catch (Exception e) {
				System.out.println("Invalid type of item: " + item);
			}
		}

		this.setListOfItems(temp);
	}

	public double checkout() {
		double totalPrice = 0.0;
		
		String output = "";
		for (Item item : listOfItems) {
			totalPrice += item.getPrice();
			output += item.name() + " ";
		}
		double discount = getDiscountValue();
		totalPrice -= discount;
		System.out.println("Checkout for items: [ " + output + "] => " + totalPrice + " Pounds");
		return totalPrice;
	}

	public double getDiscountValue() {
		double discount = 0.0;
		Map<Item, Integer> counting = new HashMap<>();
		int apples = 0;
		int oranges = 0;
		
		for (Item item : listOfItems) {
			switch (item) {
				case APPLE: 
					++apples;
					break;
				case ORANGE: 
					++oranges; 
					break;
				default:
					break;
			}
		}
		double applesDiscount = ((int)apples / 2) * Item.APPLE.getPrice();
		discount += applesDiscount;
		System.out.println("apples count: " + apples + " apples discount: " + applesDiscount);
		
		double orangesDiscount = ((int)oranges / 3) * Item.ORANGE.getPrice();
		discount += orangesDiscount;
		System.out.println("oranges count: " + oranges + " oranges discount: " + orangesDiscount);
		
		return discount;
	}
}
