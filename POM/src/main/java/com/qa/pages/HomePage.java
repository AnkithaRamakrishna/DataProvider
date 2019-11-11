package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//page factory
	
	@FindBy(xpath="//span[contains(text(),'Women')]")
	WebElement womenTag;
	
	@FindBy(className="_3ko_Ud")
	WebElement cart;
	
	@FindBy(xpath="//li[@class='_1KCOnI _2BfSTw _1h5QLb _3ZgIXy']/child::a[@title='Jewellery']")
	WebElement jewellery;
	
	@FindBy(className="LM6RPg")
	WebElement searchTextField;
	
	@FindBy(className="vh79eN")
	WebElement searchButton;
	
	@FindBy(xpath="//div[contains(text(),'4★ & above')]")
	WebElement fourRatingAbove;
	

	public HomePage() throws Exception {
		
		PageFactory.initElements(driver, this);
	}
	
	public void homePageTitle() {
		String actualTitle = "Online Shopping Site";
		String title = driver.getTitle();
		if(actualTitle.contains(title)){
		System.out.println("Page Title matches");
		}
		else
			System.out.println("Page Title does not match");
	}
	
	public void searchOption(String textToSearch){
		searchTextField.sendKeys(textToSearch);
		searchButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fourRatingAbove.click();
		System.out.println(fourRatingAbove.isSelected());

	}
	
	public JewelryPage searchForJewellery() throws Exception {
		//Actions action= new Actions(driver);
		//action.moveToElement(womenTag).build().perform();
		//action.moveToElement(jewellery).click().build().perform();
		womenTag.click();
		jewellery.click();
		return new JewelryPage();
		
	}
	
	public CartPage openCart() throws Exception {
		cart.click();
		return new CartPage();
	}
	
	

}
