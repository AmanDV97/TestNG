package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utils;

public class Purchase {
	WebDriver driver;
	WebDriverWait wait;

	public Purchase(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	By addToCart = By.xpath("(//input[@title='Add to Shopping Cart'])[2]");
	By addedToCart = By.xpath("(//h4[text()=\"Added to Cart\"])[2]");
	By accessory = By.xpath("(//span[text()='    Add to Cart   '])[1]/ancestor::span[@class='a-declarative']");
	By messagePop = By.xpath("(//span[text()=' Added to Cart '])[4]");
	By checkout = By.xpath("//input[@class='a-button-input']/ancestor::span[@id='attach-sidesheet-checkout-button']");
	By email = By.xpath("//label[@for='ap_email']");
	
	public void addToCart() throws InterruptedException {
		driver.findElement(addToCart).click();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(addedToCart));
		
		//adding accessory
		Thread.sleep(3000);
		driver.findElement(accessory).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(accessory));
	}
	
	public void payment() throws IOException {
		driver.findElement(checkout).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(email));
		Utils.ss();
	}
}
