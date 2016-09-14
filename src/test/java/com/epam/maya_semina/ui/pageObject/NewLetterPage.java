package com.epam.maya_semina.ui.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage extends MainPage {
	private WebDriver driver;

	@FindBy(xpath = ".//*[@id='_to']")
	private WebElement editableTextFieldTo;

	@FindBy(xpath = ".//*[@id='compose-subject']")
	private WebElement editableTextFieldTheme;

	@FindBy(xpath = ".//*[@id='tinymce']/div[1]")
	private WebElement editableTextFieldBody;

	@FindBy(xpath = ".//*[@id='rcmbtn109']")
	private WebElement saveLetterButton;

	@FindBy(xpath = ".//*[text() = 'Сохранено в Черновиках']")
	private WebElement saveLetterMessage;

	@FindBy(xpath = ".//*[@id='rcmbtn105']")
	private WebElement sendMessageButton;

	@FindBy(xpath = ".//*[text() = 'Сообщение отправлено']")
	private WebElement sendMessageMessage;

	public NewLetterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSendMessageMessage() {
		return sendMessageMessage;
	}

	public WebElement getSendMessageButton() {
		return sendMessageButton;
	}

	public WebElement getSaveLetterMessage() {
		return saveLetterMessage;
	}

	public WebElement getSaveButton() {
		return saveLetterButton;
	}

	public WebElement getEditableTextFieldTheme() {
		return editableTextFieldTheme;
	}

	public WebElement getEditableTextFieldBody() {
		return editableTextFieldBody;
	}

	public NewLetterPage clickSaveLetterButton() {
		new Actions(driver).click(saveLetterButton).build().perform();
		return this;
	}

	public NewLetterPage clickSendMessageButton() {
		new Actions(driver).doubleClick(sendMessageButton).build().perform();
		return this;
	}

	public NewLetterPage writeLetter(String to, String theme, String body) {
		editableTextFieldTo.click();
		editableTextFieldTo.sendKeys(to);
		editableTextFieldTheme.click();
		editableTextFieldTheme.sendKeys(theme);
		new Actions(driver).sendKeys(Keys.TAB).sendKeys(body).build().perform();
		return this;
	}

}