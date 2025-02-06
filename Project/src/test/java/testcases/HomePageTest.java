package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends BaseClass {


	@Test(groups = { "smoke" }, description = "click logout", priority = 1)

	public void clickingOnLogoutFromHomePage() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();

		HomePage homepage = new HomePage(driver);
		homepage.clickAdminUser();
		homepage.clickLogOut();

		boolean islogintitledisplayed = homepage.isLoginTitleDispalyed();
		Assert.assertTrue(islogintitledisplayed, Messages.LOGOUTERROR);

	}

}
