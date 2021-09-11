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

public class Create_Order {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys(" SelBootcamp$123");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		Thread.sleep(1000);
		//		driver.findElement(By.xpath("//div[contains(@class,'navexAppNavMenu')]")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		Thread.sleep(2000);
		WebElement newButtton = driver.findElement(By.xpath("//div[@title='New']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", newButtton);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Search Contracts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Search Contracts']")).sendKeys("00000105");
		Thread.sleep(2000);
		
		/*
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).sendKeys("Testleaf Software");
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//div[text()='Testleaf Software']")).click();
 */
//		js.executeScript("arguments[0].click();", testLeaf);


		driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
		selectDayMonthYear("MAY","2017","15");



		//span
				driver.findElement(By.xpath("//a[text()='Draft']")).click();
				driver.findElement(By.xpath("//button[@title='Save']")).click();

		//driver.findElement(By.xpath("//a[@title='Orders']")).click();



	}

	public static void selectDayMonthYear(String month,String year,String day) {
		//handling calender
		//year
		driver.findElement(By.xpath("//select[@class='slds-select picklist__label']")).click();
		WebElement yearElement = driver.findElement(By.xpath("//select[@class='slds-select picklist__label']"));
		Select select = new Select(yearElement);
		select.selectByValue(year);
		System.out.println(year);


		//month

		String monthElement = driver.findElement(By.xpath("//h2[@class='monthYear']")).getText();
		System.out.println(monthElement);
		while(!(monthElement.equals(month))) {
			driver.findElement(By.xpath("//a[@title='Go to next month']")).click();
			monthElement = driver.findElement(By.xpath("//h2[@class='monthYear']")).getText();
			System.out.println(monthElement);
		}
		//date

		driver.findElement(By.xpath("//span[text()='"+day+"']")).click();


	}

}
