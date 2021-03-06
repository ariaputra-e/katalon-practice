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

Mobile.startApplication('D:\\Data Kuliah\\Magang\\CIMB Niaga\\app-universal-release-alphasft.apk', true)

//Mobile.tap(findTestObject('Others/android.widget.FrameLayout (10)'), 0)

Mobile.setText(findTestObject('text-mail'), 'rmAT3@mail.com', 0)

Mobile.setEncryptedText(findTestObject('LoginPage/text-password'), 'RigbBhfdqOBGNlJIWM1ClA==', 
    0)

Mobile.tap(findTestObject('LoginPage/signIn'), 0)

//Mobile.tap(findTestObject(''), 0)

Mobile.tap(findTestObject('SecurityPage/digitbox4'), 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('SecurityPage/digitbox2'), 0)

Mobile.tap(findTestObject('SecurityPage/digitbox3'), 0)

Mobile.tap(findTestObject('SecurityPage/digitbox6'), 0)

Mobile.closeApplication()

