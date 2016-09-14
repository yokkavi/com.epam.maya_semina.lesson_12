package com.epam.maya_semina.mailService;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.maya_semina.mail.bo.letter.Letter;
import com.epam.maya_semina.mail.bo.Persona;
import com.epam.maya_semina.mail.bo.letter.LetterInterface;
import com.epam.maya_semina.ui.pageObject.MailboxAuthorizationPage;
import com.epam.maya_semina.ui.pageObject.MessagePage;
import com.epam.maya_semina.ui.pageObject.NewLetterPage;

public class MailboxFunctions {

	private static String AUTHORISATION_PAGE_TITLE = "Письмо.РФ - Первая Российская служба кириллической электронной почты";

	private static String LOGOUT_PAGE_TITLE = "Письмо.РФ";

	private static String CREATE_NEW_LETTER_PAGE_TITLE = "Письмо.РФ :: Написать сообщение";

	private static String DRAFTS_PAGE_TITLE = "Письмо.РФ :: Черновики";

	private WebDriver driver;

	public MailboxFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public void performAuthorization(MailboxAuthorizationPage page, Persona persona) {
		page = new MailboxAuthorizationPage(driver);
		page.login(persona.getUserLogin(), persona.getUserPassword());
		page.clickLoginButton();

	}

	public void writeNewLetter(Letter letter) {
		NewLetterPage page = new NewLetterPage(driver);
		page.writeLetter(letter.getTo(), letter.getTheme(), letter.getBody());
	}
	
	public void writeNewLetter(LetterInterface letterInterface) {
		NewLetterPage page = new NewLetterPage(driver);
		page.writeLetter(letterInterface.getTo(), letterInterface.getTheme(), letterInterface.getBody());
	}

	public boolean equalsAuthorisatiomPageTitle(String currenPagesTitle) {
		if (currenPagesTitle.equals(AUTHORISATION_PAGE_TITLE))
			return true;
		else
			return false;
	}

	public boolean equalsDraftsPageTitle(String currenPagesTitle) {
		if (currenPagesTitle.equals(DRAFTS_PAGE_TITLE))
			return true;
		else
			return false;
	}

	public boolean equalsCreateNewLetterPageTitle(String currenPagesTitle) {
		if (currenPagesTitle.equals(CREATE_NEW_LETTER_PAGE_TITLE))
			return true;
		else
			return false;
	}

	public boolean equalsLogoutPageTitle(String currenPagesTitle) {
		if (currenPagesTitle.equals(LOGOUT_PAGE_TITLE))
			return true;
		else
			return false;
	}

	public boolean isPresent(WebElement webElement) {
		boolean out = false;
		try {
			webElement.getSize();
			out = true;
		} catch (NoSuchElementException e) {
			out = false;
		}
		return out;
	}

	public WebElement waitUtilElementToBeClicable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement myDynamicElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return myDynamicElement;

	}

	public boolean equalsMessages(MessagePage sentMessagePage, String to, String theme, String body) {
		boolean assertHeaderTo = ((sentMessagePage.getMessagePage().getHeaderTo().getText()).compareTo(to) == 0);
		boolean assertHeaderSubject = (sentMessagePage.getMessagePage().getHeaderSubject().getText()
				.compareTo(theme) == 0);
		boolean assertRecentMessageBody = (sentMessagePage.getMessagePage().getRecentMessageBody().getText()
				.compareTo(body) == 0);
		return assertHeaderTo && assertHeaderSubject && assertRecentMessageBody;
	}
	
	public boolean equalsMessages(MessagePage sentMessagePage, LetterInterface letter) {
		
		String to = letter.getTo();
		String theme = letter.getTheme();
		String body = letter.getBody();

		boolean assertHeaderTo = ((sentMessagePage.getMessagePage().getHeaderTo().getText()).compareTo(to) == 0);
		boolean assertHeaderSubject = (sentMessagePage.getMessagePage().getHeaderSubject().getText()
				.compareTo(theme) == 0);
		boolean assertRecentMessageBody = (sentMessagePage.getMessagePage().getRecentMessageBody().getText()
				.compareTo(body) == 0);
		return assertHeaderTo && assertHeaderSubject && assertRecentMessageBody;
	}

}
