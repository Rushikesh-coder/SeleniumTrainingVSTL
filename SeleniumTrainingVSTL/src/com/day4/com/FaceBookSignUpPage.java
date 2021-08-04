package com.day4.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FaceBookSignUpPage {

	public WebDriver driver = null;
	public Select selectDropdownDate;

	public void initializeWebEnvirnment() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/externalResources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
	}
	
	public void verifySignupPage()
	{
		System.out.println("Create a new account Page is open");
	}

	public void setName(String strName) {

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(strName);
		System.out.println("First Name is : " + strName + "\n");
	}

	public void setLastName(String strLastName) {
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(strLastName);
		System.out.println("Last Name is : " + strLastName + "\n");
	}

	public void setMobileNumber(String strMobilNumber) {
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(strMobilNumber);
		System.out.println("Phone Number is : " + strMobilNumber + "\n");
	}

	public void setPassword(String strPassword) {
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(strPassword);
		System.out.println("Password is : " + strPassword + "\n");
	}

	public void setDay(String strDay) {
		selectDropdownDate = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		selectDropdownDate.selectByValue(strDay);
	}

	public void setMonth(int strMonth) {
		selectDropdownDate = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		selectDropdownDate.selectByIndex(strMonth);
		System.out.println("Date is : " + strMonth + "\n");
	}

	public void setYear(String strYear) {
		selectDropdownDate = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		selectDropdownDate.selectByValue(strYear);

		System.out.println("Date is : " + strYear + "\n");
	}

	public void setGender(String strGender) {

		driver.findElement(By.xpath("//input[@value='2']")).click();
		System.out.println("Gender is : " + strGender + "\n");
	}

	public void clickSignUpButton() {
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		System.out.println("Sign Up Button is Clicked\n");
	}
}
