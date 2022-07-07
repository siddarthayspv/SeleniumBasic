package selenium_basic;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox {
	
	WebDriver driver;
	String url = "https://www.hyrtutorials.com/p/alertsdemo.html";
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception{
		 
		//Alert Box
		
		
		/*driver.findElement(By.id("alertBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("output")).getText());
		*/
		
		
		//ConfirmBox	
		/*driver.findElement(By.id("confirmBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("output")).getText());
		driver.findElement(By.id("confirmBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("output")).getText());*/

		//ConfirmBox
		driver.findElement(By.id("promptBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("This is Sid");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("output")).getText());
		driver.findElement(By.id("confirmBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("output")).getText());
		
	}
	
	
	
	
	@After
	public void after() {
		driver.quit();
	}

}
