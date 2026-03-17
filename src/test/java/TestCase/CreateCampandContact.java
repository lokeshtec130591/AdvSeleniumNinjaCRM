package TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertiesFilesUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.javaUtility;

public class CreateCampandContact {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		PropertiesFilesUtility putil = new PropertiesFilesUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		javaUtility jutil = new javaUtility();
		WebDriverUtility webutil = new WebDriverUtility();

		String BROWSER = putil.readDataFromPropertyFile("Browser");
		String URL = putil.readDataFromPropertyFile("Url");
		String USERNAME = putil.readDataFromPropertyFile("Username");
		String PASSWORD = putil.readDataFromPropertyFile("Password");

		WebDriver driver = null;

		if (BROWSER.equals("Chrome")) {
			// popup
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		} else {
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		webutil.waitForPageToLoad(driver);
		driver.get(URL);

		// login
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		// create campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("DERCampaign");
		WebElement trgtsize = driver.findElement(By.name("targetSize"));
		trgtsize.clear();
		trgtsize.sendKeys("50");
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		String mainWindow = driver.getWindowHandle();

		// Create Contact

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("contactName")).sendKeys("LokeshContact");
		driver.findElement(By.name("organizationName")).sendKeys("testorg");
		driver.findElement(By.name("mobile")).sendKeys("9987458965");
		driver.findElement(By.name("title")).sendKeys("testtitle");

		driver.findElement(By.xpath("//div[@class='form-group']//div//button[@type='button']")).click();

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to new window
		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		driver.findElement(By.xpath("//button[text()='Select']")).click();

		driver.switchTo().window(mainWindow);

		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();

		// button[@fdprocessedid='w5vkpg']
		// div[@class='form-group']//div//button[@type='button']

	}

}
