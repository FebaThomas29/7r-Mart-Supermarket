package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()=\"Manage News\"]")
	private WebElement clickmanageusers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clicknewsbutton;
	@FindBy(xpath = "//textarea[@class='form-control']")
	private WebElement enternews;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement clicksavebutton;
	@FindBy(xpath = "//h1[text()=\"Manage News\"]")
	private WebElement istitledisplayed;

	public ManageNewsPage clickManageUsers() {
		PageUtility.clickOnElementUsingClick(clickmanageusers);
		return this;
	}

	public ManageNewsPage clickNewsButton() {
		PageUtility.clickOnElementUsingClick(clicknewsbutton);
		return this;
	}

	public ManageNewsPage enterNewsInTextField() {
		enternews.sendKeys("Hi my new news broadcast");
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		PageUtility.clickOnElementUsingClick(clicksavebutton);
		return this;
	}

	public boolean isTitleDisplayed() {
		return istitledisplayed.isDisplayed();
	}

}
