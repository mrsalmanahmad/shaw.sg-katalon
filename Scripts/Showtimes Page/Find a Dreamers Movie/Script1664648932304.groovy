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

String segment_1 = '//*[@id="moviesDiv"]/div[1]/div/div[2]/div/a'
String segment_2 = '//*[@id="moviesDiv"]/div[3]/div/div[2]/div[1]/a'
String segment_3 = '//*[@id="moviesDiv"]/div[5]/div/div[2]/div[1]/a'
String segment_4 = '//*[@id="moviesDiv"]/div[7]/div/div[2]/div/a'
String segment_5 = '//*[@id="moviesDiv"]/div[9]/div/div[2]/div[1]/a'
String segment_6 = '//*[@id="moviesDiv"]/div[11]/div/div[2]/div[1]/a'
String segment_7 = '//*[@id="moviesDiv"]/div[13]/div/div[2]/div[1]/a'
String segment_8 = '//*[@id="moviesDiv"]/div[15]/div/div[2]/div[1]/a'
