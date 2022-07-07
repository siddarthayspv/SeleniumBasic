package selenium_basic;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigating {
	
	WebDriver driver;
	String url="https://www.google.com/";
	
	@Before
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void test() throws Exception {
		driver.findElement(By.name("q")).sendKeys("Love me like you do");
		driver.findElement(By.name("q")).submit();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		
	}

	@After
	public void after() {
		driver.quit();
	}
	
	
}
