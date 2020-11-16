@FunctionalTest @GetStarted
Feature: Sign In
Description: This feature is used to verify that user can either sign up or change their password using Get Started button

	Background: User berada pada halaman Get Started
		Given User membuka aplikasi SFT dari perangkat
		When User menekan tombol Get Started
		Then User akan masuk ke halaman form untuk sign up
	
	@SmokeTest @UnitTest
  Scenario: Checks whether the user can focus on the next column when pressing enter after completing one of the text boxes
  	Given User mengisi salah satu kolom yaitu Email
  	When User menekan enter
  	Then Kursor akan fokus ke kolom selanjutnya
  	
  @SmokeTest @ErrorHandling
  Scenario Outline: Checking the system response when the form is filled with invalid format
  	Given User mengisi kolom email dengan <Email>
  	And Kolom sales code dengan <Sales Code>
  	And Kolom NIP dengan <NIP> 
  	And Serta kolom Password <Password> dan konfirmasi password <CF Password> 
  	When User menekan tombol Submit
  	Then User akan mendapatkan pesan error pada menu Sign Up
  	
  	Examples:
  	  | Email            | Sales Code     | NIP           | Password       | CF Password    |
      |   test.mail.com  | SC000rmAT3     |  CN000rmAT3   |  !234567890A   |  !234567890A   |
      |   test@mail.com  | SC000rmAt44    |  CN000rmAT3   |  !234567890A   |  !234567890A   |
      |   test@mail.com  | SC000rmAT3     |  CN00mAT3     |  !234567890A   |  !234567890A   |
      |   test@mail.com  | SC000rmAT3     |  CN000rmAT3   |  !2345678      |  !2345678      |
      |   test@mail.com  | SC000rmAT3     |  CN000rmAT3   |  !234567890A   |  !234567890B   |  	
  	
  	
  	