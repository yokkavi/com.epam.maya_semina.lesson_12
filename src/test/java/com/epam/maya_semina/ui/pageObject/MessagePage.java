package com.epam.maya_semina.ui.pageObject;


import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class MessagePage extends MainPage{
	private Formatter formatter;
	public MessagePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='messagelist']/tbody/tr[1]/td[2]")
	private WebElement recentLetterLink;

	@FindBy(xpath = ".//*[@id='messagelist']")
	private WebElement messageList;

	@FindBy(xpath = ".//*[@class='header subject']")
	private WebElement headerSubject;

	@FindBy(xpath = ".//*[@class='header to']/a[@class='rcmContactAddress']")
	private WebElement headerTo;

	@FindBy(xpath = ".//*[@class='rcmBody']/div[1]")
	private WebElement recentMessageBody;

	@FindBy(xpath = ".//*[@id='rcmliTrash']/a")
	private WebElement trashLink;

	@FindBy(xpath = ".//*[@id='rcmbtn106']")
	private WebElement choiseAllButton;

	public WebElement getChoiseAllButton() {
		return choiseAllButton;
	}

	public WebElement getTrashLink() {
		return trashLink;
	}

	public WebElement getHeaderSubject() {
		return headerSubject;
	}

	public WebElement getHeaderTo() {
		return headerTo;
	}

	public WebElement getRecentMessageBody() {
		return recentMessageBody;
	}

	public WebElement getMessageList() {
		return messageList;
	}

	public WebElement getRecentLetterLink() {
		return recentLetterLink;
	}

	public WebElement getLetterByNum(int num) {
		String xpath = ".//*[@id='messagelist']/tbody/tr[" + num + "]/td[2]";
		return driver.findElement(By.xpath(xpath));
	}

	public MessagePage clickRecentLetterLink() {
		new Actions(driver).click(recentLetterLink).build().perform();
		return this;
	}
	
	public MessagePage clickRecentLetterLinkByText(String textHeader, String textTo) {
		formatter = new Formatter();
		formatter.format(".//*[text() = '%s'and '%s']", textHeader, textTo);
		String xpath = formatter.toString();
		WebElement recentLetter = driver.findElement(By.xpath(xpath));
		new Actions(driver).click(recentLetter).build().perform();
		return this;
	}

	public MessagePage clickRecentLetterLinkByNum(int num) {
		WebElement recentLetterLinkByNum = getLetterByNum(num);
		new Actions(driver).click(recentLetterLinkByNum).build().perform();		
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click()", recentLetterLinkByNum);
		
		return this;
	}

	public MessagePage clickChoiseAllButton() {
		new Actions(driver).click(choiseAllButton).build().perform();
		return this;
	}

	public MessagePage dragAndDropRecentLetterByNumInTrash(int num) {
		WebElement recentLetterLinkByNum = getLetterByNum(num);
		new Actions(driver).dragAndDrop(recentLetterLinkByNum, trashLink).build().perform();
		return this;
	}

	public MessagePage dragAndDropRecentLetterInTrash() {
		new Actions(driver).dragAndDrop(recentLetterLink, trashLink).build().perform();
		return this;
	}
	
	public MessagePage getMessagePage(){
		return this;
	}
	

}
