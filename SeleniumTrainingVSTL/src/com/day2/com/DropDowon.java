package com.day2.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDowon {

	public WebDriver driver = null;

	public void initilizeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
	}

	
	public void getAllDropDownsValue(String strExpectedWebElement) {
		By locators = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown']");
		List<WebElement> listOfWebElements = driver.findElements(locators);

		for (WebElement webElement : listOfWebElements) {

			System.out.println(" " + webElement.getText());
			String strActualWebElement = webElement.getText();
			if (strActualWebElement.equals(strExpectedWebElement)) {
				webElement.click();
				break;
			}

		}

	}
	
	public void getvalues(String strValue)
	{
		//By locaternew=By.xpath("//div[@id='navbar-brand-centered']/ul[@class='nav navbar-nav']/li[@class='dropdown open']/ul[@ class='dropdown-menu']");
		By locaterOFValue=By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown open']/ul[@ class='dropdown-menu']");

		List<WebElement> listOfvalues = driver.findElements(locaterOFValue);
		System.out.println("================values================");
		
		for (WebElement webElement : listOfvalues) {
			System.out.println(webElement.getText());
			String strActualValue = webElement.getText();
		
			if(strActualValue.contains(strValue))
			{
				webElement.click();
				break;
			}

		}
	}

}
