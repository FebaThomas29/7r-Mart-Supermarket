package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()=\"Sub Category\"][1]")
	private WebElement clicksubcategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clicknewbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement selectcategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement entersubcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefilebutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement clicksavebutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement clicksearchicon;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement categorysearchdropdown;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchsubcategoryfield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement clicksearchbuttoninsearchpage;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement isdisplayedsubcategorytitle;

	public HomePage clickSubCategoryMenu() {
		PageUtility.clickOnElementUsingClick(clicksubcategory);
		return new HomePage(driver);
	}

	public SubCategoryPage clickNewButton() {
		PageUtility.clickOnElementUsingClick(clicknewbutton);
		return this;
	}

	public SubCategoryPage selectCategoryFromDropdown() {

		PageUtility.selectByVisibleText(selectcategory, "biscuit");
		return this;
	}

	public SubCategoryPage enterSubCategoryField(String subcategoryname) {
		entersubcategoryfield.sendKeys(subcategoryname);
		return this;
	}

	public SubCategoryPage chooseFileButton(String choosebutton) {
		choosefilebutton.sendKeys(choosebutton);
		return this;
	}

	public SubCategoryPage clickSaveButtonSubCategory() {

		WaitUtility.waitUntilElementToBeClickable(driver, clicksavebutton);
		PageUtility.scrollDown(driver);
		PageUtility.clickOnElement(clicksavebutton, driver);
		return this;

	}

	public SubCategoryPage clickSearchIcon() {
		PageUtility.clickOnElementUsingClick(clicksearchicon);
		return this;
	}

	public SubCategoryPage categorySearchDropdown() {
		PageUtility.selectByVisibleText(categorysearchdropdown, "Honey");
		return this;
	}

	public SubCategoryPage enterSelectCatergoryField(String subcategoryname) {
		searchsubcategoryfield.sendKeys(subcategoryname);
		return this;
	}

	public SubCategoryPage clickSearchbuttoninSearchPage() {
		PageUtility.clickOnElementUsingClick(clicksearchbuttoninsearchpage);
		return this;
	}

	public boolean subCategoryTitleIsDisplayed() {
		return isdisplayedsubcategorytitle.isDisplayed();
	}
}
