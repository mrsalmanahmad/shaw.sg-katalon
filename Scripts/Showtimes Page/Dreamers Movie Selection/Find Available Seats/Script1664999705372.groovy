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

String xpath = '//*[@id="LIDO9_SD_EL0045"]'
String Attribute = 'xlink:href'
String class_name = 'ej-d-node'
String attrr = 'id'
String color = '_shape'
String seats = '_backRect'

int size = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Size of Element by class name'), 
	[('class_name'):class_name,('attrr'):attrr],
	FailureHandling.STOP_ON_FAILURE)

String id = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Element Id by class name'),
	[('class_name'):class_name,('attrr'):attrr],
	FailureHandling.STOP_ON_FAILURE)

WebUI.comment("I am here ===== "+id)
id = WebUI.callTestCase(findTestCase('Test Cases/Core/Split String'),
	[('id'):id],
	FailureHandling.STOP_ON_FAILURE)

String Seat_Status_Path = id+'_shape'
String Seat_Status = ''

WebUI.comment("I am here ++++===== "+id)

//WebUI.callTestCase(findTestCase('Test Cases/Core/Get Seat Status'),
//	[('id'):Seat_Status],
//	FailureHandling.STOP_ON_FAILURE)

int count = count_1
int selected = 0
boolean seat_is_selected = false
int seat_number = 0
String next_seat_id = ''
boolean seat_found = false
boolean invalid_seat_selection = false
//String id_2 = WebUI.callTestCase(findTestCase('Test Cases/Core/Split String'),
//	[('id'):id,('count'):count],
//	FailureHandling.STOP_ON_FAILURE)
def SeatInvalid() {
	boolean invalid_seat_selection = false
	invalid_seat_selection = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Check if Invalid Seat Selection Popup on-off'),
		[:],FailureHandling.OPTIONAL)
	if(invalid_seat_selection == true) {
		// Close the Popup and find new seats
		WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Ok btn of Invalid Seat Selection Popup'),
			[:],FailureHandling.OPTIONAL)
	}
	return invalid_seat_selection
}

while(seat_is_selected == false) {
	String seat1 = ''
	String seat2 = ''
	id = WebUI.callTestCase(findTestCase('Test Cases/Core/Split String'),
		[('id'):id,("count"):count],
		FailureHandling.STOP_ON_FAILURE)
	// Make New Xpath of the seat
	String newName = xpath.substring(0,9)+id+xpath.substring(24,26)
	WebUI.comment("New Xpath of Seat is --> " + newName)
	Seat_Status_Path = id+color
	// Check if seat is not available don't click on it
	Seat_Status = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Seat Status'),
		[('id'):Seat_Status_Path],
		FailureHandling.STOP_ON_FAILURE)
	if(Seat_Status == 'Available') {
		invalid_seat_selection = SeatInvalid()
		// Click on the seat
		CustomKeywords.'custom.com.pk.ClickonAnyElementUsingXpath'(newName)
		// Check if the seat is Selected or not
		selected = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Quantity of Seats Selected'), null,
			FailureHandling.STOP_ON_FAILURE)
		if(selected > 0) {
			seat1 = newName // Store previous seat xpath if next seat not found we should de select this seat
			count = count+1
			WebUI.comment('Get Xpath for Next Seat with count ' + count)
			next_seat_id = WebUI.callTestCase(findTestCase('Test Cases/Core/Split String'),
				[('id'):id,('count'):count],
				FailureHandling.STOP_ON_FAILURE)
			newName = xpath.substring(0,9)+next_seat_id+xpath.substring(24,26)
			Seat_Status_Path = next_seat_id+color
			Seat_Status = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Seat Status'),
				[('id'):Seat_Status_Path],
				FailureHandling.STOP_ON_FAILURE)
			if(Seat_Status == 'Available') {
				// Click on Next Seat
				invalid_seat_selection = SeatInvalid()
				CustomKeywords.'custom.com.pk.ClickonAnyElementUsingXpath'(newName)
				invalid_seat_selection = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Check if Invalid Seat Selection Popup on-off'),
					[:],FailureHandling.OPTIONAL)
				if(invalid_seat_selection == true) {
					// Close the Popup and find new seats
					WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Ok btn of Invalid Seat Selection Popup'),
						[:],FailureHandling.OPTIONAL)
				}
			}
			else if(Seat_Status != 'Available' || invalid_seat_selection == true) {
				// De-Select First Seat
				CustomKeywords.'custom.com.pk.ClickonAnyElementUsingXpath'(seat1)
			}
			// Check if the seat is Selected or not
			selected = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Quantity of Seats Selected'), null,
				FailureHandling.STOP_ON_FAILURE)
		}
	}
	
	if(selected == 2) {
		seat_is_selected = true
		seat_found = true
	}
	
	if(count >= 50) {
		seat_is_selected = true
		seat_found = false
	}
	count++
	invalid_seat_selection = false
}

return seat_found
