package com.day1.com;

public class TestSeleniumSetup {

	public static void main(String[] args) {
		SetupSelenium objSetupSelenium=new SetupSelenium();
		objSetupSelenium.initilizeWebEnvirnment();
		objSetupSelenium.LogInFacebook();
		objSetupSelenium.tearDownEnvirenment();
		

	}

}
