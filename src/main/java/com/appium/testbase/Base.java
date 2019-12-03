package com.appium.testbase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AndroidDriver<AndroidElement> driver ;
	public static AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
		
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try{
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}catch(IOException e)
		{
			isServerRunning = true;
		}finally
		{
			serverSocket = null;
		}
		return isServerRunning;
	}
	//D:\selinium\Framework\AppiumFramework\src\main\resources\emulator.bat
	/*public static void startEmulators() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\com\\appium\\resource\\startEmulator.bat");
		Thread.sleep(6000L);
	}*/
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException 
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\appium\\config\\global.properties");
		Properties prop = new Properties();
		prop.load(file);
		prop.get(appName);
		//General-Store.apk
		File fs = new File("src");
		File f1 = new File(fs,(String) prop.get(appName));
       DesiredCapabilities cp = new DesiredCapabilities();
       String deviceName = (String) prop.get("DeviceName");
       cp.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
       /*if(deviceName.contains("Emulator"))
       {
    	   startEmulator();
       }*/
       cp.setCapability(MobileCapabilityType.APP,f1.getAbsolutePath());
       AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cp);
       return driver;
	}
	
	/*public static void getScreenshot(String s) throws IOException
	{
		File srcs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcs, new File(currentDir + "/screenshot/" + System.currentTimeMillis() +"\\"+s+".png"));
		//FileUtils.copyFile(src, new File("D:\\selinium\\Framework\\AppiumFramework\\screenshot"+"\\"+s+".png"));
	}*/

}
