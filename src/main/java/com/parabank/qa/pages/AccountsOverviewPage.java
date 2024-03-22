package com.parabank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.qa.base.TestBase;

public class AccountsOverviewPage extends TestBase {

	@FindBy(xpath = "//a[contains(@href,'openaccount')]")
	WebElement openNewAccountLink;

	@FindBy(xpath = "//a[contains(@href,'transfer')]")
	WebElement transferFundsLink;

	@FindBy(xpath = "//a[contains(@href,'billpay')]")
	WebElement billPayLink;

	@FindBy(xpath = "//a[contains(@href,'findtrans')]")
	WebElement findTransactionsLink;

	@FindBy(xpath = "//a[contains(@href,'updateprofile')]")
	WebElement updateContactsInfoLink;

	@FindBy(xpath = "//a[contains(@href,'requestloan')]")
	WebElement requestLoanLink;

	@FindBy(xpath = "//h1[text()='Accounts Overview']")
	WebElement accountOverviewText;

	@FindBy(xpath = "//h2[text()='Account Services']")
	WebElement accountServiceText;

	@FindBy(xpath = "//a[text()='Log Out']")
	WebElement logoutButton;

	public AccountsOverviewPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateAccontOverviewtext() {
		return accountOverviewText.isDisplayed();
	}

	public String validateAccountOverviewPageTitle() {
		String accountOverviewPageTitle = driver.getTitle();
		return accountOverviewPageTitle;
	}

	public String validateAccontService() {
		String accountServiceTextMessage = accountServiceText.getText();
		return accountServiceTextMessage;
	}

	public OpenNewAccountPage goToOpenNewAccountPage() {
		openNewAccountLink.click();
		return new OpenNewAccountPage();
	}

	public TransferFundsPage goToTransferFundsPage() {
		transferFundsLink.click();
		return new TransferFundsPage();
	}

	public BillPayPage goToBillPayPage() {
		billPayLink.click();
		return new BillPayPage();
	}

	public FindTransactionsPage goToFindTransactionsPage() {
		findTransactionsLink.click();
		return new FindTransactionsPage();
	}

	public UpdateContactInfoPage goToUpdateContactInfoPage() {
		updateContactsInfoLink.click();
		return new UpdateContactInfoPage();
	}

	public RequestLoanPage goToRequestLoanPage() {
		requestLoanLink.click();
		return new RequestLoanPage();
	}

	public void logout() {
		logoutButton.click();
	}
}
