import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.grpc.Context.Key;

public class Delete_Legal_Entity {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys(" SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement legalEntity = driver.findElement(By.xpath("//p[contains(text(),'Legal Entities')]"));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", legalEntity);
		js.executeScript("arguments[0].click();", legalEntity);
		String name = "Sathya1";
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
		
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys(Keys.ENTER);
		Boolean entityIsDisplayed = driver.findElement(By.xpath("//span[text()='No items to display']")).isDisplayed();
		System.out.println(entityIsDisplayed);
		
		driver.quit();
		

	}

}
