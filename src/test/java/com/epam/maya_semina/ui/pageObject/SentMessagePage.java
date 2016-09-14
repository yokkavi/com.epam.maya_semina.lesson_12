package com.epam.maya_semina.ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentMessagePage extends MessagePage{

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='rcmrow29']/td[2]/a")
	private WebElement recentSentMessageLink;

	public SentMessagePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	public MessagePage getMessagePage() {
		return super.getMessagePage();
	}
	
	public WebElement getRecentSentMessageLink() {
		return recentSentMessageLink;
	}

	public SentMessagePage clickRecentSentMessageLink() {
		new Actions(driver).doubleClick(recentSentMessageLink).build().perform();
		return this;
	}

}