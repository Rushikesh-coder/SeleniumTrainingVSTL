package com.day5.Actions.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
	public WebDriver driver = null;
	public Actions doActions;
	public void initializeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
	
	}
	
	public void dragAndDrop()
	{
		WebElement elementFrom=driver.findElement(By.xpath("//div[text()='Drag me']"));
		WebElement elementTo=driver.findElement(By.xpath("//*[@id='droppable']"));
		doActions=new Actions(driver);
		doActions.dragAndDrop(elementFrom, elementTo).build().perform();
		
		
		
	}
	public static void main(String[] args) {
		

		DragAndDropActions objDragAndDropActions=new DragAndDropActions();
		objDragAndDropActions.initializeWebEnvirnment();
		objDragAndDropActions.dragAndDrop();
	}

}
