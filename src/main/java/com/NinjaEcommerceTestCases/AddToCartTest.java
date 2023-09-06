package com.NinjaEcommerceTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.NinjaEcommerceBase.NinjaBase;
import com.NinjaEcommerceProjectPages.AddToCartPage;

public class AddToCartTest extends NinjaBase {
	public AddToCartTest() throws IOException {
		super(); //invoking the CONSTRUCTOR of ninjaBase class 1st so it runs 1st

	}

	AddToCartPage addToCart = new AddToCartPage();
	boolean addToCartStatus;

	@Test (priority =1)

	public void verifyingAddingTheProductToCartFromSearchResultPage() throws InterruptedException, IOException {
		addToCart.addTheProductToCartFromSearchResultPage("imac");
	
		Assert.assertTrue(addToCartStatus);

	}

	@Test (priority =2)

	public void verifyAddingTheProductToCartFromProductDisplayPage() throws InterruptedException {
		addToCartStatus = addToCart.addingTheProductToCartFromProductDisplayPage("iphone");
		Assert.assertTrue(addToCartStatus);

		

	}

	@Test (priority =3)

	public void verifyingAddingTheProductToCartFromWishListPage() {
		addToCartStatus = addToCart.addingTheProductToCartFromWishListPage();
		Assert.assertTrue(addToCartStatus);

	}
}
