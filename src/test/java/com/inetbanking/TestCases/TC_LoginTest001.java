package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering the userName");
		lp.setUserName(username);
		logger.info("Entering the password");
		lp.setPassword(password);
		logger.info("clicking on submit button");
        lp.clicksubmit();
      // String actual_result= driver.getTitle();
       logger.info("Verifying the Title");
       
       if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
     
        
	}

}
