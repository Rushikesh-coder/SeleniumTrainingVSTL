package com.day4.com;

import java.util.Hashtable;
import java.util.Random;

public class Utility {

	Random objRandomClass = new Random();
	public Hashtable<String, String> objHashTable;

	public Utility() {
		objHashTable = new Hashtable<>();
	}
	
	
	public Hashtable<String, String> signUpTestData() {

		objHashTable = new Hashtable<>();
		objHashTable.put("SignupPageTitle", "Create a new account");
		objHashTable.put("FirstName", "Rupam");
		objHashTable.put("LastName", "Patil");
		objHashTable.put("MobileNumber", "9748");
		objHashTable.put("Password", "ABC@123");
		//objHashTable.put("Date", "21");
		objHashTable.put("Day", "");
		objHashTable.put("Month", "");
		objHashTable.put("Year", "");
		objHashTable.put("Gender", "Male");
		objHashTable.put("xpFirstName", "firstname");
		objHashTable.put("xpLastName", "lastname");
		objHashTable.put("HomePage", "LogOut");
		return objHashTable;
	}
	

	public String randomName(int intLength) {
		String charaToz = "abcdefghijklmnopqrstuvwxyz";
		String strRandomName = "";
		for (int i = 0; i < intLength; i++) {
			int intRandomNumber = (int) (Math.random() * charaToz.length());
			strRandomName += charaToz.substring(intRandomNumber, intRandomNumber + 1);
		}
		return strRandomName;

	}

	public String randomNumber() {

		String strRandomMobileNumber = "";
		for (int intIndex = 0; intIndex < 9; intIndex++) {
			strRandomMobileNumber = strRandomMobileNumber + (int) (Math.random() * 9);
		}

		return strRandomMobileNumber;
	}

	public String randomDay()
	{
		int intDay = 0; // Day
		intDay = intDay + (int) (Math.random() * 31);
		if (intDay == 0) {
			intDay = 1 + intDay;
		}
		return String.valueOf(intDay);
		
	}
	
	public int randomMonth()
	{
//		String strArrayMonth[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }; // Month
//		String strRandomMonth = strArrayMonth[objRandomClass.nextInt(strArrayMonth.length - 1)];
		int intRandomMonth=objRandomClass.nextInt(13);
		return intRandomMonth;
	}
	public String randomYear() {
		
		int intYearTemp = 0;
		int intYear = 0; // Year
		for (int intIndex = 0; intIndex < 100; intIndex++) {
			intYearTemp = objRandomClass.nextInt(2021);
			if (intYearTemp > 1950) {
				intYear = intYearTemp;
				break;
			}
			
		}
		return String.valueOf(intYear);

	}

	

}
