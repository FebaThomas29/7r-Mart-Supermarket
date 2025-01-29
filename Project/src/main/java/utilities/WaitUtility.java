package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static int IMPLICITWAITDURATION = 10;
	public static int EXPLICITWAITDURATION = 10;

	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public  void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAITDURATION));
	}

	public  void waitUntilAlertIsPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public  void waitUntilElementSelectionStateToBePresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public static void waitUntilTitleContains(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.titleContains("News"));
	}

	public static void waitUntilTextToBePresentInElementValue(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, null));
	}

	public static void waitUntilvisibilityOf(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAITDURATION));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
