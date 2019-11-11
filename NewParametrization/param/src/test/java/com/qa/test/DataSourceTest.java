package com.qa.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.DataReq.DataSource;

public class DataSourceTest{
	 WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?");
	}
	
	@DataProvider
	public Iterator<Object[]> TestData() {
		
		ArrayList<Object[]> testdata = DataSource.readDataFromExcel();
		return testdata.iterator();
	}
	
	@Test(dataProvider="TestData")
	public  void DataSend(String fName,String lName,String mail,String password) {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(fName);
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lName);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("PASSWORD")).clear();
		driver.findElement(By.id("PASSWORD")).sendKeys(password);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	

}
