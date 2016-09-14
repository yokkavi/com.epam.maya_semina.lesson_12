package com.epam.maya_semina.ui.webDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingletone {
	private static WebDriver instance = null;

	private DriverSingletone() {
	}

	public static WebDriver getWebDriverInstance() {
		if (instance == null) {
			instance = new FirefoxDriver();
			instance.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}		
		return instance;
	}
}
