package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constants;
import constants.Messages;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class CategoryTest extends BaseClass {

	@Test(groups= {"smoke"},description = "Add a new Category", priority = 1)
	public void addingTheCategoryOne() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
	
		String categoryname = ExcelUtility.readStringData(1, 0, "Category");
		String choosefile = Constants.TESTDATAFILE1;
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickCategoryPage();
		categorypage.clickCategoryNewButton();
		categorypage.addCatergoryField(categoryname);
		categorypage.clickDiscountField();
		categorypage.chooseFileButton(choosefile);
		categorypage.clickSaveButton();
		categorypage.categoryTitleDisplayed();
		boolean categoryTitleDisplayed = categorypage.categoryTitleDisplayed();
		Assert.assertTrue(categoryTitleDisplayed, Messages.TITLENOTFOUND);
	}

	@Test(groups= {"smoke"},description = "Search a category", priority = 2)
	public void searchTheCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUserField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignInButton();
 
		String categoryname = ExcelUtility.readStringData(4, 0, "Category");
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickCategoryPage();
		categorypage.clickSearchField();
		categorypage.categorySearchField(categoryname);
		categorypage.clickSearchButton();
		boolean categoryTitleDisplayed = categorypage.categoryTitleDisplayed();
		Assert.assertTrue(categoryTitleDisplayed, Messages.TITLENOTFOUND);
	}

}
