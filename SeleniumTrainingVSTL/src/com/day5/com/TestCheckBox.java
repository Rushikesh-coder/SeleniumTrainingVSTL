package com.day5.com;

public class TestCheckBox {

	public static void main(String[] args) {
		SeleniumCheckBox objSeleniumCheckBoxAndRedioButton=new SeleniumCheckBox();
		objSeleniumCheckBoxAndRedioButton.initilizeWebEnvirnment();
		objSeleniumCheckBoxAndRedioButton.verifyHeaderOfCheckBoxPage();
		objSeleniumCheckBoxAndRedioButton.verifyCheckboxDemoText(objSeleniumCheckBoxAndRedioButton.objConfig.getProperty("XpSingleCheckBox"));
		objSeleniumCheckBoxAndRedioButton.verifyCheckboxDemoText(objSeleniumCheckBoxAndRedioButton.objConfig.getProperty("XPMultipleCheckBox"));

		objSeleniumCheckBoxAndRedioButton.selectSingleCheckBox();
		objSeleniumCheckBoxAndRedioButton.selectMultipleCheckBox("Option 1");
		objSeleniumCheckBoxAndRedioButton.selectMultipleCheckBox("Option 2");
		objSeleniumCheckBoxAndRedioButton.selectMultipleCheckBox("Option 3");
		objSeleniumCheckBoxAndRedioButton.selectMultipleCheckBox("Option 4");
		

	}

}
//objSeleniumCheckBoxAndRedioButton.verifySingleCheckBoxIsSected();