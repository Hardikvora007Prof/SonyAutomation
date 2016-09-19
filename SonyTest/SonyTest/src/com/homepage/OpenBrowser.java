/**
 * 
 */
package com.homepage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Hardik
 *
 */
public class OpenBrowser {

	WebDriver driver;
	Properties properties = new Properties();
	InputStream input = null;
	// public final static String strURL = "http://stg.sonyliv.com/";

	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {

		try {
			input = new FileInputStream("Assets.properties");
			properties.load(input);

			// Check if parameter passed from TestNG is 'firefox'
			if (browser.equalsIgnoreCase("firefox")) {
				// Create firefox instance

				// System.setProperty("webdriver.firefox.driver",
				// "E:/Hardik/SonyTest/src/wires.exe");
				
				DesiredCapabilities capabilityFirefox = DesiredCapabilities.firefox();
				capabilityFirefox.setCapability("marionette", true);
				driver = new MarionetteDriver(capabilityFirefox);
				driver.manage().window().maximize();
			}
			// Check if parameter passed as 'chrome'
			else if (browser.equalsIgnoreCase("chrome")) {
				// Set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver", "E://Hardik//SonyTest//src//chromedriver.exe");
				// Create chrome instance
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			// Check if parameter passed as 'safari'
			else if (browser.equalsIgnoreCase("safari")) {
				// System.setProperty("webdriver.safari.noinstall", "true");
				// To stop uninstall each time
				driver = new SafariDriver();
				driver.manage().window().maximize();
			}
			// Check if parameter passed as 'IE'
			else if (browser.equalsIgnoreCase("ie")) {
				// Set path to IE.exe
				System.setProperty("webdriver.ie.driver", "E://Hardik//SonyTest//src//IEDriverServer.exe");
				// Create IE instance
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				// Runtime.getRuntime().exec("taskkill /F /IM
				// IEDriverServer.exe");
				// WindowsUtils.killByName("IEDriverServer.exe");
			}

			else {
				// If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void openBrowser() {

		try {
			driver.get(properties.getProperty("baseURL"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException io) {
					io.getStackTrace();
				}
			}
		}
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}