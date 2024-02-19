package WaitCommands;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fluentwait {
	
	
	// created reference variable for WebDriver
		WebDriver driver;

		@SuppressWarnings("deprecation")
		@BeforeMethod
		public void setup() throws InterruptedException {

		// initializing driver variable using FirefoxDriver
		driver=new FirefoxDriver();
		// launching gmail.com on the browser
		driver.get("https://gmail.com");
		// maximized the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@Test
		public void test() throws InterruptedException {
		// saving the GUI element reference into a "element" variable of WebElement type
		WebElement element = driver.findElement(By.id("Email"));
		// entering username
		element.sendKeys("dummy@gmail.com");
		element.sendKeys(Keys.RETURN);
		// entering password
		driver.findElement(By.id("Passwd")).sendKeys("password");
		// clicking signin button
		driver.findElement(By.id("signIn")).click();
		// fluent wait - to wait for the compose button to be click-able
		
		//Declare and initialise a fluent wait
		@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class);

		
		
		
		}

		@AfterMethod
		public void teardown() {
		// closes all the browser windows opened by web driver
		driver.quit();
		}
}
		
