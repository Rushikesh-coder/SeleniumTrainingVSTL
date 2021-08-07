package com.day5.Actions.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	
	public WebDriver driver = null;
	
	
	public Actions doActions;

	public void initializeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
		driver.manage().window().maximize();

	}
	
	public void doAction()
	{
		doActions=new Actions(driver);
	}
	
	public void slidebar()
	{
		
		WebElement MoveHere=driver.findElement(By.xpath("//h4[text()=' Default value 10']/following::div[@class='range']"));
		this.doAction();
		doActions.moveToElement(MoveHere).build().perform();
		MoveHere.click();
	}
	
	public static void main(String[] args) {
		SliderActions objSliderActions =new SliderActions();
		objSliderActions.initializeWebEnvirnment();
		objSliderActions.slidebar();
		

	}
//	public void slidebar(String strPathText, String strPathClass, int intXOffset )
//	{
//		
//		WebElement MoveHere=driver.findElement(By.xpath("//h4[text()='"+strPathText+"']/following::div[@class='"+strPathClass+"']"));
//		this.doAction();
//		doActions.moveToElement(MoveHere, intXOffset, 0).build().perform();
//		MoveHere.click();
//	}
//	objSliderActions.slidebar(" Default value 10", "range",100);
//	objSliderActions.slidebar(" Default value 50", "range range-primary", -100);
//	objSliderActions.slidebar(" Default value 30", "range range-success",50);
//	objSliderActions.slidebar(" Default value 50", "range range-info",40);
//	objSliderActions.slidebar(" Default value 50", "range range-warning",50);
}
