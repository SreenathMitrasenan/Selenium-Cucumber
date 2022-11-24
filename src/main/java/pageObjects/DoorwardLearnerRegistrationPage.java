package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoorwardLearnerRegistrationPage {
	 WebDriver driver;
	 public DoorwardLearnerRegistrationPage(WebDriver driver) {
		 this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }

	 @FindBy(name="fullName")
	 WebElement Fullname;
	 @FindBy(name="username")
	 WebElement Username;
	 @FindBy(name="email")
	 WebElement Email;
	 @FindBy(name="password")
	 WebElement Password;
	 @FindBy(xpath="//*[@class='eb-button raised btn-primary ']") 
	 WebElement Register;
	 @FindBy(xpath="//*[contains(text(),'Thank you for trying Doorward. Please login to proceed')]") 
	 WebElement SuccessMessage;
	 @FindBy(xpath="//*[contains(text(),'Validation error')]") 
	 WebElement FailureMessageRed;
	 @FindBy(xpath="//*[contains(text(),'A user with this username already exists.')]") 
	 WebElement FailureMessage;
		

	 public void enter_registerinfo(String fullname, String name, String email, String password) {
		 Fullname.sendKeys(fullname);
		 Username.sendKeys(name);
		 Email.sendKeys(email);
		 Password.sendKeys(password);
		 Register.click();
	 }
	 
	 public void verify_registrationsuccessmessage() throws InterruptedException {
		 Thread.sleep(2000);
		 Assert.assertEquals("Verify success message","Thank you for trying Doorward. Please login to proceed", SuccessMessage.getText().trim());
	 }
	 public void verify_registrationfailuremessage() {
		 Assert.assertEquals("Verify failure message","A user with this username already exists.", FailureMessage.getText().trim()); 
	 }
}
