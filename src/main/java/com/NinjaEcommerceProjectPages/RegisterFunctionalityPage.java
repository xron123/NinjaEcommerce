package com.NinjaEcommerceProjectPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.NinjaEcommerceBase.NinjaBase;
import com.NinjaEcommerceProjectPages.LoginPage;
import com.tutorialsninja.utils.Utilities;

public class RegisterFunctionalityPage extends NinjaBase {

	By FirstNameFieldLoc = By.id("input-firstname");
	By FirstNameWarningMsg = By.xpath("//*[@id=\"account\"]/div[2]/div/div");
	By LastNameFieldLoc = By.id("input-lastname");
	By LastNameFieldWarningmsg = By.xpath("//*[@id=\"account\"]/div[3]/div/div");
	By EmailFieldLoc = By.id("input-email");
	By EmailFieldWarningmsg = By.xpath("//*[@id=\"account\"]/div[4]/div/div");
	By EmailExistingWarningMsg = By.xpath("//*[@id=\"account-register\"]/div[1]");
	By TelephoneFieldLoc = By.id("input-telephone");
	By TelephoneFieldWarningMsg = By.xpath("//*[@id=\"account\"]/div[5]/div/div");
	By PasswordFieldLoc = By.id("input-password");
	By PasswordFieldWarningMsg = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div");
	By PasswordConfirmationWarning = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div");
	By PasswordConfirmLoc = By.id("input-confirm");
	By PrivacyPolicyFieldLoc = By.xpath("//input[@name='agree']");
	By PrivacyPolicyWarningMsg = By.xpath("//*[@id=\"account-register\"]/div[1]");
	By ContinueButtonLoc = By.xpath("//input[@value='Continue']");
	By ConfirmationMsgLoc = By.xpath("//*[@id=\"content\"]/h1");
	By ContinueButton2Loc = By.linkText("Continue");

	public RegisterFunctionalityPage() throws IOException {
		super();

	}

	public void enterFirstName(String firstName) {

		driver.findElement(FirstNameFieldLoc).sendKeys(firstName);
	}

	public String retrieveFirstNameWarningMsg() {

		return driver.findElement(FirstNameWarningMsg).getText();
	}

	public void enterlastName(String secondName) {

		driver.findElement(LastNameFieldLoc).sendKeys(secondName);
	}

	public String retrieveLastNameWarningMsg() {

		return driver.findElement(LastNameFieldWarningmsg).getText();
	}

	public void enterEmailaddress(String enterEmail) {
		driver.findElement(EmailFieldLoc).sendKeys(enterEmail);

	}

	public String retrieveEmailAdressWarningMsg() {

		return driver.findElement(EmailFieldWarningmsg).getText();
	}

	public String retrieveInvalidEmailIdFormatErrorMsg() {

		return driver.findElement(EmailFieldLoc).getAttribute("validationMessage");
	}

	public String retrieveEmailExistingWarningMsg() {

		return driver.findElement(EmailExistingWarningMsg).getText();
	}

	public void enterTelephoneNumber(String enterTelephoneNumber) {
		driver.findElement(TelephoneFieldLoc).sendKeys(enterTelephoneNumber);

	}

	public String retrieveTelephoneWarningMsg() {

		return driver.findElement(TelephoneFieldWarningMsg).getText();
	}

	public void enterPassword(String enterPwd) {

		driver.findElement(PasswordFieldLoc).sendKeys(enterPwd);
	}

	public String retrievePasswordWarningMsg() {
		return driver.findElement(PasswordFieldWarningMsg).getText();
	}

	public void enterPasswordAgain(String enterPwdAgain) {

		driver.findElement(PasswordConfirmLoc).sendKeys(enterPwdAgain);
	}

	public String retrievePasswordConfirmationErrorMsg() {

		return driver.findElement(PasswordConfirmationWarning).getText();
	}

	public void clickOnPrivacyPolicy() {

		driver.findElement(PrivacyPolicyFieldLoc).click();
	}

	public String retrievePrivacyPolicyWarningMsg() {

		return driver.findElement(PrivacyPolicyWarningMsg).getText();
	}

	public void clickContinue() {

		driver.findElement(ContinueButtonLoc).click();
	}

	public boolean registeringWithOnlyMandatoryFields() throws IOException {
		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnRegisterMenu();
		// LOC are global variabl means to WRITE
		enterFirstName(dataProp.getProperty("firstName"));
		enterlastName(dataProp.getProperty("lastName"));
		enterEmailaddress(Utilities.generateTimeStamp());
		enterTelephoneNumber(dataProp.getProperty("telePhoneNo"));
		enterPassword(prop.getProperty("validPwd"));
		enterPasswordAgain(prop.getProperty("validPwd"));
		clickOnPrivacyPolicy();
		clickContinue();
		SuccessPage successPage = new SuccessPage();
		String expectedMsg = successPage.getAccountRegistrationStatus();
		boolean actualMessage = expectedMsg.equals(dataProp.getProperty("accountCreationSuccessfulMsg"));
		driver.findElement(ContinueButton2Loc).click(); // continue button from confirmation pg
		MyAccountPage myAccountPage = new MyAccountPage();
		boolean isLoggedin = myAccountPage.getDisplayStatusOfEditYourAccountOption();

		return actualMessage && isLoggedin;
	}

	public boolean registeringWithoutMandatoryFields() {
		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnRegisterMenu();
		clickContinue();

		String firstNameAct = retrieveFirstNameWarningMsg(); // name
		boolean firstNameExp = firstNameAct.equals(dataProp.getProperty("firstNameErrorMsg"));

		String lastNameAct = retrieveLastNameWarningMsg(); // last name
		boolean lastNameExp = lastNameAct.equals(dataProp.getProperty("lastNameErrorMsg"));

		String emailAct = retrieveEmailAdressWarningMsg();// email
		boolean emailExp = emailAct.equals(dataProp.getProperty("emailErrorMsg"));

		String phoneAct = retrieveTelephoneWarningMsg();// phone
		boolean phoneExp = phoneAct.equals(dataProp.getProperty("phoneFieldErrorMsg"));

		String passwordAct = retrievePasswordWarningMsg(); // pass

		boolean passwordExp = passwordAct.contains(dataProp.getProperty("passwordFieldErrorMsg"));

		String privacyErrorMsgActual = retrievePrivacyPolicyWarningMsg(); // privacy

		boolean privacyErrorExpected = privacyErrorMsgActual.equals(dataProp.getProperty("privacyErrorMsg"));
		return firstNameExp && lastNameExp && emailExp && phoneExp && passwordExp && privacyErrorExpected;

	}

	public boolean registeringWithWrongConfirmationPwd() {
		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnRegisterMenu();
		enterFirstName(dataProp.getProperty("firstName"));
		enterlastName(dataProp.getProperty("lastName"));
		enterEmailaddress(Utilities.generateTimeStamp());
		enterTelephoneNumber(dataProp.getProperty("telePhoneNo"));
		enterPassword(prop.getProperty("validPwd"));
		enterPasswordAgain(dataProp.getProperty("invalidPwd"));
		clickOnPrivacyPolicy();
		clickContinue();
		String pwdErrorConfirmationMsgAct = retrievePasswordConfirmationErrorMsg();
		return pwdErrorConfirmationMsgAct.equals(dataProp.getProperty("passwordConfirmationFieldErrorMsg"));

	}

	public boolean registeringWithExistingEmailAddress() {

		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnRegisterMenu();
		enterFirstName(dataProp.getProperty("firstName"));
		enterlastName(dataProp.getProperty("lastName"));
		enterEmailaddress(prop.getProperty("validEmail"));
		enterTelephoneNumber(dataProp.getProperty("telePhoneNo"));
		enterPassword(prop.getProperty("validPwd"));
		enterPasswordAgain(prop.getProperty("invalidEmailFormat"));
		clickOnPrivacyPolicy();
		clickContinue();
		String existingEmailIdErrorMsgAct = retrieveEmailExistingWarningMsg();
		return existingEmailIdErrorMsgAct.equals(dataProp.getProperty("emailErrorMsgForExistingId"));

	}

	public boolean registeringWithInvalidEmailFormat() {
		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnRegisterMenu();
		enterFirstName(dataProp.getProperty("firstName"));
		enterlastName(dataProp.getProperty("lastName"));
		enterEmailaddress(dataProp.getProperty("invalidEmailFormat"));
		enterTelephoneNumber(dataProp.getProperty("telePhoneNo"));
		enterPassword(prop.getProperty("validPwd"));
		enterPasswordAgain(prop.getProperty("validPwd"));
		clickOnPrivacyPolicy();
		clickContinue();
		String invalidEmailFormatAct = retrieveInvalidEmailIdFormatErrorMsg();// tooltip message
		boolean invalidEmailFormatExp = invalidEmailFormatAct.equals(dataProp.getProperty("InvalidEmailFormatErrorMsg"));
				
		return invalidEmailFormatExp;
	}
}
