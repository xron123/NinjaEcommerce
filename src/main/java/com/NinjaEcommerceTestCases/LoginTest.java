package com.NinjaEcommerceTestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.NinjaEcommerceBase.NinjaBase;
import com.NinjaEcommerceProjectPages.LoginPage;


public class LoginTest extends NinjaBase {


	public LoginTest() throws IOException {
		super();
		
	}
	LoginPage Login = new LoginPage();
	boolean Status;


	@Test(priority = 1)
	public  void VerifyvalidLogin() throws IOException {

		 Status = LoginPage.validLogin();
		Assert.assertTrue(Status);
	}


	@Test(priority = 2)
	public void verifyinvalidLoginWithWrongEmail() throws IOException {
		 Status = Login.invalidLoginWithWrongEmail();
		Assert.assertTrue(Status);
	}


	@Test(priority = 3)
	public void verifyinvalidLoginWithWrongPassword() throws IOException {
		 Status = Login.invalidLoginWithWrongPassword();
		Assert.assertTrue(Status);
	}


	@Test(priority = 4)
	public void verifyinvalidLoginWithWrongEmailandPassword() throws IOException {
		 Status = Login.invalidLoginWithWrongEmailandWrongPassword();
		Assert.assertTrue(Status);
	}


	@Test(priority = 5)
	public void verifyinvalidLoginWithoutCredentials() throws IOException {
		 Status = Login.invalidLoginWithoutCredentials();
		Assert.assertTrue(Status);

	}


	@Test(priority = 6)
	public void verifyEmailPlaceHolderTxt() throws InterruptedException {
		 Status = Login.emailandPwdFieldPlaceHolderTxt();
		Assert.assertTrue(Status);

	}

	

	

	//@Test(priority = 7)
	public void verifyClickBackAftrLogin() throws InterruptedException, IOException {
		
		LoginPage.validLogin();
	
		driver.navigate().back();
	
		driver.navigate().forward();
		//boolean Status = Login.validLogin();
		//Assert.assertTrue(Status);
		

	}

	@Test(priority = 8)
	public void verifyPasswordVisibility() {
		Login.passwordVisibility();
		 Status = Login.passwordVisibility();
		Assert.assertTrue(Status);

	}
}
