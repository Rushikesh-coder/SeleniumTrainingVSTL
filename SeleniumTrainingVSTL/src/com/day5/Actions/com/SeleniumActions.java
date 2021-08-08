package com.day5.Actions.com;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActions {
	
	public WebDriver driver = null;
	public Properties objConfig;
	public JavascriptExecutor jsExecutor;
	public Actions doActions;
	public void initializeWebEnvirnment() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL_Actions"));
		driver.manage().window().maximize();
		this.setImplicitlyWait(10);
	
	}
	
	
	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/configActions/config.properties"));
			System.out.println("No Exception");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	public void doAction()
	{
		doActions=new Actions(driver);
	}
	
	public void setImplicitlyWait(int intTimeInSecond)
	{
		driver.manage().timeouts().implicitlyWait(intTimeInSecond, TimeUnit.SECONDS);
	}
	
	public void scrollPage(int intScrollBy)
	{
		 jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("window.scrollBy(0,"+intScrollBy+")");
	}
	
	public void moveToElement()
	{
		WebElement elementModule=driver.findElement(By.xpath("//div[text()='Elements']"));
		this.doAction();
		doActions.moveToElement(elementModule).click().build().perform();
		this.setImplicitlyWait(10);
	}
	
	public void doubleClick()
	{
		WebElement formsModule=driver.findElement(By.xpath("//div[text()='Forms']"));
		this.doAction();
		doActions.doubleClick(formsModule).build().perform();
	}
	
	
	
	public void selectAddress(String strName, String strAddress)
	{
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(strName);
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(strAddress);
		
		//selecting address

		this.doAction();
		doActions.keyDown(Keys.CONTROL);
		doActions.sendKeys("a");
		doActions.keyUp(Keys.CONTROL);
		doActions.build().perform();
		
	}
	
	public void copyAddress()
	{
		//copying address
		driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		this.doAction();
		doActions.keyDown(Keys.CONTROL);
		doActions.sendKeys("c");
		doActions.keyUp(Keys.CONTROL);
		doActions.sendKeys(Keys.TAB);
		doActions.build().perform();
	        
	}
	
	public void pasteAddress()
	{
		//pasting Address
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		this.doAction();
		doActions.keyDown(Keys.CONTROL);
		doActions.sendKeys("v");
		doActions.keyUp(Keys.CONTROL);
		doActions.sendKeys(Keys.TAB);
		doActions.build().perform();
		this.scrollPage(1000);
		System.out.println("Address pasted successfully");
	}
	
	public void verifyCurrentAndPermanentAddress()
	{
		String permanentAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).getText();
		String currentAddress=driver.findElement(By.xpath("//textarea[@id='currentAddress']")).getText();
		if(currentAddress.equals(permanentAddress))
		{
			System.out.println("Current and Permanent address is same");
		}
		else
		{
			System.out.println("Address not matched");
		}
	}
	
	public void clickOnSubmitButton()
	{

		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	public void rightClick()
	{
		this.doAction();
		doActions.contextClick().build().perform();
	}


	
	
	
}
