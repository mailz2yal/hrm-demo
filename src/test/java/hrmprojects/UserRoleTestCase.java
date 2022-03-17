package hrmprojects;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctions.CommonFunctions;
import com.pageobjects.LoginPage;
import com.pageobjects.UserRole_PageObjects;

public class UserRoleTestCase extends CommonFunctions {
	Logger logger = Logger.getLogger(UserRoleTestCase.class);

	public void loginPage() {
		logger.info("Creating Login Page");
		driver.switchTo().defaultContent();
		PageFactory.initElements(driver, LoginPage.class);
		LoginPage.UserName.sendKeys(properties.getProperty("Username"));
		LoginPage.Password.sendKeys(properties.getProperty("Password"));
		LoginPage.Login.click();
	}

	public void moveToUserPage() throws InterruptedException {
		logger.info("Move to User Page");
		PageFactory.initElements(driver, UserRole_PageObjects.class);
		Actions action = new Actions(driver);
		action.moveToElement(UserRole_PageObjects.Admin);
		action.moveToElement(UserRole_PageObjects.userManagement);
		action.moveToElement(UserRole_PageObjects.users);
		action.click().build().perform();

	}

	public void SelectElements() throws InterruptedException {
		logger.info("Select the Elements");
		Select select = new Select(UserRole_PageObjects.userType);
		select.selectByIndex(1);
	}

	public void SelectEle() throws InterruptedException {
		logger.info("Select the Elements");
		Select status = new Select(UserRole_PageObjects.userStatus);
		status.selectByIndex(1);
	}

	@Test
	public void verifyValues() throws InterruptedException, IOException {
		logger.info("Verifying The Values");
		PageFactory.initElements(driver, UserRole_PageObjects.class);
		loginPage();
		moveToUserPage();
		Thread.sleep(2000);
		SelectElements();
		SelectEle();
		Thread.sleep(2000);
		UserRole_PageObjects.searchButton.click();
		Thread.sleep(2000);
		String Rolevalue = UserRole_PageObjects.UserRoleValue.getText();
		String Statusevalue = UserRole_PageObjects.UserStatusValue.getText();
		Assert.assertEquals(Rolevalue, "Admin");
		Assert.assertEquals(Statusevalue, "Enabled");
		System.out.println("Rolevalue: " + Rolevalue);
		System.out.println("Statusevalue: " + Statusevalue);
		TakesScreenshot takescreen = (TakesScreenshot) driver;
		File sourcefile = takescreen.getScreenshotAs(OutputType.FILE);
		File destinationfile  = new File("/Users/user/eclipse-workspace/orangehrmproject/screen.png");
		FileHandler.copy(sourcefile, destinationfile);


	}

}
