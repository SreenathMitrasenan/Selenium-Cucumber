package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import managers.FileReaderManager;

public class DoorwardHomePage {
	 WebDriver driver;
	 public DoorwardHomePage(WebDriver driver) {
		 this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//*[@name='username']") 
	 WebElement Username;
	 @FindBy(xpath="//*[@name='password']") 
	 WebElement Password;
	 @FindBy(xpath="//button[contains(@class,'eb-button raised btn-primary')]//span[@class='btn__text'][normalize-space()='Login']") 
	 WebElement Loginbutton;
	 @FindBy(xpath="//a[text()='Forgot Password?']") 
	 WebElement ForgotPassword;
	 @FindBy(xpath="//a[text()='Create a new account']") 
	 WebElement CreateNewAccount;
	 @FindBy(xpath="//div[contains(text(),'User with this username does not exist.')]") 
	 WebElement ErrorMessageIncorrectUser;
	 @FindBy(xpath="//div[contains(text(),'Wrong password.')]") 
	 WebElement ErrorMessageWrongPwd;
	 @FindBy(xpath="//*[contains(text(),'Go back Home')]") 
	 WebElement GoBackHomeButton;

	
	
	 
	public void navigate_homepage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getDoorwardBaseUrl());
		if(check_gobackhomebutton()) {
		click_gobackhome();
		}
	}
	public void navigate_editinformationpage() {
		
		driver.get("https://develop.doorward.org/profile/administrator");
	}
	public boolean check_gobackhomebutton() {
		
		if(GoBackHomeButton.isEnabled()&& GoBackHomeButton.isDisplayed()) {
			return true;
		}else {
			return false;
		}
		
	}
	public void enter_username(String name) {
		Username.sendKeys(name);
		Username.sendKeys(Keys.TAB);
	}
	public void enter_password(String password) {
		Password.sendKeys(password);
		Password.sendKeys(Keys.TAB);
	}
	public void click_loginbutton() throws InterruptedException {
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Loginbutton);*/
		Thread.sleep(1500);
		if(Loginbutton.isEnabled()&& Loginbutton.isDisplayed()) {
			Loginbutton.click();
		}
		Thread.sleep(1500);
		
	}
	public void click_forgotpassword() {
		ForgotPassword.click();
	}
	public void click_createnewaccount() {
		CreateNewAccount.click();
	}
	public void click_gobackhome() {
		GoBackHomeButton.click();
	}
	
	public void enter_logincredentials(String uname,String pwd) throws InterruptedException {
		enter_username(uname);
		Thread.sleep(250);
		enter_password(pwd);
	}
	public void verify_incorrectuser(String errormsg) throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals("Verify incorrect user error message", errormsg.trim().toString(),ErrorMessageIncorrectUser.getText().trim().toString());
	}
	public void verify_incorrectpassword(String errormsg) throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals("Verify name displayed as 'Admin User'", errormsg.trim().toString(), ErrorMessageWrongPwd.getText().trim().toString());
	}
}
