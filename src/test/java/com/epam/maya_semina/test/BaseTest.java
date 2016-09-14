package com.epam.maya_semina.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import com.epam.maya_semina.mail.bo.Persona;
import com.epam.maya_semina.mail.builder.BaseBuilder;
import com.epam.maya_semina.mail.builder.UserBuilder;
import com.epam.maya_semina.mailService.MailboxFunctions;
import com.epam.maya_semina.ui.pageObject.MailboxAuthorizationPage;
import com.epam.maya_semina.ui.pageObject.MainPage;
import com.epam.maya_semina.ui.webDriver.DriverSingletone;
import com.epam.maya_semina.utils.ScreenShot;
import com.epam.maya_semina.utils.ScreenShotListener;

@Listeners({ HTMLReporter.class , ScreenShotListener.class})//,
// TestCaseListener.class }) //

public class BaseTest {

	private Persona user;
	private WebDriver driver;
	private static final Logger LOG = Logger.getLogger(BaseTest.class);
	private String url;
	private MailboxAuthorizationPage mailboxAuthorizationPage;
	private MainPage inboxEmailPage;
	private static final String ELEMENT_BUTTON_CREATE_NEW_LETTER_IS_NOT_PRESENT = "Element button create new letter is not present: ";
	private static final String INCORRECT_TITLE = "Incorrect title: ";

	static {
		ScreenShot.deleteAll();
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}

	@Parameters({ "url" })
	@BeforeClass
	public void setUp(@Optional("http://Письмо.рф") String url) throws IOException {
		LOG.warn("start: setUp");
		this.url = url;
		// driver = Driver.getWebDriverInstances("Chrome", DriverTypes.CHROME);
		driver = DriverSingletone.getWebDriverInstance();
		LOG.warn("finish: setUp");
	}

	@Test(groups = "authorization")
	public void navigateToMailPageTest() {
		LOG.info("start: 'navigateToMailPageTest'");
		BaseBuilder builder = new UserBuilder();
		builder.buildPassword();
		builder.buildLogin();
		user = builder.getPersona();
		driver.get(url);
		mailboxAuthorizationPage = new MailboxAuthorizationPage(driver);
		boolean isThatPage = new MailboxFunctions(driver).equalsAuthorisatiomPageTitle(driver.getTitle());

		LOG.info("finish: 'navigateToMailPageTest'");
		Assert.assertTrue(isThatPage, ELEMENT_BUTTON_CREATE_NEW_LETTER_IS_NOT_PRESENT);
	}


	// 4 Выход из системы с помощью нажатия «выход»/«Выйти» На странице
	// появилось поле для ввода логина или пароля.


	@AfterSuite (alwaysRun = true)
	public void close() {
		LOG.warn("start: close");
		driver.close();
		LOG.warn("finish: close");
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLogger() {
		return BaseTest.LOG;
	}

	public String getUrl() {
		return this.url;
	}

	public MainPage getInboxEmailPage() {
		return this.inboxEmailPage;
	}
}
