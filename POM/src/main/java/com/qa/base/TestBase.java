package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws Exception{
		
		try
		{
			prop = new Properties();
			//String fileLocation = System.getProperty("C:\\Users\\Akshay\\eclipse-workspace\\POM\\src\\main\\java\\com\\qa\\config\\config.properties");
			FileInputStream fs = new FileInputStream("C:\\Users/Akshay/eclipse-workspace/POM/src"
					+ "/main/java/com/qa/config/config.properties");
			prop.load(fs);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		
	}
	

}
