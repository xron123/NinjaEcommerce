package com.NinjaEcommerceProjectPages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.NinjaEcommerceBase.NinjaBase;

public class MyAccountPage extends NinjaBase {
	
	private By EditYourAccountLoc =By.linkText("Edit your account information");

	public MyAccountPage() throws IOException {
		super();
		
		
	}
	public boolean getDisplayStatusOfEditYourAccountOption() {
		
		return driver.findElement(EditYourAccountLoc).isDisplayed();
	}
	
	

}
