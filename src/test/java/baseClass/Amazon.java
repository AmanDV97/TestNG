package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ItemPage;
import utils.Utils;

public class Amazon {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		String sysdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", sysdir+"//Driver//chromedriver.exe");
		driver = new ChromeDriver();
		Utils ut = new Utils(driver);
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(1500);
		driver.quit();
	}
	
	@Test(priority=1)
	public void home() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.gethomepage();
		hp.searchItem("Nothing");
	}
	
	@Test(priority=2)
	public void item() {
		ItemPage ip = new ItemPage(driver);
		ip.selectItem();
		ip.windowhandling();
	}
}
