package com.day3.com;

public class TestSeleniumDropDown {

	public static void main(String[] args) {

		SeleniumDropDown objSeleniumDropDown = new SeleniumDropDown();
		objSeleniumDropDown.initilizeWebEnvirnment();
		objSeleniumDropDown.isPopUPVisible();
		objSeleniumDropDown.closePopUp();
		objSeleniumDropDown.getDropdownAndValues(objSeleniumDropDown.objConfig.getProperty("strDropDownName"),objSeleniumDropDown.objConfig.getProperty("strDropDownValue"));
		objSeleniumDropDown.verifyDemoPageIsDisplayed();
		objSeleniumDropDown.verifyInputFields(objSeleniumDropDown.objConfig.getProperty("Single_InputFields"));
		
		objSeleniumDropDown.setSingleInput(objSeleniumDropDown.objConfig.getProperty("setSingleInput"));
		objSeleniumDropDown.clickOnShowMsg();
		objSeleniumDropDown.verifyMsgOfSingleInput(objSeleniumDropDown.objConfig.getProperty("setSingleInput"));
		objSeleniumDropDown.verifyInputFields(objSeleniumDropDown.objConfig.getProperty("Two_InputFields"));
		objSeleniumDropDown.setTwoInputFields(objSeleniumDropDown.objConfig.getProperty("xpathEnter_A"), objSeleniumDropDown.objConfig.getProperty("NumberOne"));
		objSeleniumDropDown.setTwoInputFields(objSeleniumDropDown.objConfig.getProperty("xpathEnter_B"), objSeleniumDropDown.objConfig.getProperty("NumberTwo"));
		objSeleniumDropDown.clickOnGetTotal();
		objSeleniumDropDown.verifyMsgOfTwoInputField(objSeleniumDropDown.objConfig.getProperty("NumberOne"), objSeleniumDropDown.objConfig.getProperty("NumberTwo"));
	}

}
