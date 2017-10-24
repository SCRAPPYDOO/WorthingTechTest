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
		
		for (Item item : listOfItems) {
			if(counting.get(item) != null) {
				counting.put(item, counting.get(item).intValue() + 1);
			} else {
				counting.put(item, 1);
			}
		}	
		
		for (Item item : Item.values()) {
			if(counting.get(item) != null) {
				switch(item.getDiscountType()) {
					case THREE_FOR_TWO: 
						discount = discount + (counting.get(item) / 3) * item.getPrice(); 
						break;
					case TWO_FOR_ONE:
						discount = discount + (counting.get(item) / 2) * item.getPrice(); 
						break;
					default:
						break;
				}
			}
		}
		
		return discount;
	}
}
