package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item dropdown']")
	private WebElement clickadminuser;
	@FindBy(xpath = "//a[@class='dropdown-item'][2]")
	private WebElement clicklogout;
	@FindBy(xpath = "//b[text()=\"7rmart supermarket\"]")
	private WebElement loginpagetitletitle;

	public HomePage clickAdminUser() {
		PageUtility.clickOnElementUsingClick(clickadminuser);
		return this;

	}

	public LoginPage clickLogOut() {
		PageUtility.clickOnElementUsingClick(clicklogout);
		return new LoginPage(driver);

	}

	public boolean isLoginTitleDispalyed() {
		return loginpagetitletitle.isDisplayed();
	}
}
