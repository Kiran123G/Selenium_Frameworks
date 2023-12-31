package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  public WebDriver lDriver;

	@FindBy(name = "uid")
	@CacheLookup
	WebElement userID;

	@FindBy(xpath ="//input[@name='password']")
	@CacheLookup
	WebElement password12;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement login;

	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement reset;

	public LoginPage(WebDriver driver) {
		lDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUsername(CharSequence name) {
		userID.sendKeys(name);
	}

	public void setPassword(CharSequence password1) {
		password12.sendKeys(password1);
	}

	public void clickSubmit() {
		login.click();
	}

	public void reset() {
		reset.click();
	}
}
