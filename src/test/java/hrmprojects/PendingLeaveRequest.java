package hrmprojects;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctions.CommonFunctions;
import com.pageobjects.DashboardPageObjects;
import com.pageobjects.LoginPage;

public class PendingLeaveRequest extends CommonFunctions {
	String actualmessage = null;
	Logger logger = Logger.getLogger(PendingLeaveRequest.class);

	public void loginPage() {
		logger.info("Creating Login Page");
		PageFactory.initElements(driver, LoginPage.class);
		LoginPage.UserName.sendKeys(properties.getProperty("Username"));
		LoginPage.Password.sendKeys(properties.getProperty("Password"));
		LoginPage.Login.click();
	}

	public void gettingPendingRequest() throws InterruptedException, IOException {
		logger.info("Getting The Pending Request");
		PageFactory.initElements(driver, DashboardPageObjects.class);
		DashboardPageObjects.dashboard.click();
		actualmessage = DashboardPageObjects.dash_Board_Page_Objects.getText();

	}

	@Test
	public void verify_Pending_Leaverequestest() throws InterruptedException, IOException {
		logger.info("Verifying The Pending Leaverequestest");
		loginPage();
		gettingPendingRequest();
		System.out.println("actualmessage: " + actualmessage);
		Assert.assertEquals(actualmessage, "No Records are Available");
		actualmessage = DashboardPageObjects.dash_Board_Page_Objects.getText();
		Thread.sleep(5000);
		TakesScreenshot takescreen = (TakesScreenshot) driver;
		File sourcefile = takescreen.getScreenshotAs(OutputType.FILE);
		File destinationfile  = new File("/Users/user/Documents/New Folder With Items/screen.png");
		FileHandler.copy(sourcefile, destinationfile);

	}
}
