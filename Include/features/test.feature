Feature: 
  Login Functionality

  Scenario Outline: Mengecek apakah pesan error akan muncul ketika digit security code tidak di input sesuai kriteria
    Given User telah berhasil melewati halaman log in
    When User mengisi <Security Code> pada kolom digit Security Code
    Then User tidak dapat lanjut ke halaman selanjutnya
    And User diberikan pemberitahuan error

    Examples: 
      | Security Code |
      | 200      |
      |         22001 |
