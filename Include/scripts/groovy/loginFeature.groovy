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

public class login {

	//Initiate Object with POM Implementation
	private TestObject inputEmail			= findTestObject('LoginPage/text-email')
	private TestObject inputPassword		= findTestObject('LoginPage/text-password')
	private TestObject buttonGetStarted		= findTestObject('LoginPage/getStarted')
	private TestObject buttonSignIn			= findTestObject('LoginPage/signIn')
	private TestObject alertLogin			= findTestObject('LoginPage/loginAlert')
	private TestObject textViewLogin		= findTestObject('LoginPage/label-login')

	@Given("User membuka aplikasi SFT dari perangkat")
	def openApp() {
		Mobile.startApplication(GlobalVariable.sftApp, true)
	}

	@When("User mengisi kolom (.*) dengan format yang salah")
	def inputInvalidEmail(String Email){
		Mobile.setText(inputEmail, Email, GlobalVariable.tm)
	}

	@When("User mengisi kolom (.*) dengan benar dan kolom (.*) dengan salah")
	def inputInValidPassword(String Email, String Password){
		Mobile.setText(inputEmail, Email, GlobalVariable.tm)
		Mobile.setText(inputPassword, Password, GlobalVariable.tm)
	}

	@When("Splashscreen berhasil tertutup")
	def statusAfterStart() {
		println('Continue to Login Page')
	}

	@When("User mengisi kolom Email dan Password dengan salah")
	def inputInvalidCredentials(){
		Mobile.setText(inputEmail, 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.setText(inputPassword, '123456722', GlobalVariable.tm)
		Mobile.hideKeyboard()
	}


	@When("User mengisi kolom Email dengan (.*) dan Password")
	def inputValidSpec(String Email){
		Mobile.tap(inputEmail, GlobalVariable.tm)
		Mobile.setText(inputEmail, Email, GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(inputPassword, GlobalVariable.tm)
		Mobile.setText(inputPassword, GlobalVariable.pass, GlobalVariable.tm)
		Mobile.hideKeyboard()
	}

	@When("User mengisi kolom Email dan Password dengan benar")
	def inputValidCredentials(){
		Mobile.tap(inputEmail, GlobalVariable.tm)
		Mobile.setText(inputEmail, 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(inputPassword, GlobalVariable.tm)
		Mobile.setText(inputPassword, GlobalVariable.pass, GlobalVariable.tm)
		Mobile.hideKeyboard()
	}

	@When("User mengisi kolom Email kemudian menekan Enter")
	def inputEmail(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputEmail, GlobalVariable.tm)
		driver.getKeyboard().sendKeys("rmAt@mail.com")
		driver.getKeyboard().sendKeys("\n")
		Mobile.delay(5)
		//driver.getKeyboard().sendKeys("\n")
	}

	@Then("User tidak dapat lanjut ke halaman pembuatan security code")
	def submitInvalidLogin(){
		Mobile.tap(buttonSignIn, GlobalVariable.tm)
	}

	@And("User akan mendapatkan pesan error")
	def loginAlert(){
		Mobile.tap(buttonSignIn, GlobalVariable.tm)
		String alert = Mobile.getText(alertLogin, GlobalVariable.tm)
		println(alert)
		Mobile.delay(5)
		Mobile.closeApplication()
	}


	@Then("Kursor akan lanjut ke kolom password")
	def verifyActivePasswordBox(){
		Mobile.delay(5)
		Mobile.verifyElementAttributeValue(inputPassword, 'focused', 'true', 5)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat lanjut ke halaman pembuatan security code atau home")
	def submitValidCredentials(){
		Mobile.tap(buttonSignIn, GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat melihat elemen-elemen login seperti text box email dan password serta tombol secara lengkap")
	def checkElements(){
		Mobile.tap(inputEmail, GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(inputPassword, GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(textViewLogin, GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}
}

public class forgot {

	private TestObject digitboxSC1				= findTestObject('SecurityPage/digitboxSC1') //pre logged
	private TestObject digitbox1				= findTestObject('SecurityPage/digitbox1') //first timer
	private TestObject buttonCreate				= findTestObject('SecurityPage/buttonCreateSecurity')
	private TestObject digitboxConfirm1			= findTestObject('SecurityPage/digitboxConfirm1')
	private TestObject buttonConfirm			= findTestObject('SecurityPage/buttonConfirmSecurity')

	private TestObject homeIcon 				= findTestObject('HomePage/home-icon')

	private TestObject inputEmail				= findTestObject('LoginPage/text-email')
	private TestObject inputPasswordL			= findTestObject('LoginPage/text-password')
	private TestObject buttonSignIn				= findTestObject('LoginPage/signIn')

	private TestObject buttonForgetSC			= findTestObject('SecurityPage/button-forgetSecCode')
	private TestObject buttonForgotPass 		= findTestObject('SecurityPage/button-ForgetPassword')
	private TestObject buttonNext 				= findTestObject('SecurityPage/button-right')
	private TestObject buttonBack 				= findTestObject('SecurityPage/button-left')

	private TestObject closePopUp 				= findTestObject('SecurityPage/button-close')

	private TestObject inputNIP					= findTestObject('GetStartedPage/textInput-nip')
	private TestObject inputPassword			= findTestObject('GetStartedPage/textInput-password')
	private TestObject inputConfirmPassword		= findTestObject('GetStartedPage/textInput-confirmPassword')
	private TestObject buttonSubmit				= findTestObject('GetStartedPage/button-submit')


	@Given("User fill in the security box")
	def fillSC(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(digitboxSC1, GlobalVariable.tm)
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
	@Given("User click on Forgot Security Code button")
	def forgotSCClick(){
		Mobile.tap(buttonForgetSC, GlobalVariable.tm)
	}
	@When("User enter valid credentials for log in")
	def inputCredentials(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputEmail, GlobalVariable.tm)
		Mobile.clearText(inputEmail, GlobalVariable.tm)
		driver.getKeyboard().sendKeys(GlobalVariable.rmMail)
		Mobile.delay(3)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		driver.getKeyboard().sendKeys(GlobalVariable.pass)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(buttonSignIn, GlobalVariable.tm)
	}
	@Then("User is asked to create new security code")
	def inputnewSC(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(digitbox1, GlobalVariable.tm)
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(GlobalVariable.securityCode)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(buttonCreate, GlobalVariable.tm)
		//Confirm SC
		Mobile.tap(digitboxConfirm1, GlobalVariable.tm)
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(GlobalVariable.securityCode)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		Mobile.tap(buttonConfirm, GlobalVariable.tm)
		Mobile.delay(10)
	}
	@And("User can proceed to the home page")
	def verifyHome() {
		Mobile.verifyElementExist(homeIcon, GlobalVariable.tm)
		Mobile.delay(5)
	}
	@When("User click on Forgot Password button in security code input page")
	def wrongClickPass(){
		Mobile.tap(buttonForgotPass, GlobalVariable.tm)
		Mobile.delay(3)
	}
	@When("User re-enter new password and confirm new password in a form")
	def resetPassword(){
		Mobile.tap(buttonNext, GlobalVariable.tm)
		Mobile.delay(3)
		//In Get Started Page
		AD<?> driver = MB.getDriver()
		Mobile.tap(inputNIP, GlobalVariable.tm)
		driver.getKeyboard().sendKeys('CN000rmFunding')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		Mobile.tap(inputPassword, GlobalVariable.tm)
		driver.getKeyboard().sendKeys('!2345678Rm')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		Mobile.tap(inputConfirmPassword, GlobalVariable.tm)
		driver.getKeyboard().sendKeys('!2345678Rm')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		Mobile.tap(buttonSubmit, GlobalVariable.tm)
		Mobile.delay(2)
	}
	@And("Click on Back button")
	def clickBack(){
		Mobile.tap(buttonBack, GlobalVariable.tm)
		Mobile.delay(3)
	}
	@Then("User can re-enter the security code to proceed to home page")
	def resubmitSC(){
		Mobile.tap(digitboxSC1, GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		for (i in 1..6){
			driver.pressKey(new KeyEvent(AndroidKey.DEL))
		}
		Mobile.delay(3)
		driver.getKeyboard().sendKeys('2')
		driver.getKeyboard().sendKeys('2')
		driver.getKeyboard().sendKeys('0')
		driver.getKeyboard().sendKeys('0')
		driver.getKeyboard().sendKeys('1')
		driver.getKeyboard().sendKeys('1')
		Mobile.delay(10)
	}
	@Then("User get a notice to verify the password changes in their email")
	def userPassResetNotice() {
		Mobile.delay(2)
		Mobile.tap(closePopUp, GlobalVariable.tm)
	}
}
