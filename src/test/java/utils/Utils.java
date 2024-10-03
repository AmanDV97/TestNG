package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	public static WebDriver driver;
	public static String url = "https://www.amazon.in/ref=nav_logo";
	public static int count = 0;
	
	public Utils(WebDriver driver){
		this.driver = driver;
	}
	
	public static void ss() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String sspath = System.getProperty("user.dir");
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dsn = new File(sspath+"//SS//ss"+count+".png");
		FileUtils.copyFile(src, dsn);
	}
	
}

