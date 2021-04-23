package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("UserName is Entered");
		lp.setPassword(password);
		logger.info("Password is Entered");
		
		lp.clickSubmit();
		logger.info("Clicked on Submit button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("Login test Failed");
			
		}
		



	}

}
