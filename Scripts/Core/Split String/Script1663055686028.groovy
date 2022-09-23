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

String s = id
String[] parts = s.split("_")
String part1 = parts[0] // 004
String part2 = parts[1] // 034556
String part3 = parts[2]

WebUI.comment(part1)
WebUI.comment(part2)
WebUI.comment(part3)

//String s = String.format("%0"+ (8 - "Apple".length() )+"d%s",0 ,"Apple");
//String ncount = String.valueOf(count);
// EL0001
String myName = part3
String newName = ''

if(count < 10) {
	newName = myName.substring(0,5)+count
}

if(count >= 10) {
	newName = myName.substring(0,4)+count
}
//String newName = myName.substring(0,5)+count

WebUI.comment(newName)
//String final_string = s.substring(0,8)+"_"+newName
String final_string = part1+'_'+part2+"_"+newName

WebUI.comment("***************" +final_string)

//String newName = myName.substring(0,4)+'x'+myName.substring(5)

return final_string