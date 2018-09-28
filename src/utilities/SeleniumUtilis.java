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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
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
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			openURL(projectURL);
		}

		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.firefox.marionette", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			openURL(projectURL);
		}
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void closeBrowser() {
		openURL("D:\\Java\\workplace\\Palcura\\Reports\\finalReport.html");
	}

	public void openURL(String url) {
		driver.get(url);
		implicitWait();
	}

	public void click(By locator) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		ele.click();		
	}
	
	public void enterText(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		ele.clear();
		ele.sendKeys(value);
		highlightElement(ele, false);
	}

	SimpleDateFormat formatter = new SimpleDateFormat("dMyyHmmss");
	Date date = new Date();

	SimpleDateFormat timeformat = new SimpleDateFormat("HHmmss");
	Date time = new Date();

	public void enterEmail(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		ele.sendKeys(value + formatter.format(date) + "@mailinator.com");
		highlightElement(ele, false);
	}

	public void selectByIndex(By locator, int value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		Select ddl = new Select(ele);
		ddl.selectByIndex(value);
		highlightElement(ele, false);
	}

	public void selectByText(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		Select ddl = new Select(ele);
		ddl.selectByVisibleText(value);
		highlightElement(ele, false);
	}

	public void selectByValue(By locator, String value) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		Select ddl = new Select(ele);
		ddl.deselectByValue(value);
		highlightElement(ele, false);
	}

	public String getFirstSelectedOption(By locator) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		Select ddl = new Select(ele);
		WebElement firstOption = ddl.getFirstSelectedOption();
		String firstValue = firstOption.getText();
		highlightElement(ele, false);
		return firstValue;
	}

	public List<WebElement> selectAllOptions(By locator) {
		explicitWait(locator);
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		Select ddl = new Select(ele);
		List<WebElement> allOptions = ddl.getOptions();
		highlightElement(ele, false);
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
			highlightElement(ele, true);
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
		WebElement ele = driver.findElement(locator);
		highlightElement(ele, true);
		ele.sendKeys(file.getAbsolutePath());
		highlightElement(ele, false);
	}

	public void highlightElement(WebElement ele, boolean isHeighlight) {
		if (isHeighlight) {
			JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
			javascriptExecutor.executeScript("arguments[0].style.border='1px solid blue'", ele);
		} else {
			JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
			javascriptExecutor.executeScript("arguments[0].style.border=''", ele);
		}
	}

	public List<WebElement> elementList(By locator) {
		explicitWait(locator);
		return driver.findElements(locator);
	}

	public WebElement element(By locator) {
		explicitWait(locator);
		return driver.findElement(locator);
	}

	public String tackScreenShot(String filepath) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filepath);
		FileUtils.copyFile(SrcFile, DestFile);
		return filepath;
	}

}