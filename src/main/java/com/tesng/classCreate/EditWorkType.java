package com.tesng.classCreate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditWorkType extends BaseClass{
	
	@Test(priority=1)
	public void runEditWorkType() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement workTypes = driver.findElement(By.xpath("//a[@data-label='Work Types']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", workTypes);
		js.executeScript("arguments[0].click();", workTypes);

		//doubtsni
		wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[5]/span[1]/div[1]/a[1]/span[1]/span[1]"))));
		driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[5]/span[1]/div[1]/a[1]/span[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//span[text()='Timeframe Start']/following::input")).clear();
		driver.findElement(By.xpath("//span[text()='Timeframe Start']/following::input")).sendKeys("9");
		driver.findElement(By.xpath("//span[text()='Timeframe End']/following::input")).clear();
		driver.findElement(By.xpath("//span[text()='Timeframe End']/following::input")).sendKeys("18");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		
		
	}
}
