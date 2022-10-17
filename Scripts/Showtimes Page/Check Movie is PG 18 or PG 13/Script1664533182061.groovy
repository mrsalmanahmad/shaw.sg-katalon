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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String xpath_for_pg = '//*[@id="moviesDiv"]/div[1]/div[3]/div[1]/div[1]/div/p[1]/span[1]/span'

//*[@id="moviesDiv"]/div[1]/div[6]/div[2]/div/a
//*[@id="moviesDiv"]/div[1]/div[6]/div[1]/div[1]/div/p[1]/span[1]/span

//*[@id="moviesDiv"]/div[1]/div[7]/div[1]/div[1]/div/p[1]/span[1]/span
//*[@id="moviesDiv"]/div[1]/div[7]/div[2]/div[1]/a

xpath_for_pg = '//*[@id="moviesDiv"]/div[1]/div['+Movie_Count+']/div[1]/div[1]/div/p[1]/span[1]/span'

String val = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'), 
	[('xpath'):xpath_for_pg,('attrr'):'class'],
		FailureHandling.STOP_ON_FAILURE)

String s = val
String[] parts = s.split("-")
String part1 = parts[0] 
String part2 = parts[1] 
String part3 = parts[2]
String part4 = parts[3]

WebUI.comment(part1)
WebUI.comment(part2)
WebUI.comment(part3)
WebUI.comment(part4)

// m18 pull for pg 18 movies
// pg13 pull for pg 13 movies

if(part4 == 'm18 pull') {
	return 'M18'
}
else if(part4 == 'pg13 pull') {
	return 'PG 13'
}
else if(part4 == 'nc16') {
	return 'NC 16'
}
else if(part4 == 'r21') {
	return 'NC 16'
}