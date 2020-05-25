package requestexecution

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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

import org.openqa.selenium.WebDriver


import internal.GlobalVariable

public class reviewfilters {
	private TestObject clickexecution=findTestObject('Object Repository/Request Execution/clickexecution')
	private TestObject review=findTestObject('Object Repository/Request Execution/Review menu')
	private TestObject search=findTestObject('Object Repository/Request Execution/Review option/search')
	private TestObject showcomplete=findTestObject('Object Repository/Request Execution/Review option/show completed')
	private TestObject expand=findTestObject('Object Repository/Request Execution/Review option/Expand')
	private TestObject collapse=findTestObject('Object Repository/Request Execution/Review option/collapse')

	//check grid
	private TestObject clicknotes=findTestObject('Object Repository/Request Execution/Review option/clicknotes')
	private TestObject complete1=findTestObject('Request Execution/Review option/complete1')
	private TestObject edit=findTestObject('Object Repository/Request Execution/Review option/clickedit')
	private TestObject settext=findTestObject('Object Repository/Request Execution/Review option/settext')
	private TestObject update=findTestObject('Object Repository/Request Execution/Review option/update')
	private TestObject cancel=findTestObject('Object Repository/Request Execution/Review option/cancel')
	private TestObject clicknotes2=findTestObject('Object Repository/Request Execution/Review option/clicknotes2')
	private TestObject postpone=findTestObject('Object Repository/Request Execution/Review option/postpone')
	private TestObject done=findTestObject('Object Repository/Request Execution/Review option/Done')
	//check grid priority
	private TestObject clickpriority=findTestObject('Object Repository/Request Execution/Review option/priority/clickpriority')
	private TestObject priority=findTestObject('Object Repository/Request Execution/Review option/priority/choose priority')
	private TestObject save=findTestObject('Object Repository/Request Execution/Review option/priority/save')
	//check grid date
	private TestObject clickdate=findTestObject('Object Repository/Request Execution/Review option/Grid Date/click date')
	private TestObject date=findTestObject('Object Repository/Request Execution/Review option/Grid Date/choose date')
	//check grid assigned
	private TestObject clickassigned=findTestObject('Object Repository/Request Execution/Review option/Gird assigned to/click assigned to')
	private TestObject assigned=findTestObject('Object Repository/Request Execution/Review option/Gird assigned to/chooseassigned')
	private TestObject viewpriority=findTestObject('Object Repository/Request Execution/Review option/viewpriority')
	private TestObject viewassigned=findTestObject('Object Repository/Request Execution/Viewbyassignedto')
	//view by
	private TestObject outlook=findTestObject('Object Repository/Request Execution/Review option/View by/outlook')
	private TestObject assignedto=findTestObject('Object Repository/Request Execution/Review option/View by/assigned to')
	private TestObject priority1=findTestObject('Object Repository/Request Execution/Review option/View by/priority')

	@Keyword
	def filterreviewoption(){
		WebUI.click(clickexecution)
		WebUI.click(review)

		WebDriver driver = DriverFactory.getWebDriver()
		Select at = new Select(driver.findElement(By.xpath('//*[@id="rflt-slt-Assignto"]')))
		at.selectByIndex(2);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="rflt-slt-priority"]')))
		pt.selectByIndex(2);
		WebUI.click(search)
	}
	@Keyword
	def assignedbyfilter(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebDriver driver = DriverFactory.getWebDriver()
		Select ab = new Select(driver.findElement(By.xpath('//*[@id="rflt-slt-Assignby"]')))
		ab.selectByIndex(2);
		WebUI.click(search)
	}
	@Keyword
	def assignedtofilter(){
		WebUI.click(clickexecution)
		WebUI.click(review)

		WebDriver driver = DriverFactory.getWebDriver()
		Select at = new Select(driver.findElement(By.xpath('//*[@id="rflt-slt-Assignto"]')))
		at.selectByIndex(2);
		WebUI.click(search)
	}
	@Keyword
	def priorityfilter(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebDriver driver = DriverFactory.getWebDriver()
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="rflt-slt-priority"]')))
		pt.selectByIndex(2);
		WebUI.click(search)
	}
	@Keyword
	def datefilter(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebDriver driver = DriverFactory.getWebDriver()
		KeywordLogger log = new KeywordLogger()
		for(int i=2;i<=10;i++)
		{

			WebElement field = driver.findElement(By.xpath('//*[@id="rfilter-date-range-followup"]')).click();

			WebElement field1 = driver.findElement(By.xpath('/html/body/div[4]/div[1]/ul/li['+i+']'))
			String Date=field1.getText()
			log.logInfo(Date );
			field1.click()
		}
	}
	@Keyword
	def showcompletedfilter(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(showcomplete)
	}
	@Keyword
	def searchfilter(){
		WebUI.click(clickexecution)
		WebUI.click(review)

		WebDriver driver = DriverFactory.getWebDriver()
		Select at = new Select(driver.findElement(By.xpath('//*[@id="rflt-slt-Assignto"]')))
		at.selectByIndex(2);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="rflt-slt-priority"]')))
		pt.selectByIndex(2);
		WebUI.click(search)
	}
	@Keyword
	def typefilter(){
		WebUI.click(clickexecution)
		WebUI.click(review)

		WebDriver driver = DriverFactory.getWebDriver()
		Select tp = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-Type"]')))
		tp.selectByIndex(2);
		WebUI.click(search)

	}
	@Keyword
	def completeoption(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(clicknotes)
		//WebUI.click(complete1)
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement field1=driver.findElement(By.xpath('//*[@id="table1"]/tbody[1]/tr[2]/td/div/div[1]/div[1]/a')).click()
	}


	@Keyword
	def editoption(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(settext, 'ADMIN')
		WebUI.click(update)

	}
	@Keyword
	def canceloption(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.delay(2)
		WebUI.click(clicknotes)
		WebUI.click(cancel)
	}
	@Keyword
	def postponeoption(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	@Keyword
	def priorityoption(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(clickpriority)
		WebUI.click(priority)
	}
	@Keyword
	def daterangeoption(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(clickdate)
		WebUI.click(date)
	}
	@Keyword
	def assignedto(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(clickassigned)
		WebUI.click(assigned)

	}
	@Keyword
	def viewoutlookcomplete(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(outlook)
		WebUI.click(clicknotes)
		WebUI.click(complete1)
	}
	@Keyword
	def viewoutlookedit(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(outlook)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(settext, 'ADMIN')
		WebUI.click(update)
	}
	@Keyword
	def viewoutlookcancel(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(outlook)
		WebUI.delay(2)
		WebUI.click(clicknotes)
		WebUI.click(cancel)
	}
	@Keyword
	def viewoutlookpostpone(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(outlook)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	@Keyword
	def viewoutlookexpnadcollapse(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(outlook)
		WebUI.click(expand)
		WebUI.click(collapse)
	}
	@Keyword
	def viewassignedcomplete(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(assignedto)
		WebUI.click(clicknotes)
		WebUI.click(complete1)
	}
	@Keyword
	def viewassignededit(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(assignedto)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(settext, 'ADMIN')
		WebUI.click(update)
	}
	@Keyword
	def viewassignedcancel(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(outlook)
		WebUI.delay(2)
		WebUI.click(clicknotes)
		WebUI.click(cancel)
	}
	@Keyword
	def viewassignedtokpostpone(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(assignedto)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	@Keyword
	def viewassignexpandcollapse(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(assignedto)
		WebUI.click(expand)
		WebUI.click(collapse)
	}
	@Keyword
	def viewprioritycomplete(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(priority1)
		WebUI.click(clicknotes)
		WebUI.click(complete1)
	}
	@Keyword
	def viewpriorityedit(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(priority1)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(settext, 'ADMIN1')
		WebUI.click(update)
	}
	@Keyword
	def viewprioritycancel(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(priority1)
		WebUI.delay(2)
		WebUI.click(clicknotes)
		WebUI.click(cancel)
	}
	@Keyword
	def viewprioritypostpone(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(priority1)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	@Keyword
	def viewpriorityexpandcollapse(){
		WebUI.click(clickexecution)
		WebUI.click(review)
		WebUI.click(priority1)
		WebUI.click(expand)
		WebUI.click(collapse)
	}


}

