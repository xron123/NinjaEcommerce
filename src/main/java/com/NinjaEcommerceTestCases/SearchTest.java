package com.NinjaEcommerceTestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.NinjaEcommerceBase.NinjaBase;
import com.NinjaEcommerceProjectPages.LoginPage;
import com.NinjaEcommerceProjectPages.SearchPage;
import com.NinjaEcommerceProjectPages.searchPage;

public class SearchTest extends NinjaBase {
	public SearchTest() throws IOException {
		super();
	
	}

	Boolean searchStatus;
	SearchPage searchTst = new SearchPage();

	@Test(priority = 1)

	public void VerifySearchingWithAnExistingProductName() throws InterruptedException {
		
		searchStatus =searchTst.searchingWithAnExistingProductName(dataProp.getProperty("existingProductName"));//imac
		SearchPage.clickSearchButton();

	}

	@Test(priority = 2)
	public void VerifySearchingWithNonExistingProductName() {

		searchStatus = searchTst.searchingWithNonExistingProductName(dataProp.getProperty("nonExistingProductName")); //Nike
		Assert.assertTrue(searchStatus);

	}

	@Test(priority = 3)

	public void verifySearchingForAProductAfterLoginTotheApplication() throws InterruptedException, IOException {
		searchStatus = searchTst.searchingForAProductAfterLoginTotheApplication(dataProp.getProperty("existingProductName"));//imac
		Assert.assertTrue(searchStatus);
	}

	@Test(priority = 4)  //incomplete

	public void verifySearchFieldPlaceholders() {
		searchStatus = searchTst.searchFieldPlaceholders();

	}

	@Test(priority = 5)

	public void verifySearchUsingSearchCriteriaField() {
		searchStatus = searchTst.searchUsingSearchCriteriaField();
		Assert.assertTrue(searchStatus);

	}

	@Test(priority = 6)

	public void verifysearchingInTheRightCategory() {
		searchStatus = searchTst.searchingInTheRightCategory();
		Assert.assertTrue(searchStatus);
	}

	@Test(priority = 7)

	public void verifysearchingInTheWrongCategory() {
		searchStatus = searchTst.searchingInTheWrongCategory();
		Assert.assertTrue(searchStatus);
	}

	@Test(priority = 8)

	public void VerifySearchResults() throws InterruptedException {
		searchStatus = searchTst.searchResults("Mac");

		Assert.assertTrue(searchStatus);

	}

	@Test(priority = 8)  
	public void verifyBreadcrumbOfSearchPage() {

		searchStatus = searchTst.breadcrumbOfSearchPage();
		Assert.assertTrue(searchStatus);
		System.out.println(searchStatus);
	}

	@Test(priority = 9)  
	public void verifySearchPageHeading() throws InterruptedException {
		searchStatus = searchTst.searchPageHeading();
		
		Assert.assertTrue(searchStatus);
		
	}
	
	
}
