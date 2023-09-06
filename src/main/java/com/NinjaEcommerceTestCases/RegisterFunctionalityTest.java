package com.NinjaEcommerceTestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import com.NinjaEcommerceProjectPages.RegisterFunctionalityPage;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.NinjaEcommerceBase.NinjaBase;

public class RegisterFunctionalityTest extends NinjaBase {

	boolean registerStatus;
	RegisterFunctionalityPage regMandotory = new RegisterFunctionalityPage();

	public RegisterFunctionalityTest() throws IOException {
		super();

	}

	@Test(priority = 0)

	public void verifyRegisteringWithOnlyMandatoryFields() throws IOException {
		registerStatus = regMandotory.registeringWithOnlyMandatoryFields();
		Assert.assertTrue(registerStatus);

	}

	@Test(priority = 1)

	public void verifyregisteringWithoutMandatoryFields() {
		registerStatus = regMandotory.registeringWithoutMandatoryFields();
		Assert.assertTrue(registerStatus);

	}

	@Test(priority = 2)

	public void verifyRegisteringWithWrongConfirmationPwd() {
		registerStatus = regMandotory.registeringWithWrongConfirmationPwd();
		Assert.assertTrue(registerStatus);

	}
	
	
	@Test(priority = 3) 
	public void verifyRegisteringWithExistingEmailAddress()  {
		registerStatus = regMandotory.registeringWithExistingEmailAddress();
		Assert.assertTrue(registerStatus);
		

	}
	@Test(priority = 4) 
	public void verifyRegisteringWithInvalidEmailFormat() {
		registerStatus = regMandotory.registeringWithInvalidEmailFormat();
		Assert.assertTrue(registerStatus);
	}
}
