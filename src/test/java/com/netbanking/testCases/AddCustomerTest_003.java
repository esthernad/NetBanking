package com.netbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.netbanking.pageOjects.AddCustomerPage;
import com.netbanking.pageOjects.LoginPage;

import junit.framework.Assert;

public class AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomers() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomstring()+"@gmail.com";
				addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
     logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	public String randomstring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	public String randomnum() {
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
}
