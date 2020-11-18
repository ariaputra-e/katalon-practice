import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
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

import cucumber.api.java.Before
import cucumber.api.java.After
import internal.GlobalVariable

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MB
import io.appium.java_client.android.AndroidDriver as AD
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

class forgot {
	@Given("User fill in the security box")
	def fillSC(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('obj_new/digitboxSC1'), 80)
		Mobile.delay(2)
		driver.getKeyboard().sendKeys('2')
		driver.getKeyboard().sendKeys('2')
		driver.getKeyboard().sendKeys('0')
		driver.getKeyboard().sendKeys('0')
		driver.getKeyboard().sendKeys('1')
		Mobile.delay(2)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(5)
	}

	@When("User click on Forgot Password before finish")
	def wrongClickPass(){
		Mobile.tap(findTestObject('obj_new/button-ForgetPassword'), 10)
		Mobile.delay(3)
	}

	@And("Click on Back button")
	def clickBack(){
		Mobile.tap(findTestObject('obj_new/button-left'), 50)
		Mobile.delay(3)
	}

	@Then("User can re-enter the security code to proceed to home page")
	def resubmitSC(){
		AD<?> driver = MB.getDriver()
		for (i in 1..6){
			driver.pressKey(new KeyEvent(AndroidKey.DEL))
		}
		Mobile.delay(3)
		Mobile.tap(findTestObject('obj_new/digitboxSC1'), 80)
		driver.getKeyboard().sendKeys('2')
		driver.getKeyboard().sendKeys('2')
		driver.getKeyboard().sendKeys('0')
		driver.getKeyboard().sendKeys('0')
		driver.getKeyboard().sendKeys('1')
		driver.getKeyboard().sendKeys('1')
		Mobile.delay(5)
	}

}

class getStarted {

	@When("User mengisi kolom email dengan (.*)")
	def inputEmailSignUp(String Email){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-email'), 80)
		driver.getKeyboard().sendKeys(Email)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Kolom sales code dengan (.*)")
	def inputSCSignUp(String SC){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-salesCode'), 80)
		driver.getKeyboard().sendKeys(SC)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Kolom NIP dengan (.*)")
	def inputNIPSignUp(String NIP){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-nip'), 80)
		driver.getKeyboard().sendKeys(NIP)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Serta kolom Password (.*) dan konfirmasi password (.*)")
	def inputpassSignUp(String pass, String cfpass){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-password'), 80)
		driver.getKeyboard().sendKeys(pass)
		Mobile.hideKeyboard()
		Mobile.delay(5)

		Mobile.tap(findTestObject('textInput-confirmPassword'), 80)
		driver.getKeyboard().sendKeys(cfpass)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@When("User menekan tombol Submit")
	def pressSubmitGS(){
		Mobile.tap(findTestObject('button-submit'), 10)
		Mobile.delay(2)
	}

	@Then("User akan diminta untuk membuat security code")
	def verifySCPage(){
		Mobile.verifyElementExist(findTestObject('digitBox1'), 60)
	}

	@Then("User akan mendapatkan pesan error pada menu Sign Up")
	def getError(){
		Mobile.tap(findTestObject('button-submit'), 10)
		String alert = Mobile.getText(findTestObject('alertGetStarted'), 10)
		println(alert)
		Mobile.delay(5)
		//Mobile.closeApplication()
	}

	@When("User menekan tombol Get Started")
	def pressGetStarted(){
		Mobile.delay(5)
		Mobile.tap(findTestObject('getStarted'), 80)
		Mobile.delay(5)
	}

	@Given("User mengisi salah satu kolom yaitu Email")
	def inputEmailGS(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-email'), 50)
		driver.getKeyboard().sendKeys("dsheadAT1@mail.com")
	}

	@When("User menekan enter")
	def keyEnter(){
		AD<?> driver = MB.getDriver()
		Mobile.delay(5)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(5)
	}

	@Then("Kursor akan fokus ke kolom selanjutnya")
	def verifyColumnChangeGS(){
		Mobile.verifyElementAttributeValue(findTestObject('textInput-salesCode'), 'focused', true, 10)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@When("User masuk ke halaman form untuk sign up")
	def verifySignUpPageTest(){
		Mobile.verifyElementExist(findTestObject('text-GetStarted'), 50)
	}

	@And("User menekan ikon kembali")
	def pressArrowBack(){
		Mobile.tap(findTestObject('arrow-back'), 20)
		Mobile.delay(5)
	}

	@Then("User berada di halaman log in")
	def verifyLoginPage(){
		Mobile.verifyElementExist(findTestObject('signIn'), 20)
	}

	@Then("User akan masuk ke halaman form untuk sign up")
	def verifySignUpPage(){
		Mobile.verifyElementExist(findTestObject('text-GetStarted'), 50)
	}
}

class login {

	@Given("User membuka aplikasi SFT dari perangkat")
	def openApp() {
		Mobile.startApplication(GlobalVariable.sftApp, true)
	}

	@And("User telah berhasil melewati halaman log in")
	def validLogin(){
		Mobile.startApplication(GlobalVariable.sftApp, true)
		Mobile.delay(5)
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', 80)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, 80)
		Mobile.tap(findTestObject('signIn'), 80)
		Mobile.delay(15)
	}

	@Given("User telah berhasil melewati halaman log in dan mengisi (.*) sebagai Security Code")
	def validLoginFirst(String sc){
		Mobile.startApplication(GlobalVariable.sftApp, true)
		AD<?> driver = MB.getDriver()
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', 80)
		Mobile.setEncryptedText(findTestObject('text-password'), 'RigbBhfdqOBGNlJIWM1ClA==',
				80)
		Mobile.tap(findTestObject('signIn'), 80)

		Mobile.tap(findTestObject('digitbox1'), 80)
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonCreateSecurity'), 80)
		Mobile.delay(5)
	}

	@When("User mengisi (.*) pada halaman konfirmasi Security Code")
	def confirmSC(String csc){
		Mobile.tap(findTestObject('digitboxConfirm1'), 40)
		AD<?> driver = MB.getDriver()
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(csc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
	}

	@When("User mengisi kolom (.*) dengan format yang salah")
	def inputInvalidEmail(String Email){
		Mobile.setText(findTestObject('text-email'), Email, 80)
	}

	@When("User mengisi kolom (.*) dengan benar dan kolom (.*) dengan salah")
	def inputInValidPassword(String Email, String Password){
		Mobile.setText(findTestObject('text-email'), Email, 80)
		Mobile.setText(findTestObject('text-password'), Password, 80)
	}

	@When("Splashscreen berhasil tertutup")
	def statusAfterStart() {
		println('Continue to Login Page')
	}

	@When("User mengisi kolom Email dan Password dengan salah")
	def inputInvalidCredentials(){
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', 80)
		Mobile.setText(findTestObject('text-password'), '123456722', 80)
	}

	@When("User menekan text box ke tiga di halaman security code")
	def clickThirdTextBoxSC(){
		Mobile.tap(findTestObject('digitbox3'), 80)
	}

	@When("User mengisi salah satu digit pada Security Code")
	def oneDigitInputSC(){
		Mobile.tap(findTestObject('digitbox1'), 80)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
	}

	@When("User mengisi kolom Email dengan (.*) dan Password")
	def inputValidSpec(String Email){
		Mobile.tap(findTestObject('text-email'), 80)
		Mobile.setText(findTestObject('text-email'), Email, 80)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), 80)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, 80)
		Mobile.hideKeyboard()
	}

	@When("User mengisi kolom Email dan Password dengan benar")
	def inputValidCredentials(){
		Mobile.tap(findTestObject('text-email'), 80)
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', 80)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), 80)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, 80)
		Mobile.hideKeyboard()
	}

	@When("User mengisi kolom Email kemudian menekan Enter")
	def inputEmail(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('text-email'), 80)
		driver.getKeyboard().sendKeys("rmAt@mail.com")
		driver.getKeyboard().sendKeys("\n")
		Mobile.delay(5)
		//driver.getKeyboard().sendKeys("\n")
	}

	@When("User mengisi (.*) pada kolom digit Security Code")
	def inputSC(String sc){
		Mobile.tap(findTestObject('digitbox1'), 80)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
	}

	@Then("User dapat lanjut ke halaman konfirmasi Security Code")
	def confirmationPageVerification(){
		Mobile.tap(findTestObject('digitboxConfirm1'), 80)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat lanjut ke halaman home aplikasi")
	def submitValidConfirmSC(){
		//AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('buttonConfirmSecurity'), 20)
		Mobile.verifyElementExist(findTestObject('home'), 40)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User tidak dapat lanjut ke halaman pembuatan security code")
	def submitInvalidLogin(){
		Mobile.tap(findTestObject('signIn'), 10)
	}

	@And("User akan mendapatkan pesan error")
	def loginAlert(){
		Mobile.tap(findTestObject('signIn'), 10)
		String alert = Mobile.getText(findTestObject('loginAlert'), 0)
		println(alert)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User tidak dapat lanjut ke halaman home")
	def submitInvalidConfirmSC(){
		//AD<?> driver = MB.getDriver()
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonConfirmSecurity'), 80)
	}

	@Then("User tidak dapat lanjut ke halaman selanjutnya")
	def submitFailSC(){
		Mobile.tap(findTestObject('buttonCreateSecurity'), 80)
	}

	@And("User diberikan pemberitahuan error")
	def  catchErrorMessageSC(){
		Mobile.tap(findTestObject('buttonCreateSecurity'), 80)
		String message = Mobile.getText(findTestObject('textAlertSC'), 80)
		println(message)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("Kursor akan kembali ke text box pertama")
	def verifyCursorPositionSC(){
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
		println('Digit tetap dimulai dari box pertama')
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("Kursor pindah ke digit kosong selanjutnya")
	def verifyNextActiveDigitBoxSC(){
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
		driver.getKeyboard().sendKeys("4")
		driver.getKeyboard().sendKeys("0")
		println('Object digitbox2 aktif')
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("Kursor akan lanjut ke kolom password")
	def verifyActivePasswordBox(){
		Mobile.delay(5)
		Mobile.verifyElementAttributeValue(findTestObject('text-password'), 'focused', 'true', 5)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat lanjut ke halaman pembuatan security code atau home")
	def submitValidCredentials(){
		Mobile.tap(findTestObject('signIn'), 80)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat melihat elemen-elemen login seperti text box email dan password serta tombol secara lengkap")
	def checkElements(){
		Mobile.tap(findTestObject('text-email'), 80)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), 80)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('label-login'), 80)
		Mobile.delay(5)
		Mobile.closeApplication()
	}
}