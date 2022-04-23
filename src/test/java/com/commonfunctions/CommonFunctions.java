package com.commonfunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	public static Properties properties = null;
	public static WebDriver driver = null;
	Logger logger = Logger.getLogger(CommonFunctions.class);

	public Properties loadProperties() throws IOException {
		logger.info("Orange HRM Test Begins");
		logger.info(" Loading the property file");
		FileInputStream fileinputstream = new FileInputStream("Config.properties");
		properties = new Properties();
		properties.load(fileinputstream);
		return properties;
	}

	@BeforeSuite
	public void launchBrowser() throws IOException, InterruptedException {
		logger.info("Launching The Browser");
		logger.info("Get The log4j File Messages");
		loadProperties();
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		String chromedriverlocation = properties.getProperty("chromedriverlocation");
		String geckodriverlocation = properties.getProperty("geckodriverlocation");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromedriverlocation);
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", geckodriverlocation);
			driver = new FirefoxDriver();

		}
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);

	}

	@AfterSuite
	public void tearDown() {

	
		driver.quit();
	}

}
