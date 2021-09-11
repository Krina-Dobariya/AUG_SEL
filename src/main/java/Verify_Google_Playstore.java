import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Google_Playstore {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys(" SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();



		while(!(driver.findElement(By.xpath("//span[text()='Download SalesforceA']"))).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='rightScroll']")).click();
			WebElement googlePlay = driver.findElement(By.xpath("//button[@title='Google Play']"));
			Thread.sleep(3000);
			js.executeScript("arguments[0].click();", googlePlay);

			//doubt 
			//[?]
			WebElement confirm = driver.findElement(By.xpath("//button[text()='Confirm']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(confirm).click();
			//		js.executeScript("arguments[0].click();", confirm);

			String parent = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> i = allWindowHandles.iterator();
			while(i.hasNext()) {
				String child = i.next();
				driver.switchTo().window(child);
				System.out.println(driver.switchTo().window(child).getTitle());
			}
		}

	}

}
