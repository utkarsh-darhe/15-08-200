package com.pritamecom.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	//1. create obj of webdriver
		WebDriver ldriver; // it is local driver so ldriver
		
		//constructor
		public MyAccount(WebDriver rdriver) //rdriver for remote driver
		{
			ldriver = rdriver;  //initialize local driver with remote driver
			
			PageFactory.initElements(rdriver, this);  //1st parameter=search context(which driver we are going to use for searching of webelements)
													 //2nd parameter is = object of the page
		}
		
		
	//2. identify webelements (we use @Findby annotation for find elements)
		
		//create new account
		@FindBy(id = "email_create")  //find webelement
		WebElement createEmailId; //stored in signin veriable
		
		@FindBy(id = "SubmitCreate")
		WebElement clickOnCreateAccount;
		
		//already registered user
		@FindBy(id = "email")  
		WebElement registeredUserEmail;
		
		@FindBy(id = "passwd")  
		WebElement registeredUserpwd;
		
		@FindBy(id = "SubmitLogin")
		WebElement submitLogin;
		
	//3. identify action on webelement
		public void createEmailId(String emailAdd) {
			createEmailId.sendKeys(emailAdd);	
		}
		
		public void clickCreateAccount() {
			clickOnCreateAccount.click();
		}
		
		//Action method for already registered users
		
		public void enterEmailAddress(String emailAdd) {
			registeredUserEmail.sendKeys(emailAdd);	
		}
		
		public void enterPassword(String pwd) {
			registeredUserpwd.sendKeys(pwd);
		}
		
		public void clickSubmit()
		{
			submitLogin.click();
		}
}
