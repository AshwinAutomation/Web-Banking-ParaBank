package com.parabank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.parabank.qa.base.TestBase;
import com.parabank.qa.pages.AccountsOverviewPage;
import com.parabank.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	AccountsOverviewPage accountsOverviewPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginpageTitle"));
	}

	@Test(priority = 2)
	public void bankNameTest() {
		boolean flag = loginPage.validateCustomerLogin();
		Assert.assertTrue(flag, "Bank name should be ParaSoft bank");
	}

	@Test(priority = 3)
	public void loginTest() {
		accountsOverviewPage = loginPage.loginToParasoftBank(prop.getProperty("username"),
				prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
