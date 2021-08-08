package com.day5.RedioButton.com;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRedioButton {

	public WebDriver driver = null;
	JavascriptExecutor jsExcecuter; 
	public Properties objConfig;
	
	public void initilizeWebEnvirnment() {

		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL_RedioButton"));
		driver.manage().window().maximize();
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
	
	public void scrollPage(int intScrollBy)
	{
		jsExcecuter= (JavascriptExecutor) driver;  
		jsExcecuter.executeScript("window.scrollBy(0,"+intScrollBy+")");
	}
	
	public void verifyHeaderTextOfRedioButtonPageIsDisplayed() //verify Header
	{
		if (driver.findElement(By.xpath("//h3[text()='This is again simple example to start working with radio buttons using Selenium.']")).isDisplayed()) {
			System.out.println("Header is Displayed");
		} else {
			System.out.println("Header is not Displyed");
		}
	}
	
	public boolean checkIsRadioButtonIsSelected(String strLocator)    //Check radio button is selected
	{
		boolean blnFlag = false;
		blnFlag = driver.findElement(By.xpath("//input[@value='"+strLocator+"' and @name='optradio']")).isSelected();
		return blnFlag;
	}
	
	public void clickOnRedioButton(String strPath)      //click on radio button
	{
		if(this.checkIsRadioButtonIsSelected(strPath))
		{
			
			System.out.println("Redio Button is already seleted");
		}			
		else
		{
			driver.findElement(By.xpath("//input[@value='"+strPath+"' and @name='optradio']")).click();
		}
	}
	
	
	public void clickonGetCheckedValueButton()     //Click on get Value button
	{
		driver.findElement(By.xpath("//*[text()='Get Checked value']")).click();
		System.out.println("Get Checked value is clicked");
	}
	
	public void checkResult()
	{
		if(driver.findElement(By.xpath("//p[@class='radiobutton']")).isDisplayed())
		{
			System.out.println("Massage is Displayd : "+driver.findElement(By.xpath("//p[@class='radiobutton']")).getText());
		}
		else
		{
			System.out.println("Redio button is not selected");
		}
		
		this.scrollPage(400);
	}
	
	public boolean checkIsGroupRedioButtonGenderIsSelected(String LocatorGender)   // check radio button for Gender isselected
	{

		boolean blnFlagGender = false;

		blnFlagGender = driver.findElement(By.xpath("//input[@value='"+LocatorGender+"' and @name='gender']")).isSelected();

		return blnFlagGender;
	}

	public boolean checkIsGroupRedioButtonAgeIsSelected(String locatorAge)    // check radio button for Age isselected
	{
		boolean blnFlagAge = false;
		blnFlagAge = driver.findElement(By.xpath("//input[@value='"+locatorAge+"']")).isSelected();
		return blnFlagAge;
	}

	public void clickiOnGroupRedioButtonsGender(String strGenderPath)   //click on GroupRedio Button Gender
	{
		if (this.checkIsGroupRedioButtonGenderIsSelected(strGenderPath)) {

			System.out.println("Gender is Already Selected");
		} else {
			driver.findElement(By.xpath("//input[@value='"+strGenderPath+"' and @name='gender']")).click();
		}
	}

	public void clickOnGroupRedioButtonAge(String strAgePath)    //click on GroupRedio Button Age
	{
	
		if (this.checkIsGroupRedioButtonAgeIsSelected(strAgePath)) {

			System.out.println("Age is Already Selected");
		} else {
			driver.findElement(By.xpath("//input[@value='"+strAgePath+"']")).click();
		}
	}
	
	public void clickonGetValueButton() {
		driver.findElement(By.xpath("//button[text()='Get values']")).click();
		System.out.println("Get value is clicked");
	}
	
	public void checkGroutRedioResult()
	{
		if(driver.findElement(By.xpath("//p[@class='groupradiobutton']")).isDisplayed())
		{
			System.out.println("Massage is Displayd : "+driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText());
		}
		else
		{
			System.out.println("Redio button is not selected");
		}
	}
	}

