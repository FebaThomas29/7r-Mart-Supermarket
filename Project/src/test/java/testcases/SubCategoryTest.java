package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends BaseClass {

	@Test(groups= {"smoke"},description = "Add the sub category", priority = 1)
	public void addingTheSubCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
		
		String subcategoryname = ExcelUtility.readStringData(3, 0, "SubCategory");
		String choosefile = Constants.SUBCATEGORYFILE;
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickSubCategoryMenu();
		subcategorypage.clickNewButton();
		subcategorypage.selectCategoryFromDropdown();
		subcategorypage.enterSubCategoryField(subcategoryname);
		subcategorypage.chooseFileButton(choosefile);
		subcategorypage.clickSaveButtonSubCategory();
		boolean subcategoryTitleDisplayed = subcategorypage.subCategoryTitleIsDisplayed();
		Assert.assertTrue(subcategoryTitleDisplayed, Messages.TITLENOTFOUND1);
	}

	@Test(groups= {"smoke"},description = "Search the sub category", priority = 2)

	public void searchTheSubCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();

		String subcategoryname = ExcelUtility.readStringData(2, 0, "SubCategory");
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickSubCategoryMenu();
		subcategorypage.clickSearchIcon();
		subcategorypage.categorySearchDropdown();
		subcategorypage.enterSelectCatergoryField(subcategoryname);
		subcategorypage.clickSearchbuttoninSearchPage();
		boolean subcategoryTitleDisplayed = subcategorypage.subCategoryTitleIsDisplayed();
		Assert.assertTrue(subcategoryTitleDisplayed, Messages.TITLENOTFOUND1);
	}
}
