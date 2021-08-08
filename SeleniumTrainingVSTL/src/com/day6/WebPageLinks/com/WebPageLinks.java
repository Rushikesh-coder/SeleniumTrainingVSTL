package com.day6.WebPageLinks.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebPageLinks {
	public WebDriver driver = null;
	public JavascriptExecutor jsExecutor;
	public Properties objConfig;
	public HttpsURLConnection hucConnections=null;
	
	public int intBrokanLinkSize=0;
	public int intNullLinksSize=0;
	public int intValidLinkCount=0;
	

	public void initializeWebEnvirnment() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfig.getProperty("AUT_URL"));
		driver.manage().window().maximize();

	}
	
	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/configAllLinksOnPage/config.properties"));
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
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

	
	public void verifyPageLinks()
	{
		List<WebElement> allLinks =driver.findElements(By.tagName("a"));
		System.out.println("Total Links present on the page : "+allLinks.size());
		for (WebElement webElementLink : allLinks) {
			String strURl=webElementLink.getAttribute("href");
			System.out.println("==============================================================");
			System.out.println("Link Text :"+webElementLink.getText());
			
			if(strURl==null || strURl.isEmpty())
			{
				System.out.println(strURl+" Link is Empty");
				intNullLinksSize++;
				continue;
			}
			
			try {
				hucConnections = (HttpsURLConnection) new URL(strURl).openConnection();
				
				hucConnections.connect();
				if (hucConnections.getResponseCode() >= 400) {
					System.out.println(strURl + " Link is broken");
					intBrokanLinkSize++;
				} 
				else {
					System.out.println(strURl + " Link is Valid");
					intValidLinkCount++;
					System.out.println(intValidLinkCount);
				}
				} catch (Exception exception) {
					System.out.println("Got a Exception :"+exception.getMessage());
					exception.printStackTrace();
				}
				
			}
		
		
		
		}
		
	public void getLinksDetails() {
		System.out.println("Total number of Broken Links : "+intBrokanLinkSize);
		System.out.println("Total number of Empty/Null Links : "+intNullLinksSize);
		System.out.println("Total number of Valid Links : "+intValidLinkCount);
		}
}
	


