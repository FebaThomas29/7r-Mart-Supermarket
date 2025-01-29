package automationcore;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class BaseClass {
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {

		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
			driver.manage().window().maximize();
		} else {
			throw new Exception("Invalid Browser");
		}
	}
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)
	{
		ScreenshotUtility screenShot=new ScreenshotUtility();
		screenShot.getScreenShot(driver, iTestResult.getName());
	}
		driver.quit();
		
	}

}
