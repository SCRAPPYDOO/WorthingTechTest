package main.shopingcart;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println("Checkout for items: [ " + output + "] => " + totalPrice + " Pounds");
		return totalPrice;
	}
}
