package com.NinjaEcommerceProjectPages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.NinjaEcommerceBase.NinjaBase;



public class HomePage extends NinjaBase{
	
	private static  By MyAccountDropDownMenuLoc= By.linkText("My Account");
	private static By LoginLocatorLoc = By.linkText("Login") ;
	private static By clickOnRegisterMenuLoc = By.linkText("Register") ;

	public HomePage() throws IOException {
		super();//invoking the CONSTRUCTOR of ninjaBase class 1st
		// TODO Auto-generated constructor stub
	}

	

	public static  void clickOnMyAccountDropMenu() {
		
		driver.findElement(MyAccountDropDownMenuLoc).click();
			
	}
	
	public static void clickOnMyloginMenu () {
		driver.findElement(LoginLocatorLoc).click();
	}
	public static void clickOnRegisterMenu() {
		driver.findElement(By.linkText("Register")).click();
	}
}
