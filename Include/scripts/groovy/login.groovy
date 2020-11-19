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

class forgot {
	@Given("User fill in the security box")
	def fillSC(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('obj_new/digitboxSC1'), GlobalVariable.tm)
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
		Mobile.tap(findTestObject("obj_new/button-forgetSecCode"), GlobalVariable.tm)
	}
	
	
	@When("User enter valid credentials for log in")
	def inputCredentials(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject("text-email"), GlobalVariable.tm)
		Mobile.clearText(findTestObject("text-email"), GlobalVariable.tm)
		driver.getKeyboard().sendKeys(GlobalVariable.rmMail)
		Mobile.delay(3)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		driver.getKeyboard().sendKeys(GlobalVariable.pass)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('signIn'), GlobalVariable.tm)
	}
	
	@Then("User is asked to create new security code")
	def inputnewSC(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('digitbox1'), GlobalVariable.tm)
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(GlobalVariable.securityCode)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonCreateSecurity'), GlobalVariable.tm)
		
		//Confirm SC
		Mobile.tap(findTestObject('digitboxConfirm1'), GlobalVariable.tm)
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(GlobalVariable.securityCode)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		Mobile.tap(findTestObject('buttonConfirmSecurity'), GlobalVariable.tm)
		Mobile.delay(10)
	}
	
	@And("User can proceed to the home page")
	def verifyHome() {
		Mobile.verifyElementExist(findTestObject('home'), GlobalVariable.tm)
		Mobile.delay(5)
	}

	@When("User click on Forgot Password button in security code input page")
	def wrongClickPass(){
		Mobile.tap(findTestObject('obj_new/button-ForgetPassword'), GlobalVariable.tm)
		Mobile.delay(3)
	}
	
	@When("User re-enter new password and confirm new password in a form")
	def resetPassword(){
		Mobile.tap(findTestObject('obj_new/button-right'), GlobalVariable.tm)
		Mobile.delay(3)
		
		//In Get Started Page
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-nip'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys('CN000rmFunding')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		
		Mobile.tap(findTestObject('textInput-password'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys('!2345678Rm')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		
		Mobile.tap(findTestObject('textInput-confirmPassword'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys('!2345678Rm')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)
		
		Mobile.tap(findTestObject('button-submit'), GlobalVariable.tm)
		Mobile.delay(2)
	}

	@And("Click on Back button")
	def clickBack(){
		Mobile.tap(findTestObject('obj_new/button-left'), GlobalVariable.tm)
		Mobile.delay(3)
	}

	@Then("User can re-enter the security code to proceed to home page")
	def resubmitSC(){
		Mobile.tap(findTestObject('obj_new/digitboxSC1'), GlobalVariable.tm)
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
		Mobile.tap(findTestObject('obj_new/button-close'), GlobalVariable.tm)
	}
}

class getStarted {

	@When("User mengisi kolom email dengan (.*)")
	def inputEmailSignUp(String Email){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-email'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys(Email)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Kolom sales code dengan (.*)")
	def inputSCSignUp(String SC){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-salesCode'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys(SC)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Kolom NIP dengan (.*)")
	def inputNIPSignUp(String NIP){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-nip'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys(NIP)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@And("Serta kolom Password (.*) dan konfirmasi password (.*)")
	def inputpassSignUp(String pass, String cfpass){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-password'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys(pass)
		Mobile.hideKeyboard()
		Mobile.delay(5)

		Mobile.tap(findTestObject('textInput-confirmPassword'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys(cfpass)
		Mobile.hideKeyboard()
		Mobile.delay(5)
	}

	@When("User menekan tombol Submit")
	def pressSubmitGS(){
		Mobile.tap(findTestObject('button-submit'), GlobalVariable.tm)
		Mobile.delay(2)
	}

	@Then("User akan diminta untuk membuat security code")
	def verifySCPage(){
		Mobile.verifyElementExist(findTestObject('digitBox1'), GlobalVariable.tm)
	}

	@Then("User akan mendapatkan pesan error pada menu Sign Up")
	def getError(){
		Mobile.tap(findTestObject('button-submit'), GlobalVariable.tm)
		String alert = Mobile.getText(findTestObject('alertGetStarted'), 10)
		println(alert)
		Mobile.delay(5)
		//Mobile.closeApplication()
	}

	@When("User menekan tombol Get Started")
	def pressGetStarted(){
		Mobile.delay(5)
		Mobile.tap(findTestObject('getStarted'), GlobalVariable.tm)
		Mobile.delay(5)
	}

	@Given("User mengisi salah satu kolom yaitu Email")
	def inputEmailGS(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('textInput-email'), GlobalVariable.tm)
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
		Mobile.verifyElementAttributeValue(findTestObject('textInput-salesCode'), 'focused', true, GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@When("User masuk ke halaman form untuk sign up")
	def verifySignUpPageTest(){
		Mobile.verifyElementExist(findTestObject('text-GetStarted'), 50)
	}

	@And("User menekan ikon kembali")
	def pressArrowBack(){
		Mobile.tap(findTestObject('arrow-back'), GlobalVariable.tm)
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
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, GlobalVariable.tm)
		Mobile.tap(findTestObject('signIn'), GlobalVariable.tm)
		Mobile.delay(15)
	}

	@Given("User telah berhasil melewati halaman log in dan mengisi (.*) sebagai Security Code")
	def validLoginFirst(String sc){
		Mobile.startApplication(GlobalVariable.sftApp, true)
		AD<?> driver = MB.getDriver()
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.setEncryptedText(findTestObject('text-password'), 'RigbBhfdqOBGNlJIWM1ClA==', GlobalVariable.tm)
		Mobile.tap(findTestObject('signIn'), GlobalVariable.tm)

		Mobile.tap(findTestObject('digitbox1'), GlobalVariable.tm)
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonCreateSecurity'), GlobalVariable.tm)
		Mobile.delay(5)
	}

	@When("User mengisi (.*) pada halaman konfirmasi Security Code")
	def confirmSC(String csc){
		Mobile.tap(findTestObject('digitboxConfirm1'), GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		Mobile.delay(5)
		driver.getKeyboard().sendKeys(csc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
	}

	@When("User mengisi kolom (.*) dengan format yang salah")
	def inputInvalidEmail(String Email){
		Mobile.setText(findTestObject('text-email'), Email, GlobalVariable.tm)
	}

	@When("User mengisi kolom (.*) dengan benar dan kolom (.*) dengan salah")
	def inputInValidPassword(String Email, String Password){
		Mobile.setText(findTestObject('text-email'), Email, GlobalVariable.tm)
		Mobile.setText(findTestObject('text-password'), Password, GlobalVariable.tm)
	}

	@When("Splashscreen berhasil tertutup")
	def statusAfterStart() {
		println('Continue to Login Page')
	}

	@When("User mengisi kolom Email dan Password dengan salah")
	def inputInvalidCredentials(){
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.setText(findTestObject('text-password'), '123456722', GlobalVariable.tm)
	}

	@When("User menekan text box ke tiga di halaman security code")
	def clickThirdTextBoxSC(){
		Mobile.tap(findTestObject('digitbox3'), GlobalVariable.tm)
	}

	@When("User mengisi salah satu digit pada Security Code")
	def oneDigitInputSC(){
		Mobile.tap(findTestObject('digitbox1'), GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys("2")
	}

	@When("User mengisi kolom Email dengan (.*) dan Password")
	def inputValidSpec(String Email){
		Mobile.tap(findTestObject('text-email'), GlobalVariable.tm)
		Mobile.setText(findTestObject('text-email'), Email, GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), GlobalVariable.tm)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, GlobalVariable.tm)
		Mobile.hideKeyboard()
	}

	@When("User mengisi kolom Email dan Password dengan benar")
	def inputValidCredentials(){
		Mobile.tap(findTestObject('text-email'), GlobalVariable.tm)
		Mobile.setText(findTestObject('text-email'), 'dsheadAT1@mail.com', GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), GlobalVariable.tm)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, GlobalVariable.tm)
		Mobile.hideKeyboard()
	}

	@When("User mengisi kolom Email kemudian menekan Enter")
	def inputEmail(){
		AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('text-email'), GlobalVariable.tm)
		driver.getKeyboard().sendKeys("rmAt@mail.com")
		driver.getKeyboard().sendKeys("\n")
		Mobile.delay(5)
		//driver.getKeyboard().sendKeys("\n")
	}

	@When("User mengisi (.*) pada kolom digit Security Code")
	def inputSC(String sc){
		Mobile.tap(findTestObject('digitbox1'), GlobalVariable.tm)
		AD<?> driver = MB.getDriver()
		driver.getKeyboard().sendKeys(sc)
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
	}

	@Then("User dapat lanjut ke halaman konfirmasi Security Code")
	def confirmationPageVerification(){
		Mobile.tap(findTestObject('digitboxConfirm1'), GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat lanjut ke halaman home aplikasi")
	def submitValidConfirmSC(){
		//AD<?> driver = MB.getDriver()
		Mobile.tap(findTestObject('buttonConfirmSecurity'), GlobalVariable.tm)
		Mobile.verifyElementExist(findTestObject('home'), 40)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User tidak dapat lanjut ke halaman pembuatan security code")
	def submitInvalidLogin(){
		Mobile.tap(findTestObject('signIn'), GlobalVariable.tm)
	}

	@And("User akan mendapatkan pesan error")
	def loginAlert(){
		Mobile.tap(findTestObject('signIn'), GlobalVariable.tm)
		String alert = Mobile.getText(findTestObject('loginAlert'), GlobalVariable.tm)
		println(alert)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User tidak dapat lanjut ke halaman home")
	def submitInvalidConfirmSC(){
		//AD<?> driver = MB.getDriver()
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.tap(findTestObject('buttonConfirmSecurity'), GlobalVariable.tm)
	}

	@Then("User tidak dapat lanjut ke halaman selanjutnya")
	def submitFailSC(){
		Mobile.tap(findTestObject('buttonCreateSecurity'), GlobalVariable.tm)
	}

	@And("User diberikan pemberitahuan error")
	def  catchErrorMessageSC(){
		Mobile.tap(findTestObject('buttonCreateSecurity'), GlobalVariable.tm)
		String message = Mobile.getText(findTestObject('textAlertSC'), GlobalVariable.tm)
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
		Mobile.tap(findTestObject('signIn'), GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}

	@Then("User dapat melihat elemen-elemen login seperti text box email dan password serta tombol secara lengkap")
	def checkElements(){
		Mobile.tap(findTestObject('text-email'), GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('text-password'), GlobalVariable.tm)
		Mobile.hideKeyboard()
		Mobile.tap(findTestObject('label-login'), GlobalVariable.tm)
		Mobile.delay(5)
		Mobile.closeApplication()
	}
}