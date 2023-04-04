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

String ted = '//*[@id="moviesDiv"]/div[1]/div[6]/div[2]/div/a'
 
 //*[@id="moviesDiv"]/div[1]/div[6]/div[1]/div[1]/div/p[1]/span[1]/span
 
 // Starting movie list xpath //*[@id="moviesDiv"]/div[1]/div[3]/div[2]/div/a
 
 //ted = '//*[@id="moviesDiv"]/div[1]/div['+Movie_Count+']/div[2]/div[1]/a'
 ted = '//*[@id="movieData"]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/a'
 
 ted = '//*[@id="movieData"]/div[2]/div[2]/div[3]/div['+Movie_Count+']/div[2]/div/a'
 
 CustomKeywords.'custom.com.pk.ClickonAnyElementUsingXpath'(ted)