package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.BaseClass;

public class TC02_Login extends BaseClass {

	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;

	@BeforeMethod
	public void createReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/finalReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 1)
	public void login(String userName, String password) throws InterruptedException, IOException {

		logger = extent.createTest("Login Module");
		objSeleutils.click(objLogin.lbl_signin);
		objSeleutils.enterText(objLogin.txt_email, userName);
		objSeleutils.enterText(objLogin.txt_password, password);
		objSeleutils.click(objLogin.btn_signup);
		
		boolean txt_welcome = objSeleutils.existsElement(objLogin.ddl_welcome);
		Assert.assertEquals(txt_welcome, true);
	}

	@Test(priority = 2)
	public void dashboard() {
		
		logger = extent.createTest("Dashboard Verification.");
		boolean txt_welcome = objSeleutils.existsElement(objLogin.btn_findPet);
		Assert.assertEquals(txt_welcome, false);
	}

	@AfterMethod
	public void teardown(ITestResult results) throws IOException {
		if (results.getStatus() == ITestResult.FAILURE) {
			String path = System.getProperty("user.dir") + "/Screenshots/" + "Fail_" + System.currentTimeMillis()
					+ ".png";
			String temp = objSeleutils.tackScreenShot(path);
			logger.fail(results.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			logger.log(Status.FAIL, "Test Case Failed.");
		}

		if (results.getStatus() == ITestResult.SUCCESS) {
			String path = System.getProperty("user.dir") + "/Screenshots/" + "Pass_" + System.currentTimeMillis()
					+ ".png";
			String temp = objSeleutils.tackScreenShot(path);
			logger.log(Status.PASS, "Test Case Passed.", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
	}
}
