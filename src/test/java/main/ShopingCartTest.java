package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.shopingcart.ShopingCart;

public class ShopingCartTest {
	
	ShopingCart shopingCart = new ShopingCart();
	
	private final String[] listOfItems = {"Apple","Orange", "Orange","Orange","Orange","Apple"};
	
	@Test
	public void checkoutTest() {
		
		shopingCart.setListOfItems(listOfItems);
		
		double expectedPrice = 2*60 + 4*25;
		assertEquals(expectedPrice, shopingCart.checkout(), 0);
		
		
		shopingCart.setListOfItems("Apple","Apple","Apple","Apple");
		
		expectedPrice = 4*60;
		assertEquals(expectedPrice,shopingCart.checkout(), 0);
		
		shopingCart.setListOfItems("Orange","Orange","Orange","Orange");
		
		expectedPrice = 4*25;
		assertEquals(expectedPrice,shopingCart.checkout(), 0);
	}
}
