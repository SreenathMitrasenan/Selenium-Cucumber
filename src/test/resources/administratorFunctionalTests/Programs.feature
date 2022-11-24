Feature: Programs

@regressiontest
Scenario Outline: TC016-As a user I am going to login Doorward using admin credentials, create new program and verify the same
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on programs section
    Then I click on allprograms section
    Then I click on create new program and sets programname'<pname>'numberofmodules'<mnum>'and module name'<mname>'
    Then I click on save program information button
    Then I verify the newly created program in the dashboard'<pname>'
    Then I teardown the browser

Examples:
|username				|password |pname			|mnum		|mname			|
|administrator 			|password |ProgramTest001	|	1		|linux001		|

@regressiontest
Scenario Outline: TC017-As a user I am going to login Doorward using admin credentials, create a program already exists and verify the error messages
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on programs section
    Then I click on allprograms section
    Then I click on create new program and sets programname'<pname>'numberofmodules'<mnum>'and module name'<mname>'
    Then I click on save program information button
    Then I verify the error message'<errmsg>'
    Then I teardown the browser

Examples:
|username				|password |pname			|mnum		|mname		|errmsg|
|administrator 			|password |ProgramTest001	|	1		|linux		|A program with this title already exists.|

@regressiontest
Scenario Outline: TC018-As a user I am going to login Doorward using admin credentials, delete a program verify the same
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on programs section
    Then I click on allprograms section
    Then I click on create new program and sets programname'<pname>'numberofmodules'<mnum>'and module name'<mname>'
    Then I click on save program information button
    Then I verify the newly created program in the dashboard'<pname>'
    Then I click on newly created program'<pname>'
    Then I delete the newly created program'<pname>'
    Then I click on allprograms section
    Then I get the list of programs 
    Then I verify the newly created program'<pname>'is deleted
    Then I teardown the browser

Examples:
|username				|password |pname			|mnum		|mname		|
|administrator 			|password |ProgramTest002	|	1		|linux		|

@regressiontest
Scenario Outline: TC019-As a user I am going to login Doorward using admin credentials and get all list of programs
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on programs section
    Then I click on allprograms section
    Then I verify programs table list
    Then I get the list of programs 
    Then I teardown the browser
Examples:
|username				|password|
|administrator 			|password|

@regressiontest
Scenario Outline: TC_Cleanup_Programs-As a user I am going to login Doorward using admin credentials, delete a program verify the same~clean up script
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
|username				|password |pname			|mnum		|mname		|
|administrator 			|password |ProgramTest001	|	1		|linux001	|


