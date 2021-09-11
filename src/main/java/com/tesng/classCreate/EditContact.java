package com.tesng.classCreate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditContact extends BaseClass{
	

	public void runEditContact() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement contacts = driver.findElement(By.xpath("//a[@data-label='Contacts']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", contacts);
		js.executeScript("arguments[0].click();", contacts);

		List<WebElement> totalContactsList = driver.findElements(By.xpath("//span[contains(@class,'slds-row-number')]"));
		int totalContacts =  totalContactsList.size();    
		System.out.println(totalContacts);
		for(WebElement contact : totalContactsList) {
			System.out.println(contact.toString());
		}

		String name = "SS Chan";
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(Keys.ENTER);
		//doubt
		driver.findElement(By.xpath("//div[@class=\"slds-th__action\"]")).click();

		//doubt ask for xpath
		driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[8]/span[1]/div[1]/a[1]/span[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[@title=\"Edit\"]")).click();
		driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("990998767");
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("Test");

		WebElement birthdate =driver.findElement(By.xpath("//label[text()='Birthdate']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", birthdate);
		driver.findElement(By.xpath("//input[@name='Birthdate']")).click();

		birthday("August","1994","5");
		driver.findElement(By.xpath("//label[text()='Lead Source']/following::div[1]")).click();
		driver.findElement(By.xpath("//span[@title='Purchased List']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		//verification
		String salutation = driver.findElement(By.xpath("//input[@name='salutation']")).getAttribute("value");
		System.out.println(salutation);
		System.out.println(name);
		Thread.sleep(2000);
		String verification = driver.findElement(By.xpath("//span[text()='Contact']")).getText();
		Thread.sleep(2000);
		System.out.println(verification);
		if(verification.equals("Contact \""+salutation+" "+name+"\" was saved.")) {
			System.out.println("Changed made successfully.");
		}else {
			System.out.println("Unable to undate contact.");
		}
		
		String phone = driver.findElement(By.xpath("//span[contains(@class,'forceOutputPhone ')]")).getText();
		System.out.println(phone);
		
		driver.quit();
		
	}
	public  void birthday(String month,String year,String date) {
		//month
		String monthNameSelected = driver.findElement(By.xpath("//button[@title='Previous Month']/following::h2")).getText();
		System.out.println(monthNameSelected);
		while(!monthNameSelected.equals(month)) {
			WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next Month']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", nextButton);
			monthNameSelected = driver.findElement(By.xpath("//button[@title='Previous Month']/following::h2")).getText();
//			System.out.println(monthNameSelected);
		}
		//year
		driver.findElement(By.xpath("//div[@class='slds-select_container']")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@class='slds-select']")));
		select.selectByValue(year);
		driver.findElement(By.xpath("//div[@class='slds-select_container']")).click();

		//date
		driver.findElement(By.xpath("//span[text()='"+date+"']")).click();
	}

}
