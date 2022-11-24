package stepDefinitions;

import java.net.MalformedURLException;

import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.DoorwardDashboardPage;

public class DashboardPageProgramsSteps {
	DoorwardDashboardPage dashboardPage;
	
	 public DashboardPageProgramsSteps(TestContext context) throws MalformedURLException {
		 TestContext testContext = context;
		 dashboardPage=testContext.getPageObjectManager().getDoorwardDashboardPage();
	 }
	 @Then("^I click on programs section$")
	    public void i_click_on_programs_section() throws Throwable {
	    	dashboardPage.click_programlistarrow();
	    }

	    @Then("^I click on allprograms section$")
	    public void i_click_on_allprograms_section() throws Throwable {
	    	dashboardPage.click_allprograms();
	    }

	    @Then("^I verify programs table list$")
	    public void i_verify_programs_table_list() throws Throwable {
	    	Assert.assertEquals(true, dashboardPage.verify_programlist());
	    }

	    @Then("^I get the list of programs$")
	    public void i_get_the_list_of_programs() throws Throwable {
	    	dashboardPage.get_allprogramNames();
	    }

	    
	    @Then("^I click on save program information button$")
	    public void i_click_on_save_program_information_button() throws Throwable {
	    	dashboardPage.click_saveprograminformationbutton();
	    }

	    @Then("^I verify the error message'(.+)'$")
	    public void i_verify_the_error_message(String errmsg) throws Throwable {
	    	dashboardPage.verify_errormessage(errmsg);
	    }

		@Then("^I verify the newly created program in the dashboard'(.+)'$")
	    public void i_verify_the_newly_created_program_in_the_dashboard(String pname) throws Throwable {
			dashboardPage.verify_createdprogram(pname);
	    }
		@Then("^I click on newly created program'(.+)'$")
	    public void i_click_on_newly_created_program(String pname) throws Throwable {
	        dashboardPage.click_newlycreatedprogram(pname);
	    }
		

	    
		@Then("^I delete the newly created program'(.+)'$")
	    public void i_delete_the_newly_created_program(String pname) throws Throwable {
			dashboardPage.click_deleteprogram(pname);
	    }

	    @Then("^I verify the newly created program'(.+)'is deleted$")
	    public void i_verify_the_newly_created_programis_deleted(String pname) throws Throwable {
	    	dashboardPage.verify_createdprogramNotExists(pname);
	    }
	    

	    @Then("^I delete all existing modules associated with the program'(.+)'$")
	    public void i_delete_all_existing_modules_associated_with_the_program(String mnum) throws Throwable {
	    	//dashboardPage.delete_allmodules(mnum);
	    	dashboardPage.delete_allmodules();
	    }
	    

}
