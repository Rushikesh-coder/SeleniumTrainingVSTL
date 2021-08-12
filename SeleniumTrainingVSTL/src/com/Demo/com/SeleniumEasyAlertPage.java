package com.Demo.com;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;



public class SeleniumEasyAlertPage {
	
	public Properties objConfig;


	private BaseTest objBaseTest;
	
	public SeleniumEasyAlertPage(BaseTest baseTest)
	{
		this.objBaseTest=baseTest;
	}
	
	public boolean isPopUPVisible() {
		boolean blnFlag = false;
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
			//objBaseTest.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			objBaseTest.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
		}

	}

	
	public void getAllDropDownsFields(String strExpectedWebElement) {
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By locators = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strExpectedWebElement+"')]");
		objBaseTest.getDriver().findElement(locators).click();

	}

	public void getvaluesOfDropDown(String strValueOfDropDown) {

		By locaterOFValue = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='" + strValueOfDropDown + "']");

		objBaseTest.getDriver().findElement(locaterOFValue).click();

	}

	public void getDropdownAndValues(String strSelectDropDown, String strSelectValue) {
		
		this.getAllDropDownsFields(strSelectDropDown);
		this.getvaluesOfDropDown(strSelectValue);
	}
	
	//Verify Header Text
	public void verifyBootStrapAlertTextIsDisplayed(String strExpectedText)
	{
		String strActialText=objBaseTest.getDriver().findElement(By.xpath("//h2[text()='Bootstrap Alert messages']")).getText();
		System.out.println("BootStrap Alert Page Text :  "+strActialText);
		Assert.assertTrue(strExpectedText.equals(strActialText));
	}
	
	//Click on Button
	public void clickOnMassageButton(String strAlertButtonpath)
	{
		objBaseTest.getDriver().findElement(By.xpath("//button[@id='"+strAlertButtonpath+"']")).click();
	}
	

	//Get Alert Text Massage
	public String getMassageAlertTextMassage(String strPath)
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[@class='"+strPath+"']")).getText();
		
		return strActualMassage;
	}
	
	//Verify alert Text
	public void verifyMassageAlertText(String strLocatorPath,String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextMassage(strLocatorPath);
		if(strActualMassage.startsWith("×"))
		{
			String strReplace=strActualMassage.replace('×', ' ');
			String strTrim=strReplace.trim();
			
			System.out.println("Actual value : "+ strTrim);
			System.out.println("xpected value : "+ strExpectedMassageAlert);
			Assert.assertTrue(strExpectedMassageAlert.equals(strTrim));
		}
		else
		{
			System.out.println("Actual value : "+strActualMassage);
			Assert.assertTrue(strExpectedMassageAlert.equals(strActualMassage));
		}
	}
}
