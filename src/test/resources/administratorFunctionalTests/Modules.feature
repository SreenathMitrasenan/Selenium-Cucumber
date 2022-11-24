Feature: Modules

@regressiontest
Scenario Outline: TC021-As a user I am going to login Doorward using admin credentials, create new program and add modules automatically
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
    Then I teardown the browser
Examples:
|username				|password |pname			|mnum		|mname				|
|administrator 			|password |Moduletest001	|	2		|linux001:linux002	|

@regressiontest
Scenario Outline: TC022-As a user I am going to login Doorward using admin credentials, create new program and add 10 modules and get 
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
    Then I teardown the browser
Examples:
|username				|password |pname			|mnum		|mname				|
|administrator 			|password |Moduletest002	|	10		|linux001:linux002:linux003:linux004:linux005:linux006:linux007:linux008:linux009:linux010	|



@regressiontest
Scenario Outline: TC023-As a user I am going to login Doorward using admin credentials, create new program and add modules automatically and delete the modules
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
    Then I delete all existing modules associated with the program'<mnum>'
    Then I teardown the browser
Examples:
|username				|password |pname			|mnum		|mname						|
|administrator 			|password |Moduletest003	|	3		|linux001:linux002:linux003	|

@regressiontest
Scenario Outline: TC_Cleanup_Modules-As a user I am going to login Doorward using admin credentials, delete the programs created by automation
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
|username				|password |pname				|
|administrator 			|password |Moduletest001		|	
|administrator 			|password |Moduletest002		|	
|administrator 			|password |Moduletest003		|

