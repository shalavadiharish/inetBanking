package com.inetbanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest001 extends BaseClass {
	
	@Test
	public void loginTest() {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering the userName");
		lp.setUserName(username);
		logger.info("Entering the password");
		lp.setPassword(password);
		logger.info("clicking on submit button");
        lp.clicksubmit();
       String actual_result= driver.getTitle();
       logger.info("Verifying the Title");
       Assert.assertEquals("Guru99 Bank Manager HomePage",actual_result, "We are not able to login to application" );
       logger.info("Tittle is correct Login testcase Passed");
        
	}

}
