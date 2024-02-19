package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class CrossBrowserTest {
	
	WebDriver driver;
	FirefoxOptions firefoxoptions = new FirefoxOptions();
	ChromeOptions chromeoptions = new ChromeOptions();
	EdgeOptions edgeoptions = new EdgeOptions();
	
	@Parameters("browser")
	@BeforeTest
	
	public void initialize(String browser)
	{
		
		if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox is launched");
			
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome is launched");
			
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge is launched");
			
		}
	}
	@Test
	
	public void scotiabanklogin() {
		
		driver.get("https://mooninjapan.wixsite.com/moonjapan");
		String actual = driver.getTitle();
		String expect = "Opportunity Consult";
		Assert.assertEquals(actual.contains("Opportunity Consult"), expect.contains("Opportunity Consult"));
		
	}
	@AfterTest
	public void endTest() {
		
		driver.quit();
	}
	
	
}
