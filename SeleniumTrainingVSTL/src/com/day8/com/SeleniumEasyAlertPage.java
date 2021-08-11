package com.day8.com;

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

		By locaterOFValue = By
				.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='" + strValueOfDropDown + "']");

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
	

	//AutoClose Success Massage
	public String getMassageAlertTextAutoSuccessMassage()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[contains(text(),'an autocloseable success  message. I will hide in 5 seconds.')]")).getText();
		
		return strActualMassage;
	}
	
	public void verifyMassageAlertAutoSuccessMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextAutoSuccessMassage();
		Assert.assertTrue(strExpectedMassageAlert.equals(strActualMassage));
	}
	
	
	//normal success Massage
	public String getMassageAlertTextNormalSuccessMassage()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-success alert-normal-success']")).getText();
		return strActualMassage;
	}
	
	
	public void verifyMassageAlertNormalSuccessMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextNormalSuccessMassage();
		String strReplace=strActualMassage.replace('×', ' ');
		String strTrim=strReplace.trim();
		
		System.out.println("Avalue : "+ strTrim);
		System.out.println("Evalue : "+ strExpectedMassageAlert);
		Assert.assertTrue(strExpectedMassageAlert.equals(strTrim));
	}
	
	
	//auto close warning 
	public String getMassageAlertTextAutoWarning()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[contains(text(),'an autocloseable warning message. I will hide in 3 seconds.')]")).getText();
		
		return strActualMassage;
	}
	
	public void verifyMassageAlertAutoWarningMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextAutoWarning();
		System.out.println("Warning value : "+strActualMassage);
		Assert.assertTrue(strExpectedMassageAlert.equals(strActualMassage));
	}
	
	
	
	//normal Warning
	public String getMassageAlertTextNormalWorningMassage()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-warning alert-normal-warning']")).getText();
		return strActualMassage;
	}
	
	
	public void verifyMassageAlertNormalWarningMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextNormalWorningMassage();
		String strReplace=strActualMassage.replace('×', ' ');
		String strTrim=strReplace.trim();
		
		System.out.println("Avalue Normal warning: "+ strTrim);
		Assert.assertTrue(strExpectedMassageAlert.equals(strTrim));
	}
	
	
	
	
	//Auto Close Denger
	public String getMassageAlertTextAutoDenger()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[contains(text(),'an autocloseable danger message. I will hide in 5 seconds.')]")).getText();
		
		return strActualMassage;
	}
	
	public void verifyMassageAlertAutoDengerMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextAutoDenger();
		System.out.println("Denger value : "+strActualMassage);
		Assert.assertTrue(strExpectedMassageAlert.equals(strActualMassage));
	}
	
	
	//normal Danger
	public String getMassageAlertTextNormalDengerMassage()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-danger alert-normal-danger']")).getText();
		return strActualMassage;
	}
	
	
	public void verifyMassageAlertNormalDengerMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextNormalDengerMassage();
		String strReplace=strActualMassage.replace('×', ' ');
		String strTrim=strReplace.trim();
		
		System.out.println("Avalue Normal Denger: "+ strTrim);
		Assert.assertTrue(strExpectedMassageAlert.equals(strTrim));
	}
	
	
	//Auto Close Info
	public String getMassageAlertTextAutoInFo()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[contains(text(),'an autocloseable info message. I will hide in 6 seconds.')]")).getText();
		
		return strActualMassage;
	}
	
	public void verifyMassageAlertAutoInFoMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextAutoInFo();
		System.out.println("INFO value : "+strActualMassage);
		Assert.assertTrue(strExpectedMassageAlert.equals(strActualMassage));
	}
	
	
	//normal-info
	public String getMassageAlertTextNormalInFoMassage()
	{
		String strActualMassage=objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-info alert-normal-info']")).getText();
		return strActualMassage;
	}
	
	
	public void verifyMassageAlertNormalInFoMassage(String strExpectedMassageAlert)
	{
		String strActualMassage=this.getMassageAlertTextNormalInFoMassage();
		String strReplace=strActualMassage.replace('×', ' ');
		String strTrim=strReplace.trim();
		
		System.out.println("Avalue Normal INFO: "+ strTrim);
		Assert.assertTrue(strExpectedMassageAlert.equals(strTrim));
	}
}
