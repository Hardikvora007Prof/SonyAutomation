/**
 * 
 */
package com.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Hardik
 *
 */
public class VideoPlayerCheck {

	Browsers browser = new Browsers();
	WebDriverWait wait;
	WebElement elementSonyMix, elementFooter;
	String strFooter = "©2016 Sony Pictures Networks India Pvt. Ltd";
	// JavascriptExecutor js = (JavascriptExecutor) browser.driver;

	public void videoPlayerCheck() throws Exception {
		browser.openChromeBrowser();
		// List<WebElement> elementgetAllImageLoaderValues =
		// browser.driver.findElements(By.className("onImageLoaded"));
		// String[] strTotalImageCount = new
		// String[(elementgetAllImageLoaderValues.size())];
		// System.out.println("ImageLoader class count = " +
		// strTotalImageCount.length);

		int i = 1;
		Actions action = new Actions(browser.driver);
		// for (WebElement element : elementgetAllImageLoaderValues) {
		// if(strTotalImageCount.length!=0)
		// while (strTotalImageCount.length != 0) {

		while (i > 0) {
			/*
			 * js.executeScript("scroll(0, 500)"); if (browser.driver
			 * .findElement( By.xpath(
			 * ".//*[@id='movie-all']/div/div[20]/list-ts-03/ul/li[1]/tile-ts-01/div/a/div/img"
			 * )) .getText().equalsIgnoreCase("Sony MIX - LIVE Channel")) {
			 * elementSonyMix = browser.driver.findElement( By.xpath(
			 * ".//*[@id='movie-all']/div/div[20]/list-ts-03/ul/li[1]/tile-ts-01/div/a/div/img"
			 * )); elementSonyMix.click(); break; } else { js.executeScript(
			 * "scroll(0, 250)"); }
			 */

			action.sendKeys(Keys.END).build().perform();
			// i = i + 1;
			// System.out.println("i = " + i);
			// if (i == 15) {
			// break;
			// }
			wait = new WebDriverWait(browser.driver, 10);
			elementFooter = browser.driver.findElement(By.xpath("html/body/div[3]/div[3]/footer/div/div/p"));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[3]/footer/div/div/p")));
			// if
			// (browser.driver.toString().contentEquals(strFooter.trim().toString()))
			// {
			if (elementFooter.isDisplayed()) {
				Thread.sleep(5000);

				elementSonyMix = browser.driver.findElement(
						By.xpath(".//*[@id='movie-all']/div/div[20]/list-ts-03/ul/li[1]/tile-ts-01/div/a/div/img"));
				Thread.sleep(5000);
				elementSonyMix.click();

				Thread.sleep(5000);
				browser.driver.quit();
			}
		}
		// browser.driver.findElement(By.xpath("html/body/div[3]/div[3]/footer/div/div/p")).click();

		// js.executeScript("arguments[0].scrollIntoView();",
		// browser.driver.findElement(
		// By.xpath(".//*[@id='movie-all']/div/div[20]/list-ts-03/ul/li[1]/tile-ts-01/div/a/div/img')]")));
	}
}