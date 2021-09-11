import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Accounts {

	public static void main(String[] args) throws InterruptedException {
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
		WebElement account = driver.findElement(By.xpath("//a[@title='Accounts']"));
		js.executeScript("arguments[0].click();", account);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Krina");
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
		driver.quit();
	}
	

}
