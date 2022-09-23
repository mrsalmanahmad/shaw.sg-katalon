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

String Seat_id = 'LIDO7_SD_EL0088'
String Seat_status_img_id = 'LIDO7_SD_EL0088_shape'
String Seat_Reserverd_Status = 'https://nonprodngsstorageshawsg.blob.core.windows.net/uat/content/images/layout/default/en-sg/seat-curr-avail.png'
String Seat_Selected_Status = 'https://nonprodngsstorageshawsg.blob.core.windows.net/uat/content/images/layout/default/en-sg/seat-curr-select.png'
String Seat_Unavailable_Status = 'https://ngsprodstorage1.blob.core.windows.net/prd/content/images/layout/default/en-sg/seat-curr-unavail.png'
String xpath = '//*[@id="LIDO9_SD_EL0045"]'
String Attribute = 'xlink:href'
String class_name = 'ej-d-node'
String attrr = 'id'
String color = '_shape'
String seats = '_backRect'

//CustomKeywords.'custom.com.pk.GetAnyAttributeofanyElement'(xpath,Attribute)

int size = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Size of Element by class name'), 
	[('class_name'):class_name,('attrr'):attrr],
	FailureHandling.STOP_ON_FAILURE)

String id = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Element Id by class name'),
	[('class_name'):class_name,('attrr'):attrr],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Core/Split String'),
	[('id'):id],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Core/Get Attrr Value by ID'),
	[('id'):id,('attrr'):"href"],
	FailureHandling.STOP_ON_FAILURE)

int count = 5
int selected = 0
boolean seat_is_selected = false
int seat_number = 0
String new_seat_id = ''
boolean seat_found = false

while(seat_is_selected == false) {
	
	String newName = xpath.substring(0,9)+id+xpath.substring(24,26)
	WebUI.comment("++++++" + newName)
	
	CustomKeywords.'custom.com.pk.ClickonAnyElementUsingXpath'(newName)
	
	selected = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Quantity of Seats Selected'), null,
		FailureHandling.STOP_ON_FAILURE)
	if(selected != 0) {
		seat_number = selected
	}
	
	if(seat_number == 0) {
		new_seat_id = WebUI.callTestCase(findTestCase('Test Cases/Core/Split String'),
			[('id'):id,('count'):count],
			FailureHandling.STOP_ON_FAILURE)
	}
	if(count >= 50) {
		seat_is_selected = true
		seat_found = false
	}
	else if(seat_number > 0) {
		seat_is_selected = true
		seat_found = true
	}
	count++
	id = new_seat_id
}

return seat_found
