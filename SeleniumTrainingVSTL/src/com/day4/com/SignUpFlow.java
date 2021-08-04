package com.day4.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpFlow {

	private FaceBookSignUpPage objFaceBookSignUpPage;
	private FaceBookHomePage objFaceBookHomePage;
	private Utility objUtility;
	String strTestData = "";

	public SignUpFlow() {

		objFaceBookSignUpPage = new FaceBookSignUpPage();
		objFaceBookHomePage = new FaceBookHomePage();
		objUtility = new Utility();

	}
	
	public void intializeWebEnvirnmentFromFlow()
	{
		objFaceBookSignUpPage.initializeWebEnvirnment();
	}
	
	
	public void doSignUp() {
		
		strTestData=objUtility.signUpTestData().get("SignupPageTitle");
		if(!strTestData.equals(""))
		{
			String strActualText=objFaceBookSignUpPage.driver.findElement(By.xpath("//div[text()='नवीन खाते तयार करा']")).getText();
			if(strActualText.equals("नवीन खाते तयार करा"))
			{
				
				objFaceBookSignUpPage.verifySignupPage();
			}
			else
			{
				System.out.println("Page Not open");
			}
		}

		strTestData = objUtility.signUpTestData().get("FirstName")+objUtility.randomName(4);
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setName(strTestData,objUtility.signUpTestData().get("xpFirstName"));

		}

		strTestData = objUtility.signUpTestData().get("LastName")+objUtility.randomName(4);
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setLastName(strTestData, objUtility.signUpTestData().get("xpLastName"));
		}

		strTestData = objUtility.signUpTestData().get("MobileNumber")+objUtility.randomNumber();
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setMobileNumber(strTestData);
		}

		strTestData = objUtility.signUpTestData().get("Password");
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setPassword(strTestData);
		}

//		strTestData = objUtility.signUpTestData().get("Date")+objUtility.randomDate();
//		if (!strTestData.equals("")) {
//			objFaceBookSignUpPage.setDate(strTestData);
//		}
		
		strTestData=objUtility.signUpTestData().get("Day")+objUtility.randomDay();
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setDay(strTestData);
		}
		strTestData=objUtility.signUpTestData().get("Month")+objUtility.randomMonth();
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setMonth(Integer.parseInt(strTestData));
		}
		
		strTestData=objUtility.signUpTestData().get("Year")+objUtility.randomYear();
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setYear(strTestData);
		}
		
		strTestData = objUtility.signUpTestData().get("Gender");
		if (!strTestData.equals("")) {
			objFaceBookSignUpPage.setGender(strTestData);
		}
		
		

		objFaceBookSignUpPage.clickSignUpButton();

	}

	public void verifyHomePageIsVisible() {
		String strExpectedData = objFaceBookHomePage.getLogOutText();

		strTestData = objUtility.signUpTestData().get("HomePage");

		if (strExpectedData.equals(strTestData)) {
			System.out.println("LogOut Button is visible");
			System.out.println("Test Passed");

		} else {
			System.out.println("LogOut Button is not visible");

			System.out.println("Test failed");
		}
	}
}
