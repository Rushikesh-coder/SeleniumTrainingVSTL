package com.day3.com;

public class TestSeleniumDropDown {

	public static void main(String[] args) {

		SeleniumDropDown objSeleniumDropDown = new SeleniumDropDown();
		objSeleniumDropDown.initilizeWebEnvirnment();
		objSeleniumDropDown.isPopUPVisible();
		objSeleniumDropDown.closePopUp();
		objSeleniumDropDown.getDropdownAndValues(objSeleniumDropDown.objConfig.getProperty("strDropDownName"),objSeleniumDropDown.objConfig.getProperty("strDropDownValue"));
		//objSeleniumDropDown.gettitleOfDemoPage();
		objSeleniumDropDown.enterAndShowMsg(objSeleniumDropDown.objConfig.getProperty("sendkeysInput"));
		objSeleniumDropDown.twoInputField(objSeleniumDropDown.objConfig.getProperty("strSumOne"), objSeleniumDropDown.objConfig.getProperty("strSumTwo"));
		
	}

}
