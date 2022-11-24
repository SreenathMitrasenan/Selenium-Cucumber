Feature: Admin Authentication
@regressiontest
Scenario Outline: TC001_As a user I am going to login Doorward application as administrator with valid admin login credentials
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I teardown the browser
Examples:
|username				|password|
|administrator 			|password|

@regressiontest
Scenario Outline: TC002_As a user I am going to login Doorward application as administrator with invalid username and correct password
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the error message for incorrect user in login page'<errormsg>'
    Then I teardown the browser
Examples:
|username				|password|errormsg|
|admin					|password|User with this username does not exist.|

@regressiontest
Scenario Outline: TC003_As a user I am going to login Doorward application as administrator with valid username and invalid password
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the error message for incorrect password in login page'<errormsg>'
    Then I teardown the browser
Examples:
|username				|password|errormsg|
|administrator			|00000000|Wrong password.|

@regressiontest
Scenario Outline: TC004_As a user I am going to login Doorward application as administrator with invalid user and password
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the error message for incorrect user in login page'<errormsg>'
    Then I teardown the browser
Examples:
|username				|password		|errormsg|
|abcdefghijklmn			|abcdefghijklmn |User with this username does not exist.|

@regressiontest
Scenario Outline: TC005_As a user I am going to register Doorward application as new user
    Given User is on doorward home page
    Then I click on create new account with fullname'<fullname>'username'<username>'email'<email>'and password'<passowrd>'
    Then I verify success message
    Then I teardown the browser
Examples:
|fullname			|username		|email						|password|
|Learner			|learner04      |seerpimadhusudhan@gmail.com|password|

@regressiontest
Scenario Outline: TC006_As a user I am going to re-register Doorward application with existing user
    Given User is on doorward home page
    Then I click on create new account with fullname'<fullname>'username'<username>'email'<email>'and password'<passowrd>'
    Then I verify failure message
    Then I teardown the browser
Examples:
|fullname			|username		|email						|password|
|Learner			|learner04      |seerpimadhusudhan@gmail.com|password|

@regressiontest
Scenario Outline: TC007_As a user I am going to register Doorward application as new teacher
    Given User is on doorward home page
    Then I click on create new account with fullname'<fullname>'username'<username>'email'<email>'and password'<passowrd>'
    Then I verify success message
    Then I teardown the browser
Examples:
|fullname			|username		|email						|password|
|Teacher			|teacher02      |seerpimadhusudhan@gmail.com|password|

@regressiontest
Scenario Outline: TC008_As a user I am going to re-register Doorward application as existing teacher
    Given User is on doorward home page
    Then I click on create new account with fullname'<fullname>'username'<username>'email'<email>'and password'<passowrd>'
    Then I verify failure message
    Then I teardown the browser
Examples:
|fullname			|username		|email						|password|
|Teacher			|teacher02      |seerpimadhusudhan@gmail.com|password|
