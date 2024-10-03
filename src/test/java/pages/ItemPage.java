package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
	WebDriver driver;
	
	public ItemPage(WebDriver driver){
		this.driver=driver;
	}
	
	//Locator
	By Firstitem = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
	
	public void selectItem() {
		driver.findElement(Firstitem).click();
	}
	
	public void windowhandling() {
		ArrayList<String> window = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(window.get(0)).close();;
		driver.switchTo().window(window.get(1));
		
	}
}
