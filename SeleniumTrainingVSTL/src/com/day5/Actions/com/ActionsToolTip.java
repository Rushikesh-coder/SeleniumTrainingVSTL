package com.day5.Actions.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsToolTip {
	public WebDriver driver = null;
	public JavascriptExecutor jsExecutor;
	
	public Actions doActions;

	public void initializeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().window().maximize();

	}
	
	public void doAction()
	{
		doActions=new Actions(driver);
	}
	
	public void setImplicitlyWait(int intTimeInSecond)
	{
		driver.manage().timeouts().implicitlyWait(intTimeInSecond, TimeUnit.SECONDS);
	}
	
	public void hoverOverButton() {
		this.doAction();
		
		WebElement webHoverOver=driver.findElement(By.xpath("//button[text()='Hover me to see']"));
		doActions.moveToElement(webHoverOver).build().perform();
	}
	public void hoverOverText()
	{
		this.setImplicitlyWait(20);
		WebElement webHoverOver=driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
		doActions.moveToElement(webHoverOver).build().perform();
	}
	public static void main(String[] args) {
		ActionsToolTip objActionsToolTip =new ActionsToolTip();
		objActionsToolTip.initializeWebEnvirnment();
		objActionsToolTip.hoverOverButton();
		objActionsToolTip.hoverOverText();
	}

}
