import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.Before
import cucumber.api.java.After

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import cucumber.api.java.en.And
import cucumber.api.java.en.But

import internal.GlobalVariable


public class leads {

	@Given("User RM mengisi kolom Email dan Password dengan benar")
	def loginRM(){
		Mobile.setText(findTestObject('text-email'), 'rmFunding@mail.com', 80)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, 80)
		Mobile.tap(findTestObject('signIn'), 80)
		Mobile.delay(5)
	}

	@When("User mengisi security code yang telah dibuat")
	def verifySCRM(){
	}

	@Then("User dapat lanjut ke halaman home")
	def verifyHome(){
	}
}
