package stepDefinitions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.DoorwardDashboardPage;
import pageObjects.DoorwardHomePage;
import pageObjects.DoorwardLearnerRegistrationPage;

public class UserCreationSteps {
	
	WebDriver driver;
	DoorwardHomePage homePage;
	DoorwardDashboardPage dashboardPage;
	DoorwardLearnerRegistrationPage registrationPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	 public UserCreationSteps(TestContext context) throws MalformedURLException {
		 TestContext testContext = context;
		 homePage = testContext.getPageObjectManager().getDoorwardLoginPage();
		 dashboardPage=testContext.getPageObjectManager().getDoorwardDashboardPage();
		 //driver=testContext.getWebDriverManager().getDriver();
		 } 
	
	 
}
