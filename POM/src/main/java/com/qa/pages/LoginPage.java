package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// Page Factory
	
	@FindBy(linkText = "Login & Signup")
	WebElement LoginSignupButton;
	
	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement username;
	
	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement password;
	
	@FindBy(xpath= "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement submit;
	
	@FindBy(linkText="New to Flipkart? Create an account")
	WebElement regLink;
	
	@FindBy(className = "_2AkmmA _1LctnI jUwFiZ")
	WebElement ReqOTP;

	@FindBy(xpath="//a[@class='_21JmK0 _1__46T']/descendant::span[text()='Forgot?']")
	WebElement forgotLink;
	
	public LoginPage() throws Exception{
		
		PageFactory.initElements(driver, this);
		//LoginSignupButton.click();
	}
		
	public String validateLoginPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void forgotLinkIsDisplayed() {
		//return forgotLink.isDisplayed();
		forgotLink.click();
	}
	
	
	
	public HomePage login(String uname,String pword) throws Exception {
		
		username.sendKeys(uname);
		password.sendKeys(pword);
		submit.click();
				
		return new HomePage();
	}
}
