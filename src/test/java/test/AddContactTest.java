package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {
	WebDriver driver;

	// Test Data
	String FULL_NAME = "TestNG";
	String COMPANY_NAME = "Techfios";
	String EMAIL = "abc234@techfios.com";
	String PHONE_NUMBER = "123556778";
	String COUNTRY = "Angola";
    @Test
	public void validUserShoudBeAbleToAddCustomer() {
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.insertUserName("demo@techfios.com");
		login.insertPassword("abc123");
		login.clickSignInButton();
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);

		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.insertFullName("TestNG");
		addContactPage.selectCompany("Techfios");
		addContactPage.insertEmail("abc234@techfios.com");
		addContactPage.insertPhone("123556778");
		addContactPage.selectCountry("Angola");
		
	
	}
}
