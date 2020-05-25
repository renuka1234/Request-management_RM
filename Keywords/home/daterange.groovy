package home

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.WebDriver
import internal.GlobalVariable


public class daterange {
	private TestObject Home=findTestObject('Object Repository/Home/date/click home')
	private TestObject datefield=findTestObject('Object Repository/Home/date/date field')
	private TestObject clickdate=findTestObject('Object Repository/Home/date/click date')
	//department
	private TestObject deptfield=findTestObject('Object Repository/Home/department/dept field')
	//chart
	private TestObject chart=findTestObject('Object Repository/Home/status chart/mousehover')
	@Keyword
	def homedatefilters(){
		WebDriver driver=DriverFactory.getWebDriver()
		KeywordLogger log = new KeywordLogger()
		for(int i=1;i<=10;i++) {

			WebElement field = driver.findElement(By.xpath('//*[@id="Daterangefilter"]')).click();

			WebElement field1 = driver.findElement(By.xpath('(//*[@class="ranges"])/ul/li['+i+']'))
			String date=field1.getText();
			log.logInfo(date );
			field1.click();
		}
	}
	@Keyword
	def notesdate(){
		WebUI.click(datefield)
		WebUI.click(clickdate)
	}
	@Keyword
	def department(){
		WebDriver driver=DriverFactory.getWebDriver()
		Select dpt = new Select(driver.findElement(By.xpath('//*[@id="Department_select"]')))


		dpt.selectByIndex(0);
		WebUI.click(datefield)
		WebUI.click(clickdate)

	}
	@Keyword
	def countbydeptanddate(){
		WebUI.click(datefield)
		WebUI.click(clickdate)
		WebDriver driver=DriverFactory.getWebDriver()
		Select dpt = new Select(driver.findElement(By.xpath('//*[@id="Department_select"]')))


		dpt.selectByIndex(5);

	}
	@Keyword
	def chart(){
		/*WebUI.click(datefield)
		 WebUI.click(clickdate)*/
		WebDriver driver=DriverFactory.getWebDriver()
		Select dpt = new Select(driver.findElement(By.xpath('//*[@id="Department_select"]')))


		dpt.selectByIndex(0);

		WebUI.mouseOver(chart)
	}
}
