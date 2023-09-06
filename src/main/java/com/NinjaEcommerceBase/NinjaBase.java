package com.NinjaEcommerceBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tutorialsninja.utils.Utilities;

public class NinjaBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Properties dataProp;

	public NinjaBase() throws IOException {

		FileInputStream fissource = new FileInputStream( //it establishes a connection to read file
				"C:\\Users\\Thahir\\Desktop\\NinjaEcommerceProject\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");

		Properties prop = new Properties();// this class in java provides methods like.load to save conif data (properties files)
		prop.load(fissource);// load the source

		// second property file

		FileInputStream fissource2 = new FileInputStream(
				"C:\\Users\\Thahir\\Desktop\\NinjaEcommerceProject\\src\\main\\java\\com\\tutorialsninja\\testdata\\testdata.properties");
		dataProp = new Properties();
		dataProp.load(fissource2);
		
		
		FileInputStream fis2 = new FileInputStream (s);
	}

	@BeforeMethod
	public static void launchBrowser() throws IOException { // try connecting with properties file.

		String browserName = prop.getProperty("browser");

		{
			if (browserName.equalsIgnoreCase("chrome")) {

				ChromeOptions Options = new ChromeOptions();
				Options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(Options);

			} else if (browserName.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}
