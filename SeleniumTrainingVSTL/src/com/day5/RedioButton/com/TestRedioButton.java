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
		objSeleniumRedioButton.checkIsGroupRedioButtonIsSelected();
		objSeleniumRedioButton.clickiOnGroupRedioButtons();
		objSeleniumRedioButton.clickonGetValueButton();
		objSeleniumRedioButton.checkGroutRedioResult();

	}

}
