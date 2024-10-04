package utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import baseClass.Amazon;

public class BrowserSetup {
	FileInputStream fin;
	public WebDriver driver;
	
	public String getBrowserInfo() throws IOException {
		String BrowserPath = System.getProperty("user.dir");
		try {
			fin = new FileInputStream(BrowserPath+"//src//test//java//resources//Browser.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties pr = new Properties();
		pr.load(fin);
		System.out.println(pr.getProperty("Browser"));
		return pr.getProperty("Browser");
	}
	
	@BeforeClass
	public void BrowserSetup() throws Exception {
		String value = getBrowserInfo();
		if(value.equalsIgnoreCase("Chrome")) {
			String sysdir = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", sysdir+"//Driver//chromedriver.exe");
			driver = new ChromeDriver();
			Utils ut = new Utils(driver);
		}
		else if(value.equalsIgnoreCase("Edge")) {
			String sysdir = System.getProperty("user.dir");
			System.setProperty("webdriver.edge.driver", sysdir+"//Driver//chromedriver.exe");
			driver = new EdgeDriver();
			Utils ut = new Utils(driver);
		}
		else if(value.equalsIgnoreCase("FireFox")) {
			String sysdir = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", sysdir+"//Driver//chromedriver.exe");
			driver = new FirefoxDriver();
			Utils ut = new Utils(driver);
		}
		else {
			throw new Exception("Wrong browser");
		}
	} 
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(1500);
		driver.quit();
	}
}
