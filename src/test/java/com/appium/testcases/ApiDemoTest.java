package com.appium.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.pages.ApiDemoHomePage;
import com.appium.pages.ApiDemoPrefDependency;
import com.appium.pages.ApiDemoPreferences;
import com.appium.pages.AppiumTestData;
import com.appium.testbase.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemoTest extends Base
{
	@BeforeTest
	public void kill() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
   @Test(dataProvider="InputData",dataProviderClass=AppiumTestData.class)
   public void apidemotestvalidation(String input) throws IOException, InterruptedException
   {
		service = startServer();
	   AndroidDriver<AndroidElement> driver = capabilities("ApiDemo");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ApiDemoHomePage homePage = new ApiDemoHomePage(driver);
		ApiDemoPreferences preferences = new ApiDemoPreferences(driver);
		ApiDemoPrefDependency dependency = new ApiDemoPrefDependency(driver);
		homePage.preferences.click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		preferences.prefDependencies.click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		/*driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
		driver.findElementsByClassName("android.widget.Button").get(1).click();*/
		dependency.setUpWifi(input);
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		service.stop();
   }
}
