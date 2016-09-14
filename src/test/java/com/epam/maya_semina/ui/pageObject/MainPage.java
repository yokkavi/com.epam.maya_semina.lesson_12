package com.epam.maya_semina.ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	private WebDriver driver;

	@FindBy(xpath = ".//*[@class='button-logout']")
	private WebElement exitButton;

	@FindBy(xpath = ".//*[@id='rcmbtn116']")
	private WebElement createNewLetterButton;

	@FindBy(xpath = ".//*[@id='rcmliDrafts']/a")
	private WebElement draftsLink;

	@FindBy(xpath = ".//*[@id='rcmliSent']/a")
	private WebElement sentMessagesLink;

	@FindBy(xpath = ".//*[@id='rcmliInbox']/a")
	private WebElement rcmlInboxLink;

	@FindBy(xpath = ".//*[@id='logo']")
	private WebElement mainPageLink;

	@FindBy(xpath = ".//*[@id='messagecontframe']")
	private WebElement recentMessageFrame;

	@FindBy(xpath = ".//*[@id='rcmbtn120']")
	private WebElement deleteButton;
	
	@FindBy(xpath = ".//*[@id='rcmbtn106']")
	private WebElement choiseAllButton;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public MainPage clickChoiseAllButton() {
		new Actions(driver).click(choiseAllButton).build().perform();
		return this;
	}
	
	public WebElement getChoiseAllButton() {
		return choiseAllButton;
	}
	
	public WebElement getRcmlInboxLink() {
		return rcmlInboxLink;
	}

	public WebElement getDeleteDraftButton() {
		return deleteButton;
	}

	public MainPage clickDeleteButton() {
		new Actions(driver).click(deleteButton).build().perform();
		return this;
	}

	public WebDriver switchToMessageFrame() {
		return driver.switchTo().frame(recentMessageFrame);
	}

	public WebElement getRecentMessageFrame() {
		return recentMessageFrame;
	}

	public WebElement getMainPageLink() {
		return mainPageLink;
	}

	public MainPage clickMainPageLink() {
		new Actions(driver).doubleClick(mainPageLink).build().perform();
		return this;
	}

	public WebElement getSentMessagesLink() {
		return sentMessagesLink;
	}

	public MainPage clickExitButton() {
		new Actions(driver).doubleClick(exitButton).build().perform();
		return this;
	}

	public MainPage clickCreateNewLetterButton() {
		new Actions(driver).click(createNewLetterButton).build().perform();
		return this;
	}

	public MainPage clickDraftsLink() {
		new Actions(driver).doubleClick(draftsLink).build().perform();
		return this;
	}

	public MainPage clickRcmlInboxLink() {
		new Actions(driver).doubleClick(rcmlInboxLink).build().perform();
		return this;
	}

	public MainPage clickSentMessagesLink() {
		new Actions(driver).doubleClick(sentMessagesLink).build().perform();
		return this;
	}

	public WebElement getDraftsLink() {
		return draftsLink;
	}

	public WebElement getExitButton() {
		return exitButton;
	}

	public WebElement getButtonCreateNewLetter() {
		return createNewLetterButton;
	}

}
