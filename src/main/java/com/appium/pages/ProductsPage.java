package com.appium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.testbase.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage 
{
	AndroidDriver<AndroidElement>driver;
	public ProductsPage(AndroidDriver<AndroidElement>driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

   @AndroidFindBy(xpath="//*[@text='ADD TO CART']")
   public List<WebElement> firstProduct;
   
   @AndroidFindBy(xpath="//*[@text='ADD TO CART']")
   public List<WebElement> secondProduct;
   
   @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
   public WebElement clickCartButton;
   
   
   /*public CartPage selectProduct()
   {
	   driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	   driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	   clickCartButton.click();
	   return new CartPage(driver); 
   }*/
   
}
