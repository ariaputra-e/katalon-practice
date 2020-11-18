Feature: Check
Description: This feature is used to test a single or two scenarios

	Scenario: Memastikkan bahwa user dapat kembali ke halaman sebelumnya setelah masuk ke halaman Get Started
		Given User menekan tombol Get Started
		When User masuk ke halaman form untuk sign up.
		And User menekan ikon kembali
		Then User berada di halaman log in
  	
  	
  	