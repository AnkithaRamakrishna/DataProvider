package com.qa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.JewelryPage;

public class HomePageTest extends TestBase{
	HomePage homepage;
	JewelryPage jewelrypage;

	public HomePageTest() throws Exception {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		homepage = new HomePage();
		Thread.sleep(5000);
		
	}
	@Test(priority=1,enabled=false)
	public void getPageTitle() {
		homepage.homePageTitle();		
	}
	
	@Test(priority=2,enabled=false)
	public void searchAnything() {
		homepage.searchOption("Palazzo Pants");
	}
	
	@Test(priority=4)
	public void searchJewellery() throws Exception {
		homepage.searchForJewellery();
	}
	
	@Test(priority=3,enabled=false)
	public void openCartMethod() throws Exception {
		homepage.openCart();
	}

	@AfterMethod(enabled=true)
	public void tearDown() {
		driver.close();
	}
}
