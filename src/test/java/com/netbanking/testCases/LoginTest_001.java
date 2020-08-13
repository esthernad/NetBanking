package com.netbanking.testCases;




import java.io.IOException;

import org.testng.annotations.Test;

import com.netbanking.pageOjects.LoginPage;

import junit.framework.Assert;



public class LoginTest_001 extends BaseClass {

	

	@Test
	public void loginTest() throws IOException {
		
	
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clicksubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Home Page"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else 
		{
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("Login test failed");
		}
	}
	
}
