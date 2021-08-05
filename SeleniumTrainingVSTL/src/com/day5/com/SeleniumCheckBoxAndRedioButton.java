package com.day5.com;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCheckBoxAndRedioButton {

	public WebDriver driver = null;
	public Properties objConfig;

	public void initilizeWebEnvirnment() {

		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL_CheckBox"));
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

	public void verifyHeaderOfCheckBoxPage() {

		if (driver
				.findElement(By
						.xpath("//h3[text()='This would be a basic example to start with checkboxes using selenium.']"))
				.isDisplayed()) {
			System.out.println("Header is Displayed");
		} else {
			System.out.println("Header is not Displyed");
		}
	}

	public void verifyCheckboxDemoText(String strCheckBoxPath) {

		if (driver.findElement(By.xpath("//div[text()='" + strCheckBoxPath + "']")).isDisplayed()) {
			System.out.println("Check Box Text is Visible");
		} else {
			System.out.println("Check Box field is not visible");
		}

	}

	public boolean verifySingleCheckBoxIsSected() {
		boolean blnFlag = true;
		blnFlag = driver.findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
		return blnFlag;
	}

	public void selectSingleCheckBox() {
		if (!verifySingleCheckBoxIsSected()) {
			driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		}
	}

	public void verifyMultipelCheckBox() {
		By locators = By.xpath("//input[@class='cb1-element']");
		List<WebElement> listOfElement = driver.findElements(locators);

		for (WebElement webElement : listOfElement) {
			if (webElement.isSelected()) {
				System.out.println("check box is checked");
			} else {
				System.out.println("check box is not checked");
			}
		}
	}

	public void selectMultipleCheckBox() {
		By locators = By.xpath("//input[@class='cb1-element']");
		List<WebElement> listOfElement = driver.findElements(locators);

		for (WebElement webElement : listOfElement) {
			webElement.click();
		}
	}
	
//	public void clickonUncheckAllButton()
//	{
//		driver.findElement(By.xpath("//input[@id='check1']")).click();
//	}

}
