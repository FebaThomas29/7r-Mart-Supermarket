package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public static WebDriver driver;

	public static void clickOnElement(WebElement element,WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	public static void clickOnElementUsingClick(WebElement element) {
		
		element.click();
	}

	public static void righClick(WebElement element) {

		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();

	}

	public static void draggableAction(WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();

	}

	public static void dragAndDrop(WebElement element, WebElement dropzone) {

		Actions act = new Actions(driver);
		act.dragAndDrop(element, dropzone).build().perform();

	}

	public static void mouseHover(WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

	}
	public static void clickSaveButton(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		}

	public static String selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public static String selectByIndex(WebElement element, int num) {
		Select select = new Select(element);
		select.selectByIndex(0);
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public static String selectByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue("");
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public static void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

}
