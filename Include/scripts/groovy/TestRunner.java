import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;

// PENTING
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

//Generate Security Code

@CucumberOptions(features="Include/features/createSC.feature", glue={""}, 
tags={"@GenerateCode", "@RM"}) //Untuk user RM

/** @CucumberOptions(features="Include/features/createSC.feature", glue={""}, 
tags={"@GenerateCode", "@RM"}) //Untuk user BM **/

/**@CucumberOptions(features="Include/features/login.feature", glue={""}, 
	plugin={"pretty", "html:Reports/cucumber-practice", "json:Reports/cucumber-practice/rep.json"},
	tags={"@UsabilityTest"}) 

@CucumberOptions(features="Include/features/login.feature", glue={""}, 
	plugin={"pretty", "html:Reports/cucumber-practice", "json:Reports/cucumber-practice/rep.json"},
	tags={"@InterfaceTest"}) 

@CucumberOptions(features="Include/features/loginpage/login.feature", glue={""}, 
	plugin={"pretty", "html:Reports/get-started-1", "json:Reports/get-started-1/rep.json"},
	tags={"@SmokeTest", "@Valid", "@Passed", "@RelationManager"})

@CucumberOptions(features="Include/features/login.feature", glue={""}, 
plugin={"pretty", "html:Reports/cucumber-practice", "json:Reports/cucumber-practice/rep.json"},
tags={"@SmokeTest", "@Invalid"}) **/

public class TestRunner {

}