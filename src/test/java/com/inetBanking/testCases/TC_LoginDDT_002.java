package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username entered");
		lp.setPassword(pwd);
		logger.info("Password entered");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			logger.info("Alert accepted");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}else {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Logout button clicked");
			driver.switchTo().alert().accept();
			logger.info("Logout alert accepted");
			driver.switchTo().defaultContent();
		}
	}
	
	
	
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException{
		
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
