package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class SeleniumUtilis {

	public static WebDriver driver;

	@Parameters({ "browserName", "projectURL" })
	@BeforeSuite
	public void openBrowser(String browserName, String projectURL) {
		if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			openURL(projectURL);
		}

		else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			openURL(projectURL);
		}

		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.firefox.marionette", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			openURL(projectURL);
		}
		driver.manage().window().maximize();
	}

	public void openURL(String url) {
		driver.get(url);
		implicitWait();
	}

	public void click(By locator) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		ele.click();
	}

	public void enterText(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		ele.clear();
		ele.sendKeys(value);
	}

	SimpleDateFormat formatter = new SimpleDateFormat("dMyyHmmss");
	Date date = new Date();

	SimpleDateFormat timeformat = new SimpleDateFormat("HHmmss");
	Date time = new Date();

	public void enterEmail(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		ele.sendKeys(value + formatter.format(date) + "@mailinator.com");
	}

	public WebElement selectByIndex(By locator, int value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		Select ddl = new Select(ele);
		ddl.selectByIndex(value);
		return ele;
	}

	public void selectByText(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		Select ddl = new Select(ele);
		ddl.selectByVisibleText(value);
	}

	public void selectByValue(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		Select ddl = new Select(ele);
		ddl.deselectByValue(value);
	}

	public String getFirstSelectedOption(By locator) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		Select ddl = new Select(ele);
		WebElement firstOption = ddl.getFirstSelectedOption();
		String firstValue = firstOption.getText();
		return firstValue;
	}

	public List<WebElement> selectAllOptions(By locator) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele);
		Select ddl = new Select(ele);
		List<WebElement> allOptions = ddl.getOptions();
		return allOptions;
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void explicitWait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean existsElement(By locator) {
		try {
			explicitWait(locator);
			WebElement ele = driver.findElement(locator);
			highlightElement(ele);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void assertVerify(String actual, String expected, String FailMessage) {
		SoftAssert st = new SoftAssert();
		st.assertEquals(actual, expected, FailMessage);
		st.assertAll();
	}

	public void assertElementVerify(boolean actual, boolean expected, String FailMessage) {
		SoftAssert st = new SoftAssert();
		st.assertEquals(actual, expected, FailMessage);
		st.assertAll();
	}

	public String getText(By locator) {
		explicitWait(locator);
		return driver.findElement(locator).getText();
	}

	public void fileUpload(By locator, String path) {
		explicitWait(locator);
		explicitWait(locator);
		File file = new File(path);
		WebElement upload = driver.findElement(locator);
		highlightElement(upload);
		upload.sendKeys(file.getAbsolutePath());
	}

	public void highlightElement(WebElement ele) {
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
		javascriptExecutor.executeScript("arguments[0].style.border='1px solid blue'", ele);
	}

	public List<WebElement> elementList(By locator) {
		explicitWait(locator);
		return driver.findElements(locator);
	}

	public WebElement element(By locator) {
		explicitWait(locator);
		return driver.findElement(locator);
	}

	public void tackScreenShot(String filepath) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filepath);
		FileUtils.copyFile(SrcFile, DestFile);

	}
}