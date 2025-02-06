package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()=\"Category\"]")
	private WebElement clickcategorymenu;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clickcategorynew;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement discountfield;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefilebutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement clicksavebutton;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement iscategorytitledisplayed;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchfield;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement categorysearchfield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchbuttton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetbutton;

	public CategoryPage clickCategoryPage() {
		WaitUtility.waitUntilElementToBeClickable(driver, clickcategorymenu);
		PageUtility.clickOnElementUsingClick(clickcategorymenu);
		return this;
	}

	public CategoryPage clickCategoryNewButton() {
		PageUtility.clickOnElementUsingClick(clickcategorynew);
		return this;
	}

	public CategoryPage addCatergoryField(String categoryname) {
		categoryfield.sendKeys(categoryname);
		return this;
	}

	public CategoryPage clickDiscountField() {
		PageUtility.clickOnElementUsingClick(discountfield);
		return this;
	}

	public CategoryPage chooseFileButton(String choosebutton) {
		choosefilebutton.sendKeys(choosebutton);
		return this;
	}

	public CategoryPage clickSaveButton() {

		WaitUtility.waitUntilElementToBeClickable(driver, clicksavebutton);
		PageUtility.scrollDown(driver);
		PageUtility.clickOnElement(clicksavebutton, driver);
		return this;

	}

	public boolean categoryTitleDisplayed() {
		return iscategorytitledisplayed.isDisplayed();
	}

	public CategoryPage clickSearchField() {
		PageUtility.clickOnElementUsingClick(searchfield);
		return this;
	}

	public CategoryPage categorySearchField(String categoryname) {
		categorysearchfield.sendKeys(categoryname);
		return this;
	}

	public CategoryPage clickSearchButton() {
		PageUtility.clickOnElementUsingClick(searchbuttton);
		return this;

	}

}
