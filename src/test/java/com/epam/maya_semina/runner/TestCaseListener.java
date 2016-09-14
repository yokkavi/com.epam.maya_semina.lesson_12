package com.epam.maya_semina.runner;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.maya_semina.test.BaseTest;
import com.epam.maya_semina.ui.Screenshots;
import com.epam.maya_semina.utils.LogWriter;

public class TestCaseListener implements ITestListener {
    
	private static int countReportsWithError;
    private static int countReportsPassed;
    private static int countReportsSkipped;
    private static int countReportsAll;
	
	public static String makeScreenShot(ITestResult result, String message) {
		WebDriver driver = extractDriverFromResult(result);
		if (driver == null) {
			return "Не удалось извлечь веб-драйвер. Скриншот не может быть сделан";
		}
		return Screenshots.getScreenshot(driver, message);
	}
	
	private static WebDriver extractDriverFromResult(ITestResult result) {
		if (result.getInstance() == null) {
			System.out.println("Скрин-шот не был сделан, т.к. невозможно получить объект экземпляр теста");
			return null;
		}
		if (!(result.getInstance() instanceof BaseTest)) {
			System.out.println(String.format("Скрин-шот не был сделан, т.к. невозможно преобразовать объект %s к %s", result.getInstance().getClass(), BaseTest.class));
			return null;
		}
		BaseTest test = (BaseTest)result.getInstance();
		if (test.getDriver() == null) {
			System.out.println("Скрин-шот не был сделан, т.к. веб-драйвер для теста не инициализирован");
			return null;
		}
		return test.getDriver();
	}

    public void onTestStart(ITestResult testResult) {
    }

    public void onTestSuccess(ITestResult testResult) {
        countReportsAll++;
        countReportsPassed++;
        long timeout = testResult.getEndMillis() - testResult.getStartMillis();
        LogWriter.passedMsg(testResult.getName(), "выполнено успешно за [" + getDateByMills(timeout) + "]");
    }

    public void onTestFailure(ITestResult testResult) {
        countReportsAll++;
        countReportsWithError++;
        String message = testResult.getThrowable().getMessage();
        String resultMessage = makeScreenShot(testResult, message);
        LogWriter.failedMsg(testResult.getName(), resultMessage);
    }

    public void onTestSkipped(ITestResult testResult) {
        countReportsAll++;
        countReportsSkipped++;
        LogWriter.skippedMsg(testResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
    }

    public void onStart(ITestContext context) {
        LogWriter.creatingReportFile();
    }

    public void onFinish(ITestContext context) {
        LogWriter.generateStatisticReportsAndClose(
        		countReportsAll,countReportsWithError,
                countReportsPassed,countReportsSkipped);
        LogWriter.copyReportFileInHistory();
        Screenshots.copyScreenshotFolderInHistory();
    }

    private static String getDateByMills(long timeout){
        timeout = timeout / 1000;
        int hours = (int) timeout / 3600;
        timeout = timeout % 3600;
        int min = (int) timeout / 60;
        int sec = (int) timeout % 60;
        String out = String.format("%d:%d:%d", hours, min, sec);
        return out;
    }
}

