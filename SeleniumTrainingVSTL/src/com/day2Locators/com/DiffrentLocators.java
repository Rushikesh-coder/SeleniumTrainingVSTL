package com.day2Locators.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiffrentLocators {
	public WebDriver driver = null;

	public void initilizeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
	}
	
	public void locatorExample()
	{
		
		driver.findElement(By.id("user-message")).sendKeys("Selenium Practice");  //by ID
		
		driver.findElement(By.linkText("Date pickers")).click();  //By LinkText
		driver.findElement(By.partialLinkText("Home")).click();    //by PartialLinkText
		
	}
}
