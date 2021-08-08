package com.day6.dropDown.com;

public class TestSelectDropDown {

	public static void main(String[] args) {
		SelectDropDown objSelectDropDown = new SelectDropDown();
		objSelectDropDown.initializeWebEnvirnment();
		objSelectDropDown.checkPegeHeaderIsDisplayed();
		objSelectDropDown.verifySelectListDemoText("Select List Demo");
		objSelectDropDown.verifySelectListDemoText("Multi Select List Demo");
		objSelectDropDown.getDefalultSelectedItem();
		objSelectDropDown.selectValueFromDropDown(objSelectDropDown.objConfig.getProperty("DropDownSingleDay"));
		objSelectDropDown.getselectedValue("selected-value");
		objSelectDropDown.selectMultipleValuesDropDown(objSelectDropDown.objConfig.getProperty("DropDownValue1st"),
				objSelectDropDown.objConfig.getProperty("DropDownValue2nd"),
				objSelectDropDown.objConfig.getProperty("DropDownValue3rd"));
		objSelectDropDown.clickOnGetAllSelectedButton();
		objSelectDropDown.getselectedValue("getall-selected");

	}

}
