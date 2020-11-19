// PENTING
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

//Generate Security Code

/** @CucumberOptions(features="Include/features/createSC.feature", glue={""}, 
tags={"@RM"}) //Untuk user RM **/

@CucumberOptions(features="Include/features/loginpage/forgot.feature", glue={""}, tags={"@Forgot"})

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