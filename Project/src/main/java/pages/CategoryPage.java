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
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clicksavebutton;
	@FindBy(xpath = "//h1[text()=\"Add Category\"]")
	private WebElement iscategorytitledisplayed;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchfield;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement categorysearchfield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchbuttton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetbutton;

	public void clickCategoryPage() {
		PageUtility.clickOnElement(clickcategorymenu);
	}

	public void clickCategoryNewButton() {
		PageUtility.clickOnElement(clickcategorynew);
	}

	public void addCatergoryField(String categoryname) {
		categoryfield.sendKeys(categoryname);
	}

	public void clickDiscountField() {
		PageUtility.clickOnElement(discountfield);
	}

	public void chooseFileButton(String choosebutton)  {
		choosefilebutton.sendKeys(choosebutton);
	}

	public void clickSaveButton() {
		
		PageUtility.draggableAction(clicksavebutton);

	}

	public boolean categoryTitleDisplayed() {
		return iscategorytitledisplayed.isDisplayed();
	}

	public void clickSearchField() {
		PageUtility.clickOnElement(searchfield);
	}

	public void categorySearchField(String categoryname) {
		categorysearchfield.sendKeys(categoryname);
	}

	public void clickSearchButton() {
		PageUtility.clickOnElement(searchbuttton);
		
	}

	public void clickResetButton() {
		PageUtility.clickOnElement(resetbutton);
		
	}


}
