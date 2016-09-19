/**
 * 
 */
package com.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

/**
 * @author Hardik
 *
 */
public class SearchField {

	Browsers bro = new Browsers();

	@SuppressWarnings("static-access")
	@Test
	public void searchField() throws Exception {

		bro.openChromeBrowser();

		bro.driver.findElement(By.xpath("//div[3]/div/div/div/div/div/ul/li[4]/a/div")).click();
		bro.driver.findElement(By.id("searchinput")).click();
		bro.driver.findElement(By.id("searchinput")).sendKeys("Adaalat");

		bro.generateWaitThread();
		bro.driver.findElement(By.id("searchinput")).sendKeys(Keys.ENTER);
		bro.generateWaitThread();

		bro.driver
				.findElement(By
						.xpath("html/body/div[3]/div[2]/div/div/div[2]/div/div/list-ts-01/ul/li[1]/tile-ts-01/div/a/div/img"))
				.click();

		bro.generateWaitTimer();

		bro.driver.navigate().to(bro.baseURL);
		bro.generateWaitThread();

		bro.driver.findElement(By.xpath("//div[3]/div/div/div/div/div/ul/li[4]/a/div")).click();
		bro.driver.findElement(By.id("searchinput")).click();
		bro.driver.findElement(By.id("searchinput")).sendKeys("Tarak");

		bro.generateWaitThread();
		bro.driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div/div/div/ul/li[4]/ul/li[2]/a")).click();

		bro.generateWaitThread();
		bro.driver
				.findElement(By
						.xpath("html/body/div[3]/div[2]/div/div/div[2]/div/div/list-ts-01/ul/li/tile-ts-01/div/a/div/img"))
				.click();

		bro.generateWaitTimer();

		bro.driver.navigate().to(bro.baseURL);
		bro.generateWaitThread();

		bro.driver.quit();
	}
}