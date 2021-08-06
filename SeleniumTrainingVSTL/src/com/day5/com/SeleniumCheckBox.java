package com.day5.com;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCheckBox {

	public WebDriver driver = null;
	public Properties objConfig;

	public void initilizeWebEnvirnment() {

		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL_CheckBox"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.setImplicitlyWait(10);
	}
	
	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/configCheckBoxAndRedioButton/config.properties"));
			System.out.println("No Exception");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	public void setImplicitlyWait(int intTimeInSecond)
	{
		driver.manage().timeouts().implicitlyWait(intTimeInSecond, TimeUnit.SECONDS);
	}
	
	public void scrollPage(int intScrollBy)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,"+intScrollBy+")");
	}

	public void verifyHeaderOfCheckBoxPage()    //Header is present or Not
	{

		if (driver.findElement(By.xpath("//h3[text()='This would be a basic example to start with checkboxes using selenium.']"))
				.isDisplayed()) {
			System.out.println("Header is Displayed");
		} else {
			System.out.println("Header is not Displyed");
		}
	}

	public void verifyCheckboxDemoText(String strCheckBoxPath)  //verifying Text 
	{

		if (driver.findElement(By.xpath("//div[text()='" + strCheckBoxPath + "']")).isDisplayed()) {
			System.out.println("Check Box Text is Visible");
		} else {
			System.out.println("Check Box field is not visible");
		}

	}

	public boolean verifySingleCheckBoxIsSected()    //check box isSelectred or Not
	{
		boolean blnFlag = false;
		blnFlag = driver.findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
		
		return blnFlag;
	}

	public void selectSingleCheckBox()   //Select Check box if not selected
	{
		if (verifySingleCheckBoxIsSected()) {
			System.out.println("Single check box is already checked");
		}
		else {
			driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		}
		
	}

	public boolean verifyMultipelCheckBox(String xpathofCheckBox)  //check box isSelectred or Not Group
	{
		boolean blnFlag = false;
		blnFlag=driver.findElement(By.xpath("//label[text()='"+xpathofCheckBox+"']")).isSelected();
		
		return blnFlag;
		
	}

	public void selectMultipleCheckBox(String strCheckBoxPath) //Select Check box if not selected Group
	{
		
		this.scrollPage(300);
		if(verifyMultipelCheckBox(strCheckBoxPath)) {
			System.out.println("Single check box is already checked");
		}
		else
		{
			driver.findElement(By.xpath("//label[text()='"+strCheckBoxPath+"']")).click();
		}

	}

}
