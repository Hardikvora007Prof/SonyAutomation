/**
 * 
 */
package com.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Hardik
 *
 */
public class SeeAll {
	Browsers browser = new Browsers();
	String expected = "http://stg.sonyliv.com/listing/must_watch_videos", actual;
	Actions action;

	@Test
	public void seeAllClick() throws Exception {
		browser.openChromeBrowser();

		browser.generateWaitThread();
		browser.scrollDown();

		// WebDriver Exception if Live match is available

		try {
			browser.driver.findElement(By.xpath("//div/a/span")).click();
		} catch (WebDriverException e) {
			e.getStackTrace();
			System.out.println("Live match is available thue, Element xpath got changed resulting into Script Failure");
		}
		actual = browser.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected, "Must watch page got changed");

		browser.driver.findElement(By.xpath(".//*[@id='movie-list']/ul/li[1]/tile-vid-01/div/a/div/img")).click();

		browser.generateWaitTimer();
		browser.driver.navigate().back();
		browser.generateWaitThread();

		actual = browser.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected, "Page not redirected to Must watch");

		browser.scrollDown();
		browser.generateWaitThread();
		browser.driver.findElement(By.xpath(".//*[@id='movie-list']/ul/li[12]/tile-vid-01/div/a/div/img")).click();
		browser.generateWaitTimer();
		browser.driver.navigate().back();
		browser.generateWaitThread();

		actual = browser.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected, "Page not redirected to Must watch");

		browser.driver.quit();
	}
}