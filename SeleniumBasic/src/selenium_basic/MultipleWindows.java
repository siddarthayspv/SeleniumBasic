package selenium_basic;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	
	WebDriver driver;
	String url="";
	
	@Before
	public void before() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void test() {
		
	}

	@After
	public void after() {
		
	}
}
