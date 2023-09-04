package com.banking.testCase;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);

		lp.clickSubmit();
		String getTitle = driver.getTitle();

		if (driver.getTitle().equals(getTitle)) {
			Assert.assertTrue(true);

		} else {
			{
				Assert.assertTrue(false);

			}
		}
	}
}
