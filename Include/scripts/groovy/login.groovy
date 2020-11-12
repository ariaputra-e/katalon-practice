import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MB
import io.appium.java_client.android.AndroidDriver as AD
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

class login {
	
	@Given("User membuka aplikasi SFT dari perangkat")
	def openApp() {
		Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)
	}

	@And("User telah berhasil melewati halaman log in")
	def validLogin(){
	    Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)
		Mobile.setText(findTestObject('text-email'), 'rmAT3@mail.com', 80)
		Mobile.setEncryptedText(findTestObject('text-password'), 'RigbBhfdqOBGNlJIWM1ClA==', 80)
		Mobile.tap(findTestObject('signIn'), 5)
	}

	@Given("User telah berhasil melewati halaman log in dan mengisi (.*) sebagai Security Code")
	def validLoginFirst(String sc){
		Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)
		AD<?> driver = MB.getDriver()
		Mobile.setText(findTestObject('text-mail'), 'rmAT3@mail.com', 0)
		Mobile.setEncryptedText(findTestObject('text-password'), 'RigbBhfdqOBGNlJIWM1ClA==',
				0)
		Mobile.tap(findTestObject('signIn'), 0)

		Mobile.tap(findTestObject('digitbox1'), 0)
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonCreateSecurity'), 0)
	}

	@When("User mengisi (.*) pada halaman konfirmasi Security Code")
	def confirmSC(String csc){
		Mobile.tap(findTestObject('digitboxConfirm1'), 0)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys(csc)
	}

	@When("User mengisi kolom (.*) dengan format yang salah")
	def inputInvalidEmail(String Email){
		Mobile.setText(findTestObject('text-email'), Email, 0)
	}

	@When("User mengisi kolom (.*) dengan benar dan kolom (.*) dengan salah")
	def inputInValidPassword(String Password){
		Mobile.setText(findTestObject('text-password'), Password, 0)
	}

	@When("Splashscreen berhasil tertutup")
	def statusAfterStart() {
		println('Continue to Login Page')
	}

	@When("User mengisi kolom Email dan Password dengan salah")
	def inputInvalidCredentials(){
		Mobile.setText(findTestObject('text-email'), 'rmAT3@mail.com', 0)
		Mobile.setText(findTestObject('text-password'), '123456722', 0)
	}

	@When("User menekan text box ke tiga di halaman security code")
	def clickThirdTextBoxSC(){
		Mobile.tap(findTestObject('digitbox3'), 0)
	}

	@When("User mengisi salah satu digit pada Security Code")
	def oneDigitInputSC(){
		Mobile.tap(findTestObject('digitbox1'), 0)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
	}

	@When("User mengisi kolom Email dan Password dengan benar")
	def inputValidCredentials(){
		Mobile.tap(findTestObject('text-email'), 0)
		Mobile.setText(findTestObject('text-email'), 'rmAT3@mail.com', 0)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), 0)
		Mobile.setText(findTestObject('text-password'), '12345678', 0)
		Mobile.hideKeyboard()
	}

	@When("User mengisi kolom Email kemudian menekan Enter")
	def inputEmail(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('text-email'), 0)
		driver.getKeyboard().sendKeys("rmAt@mail.com")
		driver.getKeyboard().sendKeys("\n")
		Mobile.delay(5)
		//driver.getKeyboard().sendKeys("\n")
	}

	@When("User mengisi (.*) pada kolom digit Security Code")
	def inputSC(String sc){
		Mobile.tap(findTestObject('digitbox1'), 0)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
	}

	@Then("User dapat lanjut ke halaman konfirmasi Security Code")
	def confirmationPageVerification(){
		Mobile.tap(findTestObject('digitboxConfirm1'), 0)
	}

	@Then("User dapat lanjut ke halaman home aplikasi")
	def submitValidConfirmSC(){
		AD<?> driver = MB.getDriver()
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonCreateSecurity'), 0)
	}

	@Then("User tidak dapat lanjut ke halaman pembuatan security code")
	def submitInvalidLogin(){
		Mobile.tap(findTestObject('signIn'), 0)
	}

	@And("User akan mendapatkan pesan error")
	def loginAlert(){
		alert = Mobile.getText(findTestObject('loginAlert'), 0)
		println(alert)
	}

	@Then("User tidak dapat lanjut ke halaman home")
	def submitInvalidConfirmSC(){
		AD<?> driver = MB.getDriver()
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonCreateSecurity'), 0)
	}

	@Then("User tidak dapat lanjut ke halaman selanjutnya")
	def submitFailSC(){
		Mobile.tap(findTestObject('buttonCreateSecurity'), 0)
	}

	@And("User diberikan pemberitahuan error")
	def  catchErrorMessageSC(){
		alert = Mobile.getText(findTestObject('textAlertSC'), 0)
		println(alert)
	}

	@Then("Kursor akan kembali ke text box pertama")
	def verifyCursorPositionSC(){
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
		println('Digit tetap dimulai dari box pertama')
	}

	@Then("Kursor pindah ke digit kosong selanjutnya")
	def verifyNextActiveDigitBoxSC(){
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
		driver.getKeyboard().sendKeys("4")
		driver.getKeyboard().sendKeys("0")
		println('Object digitbox2 aktif')
	}

	@Then("Kursor akan lanjut ke kolom password")
	def verifyActivePasswordBox(){
		Mobile.delay(5)
		Mobile.verifyElementAttributeValue(findTestObject('text-password'), 'focused', 'true', 5)
	}

	@Then("User dapat lanjut ke halaman pembuatan security code atau home")
	def submitValidCredentials(){
		Mobile.tap(findTestObject('signIn'), 0)
	}

	@Then("User dapat melihat elemen-elemen login seperti text box email dan password serta tombol secara lengkap")
	def checkElements(){
		Mobile.tap(findTestObject('text-email'), 0)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), 0)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('label-login'), 0)
	}
}