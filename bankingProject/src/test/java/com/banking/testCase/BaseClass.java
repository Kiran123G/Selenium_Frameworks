package com.banking.testCase;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {

	public String baseUrl = "https://www.demo.guru99.com/V4/";
	public String username = "mngr525433";
	public String password = "bugesyn";
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Logger logger = Logger.getLogger("bankingProject");
		PropertyConfigurator.configure("Log4j.Properties");
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
