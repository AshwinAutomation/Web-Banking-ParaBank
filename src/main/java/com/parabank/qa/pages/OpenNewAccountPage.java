package com.parabank.qa.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.parabank.qa.base.TestBase;

public class OpenNewAccountPage extends TestBase {

	@FindBy(xpath = "//p[text()='Add New Customer']")
	WebElement addNewCustomerText;

	@FindBy(name = "name")
	WebElement customerName;

	@FindBy(xpath = "//input[@type='radio']")
	List<WebElement> gender;

	@FindBy(id = "dob")
	WebElement calander;

	@FindBy(name = "addr")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "pinno")
	WebElement pinCode;

	@FindBy(name = "telephoneno")
	WebElement telephoneNumber;

	@FindBy(name = "emailid")
	WebElement emailID;

	@FindBy(name = "sub")
	WebElement submitButton;

	@FindBy(name = "res")
	WebElement resetButton;

}
