package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	@Test(groups= {"smoke"},description = "User Login With Valid Username and Valid Password", priority = 1,retryAnalyzer=retry.Retry.class)

	public void userLoginWithValidUsernameAndValidPassword() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username).enterPasswordOnPasswordField(password).clickSignInButton();
		boolean isdashboardDisplayed = loginpage.isdashboardDisplayed();
		Assert.assertTrue(isdashboardDisplayed, Messages.ELEMENTNOTFOUND);

	}

	@Test(groups= {"smoke"},description = "User Login With Valid Username and InValid Password", priority = 3,dataProvider="loginProvider")
	public void userLoginWithValidUsernameAndInvalidPassword(String username,String password) throws IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username).enterPasswordOnPasswordField(password).clickSignInButton();
		boolean isErrormessageDisplayed = loginpage.isErrormessageDisplayed();
		Assert.assertTrue(isErrormessageDisplayed, Messages.ALERTNOTFOUND);

	}

	@Test(groups= {"smoke"},description = "User Login With InValid Username and Valid Password", priority = 2)
	public void userLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "Login");
		String password = ExcelUtility.readStringData(3, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username).enterPasswordOnPasswordField(password).clickSignInButton();
		boolean isErrormessageDisplayed = loginpage.isErrormessageDisplayed();
		Assert.assertTrue(isErrormessageDisplayed, Messages.ALERTNOTFOUND);


	}

	@Test(groups= {"smoke"},description = "User Login With InValid Username and InValid Password", priority = 4)
	public void userLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(4, 0, "Login");
		String password = ExcelUtility.readStringData(4, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username).enterPasswordOnPasswordField(password).clickSignInButton();
		boolean isErrormessageDisplayed = loginpage.isErrormessageDisplayed();
		Assert.assertTrue(isErrormessageDisplayed, Messages.ALERTNOTFOUND);


	}
   @DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin12345","admin34567"},
			new Object[] {"admin","admin234"},
			new Object[] {ExcelUtility.readStringData(5, 0, "Login"), ExcelUtility.readStringData(5, 1, "Login")
		}
			
		};
	}
}
