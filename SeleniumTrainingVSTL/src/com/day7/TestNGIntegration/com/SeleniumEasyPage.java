package com.day7.TestNGIntegration.com;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;





public class SeleniumEasyPage {

	boolean blnFlag = false;
	public Properties objConfig;


	private BaseTest objBaseTest;
	
	public SeleniumEasyPage(BaseTest baseTest)
	{
	    this.objBaseTest=baseTest;	
	}

	public boolean isPopUPVisible() {
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			blnFlag = objBaseTest.driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).isDisplayed();
			return blnFlag;
		} catch (Exception exception) {
			System.out.println("Not Getting Pop Up" + exception.getMessage());
			return blnFlag;
		}
	}

	public void closePopUp() {
		if (this.isPopUPVisible()) {
			
			objBaseTest.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
		}

	}

	
	public void getAllDropDownsFields(String strExpectedWebElement) {
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By locators = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strExpectedWebElement+"')]");
		objBaseTest.getDriver().findElement(locators).click();

	}

	public void getvaluesOfDropDown(String strValueOfDropDown) {

		By locaterOFValue = By
				.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='" + strValueOfDropDown + "']");

		objBaseTest.getDriver().findElement(locaterOFValue).click();

	}

	public void getDropdownAndValues(String strSelectDropDown, String strSelectValue) {
		
		this.getAllDropDownsFields(strSelectDropDown);
		this.getvaluesOfDropDown(strSelectValue);
	}
	
	public void verifyDemoPageIsDisplayed(String strExpectedText)
	{
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By locator=By.xpath("//h3[text()='This would be your first example to start with Selenium.']");	
		
		String strActualText=objBaseTest.getDriver().findElement(locator).getText();
		Assert.assertTrue(strExpectedText.equals(strActualText));
		
	}
	

	
	public void verifyInputFields(String strInputField,String strExpectedInputFieldText)   //Single and Multi
	{	
		By locatorInputFieldText=By.xpath("//div[text()='"+strInputField+"']");
		String actualInputFieldText=objBaseTest.getDriver().findElement(locatorInputFieldText).getText();
		Assert.assertTrue(strExpectedInputFieldText.equals(actualInputFieldText));
		
	}

	public void setSingleInput(String strsendkeys)
	{
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(strsendkeys);
		
	}
	public void clickOnShowMsg()
	{
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Show Message']")).click();
		JavascriptExecutor js = (JavascriptExecutor) objBaseTest.getDriver();  
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void verifyMsgOfSingleInput(String strExpectedMsg) {
		
		String strActualText = objBaseTest.getDriver().findElement(By.xpath("//*[@id='display']")).getText();
		
		System.out.println("Massege is  : "+strExpectedMsg);
		Assert.assertTrue(strExpectedMsg.equals(strActualText));
	}
	
	//Two Input Field
	public void setTwoInputFields(String strLocator, String strNumber)
	{
		
		objBaseTest.getDriver().findElement(By.xpath("//*[@id='"+strLocator+"']")).sendKeys(strNumber);
		
		
	}
	public void clickOnGetTotal()
	{
		objBaseTest.getDriver().findElement(By.xpath("//*[text()='Get Total']")).click();
	}

	public void verifyMsgOfTwoInputField(String strNumberOne, String strNumberTwo) {
		int intResult= Integer.parseInt(strNumberOne)+Integer.parseInt(strNumberTwo);
		
		String strActualSum = objBaseTest.getDriver().findElement(By.xpath("//*[@id='displayvalue']")).getText();

		System.out.println("Sum is : "+strActualSum);
		Assert.assertTrue(intResult==Integer.parseInt(strActualSum));
	}
	
}
