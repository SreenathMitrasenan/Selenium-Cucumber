Feature: Exams

@regressiontest
Scenario Outline: TC001Exams-As a user I am going to login Doorward using admin credentials and create an exam with multiple choice question with four anwser as default
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
    Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    Then I add multiple choice questions from file'<filename>'having four answer options
    Then I click on options tab and enter time in minutes'<min>'
    Then I am making response option as all learners should see the responses
    Then I enter exam availability date based on number of days from exam creation date'<scdays>'
    And I click on save options button
    Then I teardown the browser
Examples:
|username		|password |pname			|mnum	|mname		|examtitle			|secinstruction											|filename		    |min|scdays |
|administrator 	|password |ExamtMCQ-001		|	1	|GKExam001	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|MCQDefault.json   	|30 |5		|


@regressiontest
Scenario Outline: TC002Exams-As a user I am going to login Doorward using admin credentials and create an exam with multiple choice question with six answer options
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
    Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    Then I add multiple choice questions from file'<filename>'having six answer options
    Then I click on options tab and enter time in minutes'<min>'
    Then I am making response option as all learners should see the responses
    Then I enter exam availability date based on number of days from exam creation date'<scdays>'
    And I click on save options button
    Then I teardown the browser
Examples:
|username		|password |pname		|mnum	|mname		|examtitle			|secinstruction											|filename					|min|scdays |
|administrator 	|password |ExamtMCQ-002	|	1	|GKExam002	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|MCQAns6Question2.json	    |30 |5		|


@regressiontest
Scenario Outline: TC003Exams-As a user I am going to login Doorward using admin credentials and create an exam with multiple choice question with three answer options
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
    Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    Then I add multiple choice questions from file'<filename>'having three answer options
    Then I click on options tab and enter time in minutes'<min>'
    Then I am making response option as all learners should see the responses
    Then I enter exam availability date based on number of days from exam creation date'<scdays>'
    And I click on save options button
    Then I teardown the browser
Examples:
|username		|password |pname		|mnum	|mname		|examtitle			|secinstruction											|filename					|min|scdays |
|administrator 	|password |ExamtMCQ-003	|	1	|GKExam003	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|MCQAns3Question2.json	    |30 |5		|



@regressiontest
Scenario Outline: TC004Exams-As a user I am going to login Doorward using admin credentials and create an exam with text input question and verify
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
    Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    Then I add text input questions from file'<filename>'having descriptive questions
    Then I click on options tab and enter time in minutes'<min>'
    Then I am making response option as all learners should see the responses
    Then I enter exam availability date based on number of days from exam creation date'<scdays>'
   	And I click on save options button
    Then I teardown the browser
Examples:
|username		|password |pname		|mnum	|mname		|examtitle			|secinstruction											|filename					|min|scdays |
|administrator 	|password |ExamtTI-001	|	1	|GKExam003	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|TextInputDefault.json	    |30 |5		|



@regressiontest
Scenario Outline: TC005Exams-As a user I am going to login Doorward using admin credentials and create an exam type as multiple choice with answer marks with four answer options
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
    Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    Then I add multiple choice with answer marks questions from file'<filename>'having four answer options
    Then I click on options tab and enter time in minutes'<min>'
    Then I am making response option as all learners should see the responses
    Then I enter exam availability date based on number of days from exam creation date'<scdays>'
   	And I click on save options button
    Then I teardown the browser
Examples:
|username		|password |pname			|mnum	|mname		|examtitle			|secinstruction											|filename					|min|scdays |
|administrator 	|password |ExamtMCQAM-001	|	1	|GKExam003	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|MCQAMDefault.json		    |30 |5		|



@regressiontest
Scenario Outline: TC006Exams-As a user I am going to login Doorward using admin credentials and create an exam type as multiple choice with answer marks with six answer option
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
    Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    Then I add multiple choice with answer marks questions from file'<filename>'having six answer options
    Then I click on options tab and enter time in minutes'<min>'
    Then I am making response option as all learners should see the responses
    Then I enter exam availability date based on number of days from exam creation date'<scdays>'
   	And I click on save options button
    Then I teardown the browser
Examples:
|username		|password |pname			|mnum	|mname		|examtitle			|secinstruction											|filename					|min|scdays |
|administrator 	|password |ExamtMCQAM-002	|	1	|GKExam003	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|MCQAMAnswer6Question3.json	|30 |5		|



@regressiontest
Scenario Outline: TC007Exams-As a user I am going to login Doorward using admin credentials and create an exam type as multiple choice with answer marks with six answer option
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
    Then I verify check box which mentions All questions are compulsory is checked true or enable otherwise
    Then I add multiple choice with answer marks questions from file'<filename>'having three answer options
    Then I click on options tab and enter time in minutes'<min>'
    Then I am making response option as all learners should see the responses
    Then I enter exam availability date based on number of days from exam creation date'<scdays>'
   	And I click on save options button
    Then I teardown the browser
Examples:
|username		|password |pname			|mnum	|mname		|examtitle			|secinstruction											|filename					|min|scdays |
|administrator 	|password |ExamtMCQAM-003	|	1	|GKExam003	|General Knowledge	|All answers are mandatory,Allowed time is 30 minutes	|MCQAMAnswer3Question3.json	|30 |5		|



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
|administrator 			|password |ExamtMCQ-001		|
|administrator 			|password |ExamtMCQ-002		|
|administrator 			|password |ExamtMCQ-003		|
|administrator 			|password |ExamtTI-001		|
|administrator 			|password |ExamtMCQAM-001	|
|administrator 			|password |ExamtMCQAM-002	|
|administrator 			|password |ExamtMCQAM-003	|
