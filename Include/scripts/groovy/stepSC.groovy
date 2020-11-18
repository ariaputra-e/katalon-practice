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

import cucumber.api.java.After
import cucumber.api.java.Before
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MB
import io.appium.java_client.android.AndroidDriver as AD
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent


class stepSC {
	@Given("User RM mengisi kolom Email dan Password")
	def inputLogInRM() {
		Mobile.delay(2)
		Mobile.setText(findTestObject('text-email'), 'rmFunding@mail.com', 80)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, 80)
		Mobile.tap(findTestObject('signIn'), 80)
		Mobile.delay(5)
	}

	@Given("User BM mengisi kolom Email dan Password")
	def inputLogInBM() {
		Mobile.setText(findTestObject('text-email'), 'sbmFunding@mail.com', 80)
		Mobile.setText(findTestObject('text-password'), GlobalVariable.pass, 80)
		Mobile.tap(findTestObject('signIn'), 80)
		Mobile.delay(5)
	}

	@When("User mengisi security code dan confirmation security code")
	def inputSC() {
		Mobile.tap(findTestObject('digitbox1'), 80)
		AD<?> driver = MB.getDriver()
		Mobile.delay(2)
		driver.getKeyboard().sendKeys('220011')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))

		Mobile.delay(2)
		Mobile.tap(findTestObject('buttonCreateSecurity'), 80)
		Mobile.delay(2)

		Mobile.tap(findTestObject('digitboxConfirm1'), 40)
		Mobile.delay(2)
		driver.getKeyboard().sendKeys('220011')
		driver.pressKey(new KeyEvent(AndroidKey.ENTER))
		Mobile.delay(2)

		Mobile.tap(findTestObject('buttonConfirmSecurity'), 80)
	}

	@Then("User masuk ke dalam halaman home")
	def verifyHome() {
		Mobile.verifyElementExist(findTestObject('home'), 40)
		Mobile.delay(5)
	}
}