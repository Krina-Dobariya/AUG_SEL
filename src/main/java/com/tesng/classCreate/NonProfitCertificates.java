package com.tesng.classCreate;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class NonProfitCertificates extends BaseClass{
	
	public void runNonProfitCertificates() throws InterruptedException {
		
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
		driver.findElement(By.xpath("//button[contains(text(),' Show filters ')]")).click();
		
		WebElement nonProfit = driver.findElement(By.id("Nonprofit"));
		
		js.executeScript("arguments[0].click();", nonProfit);
		
		List<WebElement> list = driver.findElements(By.xpath("//h2[@class='mb2 lh-title']"));
		int listSize=list.size();
		System.out.println(listSize);
		for(int i=0;i<listSize;i++) {
			if(list.get(i).isDisplayed()) {
			System.out.println(list.get(i).getText());
			}
		}
		
			if(listSize==22) {
			System.out.println("Non profit ceritfication is selected successfully");
		}else
		{
			System.out.println("Non-profit certifications is not selected");
		}
	}
	
}
