package com.parabank.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.parabank.qa.base.TestBase;
import com.parabank.qa.excelutils.ExcelUtils;
import com.parabank.qa.pages.AccountsOverviewPage;
import com.parabank.qa.pages.LoginPage;
import com.parabank.qa.pages.OpenNewAccountPage;
import com.parabank.qa.pages.RegisterPage;

public class RegisterPageTest extends TestBase {
	LoginPage loginPage;
	AccountsOverviewPage accountOverviewPage;
	OpenNewAccountPage openNewAccountPage;
	RegisterPage registerPage;
	public static String excelsheetPath = System.getProperty("user.dir") + "./ExcelData/ParasoftBank.xlsx";
	public static String xlsheet = "ParaBank_RegisterData";

	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		loginPage = new LoginPage();
		accountOverviewPage = new AccountsOverviewPage();
		openNewAccountPage = new OpenNewAccountPage();
		registerPage = new RegisterPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "registerData")
	public void registerNewUser(String firstName, String lastName, String address, String cityName, String stateName,
			String zipCode, String phoneNumber, String ssn, String userName, String password, String confirmPassword) {
		registerPage = loginPage.goToRegisterPage();
		registerPage.registerNewUser(firstName, lastName, address, cityName, stateName, zipCode, phoneNumber, ssn,
				userName, password, confirmPassword);
		accountOverviewPage.logout();
	}

	@DataProvider
	public Object[][] registerData() throws IOException {
		int rc;
		int cc;
		Object[][] data = null;
		try {
			rc = ExcelUtils.getRowCount(excelsheetPath, xlsheet);
			cc=ExcelUtils.getCellNumericData(excelsheetPath, xlsheet, rc, 1);
			data = new Object[rc][11];
			for (int i = 1; i < rc; i++) {
				
				
				data[i][0] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 0).trim(); // firstName
				data[i][1] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 1).trim(); // lastName
				data[i][2] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 2).trim(); // Address
				data[i][3] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 3).trim(); // City
				data[i][4] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 4).trim(); // State
				data[i][5] = String.valueOf(ExcelUtils.getCellNumericData(excelsheetPath, xlsheet, i, 5)).trim(); // ZIP
				data[i][6] = String.valueOf(ExcelUtils.getCellNumericData(excelsheetPath, xlsheet, i, 6)).trim(); // Phone
				data[i][7] = String.valueOf(ExcelUtils.getCellNumericData(excelsheetPath, xlsheet, i, 7)).trim(); // SSN
				data[i][8] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 8).trim(); // UserName
				data[i][9] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 9).trim(); // Password
				data[i][10] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 10).trim(); // Confirm Password
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			rc = ExcelUtils.getRowCount(excelsheetPath, xlsheet);
			data = new Object[rc][11];
			for (int i = 1; i < rc; i++) {
				data[i][0] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 0).trim(); // firstName
				data[i][1] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 1).trim(); // lastName
				data[i][2] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 2).trim(); // Address
				data[i][3] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 3).trim(); // City
				data[i][4] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 4).trim(); // State
				data[i][5] = String.valueOf(ExcelUtils.getCellNumericData(excelsheetPath, xlsheet, i, 5)).trim(); // ZIP
				data[i][6] = String.valueOf(ExcelUtils.getCellNumericData(excelsheetPath, xlsheet, i, 6)).trim(); // Phone
				data[i][7] = String.valueOf(ExcelUtils.getCellNumericData(excelsheetPath, xlsheet, i, 7)).trim(); // SSN
				data[i][8] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 8).trim(); // UserName
				data[i][9] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 9).trim(); // Password
				data[i][10] = ExcelUtils.getCellData(excelsheetPath, xlsheet, i, 10).trim(); // Confirm Password
			}

		}
		return data;
	}

}
