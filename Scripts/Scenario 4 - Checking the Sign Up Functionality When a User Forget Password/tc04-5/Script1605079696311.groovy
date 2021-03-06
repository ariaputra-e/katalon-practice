import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MB
import io.appium.java_client.android.AndroidDriver as AD
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)

AD<?> driver = MB.getDriver()

Mobile.tap(findTestObject('LoginPage/buttonGetStarted'), 0)

Mobile.tap(findTestObject('GetStartedPage/textInput-email'), 0)

driver.getKeyboard().sendKeys('rmAT3@mail.com')

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.delay(2)

Mobile.tap(findTestObject('GetStartedPage/textInput-salesCode'), 0)

driver.getKeyboard().sendKeys('SC000rmAT3')

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.delay(2)

Mobile.tap(findTestObject('GetStartedPage/textInput-nip'), 0)

driver.getKeyboard().sendKeys('CN000rmAT3')

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.delay(2)

Mobile.tap(findTestObject('GetStartedPage/textInput-password'), 0)

driver.getKeyboard().sendKeys('S123456789')

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.delay(2)

Mobile.tap(findTestObject('GetStartedPage/textInput-confirmPassword'), 0)

driver.getKeyboard().sendKeys('S123456789')

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.delay(2)

Mobile.tap(findTestObject('GetStartedPage/button-submit'), 0)

Mobile.delay(15)

Mobile.closeApplication()

