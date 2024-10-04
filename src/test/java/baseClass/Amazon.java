package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ItemPage;
import pages.Purchase;
import utils.BrowserSetup;
import utils.Utils;

public class Amazon extends BrowserSetup{
	
	//For debugging and slowing down to see execution
	@AfterMethod
	public void debug() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void home() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.gethomepage();
		hp.validateHomepage();
		hp.searchItem("Nothing");
	}
	
	@Test(priority=2, dependsOnMethods= {"home"})
	public void item() {
		ItemPage ip = new ItemPage(driver);
		ip.selectItem();
		ip.windowhandling();
	}
	
	@Test(priority=3, dependsOnMethods={"item"})
	public void cart() throws InterruptedException, IOException {
		Purchase buy = new Purchase(driver);
		buy.addToCart();
		buy.payment(); 
	}
}
