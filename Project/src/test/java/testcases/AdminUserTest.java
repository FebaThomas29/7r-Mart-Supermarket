package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import automationcore.BaseClass;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends BaseClass { // add the admin user test
	@Test(groups = { "smoke" }, description = "Add new Admin User", priority = 1)

	public void addNewAdminUsersToThePage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username).enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();

		FakerUtility faker = new FakerUtility();
		String username1 = faker.generateNewUserName();
		String password1 = faker.generateNewPassword();
		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.clickAdminUsers();
		adminuser.clickManageUsers().clickNewUserButton().enterValueInUsernameField(username1)
				.enterValueInPasswordField(password1).selectUserType().clickSaveButton();
		boolean admintitleisdisplayed = adminuser.adminTitleIsDisplayed();
		Assert.assertTrue(admintitleisdisplayed, Messages.ADMINERROR);
	}

}
