package com.day6.dropDown.com;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	public Properties objConfig;
	public Select dropDown;
	
	public Actions doActions;

	public void initializeWebEnvirnment() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL_DropDown"));
		driver.manage().window().maximize();

	}
	
	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/configDropDown/config.properties"));
			System.out.println("No Exception");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	public void setImplicitlyWait(int intTimeInSecond)
	{
		driver.manage().timeouts().implicitlyWait(intTimeInSecond, TimeUnit.SECONDS);
	}
	
	public void scrollPage(int intScrollBy)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,"+intScrollBy+")");
	}
	
	public void selectRefrance(String strPath)
	{
		 dropDown=new Select(driver.findElement(By.xpath("//select[@id='"+strPath+"']")));
	}
	
	public void checkPegeHeaderIsDisplayed()
	{
		if (driver.findElement(By.xpath("//h3[text()='This would be your first example on select dropd down list to with Selenium.']")).isDisplayed()) {
			System.out.println("Header is Displayed");
		} else {
			System.out.println("Header is not Displyed");
		}
	}
	
	public void verifySelectListDemoText(String strSelectListPath)    //verify Select Text Single and Multi
	{
		By locator= By.xpath("//div[text()='"+strSelectListPath+"']");
		if (driver.findElement(locator).isDisplayed()) {
			System.out.println(driver.findElement(locator).getText()+" Text is Visible");
		} else {
			System.out.println("Select List Demo field is not visible");
		}

	}
	
	public void getDefalultSelectedItem()
	{
		this.selectRefrance("select-demo");
		String DefaultSelected=dropDown.getFirstSelectedOption().getText();

		System.out.println("Default Selected Item :"+DefaultSelected);
	}
	public boolean isDropdownSelected()
	{
		boolean blnFlag=false;
		blnFlag=driver.findElement(By.xpath("//select[@id='select-demo']")).isSelected();
		
		return blnFlag;
	}
	
	
	
	public void selectValueFromDropDown(String strSelectDay)
	{
		if(isDropdownSelected())
		{
			System.out.println("DropDown is alredy selected");
		}
		else
		{
			this.selectRefrance("select-demo");
			dropDown.selectByVisibleText(strSelectDay);
			
		}
	}
	
	public void getselectedValue(String getValuePath)    //getSelected value single and Multi
	{
		String strgetSelectedValue=driver.findElement(By.xpath("//p[@class='"+getValuePath+"']")).getText();
		System.out.println(strgetSelectedValue);
	}
	
	public void selectMultipleValuesDropDown(String strSelectOptionOne, String strSelectOptionTwo, String strSelectOptionThree) {
		this.scrollPage(300);
		this.selectRefrance("multi-select");
		if (dropDown.isMultiple()) {
			dropDown.selectByVisibleText(strSelectOptionOne);
			dropDown.selectByVisibleText(strSelectOptionTwo);
			dropDown.selectByVisibleText(strSelectOptionThree);
		}
		else {
			System.out.println("You cannot select multiple Options");
		}
		
	}
	
	public void clickOnGetAllSelectedButton() {
		this.setImplicitlyWait(10);
		driver.findElement(By.xpath("//button[@id='printAll']")).click();
	}
	
}
