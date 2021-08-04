package com.day3.com;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	
	public void verifyDemoPageIsDisplayed()
	{
		String strText=driver.findElement(By.xpath("//h3[text()='This would be your first example to start with Selenium.']")).getText();
		
		if(driver.findElement(By.xpath("//h3[text()='This would be your first example to start with Selenium.']")).isDisplayed())
		{
			System.out.println("Simple form Demo Page is Open : "+strText);
		}
		else
		{
			System.out.println("Page not Open");
		}
	}
	
//	public void verifySingleTextField()
//	{
////		String strSingleField=driver.findElement(By.xpath("//div[text()='Single Input Field']")).getText();
//		
//		if(driver.findElement(By.xpath("//div[text()='Single Input Field']")).isDisplayed())
//		{
//			System.out.println("Single Input Field is Visible ");
//		}
//		else {
//			System.out.println("Single Input Field is Not Visible");
//		}
//	}
	
	public void verifyInputFields(String strInputField)
	{
		if(driver.findElement(By.xpath("//div[text()='"+strInputField+"']")).isDisplayed())
		{
			System.out.println(strInputField+" : Visible ");
		}
		else {
			System.out.println(strInputField+" : Not Visible");
		}
	}

	public void setSingleInput(String strsendkeys)
	{
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(strsendkeys);
		
	}
	public void clickOnShowMsg()
	{
		driver.findElement(By.xpath("//button[text()='Show Message']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void verifyMsgOfSingleInput(String strExpectedMsg) {
		
		String strActualText = driver.findElement(By.xpath("//*[@id='display']")).getText();
		if(strActualText.equals(strExpectedMsg))
		{
			System.out.println("Massege is Verifed : Same : "+strExpectedMsg);
		}
		else
		{
			System.out.println("Wrong Massege ");
		}
	}
	
	public void setTwoInputFields(String strLocator, String strNumber)
	{
		
		driver.findElement(By.xpath("//*[@id='"+strLocator+"']")).sendKeys(strNumber);
		
		
	}
	public void clickOnGetTotal()
	{
		driver.findElement(By.xpath("//*[text()='Get Total']")).click();
	}

	public void verifyMsgOfTwoInputField(String strNumberOne, String strNumberTwo) {
		int intResult= Integer.parseInt(strNumberOne)+Integer.parseInt(strNumberTwo);
		
		String strActualSum = driver.findElement(By.xpath("//*[@id='displayvalue']")).getText();
		if(intResult==Integer.parseInt(strActualSum))
		{
			System.out.println("Sum is Correct : Verifyed : "+strActualSum);
		}
		else
		{
			System.out.println("Wrong Calculation ");
		}

	}

}
