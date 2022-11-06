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

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Add Toddler'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Add Kids'), [:],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Continue btn'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent("This family package requires at least one adult and one child/adult.", false)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Toddler'), [:],
	FailureHandling.STOP_ON_FAILURE)

// ADD ADULTS
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Add Adult btn'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.enableSmartWait() 
WebUI.callTestCase(findTestCase('Test Cases/Core/Click by Xpath'), 
	[("xpath"):"/html/body/div[1]/div/div[2]/div[8]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div"],
	FailureHandling.STOP_ON_FAILURE)
WebUI.enableSmartWait()
WebUI.callTestCase(findTestCase('Test Cases/Core/Click by Xpath'), 
	[("xpath"):"/html/body/div[1]/div/div[2]/div[8]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div"],
	FailureHandling.STOP_ON_FAILURE)
WebUI.enableSmartWait()
WebUI.callTestCase(findTestCase('Test Cases/Core/Click by Xpath'), 
	[("xpath"):"/html/body/div[1]/div/div[2]/div[8]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div"],
	FailureHandling.STOP_ON_FAILURE)
WebUI.enableSmartWait()

// ADD KIDS
WebUI.callTestCase(findTestCase('Test Cases/Core/Click by Xpath'), 
	[("xpath"):"/html/body/div[1]/div/div[2]/div[8]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div"],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Core/Click by Xpath'), 
	[("xpath"):"/html/body/div[1]/div/div[2]/div[8]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div"],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Core/Click by Xpath'), 
	[("xpath"):"/html/body/div[1]/div/div[2]/div[8]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div"],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Continue btn'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.verifyTextPresent("You are allowed to select 6 seats only.", false)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Adult'), [:],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Kids'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Kids'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Kids'), [:],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Continue btn'), [:],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Select Again btn'), [:],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Adult'), [:],
	FailureHandling.STOP_ON_FAILURE)
// ADD KID
WebUI.callTestCase(findTestCase('Test Cases/Core/Click by Xpath'),
	[("xpath"):"/html/body/div[1]/div/div[2]/div[8]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div"],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Continue btn'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Select Again btn'), [:],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Adult'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Remove Kids'), [:],
	FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Add Toddler'), [:],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Showtimes Page/Dreamers Movie Selection/Click on Continue btn'), [:],
	FailureHandling.STOP_ON_FAILURE)