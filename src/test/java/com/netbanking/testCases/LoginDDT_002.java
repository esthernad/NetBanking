package com.netbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.Utilities.XLUtils;
import com.netbanking.pageOjects.LoginPage;

import junit.framework.Assert;

public class LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {//user defined method created to check alert is present or not
		
		try {
			driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][]getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/netbanking/testData/LoginData.xlsx";
		
				int rownum=XLUtils.getRowCount(path, "sheet1");
				int colcount=XLUtils.getCellCount(path, "sheet1", 1);
	
					String logindata[][]=new String[rownum][colcount];
					
				for(int i=1; i<rownum; i++) {
					
					for(int j=0; j<colcount; j++) {
						
						logindata[i-1][j]= XLUtils.getCellData(path, "sheet1", i, j);
					}
				}
				return logindata;	
	}
}
