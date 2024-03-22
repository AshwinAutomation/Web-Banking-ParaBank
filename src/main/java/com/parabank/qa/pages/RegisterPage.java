package com.parabank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.qa.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(id = "customer.firstName")
	WebElement firstNameField;

	@FindBy(id = "customer.lastName")
	WebElement lastNameField;

	@FindBy(id = "customer.address.street")
	WebElement addressField;

	@FindBy(id = "customer.address.city")
	WebElement cityNameField;

	@FindBy(id = "customer.address.state")
	WebElement stateNameField;

	@FindBy(id = "customer.address.zipCode")
	WebElement zipcodeNumberField;

	@FindBy(id = "customer.phoneNumber")
	WebElement phoneNumberField;

	@FindBy(id = "customer.ssn")
	WebElement ssnNumberField;

	@FindBy(id = "customer.username")
	WebElement userNameField;

	@FindBy(id = "customer.password")
	WebElement passwordField;

	@FindBy(id = "repeatedPassword")
	WebElement confirmPasswordField;

	@FindBy(xpath  = "//input[@value='Register']")
	WebElement registerButton;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateRegisterPageTitle() {
		String registerPageTitleName = driver.getTitle();
		return registerPageTitleName;
	}

	public void registerNewUser(String firstName, String lastName, String address, String cityName, String stateName,
			String zipCode, String phoneNumber, String ssn, String userName, String password, String confirmPassword) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		addressField.sendKeys(address);
		cityNameField.sendKeys(cityName);
		stateNameField.sendKeys(stateName);
		zipcodeNumberField.sendKeys(zipCode);
		phoneNumberField.sendKeys(phoneNumber);
		ssnNumberField.sendKeys(ssn);
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		registerButton.click();

	}
	

}
