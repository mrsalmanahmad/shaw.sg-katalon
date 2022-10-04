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

String dreamers_text = 'Lido Hall 9'

WebUI.openBrowser("https://shaw.sg/Showtimes/2022-10-02/All/All", FailureHandling.STOP_ON_FAILURE)
System.out.println(java.time.LocalDate.now())

boolean Dreamer = false
int Movie_Count = 3
int Segment = 1

int Segment_1_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
		[('xpath'):'//*[@id="moviesDiv"]/div[1]/div/div[2]/div[1]/a'],
		FailureHandling.STOP_ON_FAILURE)

int Segment_2_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
	[('xpath'):'//*[@id="moviesDiv"]/div[3]/div/div[2]/div[1]/a'],
	FailureHandling.STOP_ON_FAILURE)

int Segment_3_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
	[('xpath'):'//*[@id="moviesDiv"]/div[5]/div/div[2]/div[1]/a'],
	FailureHandling.STOP_ON_FAILURE)

int Segment_4_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
	[('xpath'):'//*[@id="moviesDiv"]/div[7]/div/div[2]/div/a'],
	FailureHandling.STOP_ON_FAILURE)

int Segment_5_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
	[('xpath'):'//*[@id="moviesDiv"]/div[9]/div/div[2]/div[1]/a'],
	FailureHandling.STOP_ON_FAILURE)

int Segment_6_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
	[('xpath'):'//*[@id="moviesDiv"]/div[11]/div/div[2]/div[1]/a'],
	FailureHandling.STOP_ON_FAILURE)

int Segment_7_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
	[('xpath'):'//*[@id="moviesDiv"]/div[13]/div/div[2]/div[1]/a'],
	FailureHandling.STOP_ON_FAILURE)

int Segment_8_movies_count = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Total Number of Movies in One Segment'),
	[('xpath'):'//*[@id="moviesDiv"]/div[15]/div/div[2]/div[1]/a'],
	FailureHandling.STOP_ON_FAILURE)

boolean segment_1_full = false

while(Dreamer == false) {
	while(segment_1_full == false) {
		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
			[('Movie_Count'):Movie_Count,('Segment'):1],
			FailureHandling.STOP_ON_FAILURE)
		
		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
			[('xpath'):xpath,('attrr'):"data-balloon"],
			FailureHandling.STOP_ON_FAILURE)
		
		WebUI.comment("______ "+D)
		
		if(D == dreamers_text) {
			Dreamer = true
		}
		
		if(Movie_Count==Segment_1_movies_count) {
			segment_1_full = true
			Dreamer = true
		}
		
		Movie_Count++
	}
//	
//	Movie_Count = 3
//	
//	while(Movie_Count == Segment_2_movies_count) {
//		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
//			[('Movie_Count'):Movie_Count,('Segment'):3],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
//			[('xpath'):xpath,('attrr'):"data-balloon"],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		WebUI.comment("______ "+D)
//		
//		if(D == dreamers_text) {
//			Dreamer = true
//		}
//		
//		Movie_Count++
//	}
//	
//	Movie_Count = 3
//	
//	while(Movie_Count == Segment_3_movies_count) {
//		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
//			[('Movie_Count'):Movie_Count,('Segment'):5],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
//			[('xpath'):xpath,('attrr'):"data-balloon"],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		WebUI.comment("______ "+D)
//		
//		if(D == dreamers_text) {
//			Dreamer = true
//		}
//		
//		Movie_Count++
//	}
//	
//	Movie_Count = 3
//	
//	while(Movie_Count == Segment_4_movies_count) {
//		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
//			[('Movie_Count'):Movie_Count,('Segment'):7],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
//			[('xpath'):xpath,('attrr'):"data-balloon"],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		WebUI.comment("______ "+D)
//		
//		if(D == dreamers_text) {
//			Dreamer = true
//		}
//		
//		Movie_Count++
//	}
//	
//	Movie_Count = 3
//	
//	while(Movie_Count == Segment_5_movies_count) {
//		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
//			[('Movie_Count'):Movie_Count,('Segment'):9],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
//			[('xpath'):xpath,('attrr'):"data-balloon"],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		WebUI.comment("______ "+D)
//		
//		if(D == dreamers_text) {
//			Dreamer = true
//		}
//		
//		Movie_Count++
//	}
//	
//	Movie_Count = 3
//	
//	while(Movie_Count == Segment_6_movies_count) {
//		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
//			[('Movie_Count'):Movie_Count,('Segment'):11],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
//			[('xpath'):xpath,('attrr'):"data-balloon"],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		WebUI.comment("______ "+D)
//		
//		if(D == dreamers_text) {
//			Dreamer = true
//		}
//		
//		Movie_Count++
//	}
//	
//	Movie_Count = 3
//	
//	while(Movie_Count == Segment_7_movies_count) {
//		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
//			[('Movie_Count'):Movie_Count,('Segment'):13],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
//			[('xpath'):xpath,('attrr'):"data-balloon"],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		WebUI.comment("______ "+D)
//		
//		if(D == dreamers_text) {
//			Dreamer = true
//		}
//		
//		Movie_Count++
//	}
//	
//	Movie_Count = 3
//	
//	while(Movie_Count == Segment_8_movies_count) {
//		String xpath = WebUI.callTestCase(findTestCase('Test Cases/Seat Selection/Get Movies Row Xpath'),
//			[('Movie_Count'):Movie_Count,('Segment'):15],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		String D = WebUI.callTestCase(findTestCase('Test Cases/Core/Get Any Attribute of any Element using xpath'),
//			[('xpath'):xpath,('attrr'):"data-balloon"],
//			FailureHandling.STOP_ON_FAILURE)
//		
//		WebUI.comment("______ "+D)
//		
//		if(D == dreamers_text) {
//			Dreamer = true
//		}
//		
//		Movie_Count++
//	}
}

