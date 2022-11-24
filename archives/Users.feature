@regressionTest
Feature: Users
@regressionTest
Scenario Outline: As a user I am going to login Doorward using admin credentials and edit information in my account first name and last name
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on administrator logo dropdown
    Then I click on edit user profile information
    Then I edit firstname'<firstname>'
    Then I edit lastname'<lastname>'
    Then I click on save information button
    Then I teardown the browser
Examples:
|username				|password|firstname	|lastname	|
|administrator 			|password|admin		|User		|

@regressionTest
Scenario Outline: As a user I am going to login Doorward using admin credentials and edit information in my account email
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on administrator logo dropdown
     Then I click on edit user profile information
    Then I edit email'<email>'
    Then I click on save information button
    Then I teardown the browser
Examples:
|username				|password|email							|
|administrator 			|password|seerpimadhusudhan@gmail.com	|

@regressionTest
Scenario Outline: As a user I am going to login Doorward using admin credentials and edit information in my account phonenumber
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on administrator logo dropdown
     Then I click on edit user profile information
    Then I edit phone number'<phonenumber>'
    Then I click on save information button
    Then I teardown the browser
Examples:
|username				|password|phonenumber		|
|administrator 			|password|0987654321		|


@regressionTest
Scenario Outline: As a user I am going to login Doorward using admin credentials, update password and verify the same by relogin
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on administrator logo dropdown
    Then I click on edit user profile information
    Then I click on change password button in user profile session and updates currentpassword'<currentpwd>'newpassword'<newpwd>'and confirmpassword'<cpass>'
    Then I click on save password button
    Then I teardown the browser
    Given User is on doorward home page
    Then I enter username'<nuname>' and password'<npassword>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
Examples:
|username				|password|phonenumber		|currentpwd	|newpwd		|cpass		|nuname			|npassword|
|administrator 			|password|0987654321		|password	|password1	|password1	|administrator	|password1|


@regressionTest
Scenario Outline: As a user I am going to login Doorward using admin credentials, update password as before TC012 and verify(revert password changes)
    Given User is on doorward home page
    Then I enter username'<username>' and password'<password>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
    Then I click on administrator logo dropdown
    Then I click on edit user profile information
    Then I click on change password button in user profile session and updates currentpassword'<currentpwd>'newpassword'<newpwd>'and confirmpassword'<cpass>'
    Then I click on save password button
    Then I teardown the browser
    Given User is on doorward home page
    Then I enter username'<nuname>' and password'<npassword>'
    And I click on login button
    Then I verify the doorward dashboard after successfull login
Examples:
|username				|password |phonenumber		|currentpwd	|newpwd		|cpass		|nuname			|npassword|
|administrator 			|password1|0987654321		|password1	|password	|password	|administrator	|password |

#@TC014
#Scenario Outline: As a user I am going to login Doorward using admin credentials, update password with special characters and verify errors
#    Given User is on doorward home page
#    Then I enter username'<username>' and password'<password>'
#    And I click on login button
#    Then I verify the doorward dashboard after successfull login
#    Then I click on administrator logo dropdown
#    Then I click on edit user profile information
#    Then I click on change password button in user profile session and updates currentpassword'<currentpwd>'newpassword'<newpwd>'and confirmpassword'<cpass>'
#    Then I click on save password button
#    Then I teardown the browser
#    Given User is on doorward home page
#    Then I enter username'<nuname>' and password'<npassword>'
#    And I click on login button
#    Then I verify the doorward dashboard after successfull login
#    Then I teardown the browser
#
#Examples:
#|username				|password |phonenumber		|currentpwd	|newpwd		|cpass		|nuname			|npassword|
#|administrator 			|password |0987654321		|password	|!@#$%^&*	|!@#$%^&*	|administrator	|!@#$%^&* |

#@TC015
#Scenario Outline: As a user I am going to login Doorward using admin credentials, update password as before TC014 
#    Given User is on doorward home page
#    Then I enter username'<username>' and password'<password>'
#    And I click on login button
#    Then I verify the doorward dashboard after successfull login
#    Then I click on administrator logo dropdown
#    Then I click on edit user profile information
#    Then I click on change password button in user profile session and updates currentpassword'<currentpwd>'newpassword'<newpwd>'and confirmpassword'<cpass>'
#    Then I click on save password button
#    Then I teardown the browser
#    Given User is on doorward home page
#    Then I enter username'<nuname>' and password'<npassword>'
#    And I click on login button
#    Then I verify the doorward dashboard after successfull login
#    Then I teardown the browser
#Examples:
#|username				|password |phonenumber		|currentpwd	|newpwd		|cpass		|nuname			|npassword|
#|administrator 			|!@#$%^&* |0987654321		|!@#$%^&*	|password	|password	|administrator	|password |
