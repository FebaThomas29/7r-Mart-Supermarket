package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass {
	@Test(groups = { "smoke" }, description = " Add new news to manage users page", priority = 1)

	public void createNewManageNewsToThePage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username).enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageUsers().clickNewsButton().enterNewsInTextField().clickSaveButton();
		boolean istitledisplayed = managenewspage.isTitleDisplayed();
		Assert.assertTrue(istitledisplayed, Messages.MANAGENEWSTITLE);

	}

}
