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

WebUI.callTestCase(findTestCase('Test Cases/VISA Payment/Lookups/Select VISA Payment Option'), null,
	FailureHandling.STOP_ON_FAILURE)

boolean Alertpresent = false

boolean Cancel_btn_Visible = true

while(Cancel_btn_Visible == true) {	
	WebUI.callTestCase(findTestCase('Test Cases/VISA Payment/Lookups/Click on Cancel btn'), null,
		FailureHandling.OPTIONAL)
	
	Alertpresent = WebUI.waitForAlert(10)

	if(Alertpresent == true) {
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
	}
	
	Cancel_btn_Visible = WebUI.callTestCase(findTestCase('Test Cases/VISA Payment/Lookups/Verify Cancel btn Present'), null,
		FailureHandling.OPTIONAL)
}