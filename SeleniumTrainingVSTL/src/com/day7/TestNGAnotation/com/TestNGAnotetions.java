package com.day7.TestNGAnotation.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnotetions {

	@BeforeSuite
	public void sute()
	{
		System.out.println("Before sute");
	}
	@AfterSuite
	public void suteAfter() {
		System.out.println("After sute");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void initializeWebEnvirnment()
	{
		System.out.println("Website Envirnment get setup");
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Closed Browser");
	}
	
	@BeforeMethod
	public void clickOnSearch()
	{
		System.out.println("Search Icon Clicked");
	}
	@AfterMethod
	public void clickBack()
	{
		System.out.println("back to home page");
	}
	
	@Test(priority = 1)
	public void enterProductDetailsGrocery()
	{
		System.out.println("grocery Product details are enterd and clicked on search");
	}
	
	@Test(priority = 2)
	public void enterProductDetailsCloths()
	{
		System.out.println("TShirt product Details are enterd and clicked on serch");
	}
	
	@Test(priority = 3, groups="ProductDetails")
	public void clickOnProductDetailsTV()
	{
		System.out.println("Product Details of TV is  Enterd and clicked on search ");
	}
	
	@Test(priority = 4, groups="ProductDetails")
	public void clickOnProductDetailsComputer()
	{
		System.out.println("Product Details of Computer is Enterd and clicked on search ");
	}
	
	
	
	
}
