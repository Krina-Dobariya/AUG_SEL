package com.tesng.classCreate;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyGooglePlayStore extends BaseClass{

	@Test
	public void runVerifyGooglePlayStore() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();



		while(!(driver.findElement(By.xpath("//span[text()='Download SalesforceA']"))).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='rightScroll']")).click();
			WebElement googlePlay = driver.findElement(By.xpath("//button[@title='Google Play']"));
			Thread.sleep(3000);
			js.executeScript("arguments[0].click();", googlePlay);

			//doubt 
			//[?]
			WebElement confirm = driver.findElement(By.xpath("//button[text()='Confirm']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(confirm).click();
			//		js.executeScript("arguments[0].click();", confirm);

			String parent = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> i = allWindowHandles.iterator();
			while(i.hasNext()) {
				String child = i.next();
				driver.switchTo().window(child);
				System.out.println(driver.switchTo().window(child).getTitle());
			}
		}


	}

}
