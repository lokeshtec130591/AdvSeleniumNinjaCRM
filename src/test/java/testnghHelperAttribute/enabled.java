package testnghHelperAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class enabled {

	@Test
	public void browser() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);

		driver.quit();
	}
	
	@Test(enabled = false)
public void sub() {
		
		Reporter.log("Sub",true);
	}
	
}
