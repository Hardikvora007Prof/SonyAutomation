/**
 * 
 */
package com.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * @author user
 *
 */
public class Premium {

	Browsers bro = new Browsers();

	@Test
	public void premium() throws Exception {
		bro.openChromeBrowser();
		bro.driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div/div/div/ul/li[1]/a")).click();

		bro.scrollDown();

		WebElement elementClick = bro.driver.findElement(
				By.xpath("html/body/div[3]/div[2]/div/div[2]/div/div[1]/list-m-01/ul/li[1]/tile-m-01/div/a/div/img"));
		elementClick.click();
		bro.generateWaitThread();

		bro.driver.findElement(By.xpath("//button[3]")).click();
		bro.generateWaitThread();

		bro.driver.findElement(By.xpath("//div[3]/button")).click();
		bro.generateWaitThread();

		bro.driver.findElement(By.name("mobileNumber")).click();
		bro.driver.findElement(By.name("mobileNumber")).sendKeys("9960021617");
		bro.driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("\n\nEnter the Pin number in the Mobile field.\nWill be waiting till 60 seconds for input");
		bro.generateWaitTimer();

		System.out.println("\n\nTimeout occurred. Closing the Script");
		bro.driver.quit();
	}
}