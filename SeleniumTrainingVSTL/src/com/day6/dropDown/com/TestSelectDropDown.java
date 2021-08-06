package com.day6.dropDown.com;

public class TestSelectDropDown {

	public static void main(String[] args) {
		SelectDropDown objSelectDropDown =new SelectDropDown();
		objSelectDropDown.initializeWebEnvirnment();
		objSelectDropDown.checkPegeHeader();
		objSelectDropDown.getDefalultSelectedItem();
		objSelectDropDown.selectValueFromDropDown();
		objSelectDropDown.selectMultipleValuesFromDropDown();

	}

}
