package com.parabank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parabank.qa.base.TestBase;
import com.parabank.qa.pages.OpenNewAccountPage;
import com.parabank.qa.pages.AccountsOverviewPage;
import com.parabank.qa.pages.LoginPage;

public class AccountsOverviewPageTest extends TestBase {
	LoginPage loginPage;
	AccountsOverviewPage accountOverviewPage;
	OpenNewAccountPage openNewAccountPage;

	public AccountsOverviewPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		loginPage = new LoginPage();
		accountOverviewPage = new AccountsOverviewPage();
		openNewAccountPage = new OpenNewAccountPage();
		accountOverviewPage = loginPage.loginToParasoftBank(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyAccountsOverviewPageTitle() {
		String accountsOverviewPageTitle = accountOverviewPage.validateAccountOverviewPageTitle();
		Assert.assertEquals(accountsOverviewPageTitle, prop.getProperty("accountOverviewpageTitle"));
	}

	@Test(priority = 2)
	public void verifyAccountOverviewText() {
		boolean messageLink = accountOverviewPage.validateAccontOverviewtext();
		Assert.assertTrue(messageLink);
	}

	@Test(priority = 3)
	public void accountServiceText() {
		String textMessage = accountOverviewPage.validateAccontService();
		Assert.assertEquals(textMessage, prop.getProperty("AccountOverviewServiceMessage"));
	}

	@Test(priority = 4)
	public void verifyOpenNewAccountLinkTest() {
		openNewAccountPage = accountOverviewPage.goToOpenNewAccountPage();
	}
}
