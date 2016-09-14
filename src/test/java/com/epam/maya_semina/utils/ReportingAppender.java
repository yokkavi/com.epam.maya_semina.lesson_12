package com.epam.maya_semina.utils;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class ReportingAppender extends AppenderSkeleton{

	public void close() {	
	}

	public boolean requiresLayout() {
		return true;
	}

	@Override
	protected void append(LoggingEvent event) {
		String message = this.layout.format(event);
		System.out.println(message);
		message = message.replaceAll("\n", "<br>");
		Reporter.log(message);
	}

}

