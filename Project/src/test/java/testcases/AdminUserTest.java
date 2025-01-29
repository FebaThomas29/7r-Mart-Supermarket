package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends BaseClass {
	@Test(groups= {"smoke"},description = "Add new Admin User", priority = 1)

	public void addAdminUsers() throws IOException  {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();

		String username1 = ExcelUtility.readStringData(1, 0, "Adminuser");
		String password1 = ExcelUtility.readStringData(1, 1, "Adminuser");
		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.clickAdminUsers();
		adminuser.clickManageUsers();
		adminuser.clickNewUserButton();
		adminuser.enterValueInUsernameField(username1);
		adminuser.enterValueInPasswordField(password1);
		adminuser.selectUserType();
		adminuser.clickSaveButton();
		boolean admintitleisdisplayed = adminuser.adminTitleIsDisplayed();
		Assert.assertTrue(admintitleisdisplayed, Messages.ADMINTITLE);
	}

}
