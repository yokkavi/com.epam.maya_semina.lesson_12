package com.epam.maya_semina.ui.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage extends MessagePage {

	public DraftsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy(xpath = ".//*[@id='rcmliDrafts']/a")
	private WebElement draftsLink;

	@FindBy(xpath = ".//*[text() = 'Черновики']")
	private WebElement deleteDraftMessage;

	public WebElement getDeleteDraftMessage() {
		return deleteDraftMessage;
	}

	@Override
	public WebElement getDraftsLink() {
		return draftsLink;
	}
	
	@Override
	public DraftsPage clickDraftsLink() {
		new Actions(driver).click(draftsLink).build().perform();
		return this;
	}
	
	@Override
	public MessagePage getMessagePage(){
		return super.getMessagePage();
	}


}