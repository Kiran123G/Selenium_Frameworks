package com.banking.testCase;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	readconfig rc = new readconfig();
	public String baseurl = rc.getUrl();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	String passString = "bugesyn";

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		Logger logger = Logger.getLogger("bankingProject");
		PropertyConfigurator.configure("Log4j.Properties");
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(baseurl);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot tScreenshot = (TakesScreenshot)driver;
		File srcFile = tScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"/screenshots"+name +".png");
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("screenshot taken");
	}

}
