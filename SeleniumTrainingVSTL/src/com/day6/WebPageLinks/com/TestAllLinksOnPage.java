package com.day6.WebPageLinks.com;

public class TestAllLinksOnPage {

	public static void main(String[] args) {
		WebPageLinks objWebPageLinks =new WebPageLinks();
		objWebPageLinks.initializeWebEnvirnment();
		objWebPageLinks.isPopUPVisible();
		objWebPageLinks.closePopUp();
		objWebPageLinks.verifyPageLinks();
		objWebPageLinks.getLinksDetails();

	}

}
