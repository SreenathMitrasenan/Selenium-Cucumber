package stepDefinitions;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataProviders.JsonReader;
import pageObjects.DoorwardDashboardPage;
import pageObjects.DoorwardHomePage;

public class DashboardPageExamsSteps {
	WebDriver driver;
	DoorwardHomePage homePage;
	DoorwardDashboardPage dashboardPage;
	public DashboardPageExamsSteps(TestContext context) throws MalformedURLException {
		 TestContext testContext = context;
		 dashboardPage=testContext.getPageObjectManager().getDoorwardDashboardPage();
		 //driver=testContext.getWebDriverManager().getDriver();
		 } 
	
	 @Then("^I click on exam session with exam title'(.+)'and section instructions'(.+)'$")
	    public void i_click_on_exam_session_with_exam_titleand_section_instructions(String examtitle, String secinstruction) throws Throwable {
	    	dashboardPage.click_exam();
	    	dashboardPage.click_onquestionstab();
	    	dashboardPage.enter_examtitle(examtitle);
	    	dashboardPage.click_onaddsection();
	    	dashboardPage.enter_sectioninstructions(secinstruction);
	    }
	 
	 @Then("^I remove exam title and verify error message'(.+)'$")
	    public void i_remove_exam_title_and_verify_error_message(String msg) throws Throwable {
		 dashboardPage.clear_examtitle();
		 dashboardPage.verify_examtitleerrormessage(msg);
	    }
	 

	 @Then("^I remove exam section instructions and verify error message'(.+)'$")
	    public void i_remove_exam_section_instructions_and_verify_error_message(String msg) throws Throwable {
		 dashboardPage.clear_examinstructions();
		 dashboardPage.verify_examinstructionseerrormessage(msg);
	    }
	 
	    @Then("^I verify check box which mentions All questions are compulsory is checked true or enable otherwise$")
	    public void i_verify_check_box_which_mentions_all_questions_are_compulsory_is_checked_true_or_enable_otherwise() throws Throwable {
	    	dashboardPage.verify_compulsorycheckboxenabled();
	    }

	    @Then("^I click on add question$")
	    public void i_click_on_add_question() throws Throwable {
	     dashboardPage.click_onaddquestion(); 
	    }

	 @Then("^I add multiple choice questions from file'(.+)'having four answer options$")
	    public void i_add_multiple_choice_questions_from_filehaving_four_answer_options(String filename) throws Throwable {
	    	int anwIter =0;
	    	int cvar =0;
	    	Actions act = new Actions(driver); 
	    	JsonReader jreader = new JsonReader();
			 HashMap<Integer, String> questionList=jreader.getDataList(filename, "Question");
			 HashMap<Integer, String> pointList=jreader.getDataList(filename, "point");
			 HashMap<Integer, String> qType=jreader.getDataList(filename, "Type");
			 HashMap<Integer, String> correctAnswerList=jreader.getDataList(filename, "CorrectAnswer");
			 HashMap<Integer, String> ansList1=jreader.getDataList(filename, "Answer1");
			 HashMap<Integer, String> ansList2=jreader.getDataList(filename, "Answer2");
			 HashMap<Integer, String> ansList3=jreader.getDataList(filename, "Answer3");
			 HashMap<Integer, String> ansList4=jreader.getDataList(filename, "Answer4");
		if(questionList.size()==pointList.size()&&qType.size()==ansList1.size()) {
			for (int iter=0; iter<questionList.size();iter++ ) {
		
				dashboardPage.fill_allMCQQuestionDetails(act, pointList.get(iter).toString(), qType.get(iter).toString(), questionList.get(iter).toString());
							
				anwIter= cvar+2;
				String xpQuestionEdit="//div[@class='eb-input--draft-text-area__editor rdw-editor-main']";
				String xpFirstanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpSecondanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpThirdanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpFourthnswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				cvar= anwIter;

				//Enter answer sessions
				dashboardPage.write_allanswerchoices(act, xpFirstanswerEdit, ansList1.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpSecondanswerEdit, ansList2.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpThirdanswerEdit, ansList3.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpFourthnswerEdit, ansList4.get(iter).toString());
				
				//logic for entering correct answer
				String xpathCorrectAnswer="//input[@name='answers["+correctAnswerList.get(iter).toString()+"].correct']";
				driver.findElement(By.xpath(xpathCorrectAnswer)).click();
			
				dashboardPage.click_addanswerstoquestionbutton();
				Thread.sleep(1500);
			}
		}			  
	    }
	    
	    
	    @Then("^I add multiple choice questions from file'(.+)'having six answer options$")
	    public void i_add_multiple_choice_questions_from_filehaving_six_answer_options(String filename) throws Throwable {
	    	int anwIter =0;
	    	int cvar =0;
	    	Actions act = new Actions(driver); 
	    	JsonReader jreader = new JsonReader();
	    	
	    	 HashMap<Integer, String> NumberofAnsList=jreader.getDataList(filename, "numerofanswers");
			 HashMap<Integer, String> questionList=jreader.getDataList(filename, "Question");
			 HashMap<Integer, String> pointList=jreader.getDataList(filename, "point");
			 HashMap<Integer, String> qType=jreader.getDataList(filename, "Type");
			 HashMap<Integer, String> correctAnswerList=jreader.getDataList(filename, "CorrectAnswer");
			 HashMap<Integer, String> ansList1=jreader.getDataList(filename, "Answer1");
			 HashMap<Integer, String> ansList2=jreader.getDataList(filename, "Answer2");
			 HashMap<Integer, String> ansList3=jreader.getDataList(filename, "Answer3");
			 HashMap<Integer, String> ansList4=jreader.getDataList(filename, "Answer4");
			 HashMap<Integer, String> ansList5=jreader.getDataList(filename, "Answer5");
			 HashMap<Integer, String> ansList6=jreader.getDataList(filename, "Answer6");
		if(questionList.size()==pointList.size()&&qType.size()==ansList1.size()) {
			
			for (int iter=0; iter<questionList.size();iter++ ) {
				// Create Question session
				dashboardPage.fill_allMCQQuestionDetails(act, pointList.get(iter).toString(), qType.get(iter).toString(), questionList.get(iter).toString());
				int defaultAnswerChoice=4;
				anwIter= cvar+2;
				//logic for adding more anwser options
				if(Integer.parseInt(NumberofAnsList.get(iter))>defaultAnswerChoice) {
					for(int i=defaultAnswerChoice;i<Integer.parseInt(NumberofAnsList.get(iter));i++) {
						dashboardPage.click_addmoreanswers();
					}
				}

				String xpFirstanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpSecondanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpThirdanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpFourthnswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpFifthhnswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpSixthnswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				cvar= anwIter;

				//Enter answer sessions				
				dashboardPage.write_allanswerchoices(act, xpFirstanswerEdit, ansList1.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpSecondanswerEdit, ansList2.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpThirdanswerEdit, ansList3.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpFourthnswerEdit, ansList4.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpFifthhnswerEdit, ansList5.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpSixthnswerEdit, ansList6.get(iter).toString());
								
				//logic for entering correct answer
				String xpathCorrectAnswer="//input[@name='answers["+correctAnswerList.get(iter).toString()+"].correct']";
				driver.findElement(By.xpath(xpathCorrectAnswer)).click();
			
				dashboardPage.click_addanswerstoquestionbutton();
				Thread.sleep(1500);
			}
		}
	    }
	    

	    @Then("^I add multiple choice questions from file'(.+)'having three answer options$")
	    public void i_add_multiple_choice_questions_from_filehaving_three_answer_options(String filename) throws Throwable {
	        
	    	int anwIter =0;
	    	int cvar =0;
	    	Actions act = new Actions(driver); 
	    	JsonReader jreader = new JsonReader();
	    	
	    	 HashMap<Integer, String> NumberofAnsList=jreader.getDataList(filename, "numerofanswers");
			 HashMap<Integer, String> questionList=jreader.getDataList(filename, "Question");
			 HashMap<Integer, String> pointList=jreader.getDataList(filename, "point");
			 HashMap<Integer, String> qType=jreader.getDataList(filename, "Type");
			 HashMap<Integer, String> correctAnswerList=jreader.getDataList(filename, "CorrectAnswer");
			 HashMap<Integer, String> ansList1=jreader.getDataList(filename, "Answer1");
			 HashMap<Integer, String> ansList2=jreader.getDataList(filename, "Answer2");
			 HashMap<Integer, String> ansList3=jreader.getDataList(filename, "Answer3");

		if(questionList.size()==pointList.size()&&qType.size()==ansList1.size()) {
			
			for (int iter=0; iter<questionList.size();iter++ ) {
				// Create Question session
				dashboardPage.fill_allMCQQuestionDetails(act, pointList.get(iter).toString(), qType.get(iter).toString(), questionList.get(iter).toString());
				int defaultAnswerChoice=4;
				anwIter= cvar+2;
				//logic for delete one more anwser options
				if(Integer.parseInt(NumberofAnsList.get(iter))<defaultAnswerChoice) {
					for(int i=Integer.parseInt(NumberofAnsList.get(iter));i<defaultAnswerChoice;i++) {
						Thread.sleep(1000);
						dashboardPage.click_deleteoneanswerchoice();
					}
				}

				String xpFirstanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpSecondanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				anwIter++;
				String xpThirdanswerEdit="(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]";
				cvar= anwIter;

				//Enter answer sessions				
				dashboardPage.write_allanswerchoices(act, xpFirstanswerEdit, ansList1.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpSecondanswerEdit, ansList2.get(iter).toString());
				dashboardPage.write_allanswerchoices(act, xpThirdanswerEdit, ansList3.get(iter).toString());								
				//logic for entering correct answer
				String xpathCorrectAnswer="//input[@name='answers["+correctAnswerList.get(iter).toString()+"].correct']";
				driver.findElement(By.xpath(xpathCorrectAnswer)).click();
			
				dashboardPage.click_addanswerstoquestionbutton();
				Thread.sleep(1500);
			}
		}
	    	
	    	
	    }
	    

	    @Then("^I add text input questions from file'(.+)'having descriptive questions$")
	    public void i_add_text_input_questions_from_filehaving_descriptive_questions(String filename) throws Throwable {
	    	
	    	int anwIter =0;
	    	int cvar =0;
	    	Actions act = new Actions(driver); 
	    	 JsonReader jreader = new JsonReader();
			 HashMap<Integer, String> questionList=jreader.getDataList(filename, "Question");
			 HashMap<Integer, String> pointList=jreader.getDataList(filename, "point");
			 HashMap<Integer, String> qType=jreader.getDataList(filename, "Type");
		if(questionList.size()==pointList.size()) {
			for (int iter=0; iter<questionList.size();iter++ ) {
				dashboardPage.fill_allTextInputnMCAMQuestionDetails(act, pointList.get(iter).toString(), qType.get(iter).toString(), questionList.get(iter).toString());						
				//Enter answer sessions
				// no answer sessions for text input
				
				//logic for entering correct answer
				// no correct answer for text input			
				dashboardPage.click_addanswerstoquestionbutton();
				Thread.sleep(1500);
			}
		}	
	    	
	       
	    }

	    
	    @Then("^I add multiple choice with answer marks questions from file'(.+)'having four answer options$")
	    public void i_add_multiple_choice_with_answer_marks_questions_from_filehaving_four_answer_options(String filename) throws Throwable {
	        int anwIter =0;
	    	int cvar =0;
	    	Actions act = new Actions(driver); 
	    	JsonReader jreader = new JsonReader();
			 HashMap<Integer, String> questionList=jreader.getDataList(filename, "Question");
			 HashMap<Integer, String> qType=jreader.getDataList(filename, "Type");
			 HashMap<Integer, String> ansList1=jreader.getDataList(filename, "Answer1");
			 HashMap<Integer, String> markList1=jreader.getDataList(filename, "Mark1");
			 HashMap<Integer, String> ansList2=jreader.getDataList(filename, "Answer2");
			 HashMap<Integer, String> markList2=jreader.getDataList(filename, "Mark2");
			 HashMap<Integer, String> ansList3=jreader.getDataList(filename, "Answer3");
			 HashMap<Integer, String> markList3=jreader.getDataList(filename, "Mark3");
			 HashMap<Integer, String> ansList4=jreader.getDataList(filename, "Answer4");
			 HashMap<Integer, String> markList4=jreader.getDataList(filename, "Mark4");
		if(questionList.size()==ansList1.size()) {
			for (int iter=0; iter<questionList.size();iter++ ) {
				int markIter =0;
				dashboardPage.fill_allTextInputnMCAMQuestionDetails(act, "Multiple choice with answer marks", qType.get(iter).toString(), questionList.get(iter).toString());
							
				//Enter answer sessions
				anwIter= cvar+2;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList1.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList2.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList3.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList4.get(iter).toString());
				cvar= anwIter;
				
				//Enter answer marks session
				
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList1.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList2.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList3.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList4.get(iter).toString());
								
				//logic for entering correct answer
				// no correct answer for MCQAM since the highest mark is referred as the priority
			
				dashboardPage.click_addanswerstoquestionbutton();
				Thread.sleep(1500);
			}
		}
	    
	    	
	    }
	    
	    
	    @Then("^I add multiple choice with answer marks questions from file'(.+)'having six answer options$")
	    public void i_add_multiple_choice_with_answer_marks_questions_from_filehaving_six_answer_options(String filename) throws Throwable {
	      
	    	int anwIter =0;
	    	int cvar =0;
	    	Actions act = new Actions(driver); 
	    	JsonReader jreader = new JsonReader();
	    	
	    	 HashMap<Integer, String> NumberofAnsList=jreader.getDataList(filename, "numerofanswers");
			 HashMap<Integer, String> questionList=jreader.getDataList(filename, "Question");
			 HashMap<Integer, String> qType=jreader.getDataList(filename, "Type");
			 HashMap<Integer, String> ansList1=jreader.getDataList(filename, "Answer1"); 
			 HashMap<Integer, String> ansList2=jreader.getDataList(filename, "Answer2");			 
			 HashMap<Integer, String> ansList3=jreader.getDataList(filename, "Answer3");			 
			 HashMap<Integer, String> ansList4=jreader.getDataList(filename, "Answer4");			 
			 HashMap<Integer, String> ansList5=jreader.getDataList(filename, "Answer5");			 
			 HashMap<Integer, String> ansList6=jreader.getDataList(filename, "Answer6");
			 HashMap<Integer, String> markList1=jreader.getDataList(filename, "Mark1");
			 HashMap<Integer, String> markList2=jreader.getDataList(filename, "Mark2");
			 HashMap<Integer, String> markList3=jreader.getDataList(filename, "Mark3");
			 HashMap<Integer, String> markList4=jreader.getDataList(filename, "Mark4");
			 HashMap<Integer, String> markList5=jreader.getDataList(filename, "Mark5");
			 HashMap<Integer, String> markList6=jreader.getDataList(filename, "Mark6");
			 if(questionList.size()==ansList1.size()) {
			
			for (int iter=0; iter<questionList.size();iter++ ) {
				int markIter =0;
				anwIter= cvar+2;
				int defaultAnswerChoice=4;
				dashboardPage.fill_allTextInputnMCAMQuestionDetails(act, "Multiple choice with answer marks", qType.get(iter).toString(), questionList.get(iter).toString());			
				//logic for adding more anwser options
				if(Integer.parseInt(NumberofAnsList.get(iter))>defaultAnswerChoice) {
					for(int i=defaultAnswerChoice;i<Integer.parseInt(NumberofAnsList.get(iter));i++) {
						dashboardPage.click_addmoreanswers();
					}
				}

				//Enter answer sessions
				anwIter= cvar+2;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList1.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList2.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList3.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList4.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList5.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList6.get(iter).toString());
				cvar= anwIter;
				
				//Enter answer marks session
				
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList1.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList2.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList3.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList4.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList5.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList6.get(iter).toString());
								
				//logic for entering correct answer
				// no correct answer for MCQAM since the highest mark is referred as the correct answer
			
				dashboardPage.click_addanswerstoquestionbutton();
				Thread.sleep(1500);
			}
		}
	    	
	    }
	    
	    @Then("^I add multiple choice with answer marks questions from file'(.+)'having three answer options$")
	    public void i_add_multiple_choice_with_answer_marks_questions_from_filehaving_three_answer_options(String filename) throws Throwable {
	        
	    	int anwIter =0;
	    	int cvar =0;
	    	Actions act = new Actions(driver); 
	    	JsonReader jreader = new JsonReader();
	    	
	    	 HashMap<Integer, String> NumberofAnsList=jreader.getDataList(filename, "numerofanswers");
			 HashMap<Integer, String> questionList=jreader.getDataList(filename, "Question");
			 HashMap<Integer, String> qType=jreader.getDataList(filename, "Type");
			 HashMap<Integer, String> ansList1=jreader.getDataList(filename, "Answer1"); 
			 HashMap<Integer, String> ansList2=jreader.getDataList(filename, "Answer2");			 
			 HashMap<Integer, String> ansList3=jreader.getDataList(filename, "Answer3");			 
			 HashMap<Integer, String> markList1=jreader.getDataList(filename, "Mark1");
			 HashMap<Integer, String> markList2=jreader.getDataList(filename, "Mark2");
			 HashMap<Integer, String> markList3=jreader.getDataList(filename, "Mark3");
			 if(questionList.size()==ansList1.size()) {
			
			for (int iter=0; iter<questionList.size();iter++ ) {
				int markIter =0;
				anwIter= cvar+2;
				int defaultAnswerChoice=4;
				dashboardPage.fill_allTextInputnMCAMQuestionDetails(act, "Multiple choice with answer marks", qType.get(iter).toString(), questionList.get(iter).toString());			
				//logic for delete one more anwser options
				if(Integer.parseInt(NumberofAnsList.get(iter))<defaultAnswerChoice) {
					for(int i=Integer.parseInt(NumberofAnsList.get(iter));i<defaultAnswerChoice;i++) {
						Thread.sleep(1000);
						dashboardPage.click_deleteoneanswerchoice();
					}
				}

				//Enter answer sessions
				anwIter= cvar+2;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList1.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList2.get(iter).toString());
				anwIter++;
				dashboardPage.write_allanswerchoices(act, "(//div[@class='rdw-editor-wrapper readOnly'])["+anwIter+"]", ansList3.get(iter).toString());
				cvar= anwIter;
				
				//Enter answer marks session
				
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList1.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList2.get(iter).toString());
				markIter++;
				dashboardPage.write_allanswermarks(act, "//input[@name='answers["+markIter+"].points']", markList3.get(iter).toString());
						
				//logic for entering correct answer
				// no correct answer for MCQAM since the highest mark is referred as the correct answer
			
				dashboardPage.click_addanswerstoquestionbutton();
				Thread.sleep(1500);
			}
		}
	    	
	    	
	    }
	    
	    
	    @Then("^I click on options tab and enter time in minutes'(.+)'$")
	    public void i_click_on_options_tab_and_enter_time_in_minutes(String min) throws Throwable {
	        dashboardPage.click_onoptionstab();
	        dashboardPage.verify_timelimitisdisabled();
	        dashboardPage.click_ontimelimit();
	        dashboardPage.enter_timeinminutes(min); 
	    }
	    
	    @Then("^I am making response option as all learners should see the responses$")
	    public void i_am_making_response_option_as_all_learners_should_see_the_responses() throws Throwable {
	        dashboardPage.verify_learnersresponsesisenabled();
	    }

	    @Then("^I enter exam availability date based on number of days from exam creation date'(.+)'$")
	    public void i_enter_exam_availability_date_based_on_number_of_days_from_exam_creation_date(int scdays) throws Throwable {
	    	//String availableFromDate=dashboardPage.get_availablefromvalue();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a ");
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.DATE, scdays);
			dashboardPage.set_availabeuntilvalue(dateFormat.format(c.getTime()));
			System.out.println(dateFormat.format(c.getTime()));
	    }
	    
	    @And("^I click on save options button$")
	    public void i_click_on_save_options_button() throws Throwable {
	    	dashboardPage.click_onsaveoptions();
	    }
}
