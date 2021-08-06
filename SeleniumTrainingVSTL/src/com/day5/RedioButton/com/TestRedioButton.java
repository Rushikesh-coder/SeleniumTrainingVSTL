package com.day5.RedioButton.com;

public class TestRedioButton {

	public static void main(String[] args) {
		SeleniumRedioButton objSeleniumRedioButton=new SeleniumRedioButton();
		objSeleniumRedioButton.initilizeWebEnvirnment();
		objSeleniumRedioButton.verifyHeaderTextOfRedioButtonPage();
		objSeleniumRedioButton.checkIsRedioButtonIsSelected();
		objSeleniumRedioButton.clickOnRedioButton();
		objSeleniumRedioButton.clickonGetCheckedValueButton();
		objSeleniumRedioButton.checkResult();
		objSeleniumRedioButton.clickiOnGroupRedioButtonsGender();
		objSeleniumRedioButton.clickOnGroupRedioButtonAge();
		objSeleniumRedioButton.clickonGetValueButton();
		objSeleniumRedioButton.checkGroutRedioResult();

	}

}
