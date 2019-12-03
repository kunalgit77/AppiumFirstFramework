package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemoPrefDependency 
{
  public ApiDemoPrefDependency(AndroidDriver<AndroidElement>driver)
  {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }
  
  @AndroidFindBy(id="android:id/checkbox")
  public WebElement clickCheckbox;
  
  @AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement clickWifiSettings;
  
  @AndroidFindBy(className="android.widget.EditText")
   public WebElement giveWifiName;
  
  @AndroidFindBy(className="android.widget.Button")
  public WebElement clicks;
  
  public void setUpWifi(String input)
  {
	  clickCheckbox.click();
	  clickWifiSettings.click();
	  giveWifiName.sendKeys(input);
	  
	  
  }
  
  
	
}
