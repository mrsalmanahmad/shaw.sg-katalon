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

String Add = 'Object Repository/Page_Cart/Add Ons Menu/Lager popcorn add'
String xpath = '//*[@id="concessions_list"]/div[2]/div/div[2]/div/i[2]'
String Add_to_cart_btn = 'Object Repository/Page_Cart/Add Ons Menu/a_Add to cart'

boolean Add_on = WebUI.verifyElementPresent(findTestObject(Add), 10, FailureHandling.OPTIONAL)

if(Add_on == true) {
//	WebUI.scrollToElement(findTestObject(Add), 10, FailureHandling.STOP_ON_FAILURE)
//	WebUI.enableSmartWait()
//	WebUI.click(findTestObject(Add), FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Test Cases/Core/Hover over a btn and click'),
		[('xpath'):xpath],
		FailureHandling.STOP_ON_FAILURE)
	sleep(5000)
	WebUI.click(findTestObject(Add_to_cart_btn), FailureHandling.STOP_ON_FAILURE)
	
	String Add_on_quantity = WebUI.callTestCase(findTestCase('Test Cases/Add Ons Cart Page/Get Selected Addons Value'),
			[:],
			FailureHandling.STOP_ON_FAILURE)
	
	WebUI.verifyEqual("1", Add_on_quantity, FailureHandling.STOP_ON_FAILURE)
}
