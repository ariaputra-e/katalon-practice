@FunctionalTest
Feature: Search
Description: This feature is used to verify the test functionality in MyLeads menu
  
  Background: User telah berhasil melewati halaman log in
  	Given User membuka aplikasi SFT dari perangkat
   	When  User mengisi kolom Email dan Password dengan benar
   	Then User dapat lanjut ke halaman pembuatan security code atau home
