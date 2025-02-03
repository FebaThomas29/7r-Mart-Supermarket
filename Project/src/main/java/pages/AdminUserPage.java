package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement clickadminusers;
	@FindBy(xpath = "//p[text()=\"Manage Users\"]")
	private WebElement clickmanageusers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clicknewuserbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username1;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password1;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement clicksavebutton;
	@FindBy(xpath = "//h1[text()=\"Admin Users\"]")
	private WebElement admintitleisdisplayed;
	

	public HomePage clickAdminUsers() {
		PageUtility.clickOnElementUsingClick(clickadminusers);
		return new HomePage(driver);
	}

	public AdminUserPage clickManageUsers() {
		PageUtility.clickOnElementUsingClick(clickmanageusers);
		return this;
	}

	public AdminUserPage clickNewUserButton() {
		PageUtility.clickOnElementUsingClick(clicknewuserbutton);
		return this;
	}

	public AdminUserPage enterValueInUsernameField(String username) {
		username1.sendKeys(username);
		return this;
	}

	public AdminUserPage enterValueInPasswordField(String password) {
		password1.sendKeys(password);
		return this;
	}

	public AdminUserPage selectUserType() {
		PageUtility.selectByVisibleText(usertype, "Staff");
		return this;
	}

	public AdminUserPage clickSaveButton() {
		PageUtility.clickOnElementUsingClick(clicksavebutton);
		return this;
	}

	public boolean adminTitleIsDisplayed() {
		return admintitleisdisplayed.isDisplayed();
	}
}
