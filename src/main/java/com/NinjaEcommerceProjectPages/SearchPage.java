package com.NinjaEcommerceProjectPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.yaml.snakeyaml.events.Event.ID;

import com.NinjaEcommerceBase.NinjaBase;

public class SearchPage extends NinjaBase {
	
	private static By SearchFieldLoc  = By.xpath("//*[@id=\"search\"]/input");
	private static By SearchButtonLoc = By.xpath("//*[@id=\"search\"]/span/button");
	
	
	
	SearchResultPage searchResultPage = new SearchResultPage();
	
public SearchPage() throws IOException {
		super();
		
	}

	public static void enterSearch(String enterProductName) {
		driver.findElement(SearchFieldLoc).sendKeys(enterProductName);
	}

	public static void clickSearchButton() {
		
		

		driver.findElement(SearchButtonLoc).click();

	}

	public boolean searchingWithAnExistingProductName(String inputProduct) {
		
		SearchPage.enterSearch(inputProduct);
		SearchPage.clickSearchButton();
		return searchResultPage.retrieveSearchResultImac();
	}

	public boolean searchingWithNonExistingProductName(String inputProduct) {
		SearchPage.enterSearch(inputProduct);
		SearchPage.clickSearchButton();

		String nonExistingProductWarningAct = searchResultPage.retrieveSearchResultForNonExistingProduct();
			
			return nonExistingProductWarningAct.equals(dataProp.getProperty("nonExistingProductWarningMsg"));
		
	}

	public boolean searchingForAProductAfterLoginTotheApplication(String inputProduct) throws IOException  {

		LoginPage.enterloginId(prop.getProperty("validEmail"));
				LoginPage.enterPassword(prop.getProperty("validPwd"));
				LoginPage.clickLoginButton();;
		SearchPage.enterSearch(inputProduct);
		SearchPage.clickSearchButton();
	return searchResultPage.retrieveSearchResultImac();

	}

	// to add one more search field
	public Boolean searchFieldPlaceholders() {   //incomplete

		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnMyloginMenu();
		String placeholderAct = driver.findElement(By.xpath("//*[@id=\"search\"]/input")).getAttribute("placeholder");
		Assert.assertEquals(placeholderAct, "Search");
		String searchCritrAct = driver.findElement(By.xpath("//*[@id=\"input-search\"]")).getAttribute("placeholder");
		Assert.assertEquals(searchCritrAct, "Keywords");
		return null;

	}

	public boolean searchUsingSearchCriteriaField() {
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"input-search\"]")).sendKeys("iLife");
		driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/select")));
		select.selectByIndex(0);
		driver.findElement(By.id("button-search")).click();
		return driver.findElement(By.xpath("//a[normalize-space()='iMac']")).isDisplayed();

	}

	public boolean searchingInTheRightCategory() {
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"input-search\"]")).sendKeys("Mac");
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/select")));
		select.selectByIndex(3); // correct cat 3
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		return driver.findElement(By.xpath("//a[normalize-space()='iMac']")).isDisplayed();

	}

	public boolean searchingInTheWrongCategory() {
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"input-search\"]")).sendKeys("Mac");
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/select")));
		select.selectByIndex(2); // wrong category 2
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		String messageAct = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		return messageAct.equals("There is no product that matches the search criteria.");
	}

	public void userCanSelectHowManyProdutsCanBeDisplayedInTheSearchResults() {

		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mac");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]"));
	}

	public boolean searchResults(String inputProduct) throws InterruptedException {
		SearchPage.enterSearch(inputProduct); // need to optimize later
		Thread.sleep(5000);

		WebElement mainPath = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]"));
		List<WebElement> counttext = mainPath.findElements(By.tagName("a"));
		// System.out.println(counttext.size()); // wrong count displayed

		for (WebElement sResult : counttext) {

			if (sResult.getText().contains("Mac")) {

				return true;

			}
		}

		return false;
	}

	public boolean breadcrumbOfSearchPage() {

		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("iMac");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.linkText("iMac")).click();
		return driver.findElement(By.xpath("//*[@id=\"product-product\"]/ul/li[3]/a")).isEnabled();

	}

	public boolean searchPageHeading() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		Thread.sleep(3000);
		String actualTittle = driver.getTitle();
		return actualTittle.equals("Search");

	}

}
