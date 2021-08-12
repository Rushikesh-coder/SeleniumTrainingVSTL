package com.day9.com;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumCheckBoxTest extends BaseTest{

	private SeleniumCheckBoxPage objSeleniumCheckBoxPage;
	
	public void initializePageObject()
	{
		objSeleniumCheckBoxPage=new SeleniumCheckBoxPage(this);
	}
	
	@BeforeClass
	public void initalizeWebEnvirnmentSetUp()
	{
		this.initializePageObject();
		this.initilizeWebEnvirnment();
	}
	
	@Test(priority = 1)
	public void TC_01CheckBoxPageHeaderTextIsDisplayed()
	{
		objSeleniumCheckBoxPage.verifyHeaderOfCheckBoxPageISDisplayde();
	}
	
	@Test(priority = 2)
	public void TC_02VerifyAndClickSingleCheckBox()
	{
		objSeleniumCheckBoxPage.verifyCheckboxDemoText(objConfig.getProperty("XpSingleCheckBox"), objConfig.getProperty("strExpectedSingleCheckBoxText"));
		objSeleniumCheckBoxPage.verifySingleCheckBoxIsSected();
		objSeleniumCheckBoxPage.selectSingleCheckBox();
	}
	
	@Test(priority = 3)
	public void TC_03verifyResultOfSingleCheckBox() {
		objSeleniumCheckBoxPage.verifyResultSingleCheckBoxText();
		
	}
	
	@Test(priority = 4)
	public void TC_04VerifyAndClickMultipleCheckBoxes()
	{
		objSeleniumCheckBoxPage.verifyCheckboxDemoText(objConfig.getProperty("XPMultipleCheckBox"), objConfig.getProperty("strExpectedMultipleCheckBoxText"));
		objSeleniumCheckBoxPage.selectMultipleCheckBox("Option 1");
		objSeleniumCheckBoxPage.selectMultipleCheckBox("Option 2");
		objSeleniumCheckBoxPage.selectMultipleCheckBox("Option 3");
		objSeleniumCheckBoxPage.selectMultipleCheckBox("Option 4");
	}
	
	
	
}
