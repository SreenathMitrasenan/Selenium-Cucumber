package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.cucumber.listener.Reporter;

import cucumber.TestContext;
//import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import utilities.CommonDataModel;
import utilities.Screenshot;
 
public class Hooks {
 
	TestContext testContext;
	WebDriver driver;
	Screenshot screenShot;
 
	public Hooks(TestContext tc) throws MalformedURLException {
		 this.testContext = tc;
		 driver=testContext.getWebDriverManager().getDriver();
		 } 
	
 	@Before
 	public void beforeScenario(Scenario scenario) {
 			Reporter.assignAuthor("Sreenath Mitrasenan / Doorward ");
 			Reporter.assignAuthor("Basil Varghese / Doorward "); 
 	}
 
 	@After(order = 1)
 	public void afterScenario(Scenario scenario) throws InterruptedException, IOException {
 		if (scenario.isFailed()) {
 			String screenshotName = scenario.getName().replaceAll(" ", "_");
 			try {
 				screenShot=new Screenshot();
 				String dPath=screenShot.CaptureScreen("jpg",screenshotName);
 				Reporter.addScreenCaptureFromPath(dPath);

 				} catch (IOException e) {
 				} 
 			Thread.sleep(1000); 
 			//Process process = Runtime.getRuntime().exec("cmd /c killchromedriver.bat", null, new File(System.getProperty("user.dir")+FileReaderManager.getInstance().getConfigReader().getUtilittyPath().replace("/", "\\")));
 		} 
 	}
 	
  	@After(order = 0)
 	public void AfterSteps() throws IOException, InterruptedException{
		
  	driver.close();
	Thread.sleep(750);
  	CommonDataModel.getInstance().clear();
  	
   
  	
 	}
 
}
