package com.day3.com;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDropDown {

	public WebDriver driver = null;
	public Properties objConfig;

	public void initilizeWebEnvirnment() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL"));
		// driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
	}

	public boolean isPopUPVisible() {
		boolean blnFlag = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			blnFlag = driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).isDisplayed();
			return blnFlag;
		} catch (Exception exception) {
			System.out.println("Not Getting Pop Up" + exception.getMessage());
			return blnFlag;
		}
	}

	public void closePopUp() {
		if (this.isPopUPVisible()) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
		}

	}

	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/config/config.properties"));
			System.out.println("No Exception");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	public void getAllDropDownsValue(String strExpectedWebElement) {
		By locators = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strExpectedWebElement+"')]");
		driver.findElement(locators).click();

	}

	public void getvalues(String strValueOfDropDown) {

		By locaterOFValue = By
				.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='" + strValueOfDropDown + "']");

		driver.findElement(locaterOFValue).click();

	}

	public void getDropdownAndValues(String strSelectDropDown, String strSelectValue) {
		
		this.getAllDropDownsValue(strSelectDropDown);
		this.getvalues(strSelectValue);
	}
	
//	public void gettitleOfDemoPage()
//	{
//		String strText=driver.findElement(By.xpath("//h3[text()='This would be your first example to start with Selenium.']")).getText();
//		System.out.println("Text on the page : "+strText);
//	}

	public void enterAndShowMsg(String strsendkeys) {
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(strsendkeys);
		driver.findElement(By.xpath("//button[text()='Show Message']")).click();
		String ActualText = driver.findElement(By.xpath("//*[@id='display']")).getText();
		System.out.println("Entered String : " + ActualText);
	}

	public void twoInputField(String strSumOne, String strSumTwo) {

		driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(strSumOne);
		driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(strSumTwo);
		driver.findElement(By.xpath("//*[text()='Get Total']")).click();

		String strActualSum = driver.findElement(By.xpath("//*[@id='displayvalue']")).getText();
		System.out.println("Sum of Numbers : " + strActualSum);

	}

}
