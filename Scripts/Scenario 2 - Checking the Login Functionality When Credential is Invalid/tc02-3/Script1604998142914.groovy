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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.AndroidDriver

Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)

Mobile.tap(findTestObject('LoginPage/text-email'), 0)

Mobile.setText(findTestObject('LoginPage/text-email'), 'rmAT3@mail.com', 0)

//Mobile.sendKeys(findTestObject('Others/android.widget.EditText - Email'), Keys.chord(Keys.ENTER))

AndroidDriver<?> driver = MobileDriverFactory.getDriver()
//driver.findElement(By.className('android.widget.EditText')).click()
//Mobile.delay(3)

driver.getKeyboard().sendKeys("\n")

Mobile.verifyElementAttributeValue(findTestObject('LoginPage/text-password'), 'focused', 'true', 5)

Mobile.delay(5)

Mobile.closeApplication()

