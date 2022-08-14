package com.pritamecom.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
//1. create obj of webdriver
	WebDriver ldriver; // it is local driver so ldriver
	
	public IndexPage(WebDriver rdriver) //<--constructor; rdriver for remote driver
	{
		ldriver = rdriver;  //initialize local driver with remote driver
		
		PageFactory.initElements(rdriver, this);  //1st parameter=search context(which driver we are going to use for searching of webelements)
												 //2nd parameter is = object of the page
	}
	
	
//2. identify webelements (we use @Findby annotation for find elements)
	@FindBy(linkText = "Sign in")  //find webelement
	WebElement signIn; //stored in signin veriable
	
//3. identify action on webelement
	public void clickOnSignin() {
		signIn.click();
	}
	
	
}
