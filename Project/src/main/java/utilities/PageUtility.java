package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public static WebDriver driver;

	public static void clickOnElement(WebElement element) {

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

	public static void selectByVisibleText(WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(null);
	}

	public static void selectByIndex(WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(0);
	}

	public static void selectByValue(WebElement element) {
		Select select = new Select(element);
		select.selectByValue(null);
	}

}
