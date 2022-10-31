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

String Seat_Available_Status = 'https://ngsprodstorage1.blob.core.windows.net/prd/content/images/layout/default/en-sg/seat-curr-avail.png'
String Seat_Selected_Status = 'https://nonprodngsstorageshawsg.blob.core.windows.net/uat/content/images/layout/default/en-sg/seat-curr-select.png'
String Seat_Unavailable_Status = 'https://ngsprodstorage1.blob.core.windows.net/prd/content/images/layout/default/en-sg/seat-curr-unavail.png'
String Handi_Cap_Seat = 'https://ngsprodstorage1.blob.core.windows.net/prd/content/images/layout/default/en-sg/seat-curr-wheelchair-avail.png'

String Seat_Available_Status_UAT = 'https://nonprodngsstorageshawsg.blob.core.windows.net/uat/content/images/layout/default/en-sg/seat-curr-avail.png'
String Seat_Selected_Status_UAT = 'https://nonprodngsstorageshawsg.blob.core.windows.net/uat/content/images/layout/default/en-sg/seat-curr-select.png'
String Seat_Unavailable_Status_UAT = 'https://nonprodngsstorageshawsg.blob.core.windows.net/uat/content/images/layout/default/en-sg/seat-curr-unavail.png'

String GlobalEnv = GlobalVariable.Env

String xpath = '//*[@id="'+id+'"]'
WebUI.comment(xpath)
String status = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
		[('xpath'):xpath,('attrr'):"xlink:href"],
		FailureHandling.STOP_ON_FAILURE)
	// JWLDRM_SD_EL0003_shape
if(GlobalEnv == 'PROD') {
	if(status == Seat_Available_Status) {
		return 'Available'
	}
	else if(status == Seat_Unavailable_Status){
		return 'UnAvailable'
	}
	else if(status == Seat_Selected_Status ){
		return 'Selected'
	}
	else if(status == Handi_Cap_Seat) {
		return 'Handicap'
	}
}

if(GlobalEnv == 'UAT') {
	if(status == Seat_Available_Status_UAT) {
		return 'Available'
	}
	else if(status == Seat_Unavailable_Status){
		return 'UnAvailable'
	}
	else if(status == Seat_Selected_Status ){
		return 'Selected'
	}
	else if(status == Handi_Cap_Seat) {
		return 'Handicap'
	}
}

