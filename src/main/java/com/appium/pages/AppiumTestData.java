package com.appium.pages;

import org.testng.annotations.DataProvider;

public class AppiumTestData {
	
	  @DataProvider(name="InputData")
	  public static Object[][] getEditData()
	  {
		  Object[][] obj = new Object[][]
		  {
			  {"hello"}, {"@#$%"}
		  };
		  return obj;
	  }
	 
	  
	  
}
