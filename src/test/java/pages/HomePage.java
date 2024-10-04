package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import utils.Utils;

public class HomePage {
	WebDriver driver;
	FileInputStream fin;
	Properties pr;
	
	public HomePage(WebDriver driver){ 
		this.driver = driver;
	}
	
	//Locators
	By SerachBox = By.id("twotabsearchtextbox");
	By Search = By.id("nav-search-submit-button");
	
	public void gethomepage() throws IOException {
		String url = System.getProperty("user.dir");
		fin = new FileInputStream(url+"//src//test//java//resources//Urls.properties");
		pr = new Properties();
		pr.load(fin);
		driver.get(pr.getProperty("Amazon_Url"));
		driver.manage().window().maximize();
	}
	
	public void validateHomepage() throws IOException {
		String pageTitle = driver.getTitle();
		String pageString = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		SoftAssert sa = new SoftAssert();
		try{
			sa.assertEquals(pageTitle, pageString);
		}
		catch(Exception e) {
			System.out.println(e);
			Utils.ss();
		}
	}
	
	public void searchItem(String item) {
		driver.findElement(SerachBox).sendKeys(item);
		driver.findElement(Search).click();
	}
}
