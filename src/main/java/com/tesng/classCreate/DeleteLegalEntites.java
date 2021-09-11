package com.tesng.classCreate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLegalEntites extends BaseClass{

	@Test(priority=2,enabled=false)
	public void runDeleteLegalEntities() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement legalEntity = driver.findElement(By.xpath("//p[contains(text(),'Legal Entities')]"));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", legalEntity);
		js.executeScript("arguments[0].click();", legalEntity);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-refid='recordId']"))));
		String name = driver.findElement(By.xpath("//a[@data-refid='recordId']")).getText();
		System.out.println(name);
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class=\"slds-th__action\"]")).click();

		//doubt
		driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[5]/span[1]/div[1]/a[1]/span[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		//doubt
		//how to verify
		String verify = driver.findElement(By.xpath("//span[text()='Legal Entity \"']")).getText();
		System.out.println(verify);



		if(verify.equals("Legal Entity \""+name+"\" was deleted. Undo")){
			System.out.println("Successfully deleted the Legal Entity");
		}else {
			System.out.println("Unable to delete");
		}
		/*driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).clear();
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys(Keys.ENTER);
		Boolean entityIsDisplayed = driver.findElement(By.xpath("//span[text()='No items to display']")).isDisplayed();
		System.out.println(entityIsDisplayed);
		 */



	}

}
