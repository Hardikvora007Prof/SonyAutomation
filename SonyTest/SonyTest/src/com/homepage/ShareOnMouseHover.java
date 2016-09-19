/**
 * 
 */
package com.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * @author user
 *
 */
public class ShareOnMouseHover {

	Browsers bro = new Browsers();
	Actions action;

	@Test
	public void shareCheck() throws Exception {

		bro.openChromeBrowser();

		//bro.openFirefoxBrowser();
		bro.scrollDown();

		action = new Actions(bro.driver);
		WebElement elementImage = bro.driver.findElement(
				By.xpath("html/body/div[3]/div[2]/div/div[2]/div/div[3]/list-ts-03/ul/li[1]/tile-ts-01/div/a/div/img"));
		WebElement elementShareFrame = bro.driver.findElement(By.xpath("html/body/div[4]/div[2]/section/div[2]"));
		WebElement elementShare = bro.driver.findElement(By.xpath("html/body/div[4]/div[2]/section/div[2]/span"));
		action.clickAndHold(elementImage).moveToElement(elementShareFrame).moveToElement(elementShare).click().build()
				.perform();
	}
}