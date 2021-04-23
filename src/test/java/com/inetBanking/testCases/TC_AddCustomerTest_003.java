package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("UserName is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		logger.info("Providing customer details");
		
		addcust.custName("Raja");
		addcust.custgender("Male");
		addcust.custdob("09", "22", "1990");
		Thread.sleep(5000);
		
		addcust.custaddress("India");
		addcust.custcity("Ranipet");
		addcust.custstate("TamilNadu");
		addcust.custpinno("632501");
		addcust.custtelephoneno("8765456232");
		
		String email = randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean b = driver.getPageSource().contains("Customer Registered Successfully");
		
		if(b == true) {
			Assert.assertTrue(true);
			logger.info("Test case is Passed");
		}
		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case is Failed");
		}
	}
	

	
}
