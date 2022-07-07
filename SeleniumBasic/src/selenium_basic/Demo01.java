package selenium_basic;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;

public class Demo01 {
	
	WebDriver driver;
	String url = "https://www.primevideo.com/ref=av_flex";
	
	

	@Before
	public void before() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");
		
		driver = new ChromeDriver(); 
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	//C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe
	@Test
	public void test() throws InterruptedException {
		
		driver.findElement(By.className("dv-overlay")).click();
		Thread.sleep(3000);
		System.out.println("First click");
		driver.findElement(By.id("ap_email")).sendKeys("yspvsiddartha@gmail.com");
		System.out.println("Second click");
		driver.findElement(By.id("ap_password")).sendKeys("Cactus@123");
		System.out.println("Entered password");
		/*if(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div/h4") != null){
			System.out.println("Incorrect password");	
			driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Cactus@123");
			System.out.println("Entered another password");
		}*/
				
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("profiles-dropdown-name")).click();
		System.out.println("Clicked on profile drop down");
		Thread.sleep(3000);
		
		String actualMessage = driver.findElement(By.xpath("//*[@id=\"pv-nav-sign-out\"]")).getText();
		System.out.println(actualMessage);
		String expectedMessage = "Not Siddharth? Sign Out";
		Assert.assertEquals(expectedMessage, actualMessage);
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of opened windows: " + windowHandles.size());
		
		Integer temp=0;
		
		String msg=null;
		
		for (String string : windowHandles) {
			driver.switchTo().window(string);
			String title = driver.getTitle();
			if (!title.equals("Prime Video")) {
				temp = 1;
				msg="Window found.";
				break;
			} else {
				temp = 0;
			}
		}
		
		if (temp == 1) {
			
			System.out.println(msg);
			
			WebElement WebPagename = driver.findElement(By.xpath("//*[@id=\"pv-nav\"]"));
			System.out.println(WebPagename.getText()+" OTT");
		}
		else if (temp == 0) {
			System.out.println("Desired Window not found.");
		}
	
		
		
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/label")).click();
		//driver.findElement(By.id("pv-nav-sign-out")).click();
		
		System.out.println("Clicked sign out");
		
		/*driver.findElement(By.id("email")).sendKeys("alwaysbestinmyownway@gmail.com");
		System.out.println("In Username");
		driver.findElement(By.id("pass")).sendKeys("Robertdeniro@123");
		System.out.println("In password");
		driver.findElement(By.id("u_0_h_rf")).click();
		driver.findElement(By.className("s45kfl79 emlxlaya bkmhp75w spb7xbtv i09qtzwb n7fi1qx3 b5wmifdl hzruof5a pmk7jnqg j9ispegn kr520xx4 c5ndavph art1omkt ot9fgl3s rnr61an3")).click();
		String pageTitle=driver.getTitle();
		System.out.println("pageTitle"+pageTitle);
		driver.findElement(By.className("n00je7tq arfg74bv qs9ysxi8 k77z8yql i09qtzwb n7fi1qx3 b5wmifdl hzruof5a pmk7jnqg j9ispegn kr520xx4 c5ndavph art1omkt ot9fgl3s rnr61an3")).click();

		*/
		
	
	}

	@After
	public void after() {
		driver.close();
	}

	
}

