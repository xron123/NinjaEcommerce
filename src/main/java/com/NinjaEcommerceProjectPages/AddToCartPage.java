package com.NinjaEcommerceProjectPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.NinjaEcommerceBase.NinjaBase;

public class AddToCartPage extends NinjaBase {

	private static By AddToCartButtonGreyLoc = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span");
	private static By AddToCartButtonBlueLoc = By.id("button-cart");
	private static By CartTotalButtonLoc = By.xpath("//span[@id='cart-total']");
	private static By AddedToCartImacMsgLoc = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private static By AddedToCartIphoneMsgLoc = By.xpath("//*[@id=\"product-product\"]/div[1]");

	public AddToCartPage() throws IOException {
		super();//invoking the CONSTRUCTOR of ninjaBase class 1st before AddToCartPage class executed
	}

	SearchPage searchPage = new SearchPage();

	public static void clickOnAddToCartButtonGrey() {

		driver.findElement(AddToCartButtonGreyLoc).click();
	}

	public static void clickOnAddToCartBlueButton() {

		driver.findElement(AddToCartButtonBlueLoc).click();

	}
	
	public static void clickOnTotalItemsInTheCart() {
	
		driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
	}
	

	public static void clickViewCart()  {
	
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();

	}

	public boolean addTheProductToCartFromSearchResultPage(String inputProduct)throws InterruptedException, IOException {
		LoginPage.validLogin();
		SearchPage.enterSearch(inputProduct);
		SearchPage.clickSearchButton();
		AddToCartPage.clickOnAddToCartButtonGrey();
		String AddedToTheCartsuccessMsgAct = driver.findElement(AddedToCartImacMsgLoc).getText();
System.out.println(AddedToTheCartsuccessMsgAct);

		boolean isProductAddedToCart = AddedToTheCartsuccessMsgAct.contains("Success: You have added iMac to your shopping cart!");
		Thread.sleep(2000);
		driver.findElement(By.linkText("shopping cart")).click();//hyperlink in the success msg
		Thread.sleep(2000);
		boolean isCartContainsProduct = driver.findElement(By.linkText("iMac")).isDisplayed();
		return isProductAddedToCart && isCartContainsProduct;
		
	}

	public boolean addingTheProductToCartFromProductDisplayPage(String inputProduct) throws InterruptedException {

		SearchPage.enterSearch(inputProduct);
		SearchPage.clickSearchButton();
		driver.findElement(By.linkText("iPhone")).click();// search result
		Thread.sleep(3000);
		AddToCartPage.clickOnAddToCartBlueButton();
		Thread.sleep(3000);

		String successMsgAct = driver.findElement((AddedToCartIphoneMsgLoc)).getText();
				
		
		boolean isProductAddedToCart = successMsgAct.contains("Success: You have added iPhone to your shopping cart!");

		Thread.sleep(3000);
		AddToCartPage.clickOnTotalItemsInTheCart();
		Thread.sleep(3000);
		AddToCartPage.clickViewCart();
		Thread.sleep(3000);
		boolean isCartContainsProduct = driver.findElement(By.linkText("iphone")).isDisplayed();
						
			

		return isProductAddedToCart && isCartContainsProduct;
	}

	public boolean addingTheProductToCartFromWishListPage() {

		LoginPage.validLogin();
		
		SearchPage.searchingWithAnExistingProductName("Mac");
		AddToCartPage.clickOnAddToCartBlueButton();

		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("iMac");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		String successMsgAct = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText();
		return successMsgAct.contains("Success: You have added iMac to your shopping cart!");

	}

}
