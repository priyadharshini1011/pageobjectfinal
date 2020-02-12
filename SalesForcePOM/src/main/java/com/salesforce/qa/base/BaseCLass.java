package com.salesforce.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.salesforce.qa.util.Util;

public class BaseCLass  {
	public static WebDriver driver;
	public static Properties prop ;
	public static WebDriver initialisation() throws IOException {
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\auhum\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\salesforce\\config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\jar\\chromedriver.exe");
		driver= new ChromeDriver();
		
		
		}
		driver.manage().timeouts().implicitlyWait(Util.implicitwait, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		return driver;
	}
//	public void screenShot(String result) throws IOException {
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
///		FileUtils.copyFile(src,new File(prop.getProperty("screenpath"+result+"screenshot.png")));
//
//	}
		

}
