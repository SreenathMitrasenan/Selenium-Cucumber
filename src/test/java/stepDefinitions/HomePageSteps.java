package stepDefinitions;


import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.DoorwardDashboardPage;
import pageObjects.DoorwardHomePage;
import pageObjects.DoorwardLearnerRegistrationPage;


public class HomePageSteps {
	WebDriver driver;
	DoorwardHomePage homePage;
	DoorwardDashboardPage dashboardPage;
	DoorwardLearnerRegistrationPage registrationPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	 public HomePageSteps(TestContext context) throws MalformedURLException {
		 TestContext testContext = context;
		 homePage = testContext.getPageObjectManager().getDoorwardLoginPage();
		 dashboardPage=testContext.getPageObjectManager().getDoorwardDashboardPage();
		 //driver=testContext.getWebDriverManager().getDriver();
		 } 
	
	 @Given("^User is on doorward home page$")
	    public void user_is_on_doorward_home_page() throws Throwable {
		 
		 //TESTING

		 //TESTING
		 homePage.navigate_homepage();
	 
	    }
	  
	 
	@Then("^I enter username'(.+)' and password'(.+)'$")
    public void i_enter_username_and_password(String username, String password) throws Throwable {
		homePage.enter_logincredentials(username, password);
    }
	@And("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
		homePage.click_loginbutton();	
			
	}

	 @Then("^I verify the error message for incorrect user in login page'(.+)'$")
	    public void i_verify_the_error_message_for_incorrect_user_in_login_page(String errormsg) throws Throwable {
		 homePage.verify_incorrectuser(errormsg);
	    }
	 
	 @Then("^I verify the error message for incorrect password in login page'(.+)'$")
	    public void i_verify_the_error_message_for_incorrect_password_in_login_page(String errormsg) throws Throwable {
		 homePage.verify_incorrectpassword(errormsg);
	    }
	  	 
	 @Then("^I teardown the browser$")
	    public void i_teardown_the_browser() throws Throwable {
	        driver.quit();
	    }
	 
	 @Then("^I verify the doorward dashboard after successfull login$")
	    public void i_verify_the_doorward_dashboard_after_successfull_login() throws Throwable {
		 dashboardPage.verify_doorwarddashboard();
		}
	  @Then("^I click on administrator logo dropdown$")
	    public void i_click_on_administrator_logo_dropdown() throws Throwable {
		  dashboardPage.click_adminlogodropdown();
	    }

	  @Then("^I click on change password button in user profile session and updates currentpassword'(.+)'newpassword'(.+)'and confirmpassword'(.+)'$")
	    public void i_click_on_change_password_button_in_user_profile_session_and_updates_currentpasswordnewpasswordand_confirmpassword(String currentpwd, String newpwd, String cpass) throws Throwable {
		  dashboardPage.click_changepasswordbutton();
		  dashboardPage.enter_currentpassword(currentpwd);
		  dashboardPage.enter_newpassword(newpwd);
		  dashboardPage.enter_confirmpassword(cpass);
	    }

	    @Then("^I click on save password button$")
	    public void i_click_on_save_password_button() throws Throwable {
	    	dashboardPage.click_savepasswordbutton();
	    }
	    @Then("^I click on edit user profile information$")
	    public void i_click_on_edit_user_profile_information() throws Throwable {
	    	//homePage.navigate_editinformationpage();
	    	dashboardPage.click_admineditinfologo();
	    	dashboardPage.click_adminEditInfoButton(); 
	    }
	    
	    @Then("^I edit firstname'(.+)'$")
	    public void i_edit_firstname(String firstname) throws Throwable {
	    	dashboardPage.edit_firstname(firstname);
	    }

	    @Then("^I edit lastname'(.+)'$")
	    public void i_edit_lastname(String lastname) throws Throwable {
	    	dashboardPage.edit_lastname(lastname);
	    }

	    @Then("^I edit email'(.+)'$")
	    public void i_edit_email(String email) throws Throwable {
	    	dashboardPage.edit_email(email);
	    }

	    @Then("^I edit phone number'(.+)'$")
	    public void i_edit_phone_number(String phonenumber) throws Throwable {
	    	dashboardPage.edit_phonenumber(phonenumber);
	    }

	    @Then("^I click on save information button$")
	    public void i_click_on_save_information_button() throws Throwable {
	    	dashboardPage.click_savebutton();  
	    }
	    
	   

	  
	    
	   

	    
	   
	    
	    
	    
	    
}
