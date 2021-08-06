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
	public Properties objConfig;
	public void initilizeWebEnvirnment() {

		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL_RedioButton"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,"+intScrollBy+")");
	}
	
	public void verifyHeaderTextOfRedioButtonPage()
	{
		if (driver.findElement(By.xpath("//h3[text()='This is again simple example to start working with radio buttons using Selenium.']")).isDisplayed()) {
			System.out.println("Header is Displayed");
		} else {
			System.out.println("Header is not Displyed");
		}
	}
	
	public boolean checkIsRedioButtonIsSelected()
	{
		boolean blnFlag = false;
		blnFlag = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']")).isSelected();
		return blnFlag;
	}
	
	public void clickOnRedioButton()
	{
		if(checkIsRedioButtonIsSelected())
		{
			
			System.out.println("Redio Button is already seleted");
		}			
		else
		{
			driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']")).click();
		}
	}
	
	
	public void clickonGetCheckedValueButton() {
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
	
	public boolean checkIsGroupRedioButtonGenderIsSelected() {

		boolean blnFlagGender = false;

		blnFlagGender = driver.findElement(By.xpath("//input[@value='Male' and @name='gender']")).isSelected();

		return blnFlagGender;
	}

	public boolean checkIsGroupRedioButtonAgeIsSelected() {
		boolean blnFlagAge = false;
		blnFlagAge = driver.findElement(By.xpath("//input[@value='5 - 15']")).isSelected();
		return blnFlagAge;
	}

	public void clickiOnGroupRedioButtonsGender() {
		if (checkIsGroupRedioButtonGenderIsSelected()) {

			System.out.println("Gender is Already Selected");
		} else {
			driver.findElement(By.xpath("//input[@value='Male' and @name='gender']")).click();
		}
	}

	public void clickOnGroupRedioButtonAge() {
	
		if (checkIsGroupRedioButtonAgeIsSelected()) {

			System.out.println("Age is Already Selected");
		} else {
			driver.findElement(By.xpath("//input[@value='5 - 15']")).click();
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

