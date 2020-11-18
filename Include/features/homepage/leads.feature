@FunctionalTest @Leads @RelationManager
Feature: MyLeads
Description: This feature is used to verify the functionality in MyLeads menu for member Relation Manager
  
  Background: User telah berhasil melewati halaman log in
  	Given User RM mengisi kolom Email dan Password dengan benar
   	When  User mengisi security code yang telah dibuat
   	Then User dapat lanjut ke halaman home
   
