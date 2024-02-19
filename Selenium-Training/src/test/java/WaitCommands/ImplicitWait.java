package WaitCommands;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWait {
	
	private WebDriver driver;
	private String baseUrl;
	private WebElement element;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() throws Exception {
	driver = new FirefoxDriver();
	baseUrl = "https://www.google.com";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
	
	@Test
	public void testUntitled() throws Exception {
	driver.get(baseUrl);
	element = driver.findElement(By.id("APjFqb"));
	element.sendKeys("Selenium WebDriver Interview questions");
	element.sendKeys(Keys.RETURN);
	
	
	// ??? Check the issue - I must understand why it is not printing the found elements ????
	
	//List<WebElement> list = driver.findElements(By.cssSelector("div.g:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > a:nth-child(1) > h3:nth-child(2)"));
	//System.out.println(list.size());
	/*By mySelector = By.cssSelector("div.g:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > a:nth-child(1) > h3:nth-child(2)");
	List<WebElement> myElements = driver.findElements(mySelector);
	for(WebElement e : myElements) {
	  System.out.println(e.getText());
	}*/

	}

	@AfterMethod
	public void tearDown() throws Exception {
	driver.quit();
	}
	
	
}
