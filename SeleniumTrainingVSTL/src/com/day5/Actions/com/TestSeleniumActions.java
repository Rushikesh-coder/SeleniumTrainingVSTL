package com.day5.Actions.com;

public class TestSeleniumActions {

	public static void main(String[] args) {
		SeleniumActions objSeleniumActions = new SeleniumActions();
		objSeleniumActions.initializeWebEnvirnment();

		objSeleniumActions.selectAddress(objSeleniumActions.objConfig.getProperty("ActionPageName"),
				objSeleniumActions.objConfig.getProperty("CurrentAddress"));
		objSeleniumActions.copyAddress();
		objSeleniumActions.pasteAddress();
		objSeleniumActions.verifyCurrentAndPermanentAddress();
		objSeleniumActions.clickOnSubmitButton();
		objSeleniumActions.moveToElement();
		objSeleniumActions.doubleClick();
		objSeleniumActions.rightClick();
		
	}

}
