package com.epam.maya_semina.ui.webDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.epam.maya_semina.exceptions.UnknownDriverTypeException;

public class Driver {

	private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";
	private static DriverTypes defaultDriverType = DriverTypes.FIREFOX;

	private static HashMap<String, WebDriver> instances;

	static {
		instances = new HashMap<String, WebDriver>();
	}

	public static WebDriver getWebDriverInstances(String name, DriverTypes driverType) {

		WebDriver driver;

		if (!instances.containsKey(name)) {
			switch (driverType) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case IE:
				driver = new InternetExplorerDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "D:\\Maya\\workspace\\com.epam.maya_semina.lesson_10\\src\\test\\resources\\chromedriver.exe");//"D:\\workspace\\com.epam.maya_semina.lesson_10\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default: 
				throw new UnknownDriverTypeException("Unknown driver type specified: " + driverType.getDriverName());
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			instances.put(name, driver);
		}
		else driver = instances.get(name);
		
		return driver;
	}
	
	public static WebDriver getWebDriverInstances(String name) {
		return getWebDriverInstances(name, defaultDriverType);
	}
	
	public static WebDriver getWebDriverInstances() {
		return getWebDriverInstances(DEFAULT_WEB_DRIVER, defaultDriverType);
	}
}
