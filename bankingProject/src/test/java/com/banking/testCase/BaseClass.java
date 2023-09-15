package com.banking.testCase;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.banking.utilities.readconfig;


public class BaseClass  {

	readconfig rc = new readconfig();
	public String baseurl= rc.getUrl();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	String passString ="bugesyn";
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		Logger logger = Logger.getLogger("bankingProject");
		PropertyConfigurator.configure("Log4j.Properties");
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
