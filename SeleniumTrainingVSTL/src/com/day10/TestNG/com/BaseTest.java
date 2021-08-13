package com.day10.TestNG.com;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
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
	
	public WebDriver getDriver()
	{
		return driver;
	}
}
