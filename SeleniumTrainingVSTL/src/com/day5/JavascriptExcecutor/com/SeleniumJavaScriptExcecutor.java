package com.day5.JavascriptExcecutor.com;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumJavaScriptExcecutor {
	public WebDriver driver = null;
	public Properties objConfig;

	public JavascriptExecutor jsExcecutor;
	public void initilizeWebEnvirnment() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL_JsExecutor"));
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
	
	public void scrollPage()
	{
		 jsExcecutor = (JavascriptExecutor) driver;  
		jsExcecutor.executeScript("window.scrollBy(0,2000)");
	}
	
	public void javaScriptExcecuter(String strName, String strLastname, String strEmail, String strPhone)
	{
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(strName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(strLastname);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(strEmail);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(strPhone);
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		WebElement webElementButton=driver.findElement(By.xpath("//button[@type='submit']"));
		jsExcecutor = (JavascriptExecutor)driver;	
		jsExcecutor.executeScript("arguments[0].click();", webElementButton);
	}
	
	
}
