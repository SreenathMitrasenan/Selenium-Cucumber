Feature: User Authentication
@regressiontest
Scenario Outline: TC030_As a user I am going to login Doorward application with user credentials after creating user in doorward
    Given User is on doorward home page
    Then I click on create new account with fullname'<fullname>'username'<username>'email'<email>'and password'<passowrd>'
    #Then I teardown the browser
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I teardown the browser
Examples:
|fullname			|username		|email						|password|
|Learner			|learner04      |seerpimadhusudhan@gmail.com|password|



