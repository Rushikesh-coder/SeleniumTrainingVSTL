package com.day5.RedioButton.com;

public class TestRedioButton {

	public static void main(String[] args) {
		SeleniumRedioButton objSeleniumRedioButton=new SeleniumRedioButton();
		objSeleniumRedioButton.initilizeWebEnvirnment();
		objSeleniumRedioButton.verifyHeaderTextOfRedioButtonPageIsDisplayed();
		
		objSeleniumRedioButton.clickOnRedioButton("Female");
		objSeleniumRedioButton.clickonGetCheckedValueButton();
		objSeleniumRedioButton.checkResult();
		
		objSeleniumRedioButton.clickiOnGroupRedioButtonsGender("Male");
		objSeleniumRedioButton.clickOnGroupRedioButtonAge("5 - 15");
		objSeleniumRedioButton.clickonGetValueButton();
		objSeleniumRedioButton.checkGroutRedioResult();

	}

}
