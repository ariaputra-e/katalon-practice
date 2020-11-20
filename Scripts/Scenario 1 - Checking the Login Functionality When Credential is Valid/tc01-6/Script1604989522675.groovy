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
//import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
//import io.appium.java_client.android.AndroidDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MB
import io.appium.java_client.android.AndroidDriver as AD

Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)

AD<?> driver = MB.getDriver()
//Mobile.tap(findTestObject('Others/android.widget.FrameLayout (9)'), 0)

Mobile.setText(findTestObject('LoginPage/text-email'), 'rmAT3@mail.com', 0)
Mobile.setEncryptedText(findTestObject('LoginPage/text-password'), 'RigbBhfdqOBGNlJIWM1ClA==', 0)

Mobile.tap(findTestObject('LoginPage/signIn'), 0)

Mobile.tap(findTestObject('SecurityPage/digitbox1'), 0)
driver.getKeyboard().sendKeys("2")
driver.getKeyboard().sendKeys("4")
driver.getKeyboard().sendKeys("0")

Mobile.closeApplication()
