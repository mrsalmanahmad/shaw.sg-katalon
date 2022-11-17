package custom.com

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.util.ObservableList.ElementAddedEvent

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Point
import org.openqa.selenium.interactions.Actions
import java.util.concurrent.TimeUnit;
import java.util.*;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.Select;
import java.io.*
import internal.GlobalVariable
import org.openqa.selenium.Alert;

public class pk {

	@Keyword
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		System.out.println('File we are going to search is '+fileName)
		File[] dirContents = dir.listFiles();
		String lastAttempt = "";
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				System.out.println(dirContents[i])
				if (dirContents[i].getName().contains(fileName)) {
					System.out.println('Yey I found the file')
					System.out.println(dirContents[i])
					// File has been found, it can now be deleted:
					dirContents[i].delete();
					//KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					return true;
				}
				lastAttempt = dirContents[i].getName().contains(fileName);
			}
			if (lastAttempt != fileName) {
				//KeywordUtil.markFailed(fileName + 'does not exist in' + downloadPath)
				return false;
			}
		}
		return false;
	}

	@Keyword
	public boolean isFileDownloaded_1(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		System.out.println('File we are going to search is '+fileName)
		File[] dirContents = dir.listFiles();
		String lastAttempt = "";
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				System.out.println(dirContents[i])
				if (dirContents[i].getName().equals(fileName)) {
					System.out.println('Yey I found the file')
					System.out.println(dirContents[i])
					// File has been found, it can now be deleted:
					dirContents[i].delete();
					//KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					return true;
				}
				lastAttempt = dirContents[i].getName().contains(fileName);
			}
			if (lastAttempt != fileName) {
				//KeywordUtil.markFailed(fileName + 'does not exist in' + downloadPath)
				return false;
			}
		}
		return false;
	}

	@Keyword
	public boolean DeleteFile(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		System.out.println('File we are going to search is '+fileName)
		File[] dirContents = dir.listFiles();
		String lastAttempt = "";
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				System.out.println(dirContents[i])
				if (dirContents[i].getName().contains(fileName)) {
					System.out.println('Yey I found the file')
					System.out.println(dirContents[i])
					// File has been found, it can now be deleted:
					dirContents[i].delete();
					//KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					return true;
				}
				lastAttempt = dirContents[i].getName().contains(fileName);
			}
			if (lastAttempt != fileName) {
				//KeywordUtil.markFailed(fileName + 'does not exist in' + downloadPath)
				return false;
			}
		}
		return false;
	}

	@Keyword
	public boolean CheckFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		System.out.println('File we are going to search is '+fileName)
		File[] dirContents = dir.listFiles();
		String lastAttempt = "";
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				System.out.println(dirContents[i])
				if (dirContents[i].getName().contains(fileName)) {
					System.out.println('Yey I found the file')
					System.out.println(dirContents[i])
					// File has been found, it can now be deleted:
					//dirContents[i].delete();
					//KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					return true;
				}
				lastAttempt = dirContents[i].getName().contains(fileName);
			}
			if (lastAttempt != fileName) {
				//KeywordUtil.markFailed(fileName + 'does not exist in' + downloadPath)
				return false;
			}
		}
		return false;
	}


	/* Check the file from a specific directory with extension */
	@Keyword
	def isFileDownloaded_Ext(String dirPath, String ext, String FileName){
		boolean flag=false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if(files[i].getName().contains(ext) && files[i].getName().contains(FileName)) {
				System.out.println(files[i].getName())
				flag=true;
			}
		}
		return flag;
	}

	/* Get the latest file from a specific directory*/
	@Keyword
	def File getLatestFilefromDir(String dirPath,String filename){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified() && files[i].getName().contains(filename)) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	/* Check the file from a specific directory with extension latest */
	@Keyword
	def isFileDownloadedLatest_Ext(String dirPath, String ext, String filename){
		boolean flag=false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified() && files[i].getName().contains(ext) && files[i].getName().contain(filename)) {
				flag=true;
			}
		}

		return flag;
	}

	@Keyword
	def GetAbsPath(String AbsPath) {
		File f = new File(AbsPath)
		String absolute = f.getAbsolutePath()
		return absolute
	}

	@Keyword
	def GetFileName(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		String lastAttempt = "";
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().contains(fileName)) {
					// File has been found, it can now be deleted:
					//dirContents[i].delete();
					//KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					String filename = dirContents[i].getName()
					return filename;
				}
				lastAttempt = dirContents[i].getName().contains(fileName);
			}
			if (lastAttempt != fileName) {
				//KeywordUtil.markFailed(fileName + 'does not exist in' + downloadPath)
				return false;
			}
		}
		return false;
	}

	@Keyword
	def WaitforFileDownload(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		String lastAttempt = "";
		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().contains(fileName)) {
					// File has been found, it can now be deleted:
					//dirContents[i].delete();
					//KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					String filename = dirContents[i].getName()
					return true
				}
				lastAttempt = dirContents[i].getName().contains(fileName);
			}
			if (lastAttempt != fileName) {
				//KeywordUtil.markFailed(fileName + 'does not exist in' + downloadPath)
				return false;
			}
		}
		return false;
	}

	@Keyword
	def GlobalEnv() {
		String demo = 'https://pocketfactory-demo.quantis.ai/'
		String qa = 'https://pocketfactory-prodqa.quantis.ai/PocketFactory/Account/LogOn?ReturnUrl=%2FPocketFactory%2F'
		String uat = 'https://pocketfactory-uat.quantis.ai/PocketFactory/Account/LogOn?ReturnUrl=%2FPocketFactory%2F'
		String global = GlobalVariable.URL
		if(global == demo) {
			return 'Demo'
		}
		else if(global == qa) {
			return 'QA'
		}
		else if(global == uat) {
			return 'UAT'
		}
	}

	@Keyword
	def GetTableRows() {
		WebDriver driver = DriverFactory.getWebDriver()
		'Expected value from Table'
		String ExpectedValue = "Pay Talk";
		'To locate table'
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
		'To locate rows of table it will Capture all the rows available in the table'
		List < WebElement > rows_table = Table.findElements(By.tagName('tr'))
		'To calculate no of rows In table'
		int rows_count = rows_table.size()

		'Loop will execute for all the rows of the table'
		Loop:
		for (int row = 0; row < rows_count; row++) {
			'To locate columns(cells) of that specific row'
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				'It will retrieve text from each cell'
				String celltext = Columns_row.get(column).getText()

				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)

				'Checking if Cell text is matching with the expected value'
				if (celltext == ExpectedValue) {
					'Getting the Country Name if cell text i.e Company name matches with Expected value'
					println('Text present in row number 3 is: ' + Columns_row.get(2).getText())

					'After getting the Expected value from Table we will Terminate the loop'
					break Loop;
				}
			}
			return [rows_count, columns_count];
		}
	}

	@Keyword
	def GetTableRows2() {
		WebDriver driver = DriverFactory.getWebDriver()
		'Expected value from Table'
		String ExpectedValue = "Pay Talk";
		'To locate table'
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
		'To locate rows of table it will Capture all the rows available in the table'
		List < WebElement > rows_table = Table.findElements(By.tagName('tr'))
		'To calculate no of rows In table'
		int rows_count = rows_table.size()

		'Loop will execute for all the rows of the table'
		Loop:
		for (int row = 0; row < rows_count; row++) {
			'To locate columns(cells) of that specific row'
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				'It will retrieve text from each cell'
				String celltext = Columns_row.get(column).getText()

				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)

				'Checking if Cell text is matching with the expected value'
				if (celltext == ExpectedValue) {
					'Getting the Country Name if cell text i.e Company name matches with Expected value'
					println('Text present in row number 3 is: ' + Columns_row.get(2).getText())

					'After getting the Expected value from Table we will Terminate the loop'
					break Loop;
				}
			}
			return rows_count;
		}
	}

	@Keyword
	def SearchTableText(ExpectedVal) {
		WebDriver driver = DriverFactory.getWebDriver()
		'Expected value from Table'
		String ExpectedValue = ExpectedVal;
		'To locate table'
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
		'To locate rows of table it will Capture all the rows available in the table'
		List < WebElement > rows_table = Table.findElements(By.tagName('tr'))
		'To calculate no of rows In table'
		int rows_count = rows_table.size()

		'Loop will execute for all the rows of the table'
		Loop:
		for (int row = 0; row < rows_count; row++) {
			'To locate columns(cells) of that specific row'
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				'It will retrieve text from each cell'
				String celltext = Columns_row.get(column).getText()

				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)

				'Checking if Cell text is matching with the expected value'
				if (celltext == ExpectedValue) {
					'Getting the Country Name if cell text i.e Company name matches with Expected value'
					println('Text present in row number is: ' + Columns_row.get(2).getText())

					'After getting the Expected value from Table we will Terminate the loop'
					break Loop;
				}
			}
			return rows_count;
		}
	}

	@Keyword
	def GetValidationsRunsTableData() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"ValidationsGrid\"]/tbody"))

		List<WebElement> rowelements = driver.findElements(By.xpath('//*[@id="ValidationsGrid"]/tbody/tr'))
		System.out.println(rowelements.size())
		int rowsize = rowelements.size();

		List<WebElement> colelements = driver.findElements(By.xpath('//*[@id="ValidationsGrid"]/tbody/tr[1]/td'))
		System.out.println(colelements.size())
		int colsize = colelements.size();


		for(int i=1;i<=rowsize;i++) {
			for(int j=1;j<=colsize;j++) {
				System.out.println(driver.findElement(By.xpath('//*[@id="ValidationsGrid"]/tbody/tr['+ i +']/td['+ j +']')).getText())
			}
		}
		return [rowsize, colsize]
	}


	@Keyword
	def GetTableHeaders(TableName) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
		List < WebElement > rows_table = Table.findElements(By.tagName('tr'))
		List<WebElement> colelements = driver.findElements(By.xpath('//*[@id="ValidationsGrid"]/tbody/tr[1]/td'))
		System.out.println(colelements.size())
		int colsize = colelements.size()
		int i = 1
		String col_text = ''
		ArrayList<String> arr = new ArrayList<Integer>(colsize)
		Loop:
		for (int row = 0; row < colsize; row++) {
			//*[@id="ValidationsGrid_headers"]/thead/tr/th[1]
			col_text = driver.findElement(By.xpath('//*[@id="ValidationsGrid_headers"]/thead/tr/th['+i+']')).getText()
			arr.add(col_text)
			System.out.println('Element '+i+ driver.findElement(By.xpath('//*[@id="ValidationsGrid_headers"]/thead/tr/th['+i+']')).getText())
			i++
		}
		for(int j=1;j<arr.size();j++) {
			if(TableName == arr[j]) {
				return j-1
			}
			println(arr[j])
		}
	}

	@Keyword
	def RulesTable() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"RulesGrid\"]/tbody"))

		List<WebElement> rowelements = driver.findElements(By.xpath('//*[@id="RulesGrid"]/tbody/tr'))
		System.out.println(rowelements.size())
		int rowsize = rowelements.size();

		List<WebElement> colelements = driver.findElements(By.xpath('//*[@id="RulesGrid"]/tbody/tr[1]/td'))
		System.out.println(colelements.size())
		int colsize = colelements.size();

		for(int i=1;i<=rowsize;i++) {
			for(int j=1;j<=colsize;j++) {
				System.out.println(driver.findElement(By.xpath('//*[@id="RulesGrid"]/tbody/tr['+ i +']/td['+ j +']')).getText())
			}
		}

		return false;
	}

	@Keyword
	def RulesTable2(ExpectedVal) {
		WebDriver driver = DriverFactory.getWebDriver()
		String ExpectedValue = ExpectedVal;
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
		List < WebElement > rows_table = Table.findElements(By.tagName('tr'))
		int rows_count = rows_table.size()

		ArrayList<Integer> arr = new ArrayList<Integer>(100);
		List<WebElement> searchTextBoxes = driver.findElements(By.className("ui-igcheckbox-container"))
		for(WebElement searchTextBox : searchTextBoxes){
			String typeValue2 = searchTextBox.getAttribute("aria-checked")
			arr.add(typeValue2)
			System.out.println("Value of type attribute: "+typeValue2)
		}

		Hashtable<Integer,String[]> ht = new Hashtable<>()
		int arrsize = arr.size()
		int isActive1 = 0
		int ExcludedFQ1 = 1

		for(int i=0;i<arrsize/2;i++) {
			ht.put(i,[arr.get(isActive1), arr.get(ExcludedFQ1)])
			isActive1 += 2
			ExcludedFQ1 += 2
		}
		System.out.println(ht);

		// Add elements to the hashtable
		//		ht.put(1,[arr.get(0),arr.get(1)])
		//		ht.put(2,[arr.get(2),arr.get(3)])
		//		ht.put(3,[arr.get(4),arr.get(5)])

		// Print size and content
		//		System.out.println("Size of map is:- " + ht.size());
		//		System.out.println(ht);

		// Check if a key is present and if
		// present, print value
		//if (ht.containsKey("vishal")) {
		//			String a = ht.get(1);
		//			System.out.println("value for key"+ " \"row\" is:- " + a);
		//}

		int index = 0
		int index_1 = 0
		Loop:
		for (int row = 0; row < rows_count; row++) {
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('td'))
			int columns_count = Columns_row.size()
			println((('Number of cells In Row ' + row) + ' are ') + columns_count)


			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)
				if (celltext == ExpectedValue) {
					println('***********************Celltext is '+celltext+' in column number '+column)
					println('Text present in row number is: ' + Columns_row.get(column).getText())
					String searched_text = Columns_row.get(column).getText()
					//boolean isActive = Columns_row.get(1).getText()

					List<String> a = ht.get(row)
					System.out.println("Value for key"+ " \"row\" is:- " + a[1])

					index = row + 1
					index_1 = index + 1
					String active_status = a[0]
					String Quality_status = a[1]

					System.out.println("Value of type attribute isActive status at index: "+index+' with status '+active_status+' at row number '+row)
					System.out.println("Value of type attribute Quality status at index: "+index_1+' with status '+Quality_status+' at row number '+row)
					WebElement searchTextBox2= driver.findElement(By.xpath('//*[@id="RulesGrid"]/tbody/tr['+ index  +']'))
					//retrieving html attribute value using getAttribute() method
					String Id=searchTextBox2.getAttribute("data-id")
					System.out.println("Value of data id: "+Id)

					int current_xpath = row+1
					System.out.println('OutPut is ********'+'SearchText '+searched_text+' '+'ActiveStatus '+active_status+' '+'CurrentXpath '+current_xpath+' '+'Id '+Id+' '+'QualityStatus '+Quality_status)
					return [searched_text, active_status , current_xpath, Id, Quality_status]
					break Loop;
				}
			}
		}
	}

	@Keyword
	def SearchValidationRunsTable(ExpectedVal,statusid) {
		WebDriver driver = DriverFactory.getWebDriver()
		String ExpectedValue = ExpectedVal;
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))
		List < WebElement > rows_table = Table.findElements(By.tagName('tr'))
		int rows_count = rows_table.size()
		//String statusid = colid.orElse(5)
		Loop:
		for (int row = 0; row < rows_count; row++) {
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('td'))
			int columns_count = Columns_row.size()
			println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)
				if (celltext == ExpectedValue) {
					println('Text present in row number is: ' + Columns_row.get(column).getText())
					String searched_text = Columns_row.get(column).getText()
					String status = Columns_row.get(statusid).getText()
					int current_xpath = row+1
					println('Status is: ' + status)
					return [searched_text, status, current_xpath];
					break Loop;
				}
			}
		}
	}
	@Keyword
	def HoverAndClick(xpath) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(xpath))

		Actions actions = new Actions(driver)
		actions.moveToElement(element)
		actions.perform()
		element.click()
	}

	@Keyword
	def GetXYPostionClick(xpath,Action) {
		sleep(3000);
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(xpath));
		Point location = element.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("Coordinates of an element is : " + x + " and " + y);
		WebElement element2 = driver.findElement(By.xpath(xpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(element2);
		actions.perform();
		//actions.contextClick(element2).perform();
		WebElement ele = driver.findElement(By.xpath('//*[@id="rowAction_editAction"]'))
		actions.moveToElement(ele)
		actions.perform()

		if(Action == 'Activate_Rule') {
			// Click on Activate button
			WebElement activate = driver.findElement(By.xpath('//*[@id="rowAction_activateAction"]'))
			activate.click()
			sleep(2000)
			driver.findElement(By.xpath("//*[text()='Yes']")).click()
		}
		else if (Action == 'DeActivate_Rule') {
			// Click on DeActivate button
			WebElement activate = driver.findElement(By.xpath('//*[@id="rowAction_deactivateAction"]'));
			activate.click()
			sleep(2000);
			driver.findElement(By.xpath("//*[text()='Yes']")).click()
		}
		else if(Action == 'Delete') {
			// Click on Delete button
			WebElement activate = driver.findElement(By.xpath('//*[@id="rowAction_deleteAction"]'));
			activate.click()
			sleep(2000);
			driver.findElement(By.xpath("//*[text()='Yes']")).click()
		}
		else if(Action == 'Exclude From Quality') {
			// Click on Exclude From Quality button
			//*[@id="rowAction_includeAction"]
			WebElement activate = driver.findElement(By.xpath('//*[@id="rowAction_excludeAction"]'));
			activate.click()
			sleep(2000);
			driver.findElement(By.xpath("//*[text()='Yes']")).click()
		}
		else if(Action == 'Include in Quality') {
			// Click on Include in Quality button

			WebElement activate = driver.findElement(By.xpath('//*[@id="rowAction_includeAction"]'));
			actions.moveToElement(activate)
			sleep(1000)
			activate.click()
			sleep(2000);
			driver.findElement(By.xpath("//*[text()='Yes']")).click()
		}

		else if(Action == 'Include in Quality') {
			// Click on Include in Quality button

			WebElement activate = driver.findElement(By.xpath('//*[@id="rowAction_includeAction"]'));
			actions.moveToElement(activate)
			sleep(1000)
			activate.click()
			sleep(2000);
			driver.findElement(By.xpath("//*[text()='Yes']")).click()
		}

		else if(Action == 'Edit') {
			// Click on Edit Button
			WebElement activate = driver.findElement(By.xpath('//*[@id="rowAction_editAction"]'));
			activate.click()
			sleep(2000);
		}

		else if(Action == 'Click on PETLINE HS DIETLIKON') {
			driver.findElement(By.xpath("//*[text()='PET LINE HS DIETLIKON'']")).click()
		}
		return [x, y]
	}

	@Keyword
	def GetDownloadPath(Env) {
		String OfficeMachine = 'C:\\Users\\salman.ahmad\\Downloads'
		String MyhomeMachine = 'C:\\Users\\Sulman\\Downloads'
		return OfficeMachine
	}

	@Keyword
	def ClickonAnyElementUsingXpath(xpath) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement activate = driver.findElement(By.xpath(xpath));
		activate.click()
	}

	@Keyword
	def GetImportPath(Env) {
		String OfficeMachine = ''
		String MyhomeMachine = 'C:\\Users\\Sulman\\Downloads'
		if(Env=='UAT') {
			OfficeMachine = 'C:\\Users\\salman.ahmad\\Downloads\\UAT Import Files\\'
		}
		else if(Env =='QA') {
			OfficeMachine = 'C:\\Users\\salman.ahmad\\Downloads\\QA Import Files\\'
		}
		return OfficeMachine
	}

	@Keyword
	def GetAnyAttributeofanyElement(xpath,attribute) {
		WebDriver driver = DriverFactory.getWebDriver()
		ArrayList<Integer> arr = new ArrayList<Integer>(1);
		List<WebElement> searchTextBoxes = driver.findElements(By.xpath(xpath))
		for(WebElement searchTextBox : searchTextBoxes){
			String typeValue2 = searchTextBox.getAttribute(attribute)
			arr.add(typeValue2)
			System.out.println("Value of type attribute: "+typeValue2)
			return arr.get(0)
		}
	}

	@Keyword
	def GetDashboardTable(exp) {
		WebDriver driver = DriverFactory.getWebDriver()
		String ExpectedValue = exp
		WebElement Table = driver.findElement(By.xpath("//table/tbody"))

		List < WebElement > rows_table = Table.findElements(By.tagName('tr'))

		int rows_count = rows_table.size()
		Loop:
		for (int row = 0; row < rows_count; row++) {

			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			int columns_count = Columns_row.size()

			println((('Number of cells In Row ' + row) + ' are ') + columns_count)
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)
				if (celltext == ExpectedValue) {
					println('Text present is: ' + Columns_row.get(column).getText())
					return ExpectedValue
					break Loop;
				}
			}
			return ExpectedValue
		}
	}

	@Keyword
	def GetElementsByClassName(classname,ExpectedVal) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.className(classname))
		for(WebElement searchText : elements){
			String text = searchText.getText()
			System.out.println("Value of type attribute: "+text)
			if(text == ExpectedVal) {
				System.out.println("Yeyy I found the value: "+text)
				return text
			}
		}
	}

	@Keyword
	def GetListItems(xpath) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath(xpath))

		List < WebElement > rows_table = Table.findElements(By.tagName('li'))

		int rows_count = rows_table.size()
		Loop:
		for (int row = 0; row < rows_count; row++) {

			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName('a'))

			int columns_count = Columns_row.size()

			println((('Number of cells In Row ' + row) + ' are ') + columns_count)
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)
				//				if (celltext == ExpectedValue) {
				//					println('Text present is: ' + Columns_row.get(column).getText())
				//					return ExpectedValue
				//					break Loop;
				//				}
			}
			//return ExpectedValue
		}
	}

	@Keyword
	def ClickbyXpath(xpath) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Ele = driver.findElement(By.xpath(xpath))
		Actions actions = new Actions(driver);
		actions.moveToElement(Ele);
		actions.perform()
		sleep(1000)
		Ele.click()
		//Ele.click()
	}

	@Keyword
	def GetElementsId(classname,attrr) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Ele = driver.findElement(By.className(classname))
		String eleid = Ele.getAttribute(attrr)
		return eleid
	}

	@Keyword
	def GetNumberOfElementsByClassName(classname,attrr) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.className(classname))
		String eleid = ''
		int size = elements.size()
		return size
	}

	@Keyword
	def GetAttrrOfEleById(id,attrr) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.id(id))
		String prop = element.getProperties()
		print(prop)
		String eleid = element.getAttribute(attrr)
		return eleid
	}

	@Keyword
	def GetDropDownListValues(Option,xpath='',KPICorrelation) {
		WebDriver driver = DriverFactory.getWebDriver()
		if(KPICorrelation == true) {
			String Fullxpath = '//*[@id="'+xpath+'_kpi_div"]/div/div[1]/div[2]/div'
			List<WebElement> rowelements = driver.findElements(By.xpath(Fullxpath))
			System.out.println(rowelements.size())
			int rowsize = rowelements.size();

			Loop:
			for(int i=1;i<=rowsize;i++) {
				System.out.println(driver.findElement(By.xpath('//*[@id="'+xpath+'_kpi_div"]/div/div[1]/div[2]/div['+i+']')).getText())
				String optionval = driver.findElement(By.xpath('//*[@id="'+xpath+'_kpi_div"]/div/div[1]/div[2]/div['+i+']')).getText()
				if(Option == optionval) {
					WebElement tickoption = driver.findElement(By.xpath('//*[@id="'+xpath+'_kpi_div"]/div/div[1]/div[2]/div['+i+']'))
					tickoption.click()
					break Loop
				}
			}
		}
		else if(KPICorrelation == false) {
			List<WebElement> rowelements = driver.findElements(By.xpath('//*[@id="tab2"]/div/div[1]/div/div[1]/div[2]/div'))
			System.out.println(rowelements.size())
			int rowsize = rowelements.size();

			Loop:
			for(int i=1;i<=rowsize;i++) {
				System.out.println(driver.findElement(By.xpath('//*[@id="tab2"]/div/div[1]/div/div[1]/div[2]/div['+ i +']')).getText())
				String optionval = driver.findElement(By.xpath('//*[@id="tab2"]/div/div[1]/div/div[1]/div[2]/div['+ i +']')).getText()
				if(Option == optionval) {
					WebElement tickoption = driver.findElement(By.xpath('//*[@id="tab2"]/div/div[1]/div/div[1]/div[2]/div['+i+']/label/input'))
					tickoption.click()
					break Loop
				}
			}
		}
	}

	// This is a duplicate function previous function was depricated due to xpath changed i just kept previous function for future examples
	@Keyword
	def GetDropDownListValues2(Option,xpathval='',KPICorrelation,Gauge,boolean Customdiv,int Customdivval,boolean BarChart=false) {
		WebDriver driver = DriverFactory.getWebDriver()
		if(KPICorrelation == true && Gauge == false) {
			//html/body/div[12]/div/ul/li[9]
			String Fullxpath = '/html/body/div[11]/div/ul/li'
			List<WebElement> rowelements = driver.findElements(By.xpath(Fullxpath))
			System.out.println(rowelements.size())
			int rowsize = rowelements.size();

			Loop:
			for(int i=1;i<=rowsize;i++) {
				System.out.println(driver.findElement(By.xpath('/html/body/div[11]/div/ul/li['+i+']')).getText())
				String optionval = driver.findElement(By.xpath('/html/body/div[11]/div/ul/li['+i+']')).getText()
				if(Option == optionval) {
					WebElement tickoption = driver.findElement(By.xpath('/html/body/div[11]/div/ul/li['+i+']'))
					tickoption.click()
					break Loop
				}
			}
		}
		else if(KPICorrelation == false && Gauge == false) {
			List<WebElement> rowelements = driver.findElements(By.xpath('/html/body/div[12]/div/ul/li'))
			System.out.println(rowelements.size())
			int rowsize = rowelements.size();

			Loop:
			for(int i=1;i<=rowsize;i++) {
				System.out.println(driver.findElement(By.xpath('/html/body/div[12]/div/ul/li['+i+']')).getText())
				String optionval = driver.findElement(By.xpath('/html/body/div[12]/div/ul/li['+i+']')).getText()
				if(Option == optionval) {
					WebElement tickoption = driver.findElement(By.xpath('/html/body/div[12]/div/ul/li['+i+']'))
					tickoption.click()
					break Loop
				}
			}
		}
		else if(Gauge == true && KPICorrelation == false) {
			List<WebElement> rowelements = driver.findElements(By.xpath('/html/body/div[10]/div/ul/li'))
			System.out.println(rowelements.size())
			int rowsize = rowelements.size();

			Loop:
			for(int i=1;i<=rowsize;i++) {
				System.out.println(driver.findElement(By.xpath('/html/body/div[10]/div/ul/li['+i+']')).getText())
				String optionval = driver.findElement(By.xpath('/html/body/div[10]/div/ul/li['+i+']')).getText()
				if(Option == optionval) {
					WebElement tickoption = driver.findElement(By.xpath('/html/body/div[10]/div/ul/li['+i+']'))
					tickoption.click()
					break Loop
				}
			}
		}
		else if(Customdiv == true) {
			if(BarChart == true) {
				System.out.println('Hello i am here for Bar chart drop values')
				List<WebElement> rowelements = driver.findElements(By.xpath('/html/body/div['+Customdivval+']/div/ul/li/div/span'))
				System.out.println('Size of rows is = : '+ rowelements.size())
				int rowsize = rowelements.size();

				Loop:
				for(int i=1;i<=rowsize;i++) {
					System.out.println(driver.findElement(By.xpath('/html/body/div['+Customdivval+']/div/ul/li['+i+']/div/span')).getText())
					String optionval = driver.findElement(By.xpath('/html/body/div['+Customdivval+']/div/ul/li['+i+']/div/span')).getText()
					if(Option == optionval) {
						WebElement tickoption = driver.findElement(By.xpath('/html/body/div['+Customdivval+']/div/ul/li['+i+']/div/span'))
						tickoption.click()
						break Loop
					}
				}
			}
			else {
				System.out.println('Hello i am here in else')
				List<WebElement> rowelements = driver.findElements(By.xpath('/html/body/div['+Customdivval+']/div/ul/li'))
				System.out.println('Size of rows is = : '+ rowelements.size())
				int rowsize = rowelements.size();

				Loop:
				for(int i=1;i<=rowsize;i++) {
					System.out.println(driver.findElement(By.xpath('/html/body/div['+Customdivval+']/div/ul/li['+i+']/span')).getText())
					String optionval = driver.findElement(By.xpath('/html/body/div['+Customdivval+']/div/ul/li['+i+']/span')).getText()
					if(Option == optionval) {
						WebElement tickoption = driver.findElement(By.xpath('/html/body/div['+Customdivval+']/div/ul/li['+i+']/span'))
						tickoption.click()
						break Loop
					}
				}
			}
		}
	}

	@Keyword
	def GetTextOfElementbyXpath(xpath) {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.xpath(xpath))
		for(WebElement searchText : elements){
			String text = searchText.getText()
			System.out.println("Value of type attribute: "+text)
			return text
		}
	}

	@Keyword
	def SelectLine(xpath,line) {
		WebDriver driver = DriverFactory.getWebDriver()
		println("//*[@id="+xpath+"]/li")
		List<WebElement> frame1 = driver.findElements(By.xpath("//*[@id="+xpath+"]/li"))
		System.out.println(frame1.size())
		int rowsize = frame1.size()
		rowsize = rowsize - 1
		for(int i=1;i<=rowsize;i++) {
			System.out.println(driver.findElement(By.xpath("//*[@id="+xpath+"]/li["+i+"]")).getText())
			String linenames = driver.findElement(By.xpath("//*[@id="+xpath+"]/li["+i+"]")).getText()
			if(linenames == line) {
				WebElement line_name = driver.findElement(By.xpath("//*[@id="+xpath+"]/li["+i+"]"))
				line_name.click()
			}
		}
	}

	@Keyword
	def SetTextOfElementbyXpath(xpath,text) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(xpath))
		element.sendKeys(text)
	}

	@Keyword
	def GetNumberOfElements(xpath) {
		WebDriver driver = DriverFactory.getWebDriver()
		List <WebElement> ele = driver.findElements(By.xpath(xpath))
		int count = ele.size()
		System.out.println("Number of Elements: "+ count)
		return count
	}

	@Keyword
	def ClickbyText(text) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement ele = driver.findElement(By.xpath('//li[contains(text(), "' + text + '")]'))
		ele.click();
	}

	@Keyword
	public static void handleDatepicker(TestObject calender, String exp_Date, String exp_Month,
			String exp_Year)throws Exception{
		String expDate = null, calYear = null,datepickerText=null,minYear=null,maxYear=null;
		int expMonth = 0, expYear = 0;
		WebElement datePicker;
		List<WebElement> noOfDays=null,noOfMonths=null,noOfYears=null;
		boolean dateNotFound = true;
		List<String> monthList = Arrays.asList("None","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec");
		def driver = DriverFactory.getWebDriver()
		WebElement SelectCalender = WebUI.findWebElement(calender, 20);
		//		JavascriptExecutor executor = ((JavascriptExecutor)driver);
		//		executor.executeScript("arguments[0].click();", SelectCalender);
		SelectCalender.click()
		// Set your expected date, month and year.
		expDate = (exp_Date);
		expMonth = Integer.parseInt(exp_Month);
		expYear = Integer.parseInt(exp_Year);

		WebElement datePicker_Heading1 =(driver).findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]"));
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.elementToBeClickable(datePicker_Heading1));
		datePicker_Heading1.click();
		//executor.executeScript("arguments[0].click();", datePicker_Heading1);
		WebElement datePicker_Heading2 =(driver).findElement(By.xpath("//div[@class='datepicker-months']/table/thead/tr[1]/th[2]"));
		//wait.until(ExpectedConditions.elementToBeClickable(datePicker_Heading2));
		datePicker_Heading2.click();

		while (dateNotFound) {
			WebElement datePicker_Heading3 =(driver).findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[2]"));
			//wait.until(ExpectedConditions.visibilityOf(datePicker_Heading3));
			datepickerText =datePicker_Heading3.getText();
			String[] datepickerYear = datepickerText.split("-");
			minYear =datepickerYear[0];
			maxYear = datepickerYear[1];
			// If current selected month and year are same as expected month
			// and year then go Inside this condition.
			if((expYear >= Integer.parseInt(minYear)) && (expYear<=Integer.parseInt(maxYear)))
			{
				datePicker = (driver).findElement(By.xpath("//div[@class='datepicker-years']/table"));
				noOfYears = datePicker.findElements(By.xpath("//span[contains(@class,'year')]"));
				firstloop:
				for (WebElement year : noOfYears) {
					// Select the date from date picker when condition
					// match.
					if (year.getText().equalsIgnoreCase((String)exp_Year)) {
						year.click();
						Thread.sleep(1500);
						datePicker = (driver).findElement(By.xpath("//div[@class='datepicker-months']/table"));
						noOfMonths = datePicker.findElements(By.xpath("//span[@class='month']"));
						Thread.sleep(1000);
						for (WebElement month : noOfMonths) {
							System.out.println(" the expected month in int  is : "+expMonth);
							System.out.println(" the expected month is : "+monthList.get(expMonth));
							System.out.println(" the Actual  month is : "+month.getText());
							if ((monthList.get(expMonth)).equalsIgnoreCase(month.getText())) {
								month.click();
								datePicker = (driver).findElement(By.xpath("//div[@class='datepicker-days']/table"));
								noOfDays = datePicker.findElements(By.xpath("//td[@class='day']"));
								Thread.sleep(1500);
								for (WebElement cell : noOfDays) {
									if (cell.getText().equalsIgnoreCase(expDate)) {
										cell.click();
										break firstloop;
									}
								}
							}
						}
					}
					//					else{
					//
					//						throw new Exception()
					//					}
				}
				dateNotFound = false;
			}else if (expYear > Integer.parseInt(maxYear)) {
				WebElement Next =(driver).findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[@class='next']"));
				if(Next.getAttribute("style").equalsIgnoreCase("visibility: visible;"))
				{// Click on next button of date picker.
					Next.click();
				}
				else {
					throw new Exception("This is exception")
				}
			}
			// If current selected month and year are greater than expected
			// month and year then go Inside this condition.
			else if (expYear < Integer.parseInt(minYear)) {
				WebElement Previous =(driver).findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[1]/th[@class='prev']"));
				if(Previous.getAttribute("style").equalsIgnoreCase("visibility: visible;"))
				{
					// Click on previous button of date picker.
					Previous.click();
				}
				else{
					throw new Exception("This is exception")
				}
			}
		}
	}

	@Keyword
	def CalenderSelection(select_date,xpath)
	{
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver = DriverFactory.getWebDriver()
		// click on date picker so that we can get the calendar in view
		//driver.findElement(By.Xpath("//*[@id="liCalControl"]/input[1]")).click()

		// this will find all matching nodes in calendar
		List<WebElement> allDates = driver.findElements(By.xpath(xpath))

		// now we will iterate all values and will capture the text. We will select when date is 28
		for(WebElement ele:allDates)
		{
			String date=ele.getText();
			println('Text present is: '+ date)
			// once date is 28 then click and break
			if(date.equalsIgnoreCase(select_date))
			{
				ele.click();
				break;
			}
		}
	}


	@Keyword
	def CalenderSelectionSlider(Value,xpath)
	{
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver = DriverFactory.getWebDriver()
		// click on date picker so that we can get the calendar in view
		//driver.findElement(By.Xpath("//*[@id="liCalControl"]/input[1]")).click()

		// this will find all matching nodes in calendar
		List<WebElement> allDates = driver.findElements(By.xpath(xpath))

		WebElement enterPrice = findElement(xpath)

		enterPrice.clear();
		enterPrice.sendKeys(Keys.chord("500000", Keys.TAB));

		//assertTrue(sliderPercent.contains("left: 50"));
	}

	@Keyword
	def AcceptAlert() {
		WebDriver driver = DriverFactory.getWebDriver()
		// This step will result in an alert on screen
		driver.findElement(By.id("alertButton")).click()
		Alert simpleAlert = driver.switchTo().alert()
		simpleAlert.accept()
	}
}
