import java.util.ArrayList;
import java.util.Collections;
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

import com.google.common.collect.Ordering;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Service_Sort_Order {

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
		
		List<WebElement> names = driver.findElements(By.xpath("//h2[contains(@class,'mb2 lh-title')]/div//span"));
		for(WebElement name:names) {
			System.out.println(name.getText());
		}
		List tmp = new ArrayList(names);
		boolean isSorted = tmp.equals(names);
		System.out.println(isSorted);
		
		if(isSorted) {
			System.out.println("List is sorted!!");
		}else {
			System.out.println("List is not sorted");
		}

	}
}


