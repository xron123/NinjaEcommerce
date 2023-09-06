package com.NinjaEcommerceTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.NinjaEcommerceBase.NinjaBase;
import com.NinjaEcommerceProjectPages.HomePage;

public class rough {

	public static WebDriver driver;

	public static void main(String[] args) {


		
//ChromeOptions Options = new ChromeOptions();

	driver = new EdgeDriver();
	driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	driver.findElement(By.id("input-email")).sendKeys("@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	//driver.findElement(By.id("input-email")).getAttribute("validationMessage");
	System.out.println(driver.findElement(By.id("input-email")).getAttribute("validationMessage"));
	}

}
