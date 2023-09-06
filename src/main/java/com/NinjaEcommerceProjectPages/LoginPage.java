package com.NinjaEcommerceProjectPages;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;

import com.NinjaEcommerceBase.NinjaBase;
import com.tutorialsninja.utils.Utilities;

public class LoginPage extends NinjaBase {

	private static By EmailFieldLoc = By.id("input-email");
	private static By PwdFieldLoc = By.id("input-password");
	private static By LoginBtnLoc = By.xpath("//input[@value='Login']");
	private By WrongCredentialLoc = By.xpath("//*[@id=\"account-login\"]/div[1]");

	public LoginPage() throws IOException {
		super();

	}

	public static void enterloginId(String userName) throws IOException {
		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnMyloginMenu();

		driver.findElement(EmailFieldLoc).sendKeys(userName);

	}

	public static void enterPassword(String password) {
		driver.findElement(PwdFieldLoc).sendKeys(password);

	}

	public static void clickLoginButton() {
		driver.findElement(LoginBtnLoc).click();

	}

	public static boolean validLogin() throws IOException { // source it from property file
		LoginPage.enterloginId(prop.getProperty("validEmail"));
		LoginPage.enterPassword(prop.getProperty("validPwd"));
		LoginPage.clickLoginButton();
		MyAccountPage myAccountpage = new MyAccountPage();
		return myAccountpage.getDisplayStatusOfEditYourAccountOption();

	}

	public boolean invalidLoginWithWrongEmail() throws IOException {
		LoginPage.enterloginId(Utilities.generateTimeStamp());// fetching random email id from timestamp method

		LoginPage.enterPassword(prop.getProperty("validPwd"));
		LoginPage.clickLoginButton();
		String warningMessageAct = driver.findElement(WrongCredentialLoc).getText();
		return warningMessageAct.equals(dataProp.getProperty("emailPwdNotMatchingWarningExpected"));

	}

	public boolean invalidLoginWithWrongPassword() throws IOException {
		LoginPage.enterloginId(prop.getProperty("validEmail"));

		LoginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		LoginPage.clickLoginButton();

		String warningMessageAct = driver.findElement(WrongCredentialLoc).getText();

		return warningMessageAct.equals(dataProp.getProperty("emailPwdNotMatchingWarningExpected"));

	}

	public boolean invalidLoginWithWrongEmailandWrongPassword() throws IOException {

		LoginPage.enterloginId(Utilities.generateTimeStamp());
		LoginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		LoginPage.clickLoginButton();
		String warningMessageAct = driver.findElement(WrongCredentialLoc).getText();
		return warningMessageAct.equals(dataProp.getProperty("emailPwdNotMatchingWarningExpected"));

	}

	public boolean invalidLoginWithoutCredentials() throws IOException {
		LoginPage.enterloginId("");
		// LoginPage.enterPassword("");
		LoginPage.clickLoginButton();
		String warningMessageAct = driver.findElement(WrongCredentialLoc).getText();
		return warningMessageAct.equals(dataProp.getProperty("emailPwdNotMatchingWarningExpected"));

	}

	public boolean emailandPwdFieldPlaceHolderTxt() throws InterruptedException { // to optimize
		HomePage.clickOnMyAccountDropMenu();
		HomePage.clickOnMyloginMenu();
		String placeHolderEmailActl = driver.findElement(EmailFieldLoc).getAttribute("placeholder");
		String placeHolderEmailExpct = "E-Mail Address";
		Thread.sleep(5000);
		boolean res = placeHolderEmailActl.equals(placeHolderEmailExpct);
		Thread.sleep(5000);
		String placeHolderPwdAct = driver.findElement(PwdFieldLoc).getAttribute("placeholder");
		String placeHolderPwdExp = "Password";
		boolean res1 = placeHolderPwdAct.equals(placeHolderPwdExp);
		Thread.sleep(5000);
		return res && res1;

	}

	public boolean passwordVisibility() {

		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.partialLinkText("Login")).click();
		String type = driver.findElement(By.id("input-password")).getAttribute("type");
		if (type.equals("password")) {

			return true;

		} else {
			return false;
		}
	}

}
