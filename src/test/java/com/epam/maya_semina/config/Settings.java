package com.epam.maya_semina.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.kohsuke.args4j.Option;

public class Settings {

	@Option (name = "--testng", usage ="set path to TestNG xml", required = true)
	public String testNGpath;
	
	@Option (name = "--url", usage ="set URL", required = true)
	public String testURL;
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
}
