package com.epam.maya_semina.ui;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.epam.maya_semina.utils.LogWriter;

public class Screenshots {
	public static final String screenshotFolder = "./imgReport/";

    public static String getScreenshot(WebDriver driver, String message) {
        try {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String filePath = screenshotFolder + screenshot.getName();
            try {
                FileUtils.copyFile(screenshot, new File(filePath));
            } catch (IOException e) {}
            String resultMessage = "<a href='" + filePath + "'>" + message + "</a>";
            return resultMessage;
        } catch (WebDriverException e){
            return "Браузер: связь потеряна в момент ошибки '" + message + "'.";
        } catch (NullPointerException e){
            return "Браузер: '" + message + "'.";
        }
    }

    public static void clearingScreenshotFolder(){
        File screenFolder = new File(screenshotFolder);
        File[] files = screenFolder.listFiles();
        for (int i = 0; i<files.length;i++){
            files[i].delete();
        }
    }

    public static void copyScreenshotFolderInHistory(){
        File oldScreenFolder = new File(screenshotFolder);
        File newScreenFolder = new File(LogWriter.getHistoryFolder() + screenshotFolder);

        File[] files = oldScreenFolder.listFiles();
        for (int i = 0; i<files.length;i++){
            try {
                FileUtils.copyFileToDirectory(files[i], newScreenFolder, true);
            } catch (IOException e) {}
        }
    }

}

