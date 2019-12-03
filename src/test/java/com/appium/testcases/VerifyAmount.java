package com.appium.testcases;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.pages.CartPage;
import com.appium.pages.GeneralAppFormPage;
import com.appium.pages.ProductsPage;
import com.appium.testbase.Base;
import com.appium.utility.GeneralUtility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
public class VerifyAmount extends Base
{
	@BeforeTest
	public void kill() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	@Test
	public void testValidation() throws IOException, InterruptedException
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Base.capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		GeneralAppFormPage general = new GeneralAppFormPage(driver);
        general.clickCountryTab.click();
		GeneralUtility utility = new GeneralUtility(driver);
		utility.scrolltotext("Argentina");
        general.clickCountry.click();
		general.enter_user_info("Kunal Aggarwal");
		general.clickGender.click();
		general.clickLetsShop.click();

		ProductsPage product = new ProductsPage(driver);
		product.firstProduct.get(0).click();
		product.secondProduct.get(0).click();
		product.clickCartButton.click();

		CartPage cart = new CartPage(driver);
				
	    int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	    double sum = 0;
	    for(int i=0;i<count;i++)
	    {
	    	String amount1 = cart.productList.get(i).getText();
		    double value1 = cart.getAmount(amount1);
		    sum = sum + value1;

	    }
	    //remove $ and conert into double
	    /*String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
	    double value1 = getAmount(amount1);
	    
	    String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
	    double value2 = getAmount(amount2);
	    
	    double sumoftotalproduct = value1 + value2;*/
	    System.out.println("sum of both product is: " + sum);
	    
	    String verifyTotal = cart.totalAmount.getText();
	    double Total = cart.getAmount(verifyTotal);
	    System.out.println("sum of product is: " + Total);
        Assert.assertEquals(Total,sum);
        cart.checkBox.click();
        TouchAction t = new TouchAction(driver);
        WebElement longPres = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        t.longPress(longPressOptions().withElement(element(longPres)).withDuration(ofSeconds(2))).release().perform();
        cart.clicks.click();
        cart.proceed.click();
        Thread.sleep(7000);
        Set<String> context = driver.getContextHandles();
        for(String contextName : context)
        {
        	System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("dhoni");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));

	    	    
	    service.stop();
	}

}
	