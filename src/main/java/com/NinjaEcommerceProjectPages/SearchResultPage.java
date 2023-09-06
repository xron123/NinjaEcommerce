package com.NinjaEcommerceProjectPages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.NinjaEcommerceBase.NinjaBase;

public class SearchResultPage extends NinjaBase {
	
	private By SearchResultLoc = By.linkText("iMac");
	
	public SearchResultPage() throws IOException {
		super();
	
	}

	public boolean retrieveSearchResultImac() {
		
		return  driver.findElement(SearchResultLoc).isEnabled();
}
	
	public String retrieveSearchResultForNonExistingProduct() {
		
		
		return driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
	}
	
}