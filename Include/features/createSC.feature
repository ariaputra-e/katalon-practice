@GenerateCode
Feature: Code Generator
Description: This feature is used generate security code for login

	@RM
  Scenario: Membuat code untuk user RM
    Given User RM mengisi kolom Email dan Password
    When  User mengisi security code dan confirmation security code
    Then User masuk ke dalam halaman home
  
  @BM
  Scenario: Membuat code untuk user BM
    Given User BM mengisi kolom Email dan Password
    When  User mengisi security code dan confirmation security code
    Then User masuk ke dalam halaman home