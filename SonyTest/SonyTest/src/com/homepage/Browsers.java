/**
 * 
 */
package com.homepage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.neotys.selenium.proxies.NLWebDriver;
import com.neotys.selenium.proxies.WebDriverProxy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Hardik
 *
 */
public class Browsers {

	public static final String baseURL = "http://stg.sonyliv.com";
	WebDriver driver;
	Properties properties = new Properties();
	InputStream input = null;
	ExtentReports log = new ExtentReports("E://Hardik//SonyTest//AdvanceReports.html", true);
	ExtentTest test;

	@BeforeTest
	public void loadProperties() throws Exception {

		test = log.startTest("Verify All Browsers", "Class with verify all the browsers").assignCategory("Regression");
		input = new FileInputStream("Assets.properties");
		properties.load(input);
	}

	@Test
	public void openFirefoxBrowser() {

		System.setProperty("webdriver.gecko.driver", "E://Hardik//SonyTest//src//wires.exe");
		driver = new MarionetteDriver();

		test = log.startTest("Verify Firefox Browsers");
		test.log(LogStatus.PASS, "Open Firefox Browser", "Checking whether Firefox browser is getting opening");
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.close();
	}

	@Test
	public void openChromeBrowser() {

		NLWebDriver NLdriver;
		System.setProperty("webdriver.chrome.driver", "E://Hardik//SonyTest//src//chromedriver.exe");
		// driver = new ChromeDriver();
		NLdriver = WebDriverProxy.newInstance(new ChromeDriver());

		// test.log(LogStatus.PASS, "Open Chrome Browser", "Checking whether
		// Chrome browser is getting opening");
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.close();
	}

	@Test
	public void openIEBrowser() {
		System.setProperty("webdriver.ie.driver", "E://Hardik//SonyTest//src//IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		test.log(LogStatus.PASS, "Open IE Browser", "Checking whether IE browser is getting opening");
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.close();
	}

	@Test
	public void openSafariBrowser() {
		driver = new SafariDriver();
		test.log(LogStatus.PASS, "Open Safari Browser", "Checking whether Safari browser is getting opening");
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.close();
	}

	public void generateWaitTimer() throws Exception {
		synchronized (driver) {
			driver.wait(30000);
		}
	}

	public void generateWaitThread() throws Exception {
		Thread.sleep(3000);
	}

	public void scrollDown() throws Exception {
		Actions action = new Actions(driver);
		for (int i = 0; i < 7; i++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
	}

	public void scrollPageDown() throws Exception {
		Actions action = new Actions(driver);
		for (int i = 0; i < 3; i++) {
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			generateWaitThread();
		}
	}

	@AfterTest
	public void quitBrowser() {
		// LogStatus status = test.getRunStatus();
		log.endTest(test);
		log.flush();
		driver.quit();
	}
}