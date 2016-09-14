package com.epam.maya_semina.runner;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import com.epam.maya_semina.config.Settings;
import com.epam.maya_semina.exceptions.TestNgRunException;


public class Runner {
	private static final String ERROR = "Error: ";
	private static final String ERROR_RUNNING_TEST_NG_SUITE = "Error running TestNG suite";
	protected TestNG testng = new TestNG();
	private String testNgConfig;

	public static void main(String[] args) throws TestNgRunException {
		new Runner(args).run();
	}

	public Runner(String[] args) {
		Settings settings = new Settings();
		CmdLineParser parser = new CmdLineParser(settings);

		try {
			parser.parseArgument(args);
			testNgConfig = settings.testNGpath;
		} catch (CmdLineException e) {
			System.err.println(ERROR + e.toString());
			parser.printUsage(System.out);
		}
	}

	public void run() throws TestNgRunException{
		try{
			XmlSuite xmlSuite = new Parser(testNgConfig).parseToList().get(0);
			this.testng.setCommandLineSuite(xmlSuite);
			this.testng.run();
		}
			catch (Exception ex){
				throw new TestNgRunException(ERROR_RUNNING_TEST_NG_SUITE +ex.getMessage());				
			}
		}
}
