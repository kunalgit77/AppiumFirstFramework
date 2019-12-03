package com.appium.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.testbase.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralUtility 
{
	AndroidDriver<AndroidElement>driver;
	public GeneralUtility(AndroidDriver<AndroidElement>driver)
	{
		this.driver = driver;
	}
	
	
     public void scrolltotext(String text)
     {
 		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
     }
}
