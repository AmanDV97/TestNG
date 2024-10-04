package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelExecutionEx {
	
	public WebDriver driver;
	
	@BeforeClass()
	public void browserSetup() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"//Driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void setup() {
		driver.get("https://www.google.com");
	}
	
	@AfterClass()
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
