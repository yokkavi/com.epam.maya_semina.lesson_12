package com.epam.maya_semina.ui.pageObject;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailboxAuthorizationPage {

	private WebDriver driver;

	@FindBy(xpath = ".//*[@class='lloginlabel']")
	private WebElement loginField;

	@FindBy(xpath = ".//*[@class='lpasslabel']")
	private WebElement passwordField;

	@FindBy(xpath = ".//*[@id='ctl01_lbutton']")
	private WebElement loginButton;

	public MailboxAuthorizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public MailboxAuthorizationPage login(String login, String password) {
		// new
		// Actions(driver).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(login).build().perform();
		// new
		// Actions(driver).sendKeys(Keys.TAB).sendKeys(password).build().perform();
		new Actions(driver).sendKeys(loginField, login).build().perform();
		new Actions(driver).sendKeys(passwordField, password).build().perform();
		return this;
	}

	public MailboxAuthorizationPage clickLoginButton() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('ctl01_lbutton').click();");
//		new Actions(driver).click(loginButton).build().perform();
		return this;
	}

}
