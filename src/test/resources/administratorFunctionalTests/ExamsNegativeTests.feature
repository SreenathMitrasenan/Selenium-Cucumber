Feature: ExamsNegativeScenarios

@regressiontest
Scenario Outline: TC001Exams-As a user I am going to login Doorward using admin credentials and create an exam without giving exam title
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on programs section
    Then I click on allprograms section
    Then I click on create new program and sets programname'<pname>'numberofmodules'<mnum>'and module names'<mname>'
    Then I click on save program information button
    Then I verify the newly created program in the dashboard'<pname>'
    Then I click on newly created program'<pname>'
    Then I verify the number of modules added to the program'<mnum>'
    Then I click on exam session with exam title'<examtitle>'and section instructions'<secinstruction>'
    Then I remove exam title and verify error message'<msg>'
    #Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    #Then I add multiple choice questions from file'<filename>'having four answer options
    #Then I click on options tab and enter time in minutes'<min>'
    #Then I am making response option as all learners should see the responses
    #Then I enter exam availability date based on number of days from exam creation date'<scdays>'
    #And I click on save options button
    #Then I teardown the browser
Examples:
|username		|password |pname			|mnum	|mname		|examtitle			|secinstruction											|msg					|
|administrator 	|password |ExamtNTest-001	|	1	|GKExam001	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|The title is required	|





@regressiontest
Scenario Outline: TC002Exams-As a user I am going to login Doorward using admin credentials and create an exam without adding Section instructions
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on programs section
    Then I click on allprograms section
    Then I click on create new program and sets programname'<pname>'numberofmodules'<mnum>'and module names'<mname>'
    Then I click on save program information button
    Then I verify the newly created program in the dashboard'<pname>'
    Then I click on newly created program'<pname>'
    Then I verify the number of modules added to the program'<mnum>'
    Then I click on exam session with exam title'<examtitle>'and section instructions'<secinstruction>'
    Then I remove exam section instructions and verify error message'<msg>'
    Then I teardown the browser
Examples:
|username		|password |pname			|mnum	|mname		|examtitle			|secinstruction											|msg					|
|administrator 	|password |ExamtNTest-002	|	1	|GKExam001	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|The instructions are required.	|



@regressiontest
Scenario Outline: TC_Cleanup_Programs-As a user I am going to login Doorward using admin credentials, delete all programs created for exams
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on programs section
    Then I click on allprograms section
    Then I click on newly created program'<pname>'
    Then I delete the newly created program'<pname>'
    Then I click on allprograms section
    Then I get the list of programs 
    Then I verify the newly created program'<pname>'is deleted
    Then I teardown the browser

Examples:
|username				|password |pname			|
|administrator 			|password |ExamtNTest-001	|
|administrator 			|password |ExamtNTest-002	|

