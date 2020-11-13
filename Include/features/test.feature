Feature: 
  Login Functionality

  Scenario: Memeriksa apakah user dapat menginput security code tanpa harus memulai inputan dari text box pertama
    Given User telah berhasil melewati halaman log in
    When User menekan text box ke tiga di halaman security code
    Then Kursor akan kembali ke text box pertama
     
