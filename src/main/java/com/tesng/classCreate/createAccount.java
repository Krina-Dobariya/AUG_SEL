package com.tesng.classCreate;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createAccount extends BaseClass{
	
	@Test(dependsOnMethods= {"com.tesng.classCreate.EditWorkType.runEditWorkType"},invocationCount=3)
	public void runcreateAccount() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement account = driver.findElement(By.xpath("//a[@title='Accounts']"));
		js.executeScript("arguments[0].click();", account);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Krina Testing2");
		String getName = driver.findElement(By.xpath("//input[@name='Name']")).getAttribute("value");
		System.out.println(getName);
		driver.findElement(By.xpath("//label[text()='Ownership']/following::div")).click();
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		//doubt
		//verification
		Thread.sleep(3000);
		String verify = driver.findElement(By.xpath("//span[text()='Account']")).getText();
	
		if(verify.equals("Account \""+getName+"\" was created.")) {
			System.out.println("Account created successfully");
		}else {
			System.out.println("Unable to create account");
		}
		String accountName = driver.findElement(By.xpath("//span[text()='"+getName+"']")).getText();
		System.out.println(accountName);
	
	
	}
}
