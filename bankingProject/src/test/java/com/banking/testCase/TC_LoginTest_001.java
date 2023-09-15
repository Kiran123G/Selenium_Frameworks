package com.banking.testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;

import com.banking.pageObject.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	@Description("Login test for the page")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
        BaseClass bs = new BaseClass();
        bs.setUp(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseurl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(passString);

		lp.clickSubmit();
		String getTitle = driver.getTitle();

		if (driver.getTitle().equals(getTitle)) {
			AssertJUnit.assertTrue(true);

		} else {
			{
				AssertJUnit.assertTrue(false);

			}
		}
	}

	@Test(dependsOnMethods = "loginTest")
	@Description("login test for the page")
	public void validUrl() throws IOException {
		captureScreenshot(driver, "validUrl");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseurl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(passString);
		String getUrString = driver.getCurrentUrl();
		if (driver.getCurrentUrl().equals(getUrString)) {
			AssertJUnit.assertTrue(true);
		} else {
			AssertJUnit.assertTrue(false);

		}
	}

	@Test(dependsOnMethods = "validUrl")
	@Description("validate the homepage url")
	public void checkCourse() throws IOException {
		captureScreenshot(driver, "validUrl");
		List<WebElement> coursElement = driver
				.findElements(By.xpath("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]"));
		for (WebElement webElement : coursElement) {
			String name = webElement.getText();
			Reporter.log(name, true);
		}
	}
}
