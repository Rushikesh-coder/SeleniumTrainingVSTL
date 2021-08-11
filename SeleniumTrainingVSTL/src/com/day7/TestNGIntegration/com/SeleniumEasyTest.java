package com.day7.TestNGIntegration.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumEasyTest  extends BaseTest{

	private SeleniumEasyPage objSeleniumEasyPage;
	
	public void initializePageObject() {
		objSeleniumEasyPage=new SeleniumEasyPage(this);
	}
	@BeforeClass
	public void setUpWebEnvirnment()
	{
		this.initializePageObject();
		this.initilizeWebEnvirnment();
	}
	
	
	
	@Test(priority = 1)
	public void TC_01VerifyDropdownClickOnValueAndInputDemoPageIsDisplayed()
	{
		objSeleniumEasyPage.closePopUp();
		objSeleniumEasyPage.getDropdownAndValues(this.objConfig.getProperty("strDropDownName"), this.objConfig.getProperty("strDropDownValue"));
		objSeleniumEasyPage.verifyDemoPageIsDisplayed(this.objConfig.getProperty("strExpectedHomePageText"));
	}
	
	@Test(priority = 2)
	public void TC_02VerifySingleInputField()
	{
		objSeleniumEasyPage.verifyInputFields(this.objConfig.getProperty("Single_InputFieldsXpath"), this.objConfig.getProperty("Single_InputField"));
		objSeleniumEasyPage.setSingleInput(this.objConfig.getProperty("setSingleInput"));
		objSeleniumEasyPage.clickOnShowMsg();
		objSeleniumEasyPage.verifyMsgOfSingleInput(this.objConfig.getProperty("setSingleInput"));
	}
	
	@Test(priority = 3)
	public void TC_03VerifyMultiInputField()
	{
		objSeleniumEasyPage.verifyInputFields(this.objConfig.getProperty("Two_InputFieldsXpath"),this.objConfig.getProperty("Two_InputField"));
		objSeleniumEasyPage.setTwoInputFields(this.objConfig.getProperty("xpathEnter_A"), this.objConfig.getProperty("NumberOne"));
		objSeleniumEasyPage.setTwoInputFields(this.objConfig.getProperty("xpathEnter_B"), this.objConfig.getProperty("NumberTwo"));
		objSeleniumEasyPage.clickOnGetTotal();
		objSeleniumEasyPage.verifyMsgOfTwoInputField(this.objConfig.getProperty("NumberOne"), this.objConfig.getProperty("NumberTwo"));
		
	}
	
	@AfterClass
	public void tearDownCloseEnvirnment()
	{
		this.tearDownEnvirnment();
	}

}
