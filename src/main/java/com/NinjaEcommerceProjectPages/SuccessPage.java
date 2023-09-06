package com.NinjaEcommerceProjectPages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.NinjaEcommerceBase.NinjaBase;

public class SuccessPage extends NinjaBase {
	
	private By ConfirmationMsgLoc = By.xpath("//*[@id=\"content\"]/h1");

	public SuccessPage() throws IOException {
		super();
		
	}
public String getAccountRegistrationStatus() {
	
return driver.findElement(ConfirmationMsgLoc).getText();
	 
	
}
}
