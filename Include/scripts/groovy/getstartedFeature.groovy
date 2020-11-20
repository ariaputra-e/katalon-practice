import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MB

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver as AD
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import com.kms.katalon.core.testobject.TestObject


public class getStarted {
	//Login Page
	private TestObject buttonGetStarted		= findTestObject('LoginPage/getStarted')

	//Get Started Page
	private TestObject inputEmail				= findTestObject('GetStartedPage/textInput-email')
	private TestObject inputSalesCode			= findTestObject('GetStartedPage/textInput-salesCode')
	private TestObject inputNIP					= findTestObject('GetStartedPage/textInput-nip')
	private TestObject inputPassword			= findTestObject('GetStartedPage/textInput-password')
	private TestObject inputConfirmPassword		= findTestObject('GetStartedPage/textInput-confirmPassword')
	private TestObject buttonSubmit				= findTestObject('GetStartedPage/button-submit')
	private TestObject buttonBack				= findTestObject('GetStartedPage/arrow-back')
	private TestObject pageTitle				= findTestObject('GetStartedPage/text-GetStarted')
	private TestObject errorAlert				= findTestObject('GetStartedPage/alertGetStarted')

	//Security Code Page
	private TestObject digitBox1				= findTestObject('SecurityPage/digitbox1')


	@When("User mengisi kolom email dengan (.*)")
	def inputEmailSignUp(String Email){
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputEmail, GlobalVariable.tm)
		driver.getKeyboard().sendKeys(Email)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Kolom sales code dengan (.*)")
	def inputSCSignUp(String SC){
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputSalesCode, GlobalVariable.tm)
		driver.getKeyboard().sendKeys(SC)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Kolom NIP dengan (.*)")
	def inputNIPSignUp(String NIP){
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputNIP, GlobalVariable.tm)
		driver.getKeyboard().sendKeys(NIP)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Serta kolom Password (.*) dan konfirmasi password (.*)")
	def inputpassSignUp(String pass, String cfpass){
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputPassword, GlobalVariable.tm)
		driver.getKeyboard().sendKeys(pass)
		Mobile.hideKeyboard()
		Mobile.delay(5)
		Mobile.tap(inputConfirmPassword, GlobalVariable.tm)
		driver.getKeyboard().sendKeys(cfpass)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@When("User menekan tombol Submit")
	def pressSubmitGS(){
		Mobile.tap(buttonSubmit, GlobalVariable.tm)
		Mobile.delay(2)
	}

	@Then("User akan diminta untuk membuat security code")
	def verifySCPage(){
		Mobile.verifyElementExist(digitBox1, GlobalVariable.tm)
	}

	@Then("User akan mendapatkan pesan error pada menu Sign Up")
	def getError(){
		Mobile.tap(buttonSubmit, GlobalVariable.tm)
		String alert = Mobile.getText(errorAlert, 40)
		println(alert)
		Mobile.delay(5)
		//Mobile.closeApplication()
	}

	@When("User menekan tombol Get Started")
	def pressGetStarted(){
		Mobile.delay(5)
		Mobile.tap(buttonGetStarted, GlobalVariable.tm)
		Mobile.delay(5)
	}

	@Given("User mengisi salah satu kolom yaitu Email")
	def inputEmailGS(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputEmail, GlobalVariable.tm)
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
		Mobile.verifyElementAttributeValue(inputSalesCode, 'focused', true, GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@When("User masuk ke halaman form untuk sign up")
	def verifySignUpPageTest(){
		Mobile.verifyElementExist(pageTitle, 50)
	}

	@And("User menekan ikon kembali")
	def pressArrowBack(){
		Mobile.tap(buttonBack, GlobalVariable.tm)
		Mobile.delay(5)
	}

	@Then("User berada di halaman log in")
	def verifyLoginPage(){
		Mobile.verifyElementExist(buttonGetStarted, 20)
	}

	@Then("User akan masuk ke halaman form untuk sign up")
	def verifySignUpPage(){
		Mobile.verifyElementExist(pageTitle, 50)
	}
}