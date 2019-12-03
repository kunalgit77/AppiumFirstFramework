package com.appium.pages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.testbase.Base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage 
{
	public AndroidDriver<AndroidElement>driver;
	public CartPage(AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement clicks;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkBox;
	
	@AndroidFindBy(xpath="//*[@text='Please read our terms of conditions']")
	public WebElement read;

	@AndroidFindBy(tagName="q")
	public WebElement sent;
	
	/*public void anather() throws InterruptedException
	{
		
    TouchAction t = new TouchAction(driver);
    checkBox.click();
    t.tap(tapOptions().withElement(element(checkBox))).perform();
    WebElement longPres = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
    t.longPress(longPressOptions().withElement(element(longPres)).withDuration(ofSeconds(2))).release().perform();
    clicks.click();
    proceed.click();
    Thread.sleep(7000);
    Set<String> context = driver.getContextHandles();
    for(String contextName : context)
    {
    	System.out.println(contextName);
    }
    driver.context("WEBVIEW_com.androidsample.generalstore");
    sent.sendKeys("dhoni");
    sent.sendKeys(Keys.ENTER);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}*/
	
	public double getAmount(String value)
	{
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		return amountValue;
	}

	
	
	
	
}
