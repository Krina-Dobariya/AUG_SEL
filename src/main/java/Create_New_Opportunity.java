import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_New_Opportunity {

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
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement opportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		js.executeScript("arguments[0].click();", opportunities);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Krina");
		String getName = driver.findElement(By.xpath("//input[@name='Name']")).getText();
		System.out.println(getName);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		
		//doubt
		//correct way to select
		DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		System.out.println(date);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(date);
		
		driver.findElement(By.xpath("//label[text()='Stage']/following::div[1]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		//verification left
	}

}
