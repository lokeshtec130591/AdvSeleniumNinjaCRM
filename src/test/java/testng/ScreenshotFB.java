package testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenshotFB {

	@Test
	public void fbScreenshot() throws IOException {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		Date date = new Date();
		String newDate = date.toString().replace(" ", "_").replace(":","_");

		
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./ScreenShots/SS_"+newDate+".png");
		org.openqa.selenium.io.FileHandler.copy(temp,perm);
		
		
	}

}
