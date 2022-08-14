package com.pritamecom.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {

	//1. create obj of webdriver
		WebDriver ldriver; // it is local driver so ldriver
		
		public RegisteredUserAccount(WebDriver rdriver) //<--constructor; 
		{
			ldriver = rdriver;  //initialize local driver with remote driver
			
			PageFactory.initElements(rdriver, this);  //1st parameter=search context(which driver we are going to use for searching of webelements)
													 //2nd parameter is = object of the page
		}
		
		
	//2. identify webelements (we use @Findby annotation for find elements)
		@FindBy(xpath = "//a[@title='View my customer account']")  
		WebElement userName; 
		
		public String getUserName()
		{
			String text = userName.getText();
			return text;
		}
		
}
