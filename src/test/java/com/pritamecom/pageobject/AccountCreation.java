package com.pritamecom.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreation {
	
	//1. create obj of webdriver
		WebDriver ldriver; // it is local driver so ldriver
		
		public AccountCreation(WebDriver rdriver) //<--constructor; rdriver for remote driver
		{
			ldriver = rdriver;  //initialize local driver with remote driver
			
			PageFactory.initElements(rdriver, this);  //1st parameter=search context(which driver we are going to use for searching of webelements)
													 //2nd parameter is = object of the page
		}
		
		
	//2. identify webelements (we use @Findby annotation for find elements)
		@FindBy(id = "id_gender1")  
		WebElement titleMrs;
		
		@FindBy(id = "customer_firstname")  
		WebElement cstmfirstname;
		
		@FindBy(id = "customer_lastname")  
		WebElement cstmlastname;
		
		@FindBy(id="passwd")
		WebElement password;
		
		@FindBy(id="firstname")
		WebElement Addfirstname;
		
		@FindBy(id="lastname")
		WebElement Addlastname;
		
		//adress1
		@FindBy(id="address1")
		WebElement address1;
		
		@FindBy(id="city")
		WebElement city;
		
		@FindBy(id="id_state")
		WebElement state;
		
		@FindBy(id="postcode")
		WebElement postcode;
		
		@FindBy(id="id_country")
		WebElement country;
		
		@FindBy(id="phone_mobile")
		WebElement phone;
		
		@FindBy(id="alias")
		WebElement address2;
		
		@FindBy(id="submitAccount")
		WebElement register;
		
		//identify actions to be performed on web elements
		
		public void selectTitleMrs() {
			titleMrs.click();
		}
		
		public void enterCustomer_firstname(String fname) {
			cstmfirstname.sendKeys(fname);
		}
		
		public void enterCustomer_lastname(String lname) {
			cstmlastname.sendKeys(lname);
		}
		
		public void enterPasswd(String pwd) {
			password.sendKeys(pwd);
		}
		
		public void enterAddressfirstname(String fname) {
			Addfirstname.clear();
			Addfirstname.sendKeys(fname);
		}
		
		public void enterAddresslastname(String lname) {
			Addlastname.clear();
			Addlastname.sendKeys(lname);
		}
		
		public void enterAddress1(String address) {
			address1.sendKeys(address);
		}
		
		public void enterCity(String cityname) {
			city.sendKeys(cityname);
		} 
		
		public void selectState(String text) {   //it has dropdown, so we create action class object
			Select obj = new Select(state);
			obj.selectByVisibleText(text);
		}

		public void enterPostcode(String postcodeData) {
			postcode.sendKeys(postcodeData);
		}

		public void selectCountry(String text) {
			Select obj = new Select(country);
			obj.selectByVisibleText(text);
		}
		
		public void enterMobilePhone(String mobile) {
			phone.sendKeys(mobile);
		}
		
		public void enterAlias(String text) {
			address2.clear();
			address2.sendKeys(text);
		}

		public void clickOnSubmitAccount() {
			register.click();
		}

		//we use this actions in TC_MyAccountPg class & for that we have to create an object of this class in TC_MyAccountPg class
}
