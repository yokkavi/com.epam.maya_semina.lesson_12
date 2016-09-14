package com.epam.maya_semina.utils;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.maya_semina.test.BaseTest;

public class ScreenShotListener implements ITestListener{
	private static final String AUTO_SCREENSHOT_IN_FAILED_TEST = "AutoScreenshot in failed test";

	private void screenMake(ITestResult result){
		Object instance = result.getInstance();
		if (instance == null){
			return;
		}
		
		if (!(instance instanceof BaseTest)){
			return;
		}
		
		BaseTest baseTest = (BaseTest) instance;
		WebDriver driver = baseTest.getDriver();
		if (driver != null){
			ScreenShot.make(driver, AUTO_SCREENSHOT_IN_FAILED_TEST);
		}
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {	
		
	}

	public void onTestFailure(ITestResult result) {
		screenMake(result);
	}

	public void onTestSkipped(ITestResult result) {
		screenMake(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		screenMake(result);
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}

