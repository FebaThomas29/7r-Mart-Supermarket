package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

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

	public void clickSubCategoryMenu() {
		PageUtility.clickOnElement(clicksubcategory);
	}

	public void clickNewButton() {
		PageUtility.clickOnElement(clicknewbutton);
	}

	public void selectCategoryFromDropdown() {
		Select select = new Select(selectcategory);
		select.selectByVisibleText("Honey");
	}

	public void enterSubCategoryField(String subcategoryname) {
		entersubcategoryfield.sendKeys(subcategoryname);
	}

	public void chooseFileButton(String choosebutton) {
		choosefilebutton.sendKeys(choosebutton);
	}

	public void clickSaveButtonSubCategory() {
		Actions act = new Actions(driver);
		act.moveToElement(clicksavebutton).click().perform();
	}

	public void clickSearchIcon() {
		PageUtility.clickOnElement(clicksearchicon);
	}

	public void categorySearchDropdown() {
		Select select = new Select(categorysearchdropdown);
		select.selectByVisibleText("Honey");
	}

	public void enterSelectCatergoryField(String subcategoryname) {
		searchsubcategoryfield.sendKeys(subcategoryname);
	}

	public void clickSearchbuttoninSearchPage() {
		PageUtility.clickOnElement(clicksearchbuttoninsearchpage);
		clicksearchbuttoninsearchpage.click();
	}

	public boolean subCategoryTitleIsDisplayed() {
		return isdisplayedsubcategorytitle.isDisplayed();
	}
}
