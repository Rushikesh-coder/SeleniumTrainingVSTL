package com.day1.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupSelenium {

	public WebDriver driver = null;

	public void initilizeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}
	
	public void LogInFacebook()
	{
		driver.findElement(By.id("email")).sendKeys("abcS@selenium.com");
		driver.findElement(By.id("pass")).sendKeys("Pas1@any23");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	
		
	}

	public void tearDownEnvirenment() {

		driver.quit();
	}
}
