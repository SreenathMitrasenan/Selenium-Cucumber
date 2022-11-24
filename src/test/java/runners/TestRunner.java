
package runners;
import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/",
 glue= {"stepDefinitions"},
 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extentreports/Extentreport.html", // working
//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  // not working
//plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"
	        

 },
 monochrome = true
 )
//plugin = { "pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},  // not working



public class TestRunner {
	 @AfterClass
	 public static void writeExtentReport() throws IOException {
		 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		 Reporter.setSystemInfo("Environment", "DOORWARD TEST");
	     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10 | " + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.6.6");
	     Reporter.setSystemInfo("Java Version", "15.0.1 2020-10-20");     
	     
	
	     // directory where output is to be printed // Not working
	     /*ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/test-output/SparkReport/Spark.html");
	     ExtentReports extent = new ExtentReports();
	     extent.attachReporter(spark); */

	     
	     
	}
	 
}