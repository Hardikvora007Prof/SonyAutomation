/**
 * 
 */
package com.homepage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Hardik
 *
 */
public class HeaderChecks {

	Browsers bro = new Browsers();
	String expectedShowURL = "http://stg.sonyliv.com/custompage/all_show_page", actualShowURL,
			expectedMoviesURL = "http://stg.sonyliv.com/custompage/all_movie_page", actualMoviesURL,
			expectedSportsURL = "http://stg.sonyliv.com/custompage/all_sport_page", actualSportsURL,
			expectedSignIn = "http://stg.sonyliv.com/signin", actualSignIn,
			expectedRegister = "http://stg.sonyliv.com/signup", actualRegister,
			expectedEuroURL = "http://euro2016.sonyliv.com/", actualEuroURL;

	@Test
	public void headerCheck() throws Exception {
		bro.openChromeBrowser();

		bro.driver.findElement(By.xpath("//a/div")).click();
		actualShowURL = bro.driver.getCurrentUrl();
		Assert.assertEquals(actualShowURL, expectedShowURL, "Shows page got changed");
		bro.scrollPageDown();
		bro.driver.navigate().back();

		bro.driver.findElement(By.xpath("//li[2]/a")).click();
		bro.generateWaitThread();
		actualMoviesURL = bro.driver.getCurrentUrl();
		Assert.assertEquals(actualMoviesURL, expectedMoviesURL, "Movies page got changed");
		bro.scrollPageDown();
		bro.driver.navigate().back();

		bro.driver.findElement(By.xpath("//li[3]/a")).click();
		bro.generateWaitThread();
		actualSportsURL = bro.driver.getCurrentUrl();
		Assert.assertEquals(actualSportsURL, expectedSportsURL, "Sports page got changed");
		bro.scrollPageDown();
		bro.driver.navigate().back();

		bro.driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		bro.generateWaitThread();
		actualSignIn = bro.driver.getCurrentUrl();
		Assert.assertEquals(actualSignIn, expectedSignIn, "Sign In page got changed");
		bro.driver.navigate().back();
		bro.generateWaitThread();

		bro.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		bro.generateWaitThread();
		actualRegister = bro.driver.getCurrentUrl();
		Assert.assertEquals(actualRegister, expectedRegister, "Register page got changed");
		bro.driver.navigate().back();
		bro.generateWaitThread();

		bro.driver.findElement(By.xpath("//li[4]/a")).click();
		bro.generateWaitThread();
		actualEuroURL = bro.driver.getCurrentUrl();
		Assert.assertEquals(actualEuroURL, expectedEuroURL, "Euro page got changed");
		bro.scrollPageDown();
		bro.generateWaitThread();

		bro.driver.quit();
	}
}