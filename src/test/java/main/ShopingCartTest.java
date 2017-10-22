package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.item.Item;
import main.shopingcart.ShopingCart;

public class ShopingCartTest {
	
	ShopingCart shopingCart = new ShopingCart();
	
	private final String[] listOfItems = {"Apple","Orange", "Orange","Orange","Orange","Apple"};
	
	@Test
	public void checkoutTest() {
		
		shopingCart.setListOfItems(listOfItems);
		
		final double applePrice = Item.APPLE.getPrice();
		final double orangePrice = Item.ORANGE.getPrice();
		
		double expectedPrice = 2*applePrice + 4*orangePrice;
		double expectedDiscount = applePrice + orangePrice;
		assertEquals(expectedPrice - expectedDiscount, shopingCart.checkout(), 0);
		
		
		shopingCart.setListOfItems("Apple","Apple","Apple","Apple");
		
		expectedPrice = 4*applePrice;
		expectedDiscount = 2*applePrice;
		assertEquals(expectedPrice - expectedDiscount,shopingCart.checkout(), 0);
		
		shopingCart.setListOfItems("Orange","Orange","Orange","Orange");
		
		expectedPrice = 4*orangePrice;
		expectedDiscount = 1*orangePrice;
		assertEquals(expectedPrice - expectedDiscount,shopingCart.checkout(), 0);
		
		shopingCart.setListOfItems("apple", "apple", "apple", "apple", "apple", "orange", "orange", "orange", "orange", "orange", "orange", "orange");
		
		expectedPrice = 5*applePrice + 7*orangePrice;
		expectedDiscount = 2*applePrice + 2*orangePrice;
		assertEquals(expectedPrice - expectedDiscount,shopingCart.checkout(), 0);
	}
}
