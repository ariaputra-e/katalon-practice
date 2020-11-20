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


class createSC {

	private TestObject inputEmail			= findTestObject('LoginPage/text-email')
	private TestObject inputPassword		= findTestObject('LoginPage/text-password')
	private TestObject buttonSignIn			= findTestObject('LoginPage/signIn')

	private TestObject digitboxSC1			= findTestObject('SecurityPage/digitboxSC1')
	private TestObject digitbox1			= findTestObject('SecurityPage/digitbox1')
	private TestObject digitbox3			= findTestObject('SecurityPage/digitbox3')
	private TestObject buttonCreate			= findTestObject('SecurityPage/buttonCreateSecurity')
	private TestObject digitboxConfirm1		= findTestObject('SecurityPage/digitboxConfirm1')
	private TestObject buttonConfirm		= findTestObject('SecurityPage/buttonConfirmSecurity')

	private TestObject errorAlert			= findTestObject('SecurityPage/textAlertSC')

	private TestObject homeIcon 			= findTestObject('HomePage/home-icon')


	@Given("User RM mengisi kolom Email dan Password")
	def inputLogInRM() {
		Mobile.delay(2)
		Mobile.setText(inputEmail, 'rmFunding@mail.com', GlobalVariable.tm)
		Mobile.setText(inputPassword, GlobalVariable.pass, GlobalVariable.tm)
		Mobile.tap(buttonSignIn, GlobalVariable.tm)
		Mobile.delay(5)
	}

	@Given("User BM mengisi kolom Email dan Password")
	def inputLogInBM() {
		Mobile.setText(inputEmail, 'sbmFunding@mail.com', GlobalVariable.tm)
		Mobile.setText(inputPassword, GlobalVariable.pass, GlobalVariable.tm)
		Mobile.tap(buttonSignIn, GlobalVariable.tm)
		Mobile.delay(5)
	}

	@When("User mengisi security code dan confirmation security code")
	def inputSC() {
		Mobile.tap(digitbox1, GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		Mobile.delay(2)
		driver.getKeyboard().sendKeys('220011')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))

		Mobile.delay(2)
		Mobile.tap(buttonCreate, GlobalVariable.tm)
		Mobile.delay(2)

		Mobile.tap(digitboxConfirm1, GlobalVariable.tm)
		Mobile.delay(2)
		driver.getKeyboard().sendKeys('220011')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)

		Mobile.tap(buttonConfirm, GlobalVariable.tm)
	}

	@Then("User masuk ke dalam halaman home")
	def verifyHome() {
		Mobile.verifyElementExist(homeIcon, GlobalVariable.tm)
		Mobile.delay(5)
	}

	@Given("User telah berhasil melewati halaman log in dan mengisi (.*) sebagai Security Code")
	def validLoginFirst(String sc){
		Mobile.startApplication(GlobalVariable.sftApp, true)
		AD<?> driver = MB.getDriver()
		Mobile.setText(inputEmail, 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.setEncryptedText(inputPassword, 'RigbBhfdqOBGNlJIWM1ClA==', GlobalVariable.tm)
		Mobile.tap(buttonSignIn, GlobalVariable.tm)

		Mobile.tap(digitbox1, GlobalVariable.tm)
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(buttonCreate, GlobalVariable.tm)
		Mobile.delay(5)
	}

	@And("User telah berhasil melewati halaman log in")
	def validLogin(){
		Mobile.startApplication(GlobalVariable.sftApp, true)
		Mobile.delay(5)
		Mobile.setText(inputEmail, 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.setText(inputPassword, GlobalVariable.pass, GlobalVariable.tm)
		Mobile.tap(buttonSignIn, GlobalVariable.tm)
		Mobile.delay(15)
	}

	@When("User mengisi (.*) pada halaman konfirmasi Security Code")
	def confirmSC(String csc){
		Mobile.tap(digitboxConfirm1, GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(csc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
	}

	@When("User menekan text box ke tiga di halaman security code")
	def clickThirdTextBoxSC(){
		Mobile.tap(digitbox3, GlobalVariable.tm)
	}

	@When("User mengisi salah satu digit pada Security Code")
	def oneDigitInputSC(){
		Mobile.tap(digitbox1, GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
	}

	@When("User mengisi (.*) pada kolom digit Security Code")
	def inputSC(String sc){
		Mobile.tap(digitbox1, GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
	}

	@Then("User dapat lanjut ke halaman konfirmasi Security Code")
	def confirmationPageVerification(){
		Mobile.tap(digitboxConfirm1, GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat lanjut ke halaman home aplikasi")
	def submitValidConfirmSC(){
		//AD<?> driver = MB.getDriver()
		Mobile.tap(buttonConfirm, GlobalVariable.tm)
		Mobile.verifyElementExist(homeIcon, 40)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User tidak dapat lanjut ke halaman home")
	def submitInvalidConfirmSC(){
		//AD<?> driver = MB.getDriver()
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(buttonConfirm, GlobalVariable.tm)
	}

	@Then("User tidak dapat lanjut ke halaman selanjutnya")
	def submitFailSC(){
		Mobile.tap(buttonCreate, GlobalVariable.tm)
	}

	@And("User diberikan pemberitahuan error")
	def  catchErrorMessageSC(){
		Mobile.tap(buttonCreate, GlobalVariable.tm)
		String message = Mobile.getText(errorAlert, GlobalVariable.tm)
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
}