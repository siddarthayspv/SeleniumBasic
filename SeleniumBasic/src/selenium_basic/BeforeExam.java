package selenium_basic;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeforeExam {
	
	WebDriver driver;
	String url = "https://www.hyrtutorials.com/p/basic-controls.html";
	
	@Before
	public void before() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.get(url);		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys("Vivek");
		Thread.sleep(3000);
		driver.findElement(By.id("lastName")).sendKeys("Rambo");
		Thread.sleep(3000);
		driver.findElement(By.id("malerb")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("englishchbx")).click();
		Thread.sleep(3000);
		WebElement hindiChk = driver.findElement(By.id("hindichbx"));
		hindiChk.click();
		Thread.sleep(3000);
		if(hindiChk.isSelected()) {
			hindiChk.click();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("registerbtn")).click();
		System.out.println(driver.findElement(By.id("msg")).getText());
		Thread.sleep(3000);
		driver.findElement(By.linkText("Click here to navigate to the home page")).click();
		
		
	}

	@After
	public void after() {
		driver.quit();
	}
}
