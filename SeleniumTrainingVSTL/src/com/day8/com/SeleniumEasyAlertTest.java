package com.day8.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumEasyAlertTest extends BaseTest {

	private SeleniumEasyAlertPage objSeleniumEasyAlertPage;
	
	public void initializePageObject()
	{
		objSeleniumEasyAlertPage=new SeleniumEasyAlertPage(this);
	}
	
	@BeforeClass
	public void initalizewebSetUpEnvirnment()
	{
		this.initializePageObject();
		this.initilizeWebEnvirnment();
	}
	
	@Test(priority = 1)
	public void TC_01verifyDropdownClickValueAndPageIsDesplayed()
	{
		objSeleniumEasyAlertPage.isPopUPVisible();
		objSeleniumEasyAlertPage.closePopUp();
		objSeleniumEasyAlertPage.getDropdownAndValues(this.objConfig.getProperty("strDropdownName"), this.objConfig.getProperty("strDropdownValues"));
		objSeleniumEasyAlertPage.verifyBootStrapAlertTextIsDisplayed(this.objConfig.getProperty("strExpectedTextHeader"));
	}
	
	@Test(priority = 2)
	public void TC_02ClickButtonAndVerifyAlertTextAutoCloseSuccess()
	{
		objSeleniumEasyAlertPage.clickOnMassageButton("autoclosable-btn-success");
		objSeleniumEasyAlertPage.getMassageAlertTextAutoSuccessMassage();
		objSeleniumEasyAlertPage.verifyMassageAlertAutoSuccessMassage(objConfig.getProperty("strExpectedalertMassageAutoCloseSuccess"));
	}
	
	@Test(priority = 3)
	public void TC_03ClickButtonAndVerifyAlertTextNormalSuccess()
	{
		
		objSeleniumEasyAlertPage.clickOnMassageButton("normal-btn-success");
		objSeleniumEasyAlertPage.getMassageAlertTextNormalSuccessMassage();
		objSeleniumEasyAlertPage.verifyMassageAlertNormalSuccessMassage(objConfig.getProperty("strExpectedalertMassageNormalSuccess"));
	}
	
	@Test(priority = 4)
	public void TC_04ClickButtonAndVerifyAlertTextAutoCloseWarning()
	{
		objSeleniumEasyAlertPage.clickOnMassageButton("autoclosable-btn-warning");
		objSeleniumEasyAlertPage.getMassageAlertTextAutoWarning();
		objSeleniumEasyAlertPage.verifyMassageAlertAutoWarningMassage(objConfig.getProperty("strExpectedMassegeAutoWarning"));
	}
	
	@Test(priority = 5)
	public void TC_05ClickButtonAndVerifyAlertTextNormalWarning()
	{
		objSeleniumEasyAlertPage.clickOnMassageButton("normal-btn-warning");
		objSeleniumEasyAlertPage.getMassageAlertTextNormalWorningMassage();
		objSeleniumEasyAlertPage.verifyMassageAlertNormalWarningMassage(objConfig.getProperty("strExpectedMassegeNormalWarning"));
	}
	
	@Test(priority = 6)
	public void TC_06ClickButtonAndVerifyAlertTextAutoCloseDenger()
	{
		objSeleniumEasyAlertPage.clickOnMassageButton("autoclosable-btn-danger");
		objSeleniumEasyAlertPage.getMassageAlertTextAutoDenger();
		objSeleniumEasyAlertPage.verifyMassageAlertAutoDengerMassage(objConfig.getProperty("strExpectedMassageAutoDenger"));
	}
	@Test(priority = 7)
	public void TC_07ClickButtonAndVerifyAlertTextNormalDenger()
	{
		objSeleniumEasyAlertPage.clickOnMassageButton("normal-btn-danger");
		objSeleniumEasyAlertPage.getMassageAlertTextNormalDengerMassage();
		objSeleniumEasyAlertPage.verifyMassageAlertNormalDengerMassage(objConfig.getProperty("strExpectedMassageNormalDenger"));
	}
	
	@Test(priority = 8)
	public void TC_08ClickButtonAndVerifyAlertTextAutoCloseINFO()
	{
		objSeleniumEasyAlertPage.clickOnMassageButton("autoclosable-btn-info");
		objSeleniumEasyAlertPage.getMassageAlertTextAutoInFo();
		objSeleniumEasyAlertPage.verifyMassageAlertAutoInFoMassage(objConfig.getProperty("strExpectedMassageAutoINFO"));
	}
	
	@Test(priority = 9)
	public void TC_09ClickButtonAndVerifyAlertTextNormalINFO() {
		objSeleniumEasyAlertPage.clickOnMassageButton("normal-btn-info");
		objSeleniumEasyAlertPage.getMassageAlertTextNormalInFoMassage();
		objSeleniumEasyAlertPage.verifyMassageAlertNormalInFoMassage(objConfig.getProperty("strExpectedMassageNormalInfo"));
	}
	
	@AfterClass
	public void closeBrowser()
	{
		this.tearDownEnvirnment();
	}
	
}
