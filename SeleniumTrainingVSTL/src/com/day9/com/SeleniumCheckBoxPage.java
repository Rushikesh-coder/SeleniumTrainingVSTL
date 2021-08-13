package com.day9.com;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class SeleniumCheckBoxPage {

	private BaseTest objBaseTest;
	
	public SeleniumCheckBoxPage(BaseTest baseTest)
	{
		this.objBaseTest=baseTest;
	}

	public void verifyHeaderOfCheckBoxPageISDisplayde() // Header is Displayed or Not
	{

		boolean blnHeaderIsDisplayd = objBaseTest.getDriver().findElement(By
						.xpath("//h3[text()='This would be a basic example to start with checkboxes using selenium.']")).isDisplayed();

		Assert.assertTrue(blnHeaderIsDisplayd);
	}

	public void verifyCheckboxDemoText(String strCheckBoxPath, String strExpectedText)  //verifying Text 
	{
		String strCheckBoxText=objBaseTest.getDriver().findElement(By.xpath("//div[text()='" + strCheckBoxPath + "']")).getText();
		String strExpected=strExpectedText;
		Assert.assertEquals(strCheckBoxText, strExpected);
	}

	public boolean verifySingleCheckBoxIsSected()    //check box isSelectred or Not
	{
		boolean blnFlag = false;
		blnFlag = objBaseTest.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
		
		return blnFlag;
	}

	public void selectSingleCheckBox()   //Select Check box if not selected
	{
		Assert.assertFalse(verifySingleCheckBoxIsSected());
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']")).click();
	}
	
	public void verifyResultSingleCheckBoxText()
	{
		String strExpected="Success - Check box is checked";
		String strResultText=objBaseTest.getDriver().findElement(By.xpath("//div[text()='Success - Check box is checked']")).getText();
		Assert.assertNotNull(strResultText);
		Assert.assertEquals(strResultText, strExpected);
	}

	public boolean verifyMultipelCheckBoxIsSelected(String xpathofCheckBox)  //check box isSelectred or Not Group
	{
		boolean blnFlag = false;
		blnFlag=objBaseTest.getDriver().findElement(By.xpath("//label[text()='"+xpathofCheckBox+"']")).isSelected();
		
		return blnFlag;
		
	}

	public void selectMultipleCheckBox(String strCheckBoxPath) //Select Check box if not selected Group
	{
		objBaseTest.scrollPage(300);
		
		Assert.assertFalse(verifyMultipelCheckBoxIsSelected(strCheckBoxPath));
		
		objBaseTest.getDriver().findElement(By.xpath("//label[text()='"+strCheckBoxPath+"']")).click();

	}

}
