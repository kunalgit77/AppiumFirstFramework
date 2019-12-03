package com.appium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.testbase.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralAppFormPage 
{
	public AndroidDriver<AndroidElement>driver;
	public GeneralAppFormPage(AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement enterName;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement clickGender;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement clickLetsShop;


	@AndroidFindBy(id="android:id/text1")
	public WebElement clickCountryTab;
	
	/*@AndroidFindBy(AndroidUIAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\")")
	public WebElement scrollCountry;*/
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement clickCountry;
	
	
	public void enter_user_info(String userName)
	{
		enterName.sendKeys(userName);
		
    }
	/*public ProductsPage enter_user_info(String userName)
	{
		enterName.sendKeys(userName);
		driver.hideKeyboard();
		clickGender.click();
		clickLetsShop.click();
		return new ProductsPage(driver);
		
    }*/
	
      
	
}
