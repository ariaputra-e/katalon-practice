@IntegrationTest @Forgot
Feature: Forgot Functionality
Description: This feature is to verify the system integrity when a user forgot their credentials such as password or security code.
	
  @SmokeTest @ForgotPassword
  Scenario: User accidentally pressed the forgot password button and want to go back proceed login
    Given User fill in the security box
    When User click on Forgot Password before finish
    And Click on Back button
    Then User can re-enter the security code to proceed to home page
