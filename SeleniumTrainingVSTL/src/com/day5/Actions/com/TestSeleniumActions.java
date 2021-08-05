package com.day5.Actions.com;

public class TestSeleniumActions {

	public static void main(String[] args) {
		SeleniumActions objSeleniumActions=new SeleniumActions();
		objSeleniumActions.initializeWebEnvirnment();
		
		objSeleniumActions.selectAddress();
		objSeleniumActions.copyAddress();
		objSeleniumActions.pasteAddress();
		objSeleniumActions.clickOnSubmitButton();
		objSeleniumActions.rightClick();
		objSeleniumActions.moveToElement();
		objSeleniumActions.doubleClick();
		objSeleniumActions.rightClick();
		
		

	}

}
