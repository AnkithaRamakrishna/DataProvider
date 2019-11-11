package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws Exception {
		super();

	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();
		loginpage = new LoginPage();
	}
	
	
	
	/*
	 * @Test public String loginPageTitleTest(){ String title =
	 * loginpage.validateLoginPageTitle(); System.out.println(title); return title;
	 * //Assert.assertEquals(title, ""); }
	 */	 
	 	
	
	
	  @Test(priority=1,enabled=false)
	  public void loginTest() throws Exception { 
		  loginpage.login(prop.getProperty("email"),prop.getProperty("password")); 
		  }
	  
	  @Test(priority=2)
	  public void clickOnForgotPassword() {
		  
	  }
	 
	  
	 @AfterMethod
	 public void tearDown()
	 {
		 driver.quit();
	 }

}
