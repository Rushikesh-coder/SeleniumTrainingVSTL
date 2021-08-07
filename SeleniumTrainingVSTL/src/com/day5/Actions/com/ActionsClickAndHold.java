package com.day5.Actions.com;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndHold {

	public WebDriver driver = null;
	public JavascriptExecutor jsExecutor;
	
	public Actions doActions;

	public void initializeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/menu");
		driver.manage().window().maximize();

	}
	
	public void doAction()
	{
		doActions=new Actions(driver);
	}
	
	public void clickAndHold()
	{
		WebElement webElement =driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		this.doAction();
		doActions.moveToElement(webElement);
		doActions.clickAndHold();
		
		doActions.build().perform();
	}
	
	

	public static void main(String[] args) {

	ActionsClickAndHold objActionsClickAndHold=new ActionsClickAndHold();
	objActionsClickAndHold.initializeWebEnvirnment();
	objActionsClickAndHold.clickAndHold();
	
	}

}
