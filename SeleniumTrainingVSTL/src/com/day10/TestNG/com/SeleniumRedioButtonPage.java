package com.day10.TestNG.com;

import org.openqa.selenium.By;
import org.testng.Assert;

public class SeleniumRedioButtonPage {

	private BaseTest objBaseTest;
	
	public SeleniumRedioButtonPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}
	
	public void verifyHeaderTextOfRedioButtonPageIsDisplayed() //verify Header
	{	
		Assert.assertTrue(objBaseTest.getDriver().findElement(By.xpath("//h3[text()='This is again simple example to start working with radio buttons using Selenium.']")).isDisplayed());
	}
	
	public boolean checkIsRadioButtonIsSelected(String strLocator)    //Check radio button is selected
	{
		boolean blnFlag = false;
		blnFlag = objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strLocator+"' and @name='optradio']")).isSelected();
		return blnFlag;
	}
	
	public void clickOnRedioButton(String strPath)      //click on radio button
	{
		Assert.assertFalse(this.checkIsRadioButtonIsSelected(strPath));
		objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strPath+"' and @name='optradio']")).click();
	}
	
	
	public void clickonGetCheckedValueButton()     //Click on get Value button
	{
		objBaseTest.getDriver().findElement(By.xpath("//*[text()='Get Checked value']")).click();
		System.out.println("Get Checked value is clicked");
	}
	
	public void checkResult()
	{
		boolean blnresult=objBaseTest.getDriver().findElement(By.xpath("//p[@class='radiobutton']")).isDisplayed();
		String strMasseage=objBaseTest.getDriver().findElement(By.xpath("//p[@class='radiobutton']")).getText();
		Assert.assertTrue(blnresult);
		Assert.assertTrue(strMasseage.contains("Female"));
		objBaseTest.scrollPage(400);
	}
	
	public boolean checkIsGroupRedioButtonGenderIsSelected(String LocatorGender)   // check radio button for Gender isselected
	{

		boolean blnFlagGender = false;

		blnFlagGender = objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+LocatorGender+"' and @name='gender']")).isSelected();

		return blnFlagGender;
	}

	public boolean checkIsGroupRedioButtonAgeIsSelected(String locatorAge)    // check radio button for Age isselected
	{
		boolean blnFlagAge = false;
		blnFlagAge = objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+locatorAge+"']")).isSelected();
		return blnFlagAge;
	}

	public void clickOnGroupRedioButtonsGender(String strGenderPath)   //click on GroupRedio Button Gender
	{
		
		Assert.assertFalse(this.checkIsGroupRedioButtonGenderIsSelected(strGenderPath));
		objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strGenderPath+"' and @name='gender']")).click();
	}

	public void clickOnGroupRedioButtonAge(String strAgePath)    //click on GroupRedio Button Age
	{
		
		Assert.assertFalse(this.checkIsGroupRedioButtonAgeIsSelected(strAgePath));
		objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strAgePath+"']")).click();
	}
	
	public void clickonGetValueButton() {
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Get values']")).click();
		System.out.println("Get value is clicked");
	}
	
	public void checkGroutRedioResult()
	{
		if(objBaseTest.getDriver().findElement(By.xpath("//p[@class='groupradiobutton']")).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Massage is Displayd : "+objBaseTest.getDriver().findElement(By.xpath("//p[@class='groupradiobutton']")).getText());
		}
		else
		{
			System.out.println("Redio button is not selected");
			Assert.assertTrue(false);
		}
	}
	}

