package testng;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {

	
	@Test
	public void login() {
		
	String expResult= "Facebook";
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	String actualResult = driver.getTitle();
	Assert.assertEquals(expResult, actualResult);
			
	
	}
	
	
}
