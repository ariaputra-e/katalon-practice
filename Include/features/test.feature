@IntegrationTest @Forgot
Feature: Forgot Functionality
Description: This feature is to verify the system integrity when a user forgot their credentials such as password or security code.
	
  @SmokeTest @ForgotPassword @Reset
  Scenario: User forgot password and want to change via security code page
    Given User click on Forgot Password button in security code input page
    When  User re-enter new password and confirm new password in a form
    Then User get a notice to verify the password changes in their email
    
    