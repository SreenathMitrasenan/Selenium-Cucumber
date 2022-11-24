package pageObjects;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.WebDriverManager;
import utilities.CommonDataModel;

public class DoorwardDashboardPage {
	 WebDriver driver;
	 CommonDataModel commondataModel ;//new CommonDataModel();
	 public DoorwardDashboardPage(WebDriver driver) {
		 this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//div[contains(text(),'DASHBOARD')]") 
	 WebElement Dashboard;	
	 @FindBy(xpath="//span[contains(text(),'Admin User')]") 
	 WebElement Adminuser;
	 @FindBy(xpath="//span[contains(text(),'gitaumoses4@gmail.com')]") 
	 WebElement Adminemail;
	 @FindBy(xpath="//i[contains(@class,'dropdown-arrow')]") 
	 WebElement Adminlogodropdown;
	//Issues in element locators for [using link navigation as alternative]
	 //===================================================================
	 @FindBy(xpath="(//div[@class='ed-dropdown__trigger']/div)[3]") 
	 WebElement AdminEditInfologo;
	 //===================================================================
	
	 @FindBy(xpath="//div[@class='ed-card__header']/i[contains(text(),'edit')]") 
	 WebElement AdminEditInfoButton;
	 @FindBy(xpath="//input[contains(@name,'firstName')]") 
	 WebElement AdminEditInfoFirstname;
	 @FindBy(xpath="//input[contains(@name,'lastName')]") 
	 WebElement AdminEditInfoLastname;
	 @FindBy(xpath="//input[contains(@name,'email')]") 
	 WebElement AdminEditInfoEmail;
	 @FindBy(xpath="//input[contains(@name,'phoneNumber')]") 
	 WebElement AdminEditInfoPhonenumber;
	 @FindBy(xpath="//span[contains(@class,'ed-display__label')]") 
	 WebElement AdminEditInfoUsername;
	 @FindBy(xpath="//button[contains(@type,'submit')]") 
	 WebElement AdminEditInfoSaveButton;
	 @FindBy(xpath="//span[@class='btn__text']") 
	 WebElement ChangePasswordButton;
	 @FindBy(xpath="//input[@name='password']") 
	 WebElement CurrentPassword;
	 @FindBy(xpath="//input[@name='newPassword']") 
	 WebElement NewPassword;
	 @FindBy(xpath="//input[@name='confirmPassword']") 
	 WebElement ReEnterNewPassword;
	 @FindBy(xpath="(//div[@class='ed-button__container']/button[@type='submit'])[2]") 
	 WebElement SavePasswordButton;

	 // Program session
	 @FindBy(xpath="//li[2]//span[1]//i[2]") 
	 WebElement ProgramsArrow;
	 @FindBy(xpath="//span[contains(text(),'Programs')]") 
	 WebElement Programs;
	 @FindBy(xpath="//span[contains(text(),'All programs')]") 
	 WebElement AllPrograms;
	 @FindBy(xpath="//span[contains(text(),'CREATE A NEW PROGRAM')]") 
	 WebElement CreateaNewProgramButton;
	/* @FindBy(xpath="//div[@aria-rowindex=1]/div[@aria-colindex='1']/div[@class='course-title']/span") 
	 WebElement FirstProgramName;
	 @FindBy(xpath="//div[@aria-rowindex=2]/div[@aria-colindex='1']/div[@class='course-title']/span") 
	 WebElement SecondProgramName; */
	 @FindBy(xpath="//div[@class='ReactVirtualized__Table']") 
	 WebElement ProgramTable;
	 @FindBy(xpath="//div[@class='ReactVirtualized__Table__row']") 
	 List <WebElement> ProgramNamesList;
	@FindBy(xpath="//*[contains(text(),'Delete program')]") 
	 //@FindBy(xpath="li[@class='dropdown-item'][4]")
	 WebElement DeleteProgramButton;
	 @FindBy(xpath="//*[contains(text(),'more_vert')]") 
	 WebElement DeleteProgramVerticalButton;
	 @FindBy(xpath="//input[@name='courseName']") 
	 WebElement DeleteProgramNameEntry;
	 @FindBy(xpath="//*[contains(text(),'Yes')]") 
	 WebElement DeleteProgramEntryYesButton;
	
	 
	
	//Program Information session
	 @FindBy(xpath="//input[@label='Program name.']") 
	 WebElement ProgramName;
	 @FindBy(xpath="//input[@name='noOfModules']") 
	 WebElement NumberOfModules;
	 @FindBy(xpath="//input[@name='modules.0.title']") 
	 WebElement FirstModuleName;
	 @FindBy(xpath="//input[@name='modules.1.title']") 
	 WebElement SecondModuleName;
	 @FindBy(xpath="//span[contains(text(),'Add module')]") 
	 WebElement AddModuleButton;
	 @FindBy(xpath="//span[contains(text(),'Save')]") 
	 WebElement SaveProgramInformationButton;
	 @FindBy(xpath="//span[contains(text(),'DevopsAlpha01')]") 
	 WebElement ProgramDevopsAlpha01;
	 
	//Module session
	 @FindBy(xpath="//span[contains(text(),'Add module')]") 
	 WebElement AddmoduleButton;
	 @FindBy(xpath="//input[@label='Module name.']") 
	 WebElement AddProgrammoduleModuleName;
	 @FindBy(xpath="//button[@class='eb-button raised btn-success positive_button']") 
	 WebElement SaveModuleButton;
	 @FindBy(xpath="//div[@class='ed-label-row']/span[1]") 
	 WebElement NumberofModules;
	 @FindBy(xpath="//div[@class='ed-label-row']/a") 
	 WebElement NumberofAssignments;
	 @FindBy(xpath="//div[@class='ed-label-row']/span[4]") 
	 WebElement NumberofQuizzes;
	 @FindBy(xpath="//div[@class='ed-label-row']/span[6]") 
	 WebElement NumberofExams;
	 @FindBy(xpath="//div[@class='ed-label-row']/span[8]") 
	 WebElement NumberofPages;
	 @FindBy(xpath="(//i[contains(text(),'delete')])[2]") 
	 WebElement DeleteModule;
	 @FindBy(xpath="//i[contains(text(),'delete')]") 
	 List <WebElement> DeleteAllModule;
	 @FindBy(xpath="//span[normalize-space()='Yes']") 
	 WebElement DeleteModuleYesbutton;
	 
	//Exam Session
	 @FindBy(xpath="(//i[contains(text(),'add')] [@class='material-icons  clickable'])[1]") 
	 WebElement PlusButton;
	 @FindBy(xpath=	"//i[contains(text(),'assessment')]" ) 
	 WebElement ExamLabel;
	 @FindBy(xpath=	 "//div[contains(text(),'Questions')]") 
	 WebElement QuestionTab;
	 @FindBy(xpath=	 "//div[contains(text(),'Options')]") 
	 WebElement OptionsTab;
	 @FindBy(xpath= "//input[@placeholder='Title of the Exam']") 
	 WebElement ExamTitle;
	 @FindBy(xpath= "//span[contains(text(),'Add Section')]") 
	 WebElement AddSectionButton;
	 @FindBy(xpath= "//div[@class='DraftEditor-root']") 
	 WebElement AddSectionInstructions;
	 @FindBy(xpath= "//input[@placeholder='All questions are compulsory']//following-sibling::span") 
	 WebElement SectionInstructionCheckBox;
	 @FindBy(xpath= "//input[@placeholder='All questions are compulsory']") 
	 WebElement QuestionsCompulsoryCheckBox;
	 @FindBy(xpath= "//*[contains(text(),'Add question')]") 
	 WebElement AddQuestion;
	 @FindBy(xpath= "//*[contains(text(),'Number of questions to choose')]") 
	 WebElement NumberOfQuestions;
	 @FindBy(xpath= "//div[contains(text(),'The title is required')]") 
	 WebElement ExamTitleErrorMessage;
	 @FindBy(xpath= "//div[contains(text(),'The instructions are required.')]") 
	 WebElement ExamInstructionsErrorMessage;
	 
	 
	 
	 
	 // Question creation session
	 @FindBy(xpath= "//input[@name='points']") 
	 WebElement PointsforQuestion;
	 @FindBy(xpath=  "//div[@class='eb-input__dropdownSelect']") 
	 WebElement QuestionTypeDropdown;
	 @FindBy(xpath=  "//div[contains(@class,'react-dropdown-select-dropdown-handle')]") 
	 WebElement QuestionTypeDropdownIcon;	
	 @FindBy(xpath=  "//span[@aria-label='Text input']") 
	 WebElement QuestionTypeTextInputLabel;
	 @FindBy(xpath=  "//span[@aria-label='Multiple choice with answer marks']") 
	 WebElement QuestionTypeMCWithAns;
	 @FindBy(xpath=  "//span[@aria-label='Multiple choice']") 
	 WebElement QuestionTypeMC; 
	 @FindBy(xpath=  "//div[@direction='ltr']/div[1]/span") 
	 WebElement QuestionTypeDropdownVerifyText;
	 @FindBy(xpath=  "//button[@class='eb-button raised btn-success positive_button']") 
	 WebElement AddanswersToQuestionButton;
	 @FindBy(xpath=  "//span[contains(text(),'Add answer')]") 
	 WebElement AddMoreanswers;
	 @FindBy(xpath=  "(//i[@class='material-icons delete-answer clickable'])[2]") 
	 WebElement DeleteOneanswer;
	 @FindBy(xpath= "//input[@name ='options.timeLimit.allow']" ) 
	 WebElement TimeLimitCheckBox;  // value = false 
	 @FindBy(xpath=  "//input[@name ='options.timeLimit.minutes']" ) 
	 WebElement TimeinMinutes;  
	 @FindBy(xpath= "//input[@name ='options.responses.show']" ) 
	 WebElement ResponsesCheckBox;  //value =true	
	 @FindBy(xpath=  "//input[@name ='options.availability.from']" ) 
	 WebElement AvailableFromEdit; 
	 @FindBy(xpath= "//input[@name ='options.availability.to']" ) 
	 WebElement AvailableUntilEdit;  
	 @FindBy(xpath=  "//span[contains(text(),'Save')]" ) 
	 WebElement SaveOptionButton; 
	 
	 
	
	
	 
	
	 
	
	
	 


		
	public void verify_admininformation() {
		Assert.assertEquals(true,Adminuser.isDisplayed());
		Assert.assertEquals(true,Adminemail.isDisplayed());
		Assert.assertEquals("Verify name displayed as 'Admin User'", "Admin User", Adminuser.getText().toString());
		Assert.assertEquals("Verify email displayed as 'Admin User'", "gitaumoses4@gmail.com", Adminemail.getText().toString());
	}
	public void verify_doorwarddashboard() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		Assert.assertEquals("Verify doorward dashboard screen'", true, Dashboard.isDisplayed());

	}
	public void edit_admininformation(String firstname, String lastname,String email, String phonenumber) {
		AdminEditInfoFirstname.sendKeys(firstname);
		AdminEditInfoLastname.sendKeys(lastname);
		AdminEditInfoEmail.sendKeys(email);
		AdminEditInfoPhonenumber.sendKeys(phonenumber);
	}
	public void edit_firstname(String firstname) {
		AdminEditInfoFirstname.clear();
		AdminEditInfoFirstname.sendKeys(firstname);
	}
	public void edit_lastname(String lastname) {
		AdminEditInfoLastname.clear();
		AdminEditInfoLastname.sendKeys(lastname);
	}
	public void edit_email(String email) {
		AdminEditInfoEmail.clear();
		AdminEditInfoEmail.sendKeys(email);
	}
	public void edit_phonenumber(String phonenumber) {
		AdminEditInfoPhonenumber.clear();
		AdminEditInfoPhonenumber.sendKeys(phonenumber);
	}
	public void click_admineditinfologo() throws InterruptedException {
		AdminEditInfologo.click();	
	}
	public void click_adminEditInfoButton() throws InterruptedException {
		AdminEditInfoButton.click();
	}
	public void click_adminlogodropdown() {
		Adminlogodropdown.click();
	}
	public void click_savebutton() {
		AdminEditInfoSaveButton.click();
	}
	public void click_changepasswordbutton() {
		ChangePasswordButton.click();
	}
	public void enter_currentpassword(String currentPassword) {
		CurrentPassword.clear();
		CurrentPassword.sendKeys(currentPassword);
	}
	public void enter_newpassword(String newPassword) {
		NewPassword.clear();
		NewPassword.sendKeys(newPassword);
	}
	public void enter_confirmpassword(String newPassword) {
		ReEnterNewPassword.clear();
		ReEnterNewPassword.sendKeys(newPassword);
	}
	public void click_savepasswordbutton() throws InterruptedException {
		SavePasswordButton.click();
		Thread.sleep(1250);
	}
	
	// Program session
	public void click_programlistarrow() throws InterruptedException {
		ProgramsArrow.click();
		
	}
	public void click_allprograms() throws InterruptedException {
		Thread.sleep(1000);
		try {
			AllPrograms.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", AllPrograms);
		  }
	}
	public void get_allprogramNames() throws InterruptedException {
		Thread.sleep(1500);
		HashMap programData = new HashMap();
		int iCounter=0;
		for(WebElement items : ProgramNamesList) {
			iCounter=iCounter+1;
			String xpath="//div[@aria-rowindex="+iCounter+"]/div[@aria-colindex='1']/div[@class='course-title']/span";
		    System.out.println(driver.findElement(By.xpath(xpath)).getText());
		    programData.put(iCounter, driver.findElement(By.xpath(xpath)).getText());
		    
		}
		commondataModel.getInstance().add("ProgramsNameListDetails", programData);
		
	}
	public boolean verify_programlist() {
		return ProgramTable.isDisplayed();
		
	}
	public void click_newlycreatedprogram(String Programname) {
	String xpath="//*[contains(text(),'"+Programname+"')]";
	driver.findElement(By.xpath(xpath)).click();
	}
	
	public void click_deleteprogram(String pname) throws InterruptedException {
		Thread.sleep(1000);
		DeleteProgramVerticalButton.click();
		Thread.sleep(1500);
		/*try {
			Actions actions = new Actions(driver);
			actions.moveToElement(DeleteProgramButton);
			actions.click().build().perform();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", DeleteProgramButton);
		  } */
		//DeleteProgramButton.click();
		   Actions act = new Actions(driver); 
		   act.sendKeys(Keys.TAB).build().perform();
		   act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1500);
		DeleteProgramNameEntry.sendKeys(pname);
		Thread.sleep(500);
		DeleteProgramEntryYesButton.click();
		}
	
	public void verify_createdprogram(String argProgName) {
		String xpath="//span[contains(text(),'"+argProgName+"')]";
		Assert.assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
	}
	
	public void verify_createdprogramNotExists(String argProgName) throws InterruptedException {
		//Find newly created program exists from list of data map
		Assert.assertEquals(false, CommonDataModel.getInstance().provide("ProgramsNameListDetails").containsValue(argProgName));
	}

	public void verify_errormessage(String errmsg) throws InterruptedException {
		Thread.sleep(1500);
		String xpath="//div[contains(@class,'required')]//div[@class='eb-input__error-message']";
		Assert.assertEquals(errmsg, driver.findElement(By.xpath(xpath)).getText());
	}
	
	//Program Information session
	public void click_createnewprogrambutton() {
		CreateaNewProgramButton.click();
	}
	public void set_programname(String name)  {
		ProgramName.clear();
		ProgramName.sendKeys(name);
	}
	public void set_numberofmodules(String modulenumber)  {
		NumberOfModules.clear();
		NumberOfModules.sendKeys(Keys.BACK_SPACE);
		NumberOfModules.sendKeys(modulenumber);
		NumberOfModules.sendKeys(Keys.TAB);
	}
	public void set_modulename(String modulename)  {
		FirstModuleName.clear();
		FirstModuleName.sendKeys(modulename);
	}
	public void set_modulenames(String modulename)  {
		String[] mnames=modulename.split(":");
		int iterIndx=0;
		for(String item:mnames) {
			String xpth="//input[@name='modules."+iterIndx+".title']";
			driver.findElement(By.xpath(xpth)).clear();
			driver.findElement(By.xpath(xpth)).sendKeys(item);
			driver.findElement(By.xpath(xpth)).sendKeys(Keys.TAB);;
			iterIndx++;
		}
	}
	public void click_saveprograminformationbutton(){
		SaveProgramInformationButton.click();
	}
	
	//Modules session
	public void get_allprogramdetails() {
		String numberofModules=NumberofModules.getText().replace("modules", "").replace("module", "").trim();
		String numberofAssignments=NumberofAssignments.getText().replace("assignments", "").trim();
		String numberofQuizzes=NumberofQuizzes.getText().replace("quizzes", "").trim();
		String numberofExams=NumberofExams.getText().replace("exams", "").trim();
		String numberofPages=NumberofPages.getText().replace("pages", "").trim();
		HashMap programData = new HashMap();
		programData.put("numberofModules", numberofModules);
		programData.put("numberofAssignments", numberofAssignments);
		programData.put("numberofQuizzes", numberofQuizzes);
		programData.put("numberofExams", numberofExams);
		programData.put("numberofPages", numberofPages);
		System.out.println("Program Specefic Details : "+programData);
		commondataModel.getInstance().add("ProgramSpecificDetails", programData);
	}
	public void verify_numberofmodules(String mnumber) {
		Assert.assertEquals(mnumber,CommonDataModel.getInstance().provide("ProgramSpecificDetails").get("numberofModules").toString());
	}
	public void delete_allmodules(String mnum) throws InterruptedException {
		int indx=2;
		int modCount=Integer.parseInt(mnum);
		for (int i=0;i<modCount;i++) {
			String xpth="(//i[contains(text(),'delete')])["+indx+"]";
			Thread.sleep(500);
			driver.findElement(By.xpath(xpth)).click();
			Thread.sleep(500);
			DeleteModuleYesbutton.click();
		}
		
	}
	public void delete_allmodules() throws InterruptedException {
		int iCounter=0;
		for(WebElement items : DeleteAllModule) {
			iCounter=iCounter+1;
			String xpath="(//i[contains(text(),'delete')])["+iCounter+"]";		    
		    try {
		        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		        System.out.println("Element is clickable");
		        driver.findElement(By.xpath(xpath)).click();
		        DeleteModuleYesbutton.click();
		      }
		 catch(TimeoutException e) {
		        System.out.println("Element isn't clickable");
		     }
		}
		
	}
	
	// EXAM session
	public void click_exam() {
		PlusButton.click();
		ExamLabel.click();
	}
	public void click_onquestionstab() {
		QuestionTab.click();
	}
	public void enter_examtitle(String argexamTitle) {
		ExamTitle.sendKeys(Keys.BACK_SPACE);
		ExamTitle.clear();
		ExamTitle.sendKeys(argexamTitle);
		ExamTitle.sendKeys(Keys.TAB);
	}
	public void clear_examtitle() {
		ExamTitle.clear();
		ExamTitle.sendKeys(Keys.CONTROL, "a");
		ExamTitle.sendKeys(Keys.BACK_SPACE);
		ExamTitle.sendKeys(Keys.TAB);
	}
	public void clear_examinstructions() {
		 Actions act = new Actions(driver); 
		 	ExamTitle.clear();
		 	ExamTitle.click();
			ExamTitle.sendKeys(Keys.CONTROL, "a");
			ExamTitle.sendKeys(Keys.BACK_SPACE);
			ExamTitle.sendKeys(Keys.TAB);
		  // Select the Current Address using CTRL + A
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");
        act.keyUp(Keys.CONTROL);
        act.sendKeys(Keys.BACK_SPACE);
        act.sendKeys(Keys.TAB);
        act.build().perform();

	}
	
	
	public void verify_examtitleerrormessage(String message) {
		Assert.assertEquals(message,ExamTitleErrorMessage.getText().toString());
	}
	public void verify_examinstructionseerrormessage(String message) {
		Assert.assertEquals(message,ExamInstructionsErrorMessage.getText().toString());
	}
	
	public void click_onaddsection() {
		AddSectionButton.click();
	}
	public void enter_sectioninstructions(String argSectionInstructions) {
		
		
		AddSectionInstructions.click();
		
		List<WebElement> warningPopUp=driver.findElements(By.xpath("*//div[@aria-label='Close']"));
		
		for (int i=0;i <warningPopUp.size();i++) {
			driver.switchTo().alert().dismiss();
		}
		
		 Actions act = new Actions(driver); 
		 act.sendKeys(Keys.CLEAR).build().perform();
		 act.sendKeys(Keys.BACK_SPACE).build().perform();
		 String[] instructions = argSectionInstructions.split(",");
		 int instrCount=0;
		 for (String str : instructions) {
			 instrCount++;
			 String instr=String.valueOf(instrCount);
			 act.sendKeys(instr).build().perform();
			 act.sendKeys(Keys.ARROW_RIGHT).build().perform();
			 act.sendKeys(Keys.ENTER).build().perform();
			 act.sendKeys(str).build().perform();
			 act.sendKeys(Keys.ENTER).build().perform();
			}
		 
		 act.sendKeys(Keys.TAB).build().perform();
	}
	

	public void verify_compulsorycheckboxenabled() {			
	Assert.assertEquals("true", QuestionsCompulsoryCheckBox.getAttribute("value").toString()); 
	}
	
	public void enable_compulsorycheckboxenabled() {	
		try {
			if(QuestionsCompulsoryCheckBox.getAttribute("value").toString().equals("false")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", SectionInstructionCheckBox);
		}
	  } catch (Exception e) {
	    	  } 

	}
	
	public void click_onaddquestion() {
		AddQuestion.click();
	}
	
	public void enter_pointsforquestion(String argMarks) {
		PointsforQuestion.clear();
		PointsforQuestion.sendKeys(Keys.BACK_SPACE);
		PointsforQuestion.sendKeys(argMarks);
	}
	
	public void verify_select_type(String argSelectValue) {
		if(!QuestionTypeDropdownVerifyText.getText().toString().equalsIgnoreCase(argSelectValue)) {
			Select type = new Select(QuestionTypeDropdown);
			type.selectByVisibleText(argSelectValue);
		}
		Assert.assertEquals(argSelectValue, QuestionTypeDropdownVerifyText.getText().toString());
	}
	
	public void click_addanswerstoquestionbutton(){
		AddanswersToQuestionButton.click();
	}
	
	public void click_addmoreanswers() {
		AddMoreanswers.click();
	}
	
	public void click_deleteoneanswerchoice() {
		DeleteOneanswer.click();
	}
	public void write_allanswerchoices(Actions act, String argXpath, String argAnswer) throws InterruptedException {
		driver.findElement(By.xpath(argXpath)).click();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		act.sendKeys(argAnswer).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(750);
	}
	
	public void write_allanswermarks(Actions act, String argXpath, String argMarks) throws InterruptedException {
		driver.findElement(By.xpath(argXpath)).click();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		act.sendKeys(argMarks).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(750);
	}
	
	
	public void fill_allMCQQuestionDetails(Actions act,String argMarks,String questionType, String argQuestion) throws InterruptedException {
		AddQuestion.click(); // click on add question
		PointsforQuestion.clear();
		PointsforQuestion.sendKeys(Keys.BACK_SPACE);
		PointsforQuestion.sendKeys(argMarks);
		if(!QuestionTypeDropdownVerifyText.getText().toString().equalsIgnoreCase(questionType)) {
			Select type = new Select(QuestionTypeDropdown);
			type.selectByVisibleText(questionType);
		}
		Assert.assertEquals(questionType, QuestionTypeDropdownVerifyText.getText().toString());
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(argQuestion).build().perform();
		Thread.sleep(750);
	}
	
	
	public void fill_allTextInputnMCAMQuestionDetails(Actions act,String argMarks,String questionType, String argQuestion) throws InterruptedException {
		AddQuestion.click(); // click on add question
		
		if(!QuestionTypeDropdownVerifyText.getText().toString().equalsIgnoreCase(questionType)) { // assuming 'Multiple choice' is default
			Thread.sleep(750);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
		   if(questionType.equalsIgnoreCase("text input")) {
			    PointsforQuestion.clear();
				PointsforQuestion.sendKeys(Keys.BACK_SPACE);
				PointsforQuestion.sendKeys(argMarks);
				PointsforQuestion.sendKeys(Keys.TAB);
				executor.executeScript("arguments[0].click();", QuestionTypeDropdownIcon);
				executor.executeScript("arguments[0].click();", QuestionTypeTextInputLabel);
		   }
		   else  { // MCQAM
			   PointsforQuestion.sendKeys(Keys.TAB);
			   
			   executor.executeScript("arguments[0].click();", QuestionTypeDropdownIcon);
			   executor.executeScript("arguments[0].click();", QuestionTypeMCWithAns);
		   }
		    
		    
			
		}

		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(argQuestion).build().perform();
		Thread.sleep(750);
	}
	public void click_onoptionstab(){
		OptionsTab.click();
	}
	
	public void click_ontimelimit(){
		TimeLimitCheckBox.click();
	}
	
	public void enter_timeinminutes(String argMinutes){
		TimeinMinutes.sendKeys(argMinutes);
	}
	
	public void click_onlearnersresponses(){
		ResponsesCheckBox.click();
	}
	
	public void verify_learnersresponsesisenabled(){
		Assert.assertEquals("true",ResponsesCheckBox.getAttribute("value").toString());
	}
	
	public void verify_timelimitisenabled(){
		Assert.assertEquals("true",TimeLimitCheckBox.getAttribute("value").toString());
	}
	
	public void verify_timelimitisdisabled(){
		Assert.assertEquals("false",TimeLimitCheckBox.getAttribute("value").toString());
	}
	
	public String  get_availablefromvalue(){
		return AvailableFromEdit.getAttribute("value").toString();
	}
	
	public void set_availablefrom(String argDate){
		 AvailableFromEdit.sendKeys(argDate);
	}
	
	public String  get_availabeuntilvalue(){
		return AvailableUntilEdit.getAttribute("value").toString();
	}
	
	public void set_availabeuntilvalue(String argDate){
		 AvailableUntilEdit.sendKeys(argDate);
		 AvailableUntilEdit.sendKeys(Keys.ENTER);
		 AvailableUntilEdit.sendKeys(Keys.TAB);
	}
	
	public void click_onsaveoptions() {
		SaveOptionButton.click();
	}
	
	public void click_onsavequestions() {
		SaveOptionButton.click();
	}
}


