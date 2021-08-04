package com.day4.com;

public class TestSignUpPage {

	public static void main(String[] args) {
		
		SignUpFlow objSignUpFlow=new SignUpFlow();
		objSignUpFlow.intializeWebEnvirnmentFromFlow();
		objSignUpFlow.doSignUp();
		objSignUpFlow.verifyHomePageIsVisible();
		
		

	}

}
