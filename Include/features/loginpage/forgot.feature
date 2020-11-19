@IntegrationTest @Forgot
Feature: Forgot Functionality
Description: This feature is to verify the system integrity when a user forgot their credentials such as password or security code.
	
  @SmokeTest @ForgotPassword @ErrorHandling
  Scenario: User accidentally pressed the forgot password button and want to go back proceed login
    Given User fill in the security box
    When User click on Forgot Password button in security code input page
    And Click on Back button
    Then User can re-enter the security code to proceed to home page
    
  @SmokeTest @ForgotSecurityCode @Reset
  Scenario: User forgot security code
    Given User click on Forgot Security Code button
    When User enter valid credentials for log in
    Then User is asked to create new security code
    And User can proceed to the home page
    
    
  @SmokeTest @ForgotPassword @Reset
  Scenario: User forgot password and want to change via security code page
    Given User click on Forgot Password button in security code input page
    When  User re-enter new password and confirm new password in a form
    Then User get a notice to verify the password changes in their email
    
    