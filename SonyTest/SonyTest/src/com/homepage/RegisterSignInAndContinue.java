/**
 * 
 */
package com.homepage;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Hardik
 *
 */
public class RegisterSignInAndContinue {

	Browsers bro = new Browsers();
	SeeAll seeAll;
	Random random = new Random();
	int randomIntegerGeneration = random.nextInt(1000);
	String randomGeneration = "testing" + randomIntegerGeneration;
	String randomEmailGeneration = randomGeneration + "@mailinator.com";
	String randomMobileGeneration;
	WebElement elementDay, elementMonth, elementYear;
	String expected = "http://stg.sonyliv.com/signup-success", actual = "",
			strExpectedVerifyAccount = "We have sent you an email to verify your account. Please follow the"
					+ " instructions in that email and complete the verification. Once "
					+ "verified, you should be able to sign in to your account.";

	@Test
	public void registerPageOnFirefoxAsContinue() throws Exception {

		bro.openFirefoxBrowser();
		bro.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		bro.driver.findElement(By.id("firstNameInput")).sendKeys(randomGeneration);
		bro.driver.findElement(By.id("lastNameInput")).sendKeys(randomGeneration);

		// Randomly generated Email id's
		bro.driver.findElement(By.id("emailInput")).sendKeys(randomEmailGeneration);
		System.out.println("Email id = " + randomEmailGeneration);

		elementDay = bro.driver.findElement(By.cssSelector("input[name=day]"));
		elementDay.sendKeys("" + 1);
		elementMonth = bro.driver.findElement(By.cssSelector("input[name=month]"));
		elementMonth.sendKeys("" + 11);
		elementYear = bro.driver.findElement(By.cssSelector("input[name=year]"));
		elementYear.sendKeys("" + 1984);

		randomMobileGeneration = RandomStringUtils.randomNumeric(9);
		bro.driver.findElement(By.id("mobileInput")).sendKeys("9" + randomMobileGeneration);
		bro.driver.findElement(By.id("passwordInput")).sendKeys(randomGeneration);
		System.out.println("Password value = " + randomGeneration);

		bro.generateWaitTimer();
		bro.driver.findElement(By.xpath("//button[@type='submit']")).click();

		bro.generateWaitThread();

		actual = bro.driver.getCurrentUrl();
		System.out.println("Success page url = " + actual);
		Assert.assertEquals(actual, expected, "Success page got changed");

		bro.generateWaitThread();

		bro.driver.findElement(By.xpath("//div[2]/div/div/div/div/button")).click();
		bro.generateWaitThread();

		String actualURL = bro.driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "http://stg.sonyliv.com/signin", "SignIn Page got changed");

		bro.driver.findElement(By.name("username")).click();
		bro.driver.findElement(By.name("username")).sendKeys(randomEmailGeneration);

		bro.driver.findElement(By.name("password")).click();
		bro.driver.findElement(By.name("password")).sendKeys(randomGeneration);
		bro.driver.findElement(By.xpath("//button[@type='submit']")).click();

		bro.generateWaitThread();

		String strActualVerificationText = bro.driver
				.findElement(By.xpath("html/body/div[3]/div[2]/div/div[2]/div[2]/div[3]/form/div[1]/span")).getText();
		System.out.println("Actual Verification Text = " + strActualVerificationText);

		if (strActualVerificationText.equalsIgnoreCase(strExpectedVerifyAccount)) {
			System.out.println(
					"\n\nVerification text is displayed as expected.\nPlease complete the verification from your email id");
		} else {
			System.out.println("Verification text got changed");
		}

		bro.quitBrowser();
	}
}