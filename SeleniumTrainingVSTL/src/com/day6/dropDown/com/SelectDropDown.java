package com.day6.dropDown.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	
		
		public WebDriver driver = null;
	public JavascriptExecutor jsExecutor;
	public Select dropDown;
	
	public Actions doActions;

	public void initializeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();

	}
	
	public void selectRefrence(String strPath)
	{
		 dropDown=new Select(driver.findElement(By.xpath("//select[@id='"+strPath+"']")));
	}
	
	public void checkPegeHeader()
	{
		if (driver.findElement(By.xpath("//h3[text()='This would be your first example on select dropd down list to with Selenium.']")).isDisplayed()) {
			System.out.println("Header is Displayed");
		} else {
			System.out.println("Header is not Displyed");
		}
	}
	
	public void getDefalultSelectedItem()
	{
		this.selectRefrence("select-demo");
		String DefaultSelected=dropDown.getFirstSelectedOption().getText();

		System.out.println("Default Selected Item :"+DefaultSelected);
	}
	public boolean isDropdownSelected()
	{
		boolean blnFlag=false;
		blnFlag=driver.findElement(By.xpath("//select[@id='select-demo']")).isSelected();
		
		return blnFlag;
	}
	
	
	
	public void selectValueFromDropDown()
	{
		if(isDropdownSelected())
		{
			System.out.println("DropDown is alredy selected");
		}
		else
		{
			this.selectRefrence("select-demo");
			dropDown.selectByVisibleText("Tuesday");
			
		}
	}
	
	public void selectMultipleValuesFromDropDown()
	{
		this.selectRefrence("multi-select");
		dropDown.selectByVisibleText("California");
		dropDown.selectByVisibleText("New Jersey");
		dropDown.selectByVisibleText("Texas");
		
	}
}
