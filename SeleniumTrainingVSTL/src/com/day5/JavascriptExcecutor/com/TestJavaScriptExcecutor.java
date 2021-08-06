package com.day5.JavascriptExcecutor.com;

public class TestJavaScriptExcecutor {

	public static void main(String[] args) {

		SeleniumJavaScriptExcecutor objSeleniumJavaScriptExcecutor = new SeleniumJavaScriptExcecutor();
		objSeleniumJavaScriptExcecutor.initilizeWebEnvirnment();
		objSeleniumJavaScriptExcecutor.scrollPage();
		objSeleniumJavaScriptExcecutor.javaScriptExcecuter(
				objSeleniumJavaScriptExcecutor.objConfig.getProperty("FirstName"),
				objSeleniumJavaScriptExcecutor.objConfig.getProperty("LastName"),
				objSeleniumJavaScriptExcecutor.objConfig.getProperty("Email"),
				objSeleniumJavaScriptExcecutor.objConfig.getProperty("PhoneNumber"));

	}

}
