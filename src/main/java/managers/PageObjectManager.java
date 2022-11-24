package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.DoorwardDashboardPage;
import pageObjects.DoorwardHomePage;
import pageObjects.DoorwardLearnerRegistrationPage;

public class PageObjectManager {
	private WebDriver driver;
	private DoorwardHomePage doorwardLogin;
	private DoorwardDashboardPage doorwardDashboard;
	private DoorwardLearnerRegistrationPage doorwardRegistration;
	
	public PageObjectManager(WebDriver driver) {
		 this.driver = driver;
		}
	public DoorwardHomePage getDoorwardLoginPage(){
		return (doorwardLogin == null) ? doorwardLogin = new DoorwardHomePage(driver) : doorwardLogin;
		}
	public DoorwardDashboardPage getDoorwardDashboardPage(){
		return (doorwardDashboard == null) ? doorwardDashboard = new DoorwardDashboardPage(driver) : doorwardDashboard;
		}
	public DoorwardLearnerRegistrationPage getDoorwardRegistrationPage(){
		return (doorwardRegistration == null) ? doorwardRegistration = new DoorwardLearnerRegistrationPage(driver) : doorwardRegistration;
		}
}
