package com.tutorialsninja.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.NinjaEcommerceBase.NinjaBase;

public class MyListeners extends NinjaBase implements ITestListener {  // for ilistener
	
	public MyListeners() throws IOException {
		super();
		
	}

	public void onStart(ITestContext context) { 
		
		System.out.println("onStart-execution of project started");
		
	}

	public void onTestStart(ITestResult result) {
	
		String testName = result.getName();
		System.out.println(testName + " started executing");
	}
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + " is succesful ");
	}
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + " is failed ");
        System.out.println(result.getThrowable());
       // File src = driver.getScreenshotAs(OutputType.FILE);
	}
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + " is skipped ");
	      System.out.println(result.getThrowable());


	}
	
	public void onFinish(ITestContext context) {
		String testName = context.getName();
		System.out.println(testName + " done with testing ");
	}  
}
