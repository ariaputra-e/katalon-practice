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
import org.junit.After as After
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MB
import io.appium.java_client.android.AndroidDriver as AD
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent

Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)

AD<?> driver = MB.getDriver()

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - Email'), 'rmAT3@mail.com', 0)

Mobile.setEncryptedText(findTestObject('Object Repository/android.widget.EditText - Password (10)'), 'RigbBhfdqOBGNlJIWM1ClA==', 
    0)

Mobile.tap(findTestObject('Object Repository/android.view.ViewGroup (14)'), 0 //Button Sign In
    )

Mobile.tap(findTestObject('Object Repository/android.view.ViewGroup (8)'), 0 //Text Box SC
    )

driver.getKeyboard().sendKeys('2')

driver.getKeyboard().sendKeys('2')

driver.getKeyboard().sendKeys('0')

driver.getKeyboard().sendKeys('0')

driver.getKeyboard().sendKeys('1')

driver.getKeyboard().sendKeys('1')

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.tap(findTestObject('android.view.ViewGroup (16)'), 0)

Mobile.delay(10)

Mobile.closeApplication()

