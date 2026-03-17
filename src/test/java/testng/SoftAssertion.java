package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	
	@Test
	public void login2() {
		
	String expResult= "Facebook";
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	String actualResult = driver.getTitle();

	SoftAssert soft = new SoftAssert();
	soft.assertEquals(expResult, actualResult);
	System.out.println("Next line");
	soft.assertAll();
	
	
	}
}
