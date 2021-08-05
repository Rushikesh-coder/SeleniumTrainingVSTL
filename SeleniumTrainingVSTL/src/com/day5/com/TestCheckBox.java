package com.day5.com;

public class TestCheckBox {

	public static void main(String[] args) {
		SeleniumCheckBoxAndRedioButton objSeleniumCheckBoxAndRedioButton=new SeleniumCheckBoxAndRedioButton();
		objSeleniumCheckBoxAndRedioButton.initilizeWebEnvirnment();
		objSeleniumCheckBoxAndRedioButton.verifyHeaderOfCheckBoxPage();
		objSeleniumCheckBoxAndRedioButton.verifyCheckboxDemoText(objSeleniumCheckBoxAndRedioButton.objConfig.getProperty("XpSingleCheckBox"));
		objSeleniumCheckBoxAndRedioButton.verifyCheckboxDemoText(objSeleniumCheckBoxAndRedioButton.objConfig.getProperty("XPMultipleCheckBox"));
		objSeleniumCheckBoxAndRedioButton.verifySingleCheckBoxIsSected();
		objSeleniumCheckBoxAndRedioButton.selectSingleCheckBox();
		objSeleniumCheckBoxAndRedioButton.verifyMultipelCheckBox();
		objSeleniumCheckBoxAndRedioButton.selectMultipleCheckBox();
		objSeleniumCheckBoxAndRedioButton.verifyMultipelCheckBox();
//		objSeleniumCheckBoxAndRedioButton.clickonUncheckAllButton();

	}

}
