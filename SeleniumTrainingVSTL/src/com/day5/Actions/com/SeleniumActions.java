package com.day5.Actions.com;

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
	public Actions doActions;
	public void initializeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
	
	}
	
	
	public void moveToElement()
	{
		WebElement elementModule=driver.findElement(By.xpath("//div[text()='Elements']"));
		doActions=new Actions(driver);
		doActions.moveToElement(elementModule).click().build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void doubleClick()
	{

		WebElement formsModule=driver.findElement(By.xpath("//div[text()='Forms']"));
		doActions=new Actions(driver);
		doActions.doubleClick(formsModule).build().perform();
	}
	
	
	
	public void selectAddress()
	{
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Akash");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Pune, Maharashtra, India");
		
		//selecting address
		doActions=new Actions(driver);
		doActions.keyDown(Keys.CONTROL);
		doActions.sendKeys("a");
		doActions.keyUp(Keys.CONTROL);
		doActions.build().perform();
		
	}
	
	public void copyAddress()
	{
		//copying address
		driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		doActions=new Actions(driver);
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
		doActions=new Actions(driver);
		doActions.keyDown(Keys.CONTROL);
		doActions.sendKeys("v");
		doActions.keyUp(Keys.CONTROL);
		doActions.sendKeys(Keys.TAB);
		doActions.build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,2000)");
		System.out.println("Address pasted successfully");
	}
	
	
	
	public void clickOnSubmitButton()
	{

		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	public void rightClick()
	{
		doActions=new Actions(driver);
		doActions.contextClick().build().perform();
	}

	
	
	
}
