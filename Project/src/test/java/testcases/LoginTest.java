package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	@Test(groups= {"smoke"},description = "User Login With Valid Username and Valid Password", priority = 1)

	public void userLoginWithValidUsernameAndValidPassword() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
		boolean isdashboardDisplayed = loginpage.isdashboardDisplayed();
		Assert.assertTrue(isdashboardDisplayed, Messages.ELEMENTNOTFOUND);

	}

	@Test(groups= {"smoke"},description = "User Login With Valid Username and InValid Password", priority = 3)
	public void userLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "Login");
		String password = ExcelUtility.readStringData(2, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
		boolean isErrormessageDisplayed = loginpage.isErrormessageDisplayed();
		Assert.assertTrue(isErrormessageDisplayed, Messages.ALERTNOTFOUND);

	}

	@Test(groups= {"smoke"},description = "User Login With InValid Username and Valid Password", priority = 2)
	public void userLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
		boolean isErrormessageDisplayed = loginpage.isErrormessageDisplayed();
		Assert.assertTrue(isErrormessageDisplayed, Messages.ALERTNOTFOUND);


	}

	@Test(groups= {"smoke"},description = "User Login With InValid Username and InValid Password", priority = 4)
	public void userLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(4, 0, "Login");
		String password = ExcelUtility.readStringData(4, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
		boolean isErrormessageDisplayed = loginpage.isErrormessageDisplayed();
		Assert.assertTrue(isErrormessageDisplayed, Messages.ALERTNOTFOUND);


	}

}
