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

	public void clickManageUsers() {
		PageUtility.clickOnElement(clickmanageusers);
	}

	public void clickNewsButton() {
		PageUtility.clickOnElement(clicknewsbutton);
	}

	public void enterNewsInTextField() {
		enternews.sendKeys("Hi my new news broadcast");
	}

	public void clickSaveButton() {
		PageUtility.clickOnElement(clicksavebutton);
	}

	public boolean isTitleDisplayed() {
		return istitledisplayed.isDisplayed();
	}

}
