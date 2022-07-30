package selenium_basic;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	WebDriver driver;
	String url = "https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html";
	
	@Before
	public void before() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver.exe");		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();	
		driver.get(url);				
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() throws InterruptedException {
		
		WebElement ideElement = driver.findElement(By.id("ide"));
		Select ideDropdown = new Select(ideElement);
		
		List<WebElement> ideDropdownOptions = ideDropdown.getOptions();
		
		for(WebElement option: ideDropdownOptions) {
			System.out.println(option.getText());
		}
		
		
		ideDropdown.selectByValue("ij");
		Thread.sleep(3000);
		ideDropdown.selectByVisibleText("NetBeans");
		Thread.sleep(3000);
		
		ideDropdown.deselectByVisibleText("IntelliJ IDEA");
		
		List<WebElement> text = ideDropdown.getAllSelectedOptions();
		for(WebElement option: text) {
			System.out.println("Seleted Visible Text is -"+option.getText());
		}
		
		
		
	}

	@After
	public void after() {
		driver.quit();
	}
}
