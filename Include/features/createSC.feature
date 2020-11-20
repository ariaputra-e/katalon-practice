@SecurityCode @SignIn
Feature: Security Code Feature
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
    
  @SmokeTest @Valid 
  Scenario: Mengecek apakah ketika user memberi input pada kolom pertama maka kursor akan fokus ke kolom selanjutnya pada halaman input security code
    Given User telah berhasil melewati halaman log in
    When User mengisi salah satu digit pada Security Code
    Then Kursor pindah ke digit kosong selanjutnya

	@SmokeTest @Valid 
  Scenario: Memeriksa apakah user dapat menginput security code tanpa harus memulai inputan dari text box pertama
    Given User telah berhasil melewati halaman log in
    When User menekan text box ke tiga di halaman security code
    Then Kursor akan kembali ke text box pertama
	
	@SmokeTest @Valid @FailedTest
  Scenario Outline: Mengecek apakah pesan error akan muncul ketika digit security code tidak di input sesuai kriteria
    Given User telah berhasil melewati halaman log in
    When User mengisi <Security Code> pada kolom digit Security Code
    Then User tidak dapat lanjut ke halaman selanjutnya
    And User diberikan pemberitahuan error

    Examples: 
      | Security Code |
      |   200CC       |
      |   22001       |
	
	@SmokeTest @Valid
  Scenario Outline: Memeriksa apakah user dapat masuk ketika memasukkan security code yang telah sesuai dengan kriteria
    Given User telah berhasil melewati halaman log in
    When User mengisi <Security Code> pada kolom digit Security Code
    Then User dapat lanjut ke halaman konfirmasi Security Code

    Examples: 
      | Security Code |
      |        220011 |
      |        110044 |
      
	@SmokeTest @Valid
  Scenario Outline: Memeriksa apakah user dapat lanjut ketika mengkonfirmasi security code dengan tidak benar
    Given User telah berhasil melewati halaman log in dan mengisi <Security Code> sebagai Security Code
    When User mengisi <Confirmation Security Code> pada halaman konfirmasi Security Code
    Then User tidak dapat lanjut ke halaman home

    Examples: 
      | Security Code | Confirmation Security Code |
      |        220011 |                     221011 |
      |        110044 |                     112044 |

  @SmokeTest @Valid @Passed
  Scenario Outline: Mengecek apakah user dapat masuk ketika menginput security code yang sesuai ketika konfirmasi
    Given User telah berhasil melewati halaman log in dan mengisi <Security Code> sebagai Security Code
    When User mengisi <Confirmation Security Code> pada halaman konfirmasi Security Code
    Then User dapat lanjut ke halaman home aplikasi

    Examples: 
      | Security Code | Confirmation Security Code |
      |        220011 |                     220011 |