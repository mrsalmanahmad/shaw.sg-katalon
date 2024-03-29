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

int Movie_Count = 3
boolean seat_found = false
String PG = ''

while(seat_found == false) {
	
	WebUI.callTestCase(findTestCase('Test Cases/Navigations/Open Shaw sg'), null,
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Test Cases/Navigations/Open Dreamers Movies'), null,
		FailureHandling.STOP_ON_FAILURE)
	sleep(3000)
	int Movies = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Get Total number of Movies'), null,
		FailureHandling.STOP_ON_FAILURE)
	
	int Movies_time = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Get Total number of Movies'), null,
		FailureHandling.STOP_ON_FAILURE)
	
	PG = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Check Movie is PG 18 or PG 13'),
		[('Movie_Count'):Movie_Count, ('Dreamers'):true],
		FailureHandling.STOP_ON_FAILURE)
	
	if(Movies > 0) {
		if(Movies_time > 0) {
			WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/IMax Movies Selection/Click on IMax Movies'),
				[('Movie_Count'):Movie_Count, ('Dreamers'):true],
				FailureHandling.STOP_ON_FAILURE)
		}
	}
	WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Family Selection all steps'), [:],
		FailureHandling.STOP_ON_FAILURE)
	
//	WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Add Toddler'), [:],
//		FailureHandling.STOP_ON_FAILURE)
//	
//	WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Add Kids'), [:],
//		FailureHandling.STOP_ON_FAILURE)
	
//	WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Continue btn'), [:],
//		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Proceed btn'), [:],
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Reset btn'), [:],
		FailureHandling.STOP_ON_FAILURE)
	sleep(9000)
	seat_found = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Find Available Seats'), 
		[('count_1'):2],
		FailureHandling.STOP_ON_FAILURE)
	
	Movie_Count++
}

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Confirm Seat(s) btn'), null,
	FailureHandling.STOP_ON_FAILURE)

if(PG == 'M18') {
	WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Agree btn'), null,
		FailureHandling.CONTINUE_ON_FAILURE)
}
else if(PG == 'NC 16') {
	WebUI.callTestCase(findTestCase('Test Cases/Pop Ups/NC 16 Pop Up/Click on Agree btn of NC 16 Pop Up'), null,
		FailureHandling.CONTINUE_ON_FAILURE)
}

sleep(2000)
WebUI.comment('second')
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Proceed btn if Different Row Seat Selected'), null,
	FailureHandling.CONTINUE_ON_FAILURE)

sleep(2000)
WebUI.comment('first')
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Conitnue btn'), null,
	FailureHandling.STOP_ON_FAILURE)

sleep(2000)
WebUI.comment('second')
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Proceed btn if Different Row Seat Selected'), null,
	FailureHandling.CONTINUE_ON_FAILURE)

sleep(2000)
WebUI.comment('third')
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Continue Addon btn'), null,
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Cancel Booking btn'), null,
	FailureHandling.OPTIONAL)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Cancel Booking btn'), null,
	FailureHandling.OPTIONAL)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Welcome to Shaw/button_SHOWTIMES'),
	FailureHandling.OPTIONAL)

WebUI.deleteAllCookies()

//WebUI.callTestCase(findTestCase('Test Cases/VISA Payment/Functional Test/Fill VISA Payment Form'), null,
//	FailureHandling.STOP_ON_FAILURE)
//
//WebUI.deleteAllCookies()
