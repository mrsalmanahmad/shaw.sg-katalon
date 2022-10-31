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
	
	WebUI.comment("Select Showtimes filter and select the first movie showtime")
	WebUI.callTestCase(findTestCase('Test Cases/Navigations/Open Shaw sg'), null,
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Test Cases/Main Page Elements/Click on Showtimes button'), null,
		FailureHandling.STOP_ON_FAILURE)
	
	int Movies = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Get Total number of Movies'), null,
		FailureHandling.STOP_ON_FAILURE)
	
	int Movies_time = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Get Total number of Movies'), null,
		FailureHandling.STOP_ON_FAILURE)
	
	PG = WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Check Movie is PG 18 or PG 13'),
		[('Movie_Count'):Movie_Count],
		FailureHandling.STOP_ON_FAILURE)
	
	if(Movies > 0) {
		if(Movies_time > 0) {
			WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/IMax Movies Selection/Click on IMax Movies'),
				[('Movie_Count'):Movie_Count],
				FailureHandling.STOP_ON_FAILURE)
		}
	}
	
	seat_found = WebUI.callTestCase(findTestCase('Test Cases/All Seat Selection Patterens/Select Handicap Seat'), 
		[('count_1'):2,
		 ('ci'):5	
		],
		FailureHandling.STOP_ON_FAILURE)
	
	Movie_Count++
}

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Confirm Seat(s) btn'), null,
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Pop Ups/Check on Which popup we should click'), [('PG'):PG],
	FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Test Cases/Pop Ups/Different Seat Selection Popup/Click on Modify Seat Selection btn'), null,
//	FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Reset btn'), null,
//	FailureHandling.STOP_ON_FAILURE)
//
//seat_found = WebUI.callTestCase(findTestCase('Test Cases/All Seat Selection Patterens/Select Invalid Seat'),
//	[('count_1'):2,
//	 ('ci'):1
//	],
//	FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Confirm Seat(s) btn'), null,
//	FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Test Cases/Pop Ups/Check on Which popup we should click'), [('PG'):PG],
//	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Conitnue btn'), null,
	FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Test Cases/Add Ons Cart Page/Select Add on if Available'), null,
//	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Continue Addon btn'), null,
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Cancel Booking btn'), null,
	FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Click on Cancel Booking btn'), null,
	FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Welcome to Shaw/button_SHOWTIMES'),
	FailureHandling.STOP_ON_FAILURE)

WebUI.deleteAllCookies()

//WebUI.callTestCase(findTestCase('Test Cases/VISA Payment/Lookups/Select VISA Payment Option'), null,
//	FailureHandling.CONTINUE_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Test Cases/VISA Payment/Functional Test/Cancel VISA Payment'), null,
//	FailureHandling.STOP_ON_FAILURE)
//
//WebUI.deleteAllCookies()