package com.tesng.classCreate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceSortOrder extends BaseClass{
	
	@Test()
	public void runServiceSortOrder() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		while(!(driver.findElement(By.xpath("//span[contains(text(),'See System Status')]")).isDisplayed()) ){
			driver.findElement(By.xpath("//div[@class='rightScroll']")).click();
		}
		Thread.sleep(2000);
		//ask for this... need good xpath
		 WebElement getStarted = driver.findElement(By.xpath("(//span[contains(text(),': System Status')]/preceding-sibling::span[contains(text(),'Get Started')])[2]"));
		 js.executeScript("arguments[0].click();", getStarted);
		 
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> iterate = s.iterator();
		while(iterate.hasNext()) {
			String child = iterate.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
			}
		}
		
		driver.findElement(By.id("dropdown-button")).click();
		driver.findElement(By.xpath("//a[contains(@href,'compliance.salesforce.com')]")).click();
		
		List<WebElement> names = driver.findElements(By.xpath("//h2[contains(@class,'mb2 lh-title')]/div//span"));
		for(WebElement name:names) {
			System.out.println(name.getText());
		}
		List tmp = new ArrayList(names);
		boolean isSorted = tmp.equals(names);
		System.out.println(isSorted);
		
		if(isSorted) {
			System.out.println("List is sorted!!");
		}else {
			System.out.println("List is not sorted");
		}

	}

}
