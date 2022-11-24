package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.DoorwardHomePage;
import pageObjects.DoorwardLearnerRegistrationPage;

public class RegistrationPageSteps {
	DoorwardHomePage homePage;
	DoorwardLearnerRegistrationPage registrationPage;
	
	public RegistrationPageSteps(TestContext context) {
		 TestContext testContext = context;
		 homePage = testContext.getPageObjectManager().getDoorwardLoginPage();
		 registrationPage = testContext.getPageObjectManager().getDoorwardRegistrationPage();
		 } 
	
	@Then("^I click on create new account with fullname'(.+)'username'(.+)'email'(.+)'and password'(.+)'$")
    public void i_click_on_create_new_account_with_fullnameusernameemailand_password(String fullname, String username, String email, String password) throws Throwable {
	  homePage.click_createnewaccount();
	  registrationPage.enter_registerinfo(fullname, username, email, password);
    }

    @Then("^I verify success message$")
    public void i_verify_success_message() throws Throwable {
    	registrationPage.verify_registrationsuccessmessage();
    }
    @Then("^I verify failure message$")
    public void i_verify_failure_message() throws Throwable {
    	registrationPage.verify_registrationfailuremessage();
    }

}
