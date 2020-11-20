@FunctionalTest @Login
Feature: Login Feature
Description: This feature is used to verify the login functionality
  
  @SmokeTest @InterfaceTest @FailedTest
  Scenario: Mengecek apakah semua elemen untuk login telah termuat dengan lengkap ketika aplikasi dibuka
    Given User membuka aplikasi SFT dari perangkat
    When Splashscreen berhasil tertutup
    Then User dapat melihat elemen-elemen login seperti text box email dan password serta tombol secara lengkap
	
	@SmokeTest @UnitTest
  Scenario: Mengecek apakah ketika field email diisi user dapat melanjutkan ke kolom password dengan menekan enter
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom Email kemudian menekan Enter
    Then Kursor akan lanjut ke kolom password

  @SmokeTest @Valid @Passed
  Scenario Outline: Mengecek bagaimana sistem merespon ketika user memberikan kredensial yang valid
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom Email dengan <Email> dan Password
    Then User dapat lanjut ke halaman pembuatan security code atau home
    
    @RelationManager
    Examples:
    | Email                   |
    |   rmFunding@mail.com    |
    
    @BusinessManager
    Examples:
    | Email |
    | sbmFunding@mail.com |

  @SmokeTest @Invalid
  Scenario: Mengecek bagaimana sistem merespon ketika field email serta password diisi dengan tidak valid
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom Email dan Password dengan salah
    Then User tidak dapat lanjut ke halaman pembuatan security code
    And User akan mendapatkan pesan error

	@SmokeTest @Invalid @FailedTest
  Scenario Outline: Memeriksa bagaimana sistem merespon ketika user menginput email dengan format yang salah
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom <Email> dengan format yang salah
    Then User akan mendapatkan pesan error

    Examples: 
      | Email          |
      | rmAT&mail.com  |
      | rmAT3.mail.com |
      | rmAT3@mail@com |
      | rmAT3mail.com  |

	@SmokeTest @Invalid
  Scenario Outline: Memeriksa bagaimana sistem merespon setelah terjadi kesalahan login secara berulang-ulang pada email yang benar namun password yang salah
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom <Email> dengan benar dan kolom <Password> dengan salah
    Then User akan mendapatkan pesan error

    Examples: 
      | Email         | Password  |
      | dsheadAT1@mail.com | 123456789 |
      | dsheadAT1@mail.com | 012345678 |
      | dsheadAT1@mail.com |   1234567 |
