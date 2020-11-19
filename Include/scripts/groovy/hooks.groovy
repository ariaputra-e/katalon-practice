import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import cucumber.api.java.After
import cucumber.api.java.Before
import internal.GlobalVariable

class hooks {
	@Before(value="@SignIn, @Forgot") def startApp(){
		Mobile.delay(3)
		Mobile.startApplication(GlobalVariable.sftApp, false)
		Mobile.delay(5)
	}

	@After def closeApp(){
		Mobile.delay(5)
		Mobile.closeApplication()
	}
}