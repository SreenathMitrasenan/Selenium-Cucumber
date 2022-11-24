package stepDefinitions;

import java.net.MalformedURLException;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.DoorwardDashboardPage;

public class DashboardPageModulesSteps {
	
	DoorwardDashboardPage dashboardPage;
	
	 public DashboardPageModulesSteps(TestContext context) throws MalformedURLException {
		 TestContext testContext = context;
		 dashboardPage=testContext.getPageObjectManager().getDoorwardDashboardPage();
	 }
	
	  @Then("^I verify the number of modules added to the program'(.+)'$")
	    public void i_verify_the_number_of_modules_added_to_the_program(String mnum) throws Throwable {
	       dashboardPage.get_allprogramdetails();
	       dashboardPage.verify_numberofmodules(mnum);
	    }
	  
	  @Then("^I click on create new program and sets programname'(.+)'numberofmodules'(.+)'and module name'(.+)'$")
	    public void i_click_on_create_new_program_and_sets_programnamenumberofmodulesand_module_name(String pname, String mnum, String mname) throws Throwable {
	    	dashboardPage.click_createnewprogrambutton();
	    	dashboardPage.set_programname(pname);
	    	dashboardPage.set_numberofmodules(mnum);
	    	dashboardPage.set_modulename(mname);
	    }

	    @Then("^I click on create new program and sets programname'(.+)'numberofmodules'(.+)'and module names'(.+)'$")
	    public void i_click_on_create_new_program_and_sets_programnamenumberofmodulesand_module_names(String pname, String mnum, String mname) throws Throwable {
	    	dashboardPage.click_createnewprogrambutton();
	    	dashboardPage.set_programname(pname);
	    	dashboardPage.set_numberofmodules(mnum);
	    	dashboardPage.set_modulenames(mname); // module names should be seperated by :
	    }

}
