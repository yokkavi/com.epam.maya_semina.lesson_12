package com.epam.maya_semina.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class LogWriter {
	private static PrintWriter writer;
    private static String fileReportHtmlPath;
    private static String historyFileReportHtmlPath;
    private static String historyFolder;


    public static String getHistoryFolder() {
        return historyFolder;
    }
    
    public static void creatingReportFile(){
        historyFolder = "./historyReports/" + getTodayDate() + "/";
        fileReportHtmlPath = "Report.html";
        historyFileReportHtmlPath = "Reports " + getTodayDate() + ".html";
        File fileOldReport = new File(fileReportHtmlPath);
        if(fileOldReport.exists()){
            fileOldReport.delete();
        }
        try {
            writer = new PrintWriter(fileReportHtmlPath, "UTF-8");
        }
        catch (FileNotFoundException e) {}
        catch (UnsupportedEncodingException e) {}
        writer.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>");
        writer.println("<title>Week 5 Selenium WebDriver Advanced</title>");
        writer.println("<style type=\"text/css\">i {color: #247E4D;}</style>");
        writer.println("<style type=\"text/css\">b {color: #AD1A0B;}</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("Демо отчет для лекции 'Week 5 Selenium WebDriver Advanced'<br>");
        writer.println("<table border=\"\"1\"\"><tr><th>Time</th><th>Test Name</th><th>Passed/Failed</th><th>Screen / [ Time ]</th></tr>");
    }

    public static void passedMsg(String testName, String statusText){
        writer.print("<tr><td>" + getTimeNow() + " <td>" + testName);
        writer.println("<td><i>Passed</i><td>" + statusText + "</td></tr>");
    }

    public static void failedMsg(String testName, String errorText){
        writer.print("<tr><td>" + getTimeNow() + " <td>" + testName);
        writer.println("<td><b>Failed</b><td>" + errorText + "</td></tr>");
    }

    public static void skippedMsg(String testName){
        writer.print("<tr><td>" + getTimeNow() + " <td>" + testName);
        String colorId = "696969";
        writer.println("<td><font color=\"#" + colorId + "\">Skipped</font>" +
                "<td><font color=\"#" + colorId + "\">Тест пропущен</font></td></tr>");
    }

    public static void generateStatisticReportsAndClose(
    		int all, int error,
    		int passed, int skipped){
        writer.println("</table>");
        writer.print("<br>");
        writer.println("<table border=\"\"1\"\"><tr><th>Статистика проверок</th><th>Количество отчетов</th></tr>");
        writer.print("<tr><td>Всего тестов<td>" + all + "</tr>");
        writer.print("<tr><td>Успешные тесты<td>" + passed +"</tr>");
        writer.print("<tr><td>Пропущено тестов<td>" + skipped + "</tr>");
        writer.print("<tr><td>Тесты с ошибками<td>" + error + "</tr>");
        writer.println("</table>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }

    public static void copyReportFileInHistory() {
        File oldFile = new File(fileReportHtmlPath);
        File newFile = new File(historyFolder + historyFileReportHtmlPath);
        try {
            FileUtils.copyFile(oldFile, newFile);
        } catch (IOException e) {}
    }

    private static String getTodayDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd - HH.mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static String getTimeNow(){
        DateFormat dateFormat = new SimpleDateFormat("HH.mm.ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}

