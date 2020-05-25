package requestlist

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
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement

import org.openqa.selenium.WebDriver
import internal.GlobalVariable



public class Addingnotes {
	private TestObject clickrequestlist=findTestObject('Object Repository/Request List/click request list')
	private TestObject addtext=findTestObject('Object Repository/Request List/Add text')
	private TestObject settext=findTestObject('Object Repository/Request List/set text')
	private TestObject notessave=findTestObject('Object Repository/Request List/notessave')
	private TestObject clickhome=findTestObject('Object Repository/Request List/click home')
	private TestObject singledelete=findTestObject('Object Repository/Request List/fields/singledelete')
	private TestObject yes=findTestObject('Object Repository/Request List/fields/deleteyes')
	private TestObject inbox=findTestObject('Object Repository/Request List/fields/click inbox')
	private TestObject inboxsave=findTestObject('Object Repository/Request List/fields/inbox/Inboxnotes save')
	private TestObject click1=findTestObject('Object Repository/Request List/Date Range/click 1')
	private TestObject click2=findTestObject('Object Repository/Request List/Date Range/click2')
	private TestObject detail=findTestObject('Object Repository/Request List/Department/detail')
	private TestObject dept=findTestObject('Object Repository/Request List/Department/Dept')
	//bulk delete
	private TestObject checkbox1=findTestObject('Object Repository/Request List/fields/checkboxclick1')
	private TestObject checkbox2=findTestObject('Object Repository/Request List/fields/checkbox click 2')
	private TestObject bulkdelete=findTestObject('Object Repository/Request List/fields/bulk delete')
	private TestObject bulkyes=findTestObject('Object Repository/Request List/fields/Bulk yes')
	private TestObject mousehover=findTestObject('Object Repository/Request List/fields/mouse hover')
	//setup
	private TestObject clicksetup=findTestObject('Object Repository/Request List/setup/clicksetup')
	private TestObject drag=findTestObject('Object Repository/Request List/setup/drag')
	private TestObject drop=findTestObject('Object Repository/Request List/setup/drop')
	//resource allocation
	private TestObject allocation=findTestObject('Object Repository/Resource Allocation/click allocation')
	private TestObject draga=findTestObject('Object Repository/Resource Allocation/drag')
	private TestObject dropa=findTestObject('Object Repository/Resource Allocation/drop')
	// check priority
	private TestObject clickpriority=findTestObject('Object Repository/Request List/priority/clickpriority')
	private TestObject dragp=findTestObject('Object Repository/Request List/priority/dragp')
	private TestObject dropp=findTestObject('Object Repository/Request List/priority/dropp')
	//check duedate and summary tab
	private TestObject clickdue=findTestObject('Object Repository/Request List/Due Date/click due date')
	private TestObject dragd=findTestObject('Object Repository/Request List/Due Date/Dragd')
	private TestObject dropd=findTestObject('Object Repository/Request List/Due Date/Dropd')
	private TestObject summary=findTestObject('Object Repository/Request List/summary tab/clicksummary')
	@Keyword
	def notesadding(){
		WebUI.click(clickrequestlist)

		WebUI.setText(settext,'Admin new12')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.click(notessave)
		WebUI.click(clickhome)
	}
	@Keyword
	def processingnotes(){
		WebUI.click(clickrequestlist)
		WebDriver driver = DriverFactory.getWebDriver()
		Select rt = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[1]/td[3]/div/div[6]/div/select')))
		rt.selectByIndex(1);
		Select ra = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[1]/td[3]/div/div[5]/div/select')))
		ra.selectByIndex(9);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[1]/td[3]/div/div[3]/div/select')))
		pt.selectByIndex(2);
		WebUI.click(notessave)
	}
	@Keyword
	def verfyingcountinaction(){
		WebUI.click(clickhome)
	}
	//verifying notes by both processing and not processing
	@Keyword
	def processnotprocess(){
		WebUI.click(clickrequestlist)
		WebUI.setText(settext,'Admin6')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.click(notessave)
		WebUI.click(clickhome)
		WebUI.click(clickrequestlist)
		WebDriver driver = DriverFactory.getWebDriver()
		Select rt = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[3]/td[3]/div/div[6]/div/select')))
		rt.selectByIndex(1);
		Select ra = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[3]/td[3]/div/div[5]/div/select')))
		ra.selectByIndex(9);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[3]/td[3]/div/div[3]/div/select')))
		pt.selectByIndex(2);
		WebUI.click(notessave)

	}
	@Keyword
	def deletenotes(){
		WebUI.click(clickrequestlist)
		//WebUI.setText(settext,'Admin8')
		//WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.mouseOver(singledelete)
		WebUI.click(singledelete)
		WebUI.click(yes)
	}
	@Keyword
	def savenotes(){
		WebUI.click(clickrequestlist)
		WebUI.setText(settext,'Admin8')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.click(notessave)

	}
	//processing notes from draft
	@Keyword
	def requestfromdraft(){
		WebUI.click(clickrequestlist)
		WebUI.setText(settext,'Admin new12')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebDriver driver = DriverFactory.getWebDriver()
		Select rt = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[1]/td[3]/div/div[6]/div/select')))
		rt.selectByIndex(1);
		Select ra = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[1]/td[3]/div/div[5]/div/select')))
		ra.selectByIndex(9);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="draft_tbl"]/tbody/tr[1]/td[3]/div/div[3]/div/select')))
		pt.selectByIndex(2);
		WebUI.click(notessave)

	}
	//processing notes from inbox
	@Keyword
	def notesfrominbox(){
		WebUI.click(clickrequestlist)
		WebUI.setText(settext,'Admin new')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.click(notessave)
		WebUI.delay(2)
		WebUI.click(inbox)
		WebDriver driver = DriverFactory.getWebDriver()
		Select rt = new Select(driver.findElement(By.xpath('//*[@id="inboxdraft_tbl"]/tbody/tr[1]/td[3]/div/div[6]/div/select')))
		rt.selectByIndex(1);
		Select ra = new Select(driver.findElement(By.xpath('//*[@id="inboxdraft_tbl"]/tbody/tr[1]/td[3]/div/div[5]/div/select')))
		ra.selectByIndex(9);
		Select pt = new Select(driver.findElement(By.xpath('//*[@id="inboxdraft_tbl"]/tbody/tr[1]/td[3]/div/div[3]/div/select')))
		pt.selectByIndex(2);
		WebUI.click(inboxsave)

	}
	//bulk delete
	@Keyword
	def deletebulknotes(){
		WebUI.click(clickrequestlist)
		WebUI.delay(2)
		WebUI.setText(settext,'Admin new12')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.click(notessave)
		WebUI.mouseOver(mousehover)
		WebUI.click(checkbox1)
		WebUI.click(bulkdelete)
		WebUI.click(bulkyes)

	}
	//processing notes from setup
	@Keyword
	def setupnotes(){
		WebUI.click(clickrequestlist)
		WebUI.delay(2)
		WebUI.setText(settext,'Admin new12')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.click(notessave)
		WebUI.click(clicksetup)
		WebUI.dragAndDropToObject(drag, drop)
		//WebUI.dragAndDropByOffset(drag, 100, 100)
	}
	//checking setup tab
	@Keyword
	def checksetup1(){

		WebUI.click(clickrequestlist)
		WebUI.delay(2)
		WebUI.setText(settext,'Admin new12')
		WebUI.sendKeys(findTestObject('Request List/set text'),Keys.chord(Keys.ENTER))
		WebUI.click(notessave)
		WebUI.click(clicksetup)
	}
	@Keyword
	def resourceallocation(){
		WebUI.click(clickrequestlist)
		WebUI.click(allocation)
		WebUI.dragAndDropToObject(draga, dropa)

	}
	@Keyword
	def checkpriority(){
		WebUI.click(clickrequestlist)
		WebUI.click(clickpriority)
		WebUI.dragAndDropToObject(dragp, dropp)
	}
	@Keyword
	def checkdue(){
		WebUI.click(clickrequestlist)
		WebUI.click(clickdue)
		WebUI.dragAndDropToObject(dragd, dropd)
	}
	@Keyword
	def checksummary(){
		WebUI.click(clickrequestlist)
		WebUI.click(summary)
	}
	@Keyword
	def daterange(){
		WebUI.click(clickrequestlist)
		WebUI.click(click1)
		WebUI.click(click2)
	}
	@Keyword
	def departmentchange(){
		WebUI.click(clickrequestlist)
		WebUI.click(detail)
		WebUI.click(dept)
	}

}
