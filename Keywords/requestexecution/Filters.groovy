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




public class Filters {
	private TestObject clickexecution=findTestObject('Object Repository/Request Execution/clickexecution')
	private TestObject search=findTestObject('Object Repository/Request Execution/search')
	private TestObject showcompleted=findTestObject('Object Repository/Request Execution/show only completed')
	private TestObject expandall=findTestObject('Object Repository/Request Execution/expand all')
	private TestObject collapseall=findTestObject('Object Repository/Request Execution/collapse all')
	private TestObject outlook=findTestObject('Object Repository/Request Execution/outlook')
	private TestObject bypriority=findTestObject('Object Repository/Request Execution/bypriority')
	private TestObject assignedto=findTestObject('Object Repository/Request Execution/Assignedto')

	//complete option
	private TestObject clicknotes=findTestObject('Object Repository/Request Execution/grid/clicknotes')
	private TestObject complete=findTestObject('Object Repository/Request Execution/grid/complete')
	private TestObject cancel=findTestObject('Object Repository/Request Execution/grid/cancel')
	//check edit
	private TestObject edit=findTestObject('Object Repository/Request Execution/grid/Edit/clickedit')
	private TestObject followup=findTestObject('Object Repository/Request Execution/grid/Edit/change followup')
	private TestObject update=findTestObject('Object Repository/Request Execution/grid/Edit/Update')
	//postpon
	private TestObject clicknotes2=findTestObject('Object Repository/Request Execution/grid/postpone/clicknotes2')
	private TestObject postpone=findTestObject('Object Repository/Request Execution/grid/postpone/postpone')
	private TestObject done=findTestObject('Object Repository/Request Execution/grid/postpone/done')
	//check grid priority
	private TestObject clickpriority=findTestObject('Object Repository/Request Execution/grid/priority/clickpriority')
	private TestObject clickoption=findTestObject('Object Repository/Request Execution/grid/priority/clickpoption')
	private TestObject clicksave=findTestObject('Object Repository/Request Execution/grid/save')
	//check assigned to
	private TestObject clickassignedto=findTestObject('Object Repository/Request Execution/grid/Assignedto/clickassignedto')
	private TestObject choosename=findTestObject('Object Repository/Request Execution/grid/Assignedto/chooseaname')
	//check date in grid
	private TestObject clickdate=findTestObject('Object Repository/Request Execution/grid/Grid date/click date')
	private TestObject choosedate=findTestObject('Object Repository/Request Execution/grid/Grid date/choosedate')
	//View by outlook
	private TestObject outlookday=findTestObject('Object Repository/Request Execution/outlook day')
	private TestObject viewassigned=findTestObject('Object Repository/Request Execution/Viewbyassignedto')
	private TestObject viewpriority=findTestObject('Object Repository/Request Execution/viewbypriority')
	//check all filters by option
	@Keyword
	def filteroption(){
		WebUI.click(clickexecution)

		WebDriver driver = DriverFactory.getWebDriver()
		Select at = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-Assignto"]')))
		at.selectByIndex(2);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-priority"]')))
		pt.selectByIndex(2);
		WebUI.click(search)
	}
	//check assigned by filter
	@Keyword
	def assignedfilter(){
		WebUI.click(clickexecution)

		WebDriver driver = DriverFactory.getWebDriver()
		Select ab = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-Assignby"]')))
		ab.selectByIndex(2);
		WebUI.click(search)
	}
	//check assignedto filter
	@Keyword
	def assignedto(){
		WebUI.click(clickexecution)

		WebDriver driver = DriverFactory.getWebDriver()
		Select at = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-Assignto"]')))
		at.selectByIndex(2);
		WebUI.click(search)
	}
	//check priority
	@Keyword
	def prioritycheck(){
		WebUI.click(clickexecution)

		WebDriver driver = DriverFactory.getWebDriver()
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-priority"]')))
		pt.selectByIndex(2);
		WebUI.click(search)
	}
	//check date filter
	@Keyword
	def datefilter(){
		WebUI.click(clickexecution)
		WebDriver driver = DriverFactory.getWebDriver()
		KeywordLogger log = new KeywordLogger()
		for(int i=1;i<=10;i++)
		{

			WebElement field = driver.findElement(By.xpath('//*[@id="filter-date-range-followup"]')).click();

			WebElement field1 = driver.findElement(By.xpath('(//*[@class="ranges"]/ul/li['+i+'])'))
			String Date=field1.getText()
			log.logInfo(Date );
			field1.click()
		}
	}
	//check search
	@Keyword
	def searchoption(){
		WebUI.click(clickexecution)

		WebDriver driver = DriverFactory.getWebDriver()
		Select at = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-Assignto"]')))
		at.selectByIndex(2);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="flt-slt-priority"]')))
		pt.selectByIndex(2);
		WebUI.click(search)

	}
	//check show only complete
	@Keyword
	def showcomplete(){
		WebUI.click(clickexecution)
		WebUI.click(showcompleted)
	}
	//check expand and collapse
	@Keyword
	def expandcollapse(){
		WebUI.click(clickexecution)
		WebUI.click(expandall)
		WebUI.click(collapseall)
	}
	//check complete
	@Keyword
	def completenotes(){
		WebUI.click(clickexecution)
		WebUI.click(clicknotes)
		WebUI.click(complete)
	}
	//check edit
	@Keyword
	def editnotes(){
		WebUI.click(clickexecution)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(followup, 'ADMIN MAY')
		WebUI.click(update)
	}
	//check cancel
	@Keyword
	def checkcancel(){
		WebUI.click(clickexecution)
		WebUI.click(clicknotes2)
		WebUI.click(cancel)

	}
	//check postpone
	@Keyword
	def postponenotes(){
		WebUI.click(clickexecution)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	//change priority in grid
	@Keyword
	def prioritychangeingrid(){
		WebUI.click(clickexecution)
		WebUI.click(clickpriority)
		WebUI.click(clickoption)
		WebUI.click(clicksave)
	}
	//change assigned to in grid
	@Keyword
	def assignedtoingrid(){
		WebUI.click(clickexecution)
		WebUI.click(clickassignedto)
		WebUI.click(choosename)
		WebUI.click(clicksave)
	}
	//change date in grid
	@Keyword

	def datechangeingrid(){
		WebUI.click(clickexecution)
		WebUI.click(clickdate)
		WebUI.click(choosedate)
		WebUI.click(clicksave)
	}
	@Keyword
	def outlookcomplete(){
		WebUI.click(clickexecution)
		WebUI.click(outlookday)
		WebUI.click(clicknotes)
		WebUI.click(complete)
	}
	@Keyword
	def outlookedit(){
		WebUI.click(clickexecution)
		WebUI.click(outlookday)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(followup, 'ADMIN NEW')
		WebUI.click(update)

	}
	@Keyword
	def outlookcancel(){
		WebUI.click(clickexecution)
		WebUI.click(outlookday)
		WebUI.click(clicknotes2)
		WebUI.click(cancel)

	}
	//check postpone
	@Keyword
	def outlookpostponenotes(){
		WebUI.click(clickexecution)
		WebUI.click(outlookday)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	//check outlook by expand and collapse
	@Keyword
	def outlookexpandcollapse(){
		WebUI.click(clickexecution)
		WebUI.click(outlookday)
		WebUI.click(expandall)
		WebUI.click(collapseall)
	}
	@Keyword
	def viewassignedcomplete(){
		WebUI.click(clickexecution)
		WebUI.click(outlook)
		WebUI.click(clicknotes)
		WebUI.click(complete)
	}
	@Keyword
	def viewassignedtoedit(){
		WebUI.click(clickexecution)
		WebUI.click(viewassigned)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(followup, 'ADMIN Assigned')
		WebUI.click(update)

	}
	@Keyword
	def viewassignedcancel(){
		WebUI.click(clickexecution)
		WebUI.click(viewassigned)
		WebUI.click(clicknotes2)
		WebUI.click(cancel)

	}
	//check postpone
	@Keyword
	def viewassignedpostponenotes(){
		WebUI.click(clickexecution)
		WebUI.click(viewassigned)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	//check outlook by expand and collapse
	@Keyword
	def viewassignedexpandcollapse(){
		WebUI.click(clickexecution)
		WebUI.click(viewassigned)
		WebUI.click(expandall)
		WebUI.click(collapseall)
	}

	@Keyword
	def viewprioritycomplete(){
		WebUI.click(clickexecution)
		WebUI.click(viewpriority)
		WebUI.click(clicknotes)
		WebUI.click(complete)
	}
	@Keyword
	def viewprioritytoedit(){
		WebUI.click(clickexecution)
		WebUI.click(viewpriority)
		WebUI.click(clicknotes)
		WebUI.click(edit)
		WebUI.setText(followup, 'ADMIN Assigned')
		WebUI.click(update)

	}
	@Keyword
	def viewprioritycancel(){
		WebUI.click(clickexecution)
		WebUI.click(viewpriority)
		WebUI.click(clicknotes2)
		WebUI.click(cancel)

	}
	//check postpone
	@Keyword
	def viewprioritypostponenotes(){
		WebUI.click(clickexecution)
		WebUI.click(viewpriority)
		WebUI.click(clicknotes2)
		WebUI.click(postpone)
		WebUI.click(done)
	}
	//check priority by expand and collapse
	@Keyword
	def viewpriorityexpandcollapse(){
		WebUI.click(clickexecution)
		WebUI.click(viewpriority)
		WebUI.click(expandall)
		WebUI.click(collapseall)
	}

}


