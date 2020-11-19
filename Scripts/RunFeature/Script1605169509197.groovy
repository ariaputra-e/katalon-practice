import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

//CucumberKW.runFeatureFile('Include/features/login.feature')
//CucumberKW.runFeatureFileWithTags('Include/features/login.feature', "@LoginInterface")

CucumberKW.runWithCucumberRunner(TestRunner.class)