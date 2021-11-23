package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	
	
	// Login Data
	String userName = "demo@techfios.com";
	String password = "abc123";

	@Test
	public void verifiedUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSignInButton();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		
		dashboard.verifyDashboard();
	}
	

}
