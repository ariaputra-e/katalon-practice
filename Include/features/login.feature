Feature: 
  Login Functionality

  @Prequisites
  Scenario: Mengecek apakah semua elemen untuk login telah termuat dengan lengkap ketika aplikasi dibuka
    Given User membuka aplikasi SFT dari perangkat
    When Splashscreen berhasil tertutup
    Then User dapat melihat elemen-elemen login seperti text box email dan password serta tombol secara lengkap

  Scenario: Mengecek apakah ketika field email diisi user dapat melanjutkan ke kolom password dengan menekan enter
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom Email kemudian menekan Enter
    Then Kursor akan lanjut ke kolom password

  @Valid
  Scenario: Mengecek bagaimana sistem merespon ketika user memberikan kredensial yang valid untuk pertama kali
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom Email dan Password dengan benar
    Then User dapat lanjut ke halaman pembuatan security code atau home

  Scenario: Mengecek bagaimana sistem merespon ketika user memberikan kredensial yang valid
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom Email dan Password dengan benar
    Then User dapat lanjut ke halaman pembuatan security code atau home

  Scenario: Mengecek apakah ketika user memberi input pada kolom pertama maka kursor akan fokus ke kolom selanjutnya pada halaman input security code
    Given User telah berhasil melewati halaman log in
    When User mengisi salah satu digit pada Security Code
    Then Kursor pindah ke digit kosong selanjutnya

  Scenario: Memeriksa apakah user dapat menginput security code tanpa harus memulai inputan dari text box pertama
    Given User telah berhasil melewati halaman log in
    When User menekan text box ke tiga di halaman security code
    Then Kursor akan kembali ke text box pertama

  Scenario Outline: Mengecek apakah pesan error akan muncul ketika digit security code tidak di input sesuai kriteria
    Given User telah berhasil melewati halaman log in
    When User mengisi <Security Code> pada kolom digit Security Code
    Then User tidak dapat lanjut ke halaman selanjutnya
    And User diberikan pemberitahuan error

    Examples: 
      | Security Code |
      | "2200CC"      |
      |         22001 |

  Scenario Outline: Memeriksa apakah user dapat masuk ketika memasukkan security code yang telah sesuai dengan kriteria
    Given User telah berhasil melewati halaman log in
    When User mengisi <Security Code> pada kolom digit Security Code
    Then User dapat lanjut ke halaman konfirmasi Security Code

    Examples: 
      | Security Code |
      |        220011 |
      |        110044 |

  Scenario Outline: Memeriksa apakah user dapat lanjut ketika mengkonfirmasi security code dengan tidak benar
    Given User telah berhasil melewati halaman log in dan mengisi <Security Code> sebagai Security Code
    When User mengisi <Confirmation Security Code> pada halaman konfirmasi Security Code
    Then User tidak dapat lanjut ke halaman home

    Examples: 
      | Security Code | Confirmation Security Code |
      |        220011 |                     221011 |
      |        110044 |                     112044 |

  Scenario Outline: Mengecek apakah user dapat masuk ketika menginput security code yang sesuai ketika konfirmasi
    Given User telah berhasil melewati halaman log in dan mengisi <Security Code> sebagai Security Code
    When User mengisi <Confirmation Security Code> pada halaman konfirmasi Security Code
    Then User dapat lanjut ke halaman home aplikasi

    Examples: 
      | Security Code | Confirmation Security Code |
      |        220011 |                     220011 |
      |        110044 |                     112044 |

  @Invalid
  Scenario: Mengecek bagaimana sistem merespon ketika field email serta password diisi dengan tidak valid
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom Email dan Password dengan salah
    Then User tidak dapat lanjut ke halaman pembuatan security code
    And User akan mendapatkan pesan error

  Scenario Outline: Memeriksa bagaimana sistem merespon ketika user menginput email dengan format yang salah
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom <Email> dengan format yang salah
    Then User akan mendapatkan pesan error

    Examples: 
      | Email            |
      | "rmAT&mail.com"  |
      | "rmAT3.mail.com" |
      | "rmAT3@mail@com" |
      | "rmAT3mail.com"  |

  Scenario Outline: Memeriksa bagaimana sistem merespon setelah terjadi kesalahan login secara berulang-ulang pada email yang benar namun password yang salah
    Given User membuka aplikasi SFT dari perangkat
    When User mengisi kolom <Email> dengan benar dan kolom <Password> dengan salah
    Then User akan mendapatkan pesan error

    Examples: 
      | Email           | Password  |
      | "rmAT@mail.com" | 123456789 |
      | "rmAT@mail.com" | 012345678 |
      | "rmAT@mail.com" |   1234567 |
