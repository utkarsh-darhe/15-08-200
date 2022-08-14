package com.pritamecom.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pritamecom.pageobject.AccountCreation;
import com.pritamecom.pageobject.IndexPage;
import com.pritamecom.pageobject.MyAccount;
import com.pritamecom.pageobject.RegisteredUserAccount;

public class TC_MyAccountPg extends BaseClass 
{

	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{
		//browser will launch from baseclass
		

		//now we have to click on signin, for this we created object of index pg(where we created clickonsignin())
		//so, now we create an object of index class in this class

		IndexPage pg = new IndexPage(driver); //we pass the webdriver object i.e. driver as parameter (it becomes remotedriver)
		pg.clickOnSignin();  //created this method in indexpg

		MyAccount pg1 = new MyAccount(driver);

		pg1.createEmailId("pn923@gmail.com");
		pg1.clickCreateAccount();

		AccountCreation accCreationpg = new AccountCreation(driver);
		//now we have to enter user info

		accCreationpg.selectTitleMrs();
		accCreationpg.enterCustomer_firstname("Pritam");
		accCreationpg.enterCustomer_lastname("Nanaware");
		accCreationpg.enterPasswd("pn923");
		accCreationpg.enterAddressfirstname("Pritam");
		accCreationpg.enterAddresslastname("Nanaware");
		accCreationpg.enterAddress1("15/5 KP");

		accCreationpg.enterCity("Pune");
		accCreationpg.selectState("Alaska");
		accCreationpg.enterPostcode("41521");
		accCreationpg.selectCountry("United States");

		accCreationpg.enterMobilePhone("7088552299");
		accCreationpg.enterAlias("Home");
		accCreationpg.clickOnSubmitAccount();


		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		String userName= regUser.getUserName();

		Assert.assertEquals("Pritam Nanaware", userName); //to verify user name we use assert class
	}
	@Test
	public void verifyLogin() throws IOException {
		
		IndexPage pg = new IndexPage(driver); 
		pg.clickOnSignin();  

		MyAccount pg1 = new MyAccount(driver);

		pg1.enterEmailAddress("pn923@gmail.com");
		pg1.enterPassword("pn923");
		pg1.clickSubmit();
		
		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		String userName= regUser.getUserName();
		if(userName.equals("Pritam Nanaware"))
		{
			logger.info("VerifyLogin - passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - failed");
			captureScreenShot(driver, "Verifylogin");
			Assert.assertTrue(false);
		}
		
		
	}
}
