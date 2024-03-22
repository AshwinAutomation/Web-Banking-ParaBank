package com.parabank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement userPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement buttonLogin;

	@FindBy(name = "btnReset")
	WebElement buttonReset;

	@FindBy(xpath = "//h2[text()='Customer Login']")
	WebElement customerLogin;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;
	
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		String loginPageTitleName = driver.getTitle();
		return loginPageTitleName;
	}
	
	public boolean validateCustomerLogin() {
		return customerLogin.isDisplayed();
	}

	public AccountsOverviewPage loginToParasoftBank(String userID, String password) {
		userName.sendKeys(userID);
		userPassword.sendKeys(password);
		buttonLogin.click();
		return new AccountsOverviewPage();
	}
	
	public RegisterPage goToRegisterPage() {
		registerLink.click();
		return new RegisterPage();
	}
}