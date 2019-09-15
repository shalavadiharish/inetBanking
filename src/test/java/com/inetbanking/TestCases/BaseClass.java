package com.inetbanking.TestCases;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass 
	public void setup(String browser){
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			logger.info("Setting up  the chrome browser ");
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			logger.info("Setting up  the firefox browser");
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("ie")){
			System.setProperty("webdriver.IE.driver", readconfig.getIEPath());
			logger.info("Setting up  the IE browser");
			driver = new InternetExplorerDriver();
		}
		else {
			logger.error("browser is not specified");
		}
		
		driver.get(baseURL);
		logger.info("Opening the URL");
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
}
