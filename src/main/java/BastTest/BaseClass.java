package BastTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import GenericUtilities.PropertiesFilesUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;    // This is used only for Listener
	public PropertiesFilesUtility putil = new PropertiesFilesUtility();
	public WebDriverUtility webutil = new WebDriverUtility();

	@BeforeSuite
	public void beforeSuite() {

		Reporter.log("DB Open", true);
	}

	// @Parameters("BROWSER")
	@BeforeClass
	public void beforeClass() throws Throwable {

		//String BROWSER = putil.readDataFromPropertyFile("Browser");
		
		String BROWSER = System.getProperty("Browser");

		if (BROWSER.equals("Chrome")) {
			// popup
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
			sdriver=driver;
		} else {
			driver = new FirefoxDriver();
			sdriver=driver;
		}
		Reporter.log("Launch Browser", true);

	}

	@BeforeMethod
	public void beforeMethod() throws Throwable {

		String URL = putil.readDataFromPropertyFile("Url");
		String USERNAME = putil.readDataFromPropertyFile("Username");
		String PASSWORD = putil.readDataFromPropertyFile("Password");

		driver.manage().window().maximize();
		webutil.waitForPageToLoad(driver);
		driver.get(URL);

		// login
		LoginPage lp = new LoginPage(driver);

		lp.getUsername().sendKeys(USERNAME);
		lp.getPassword().sendKeys(PASSWORD);
		lp.getLoginBtn().click();

		Reporter.log("Login Application", true);
	}

	@AfterMethod
	public void afterMethod() {
		HomePage hp = new HomePage(driver);

		// Homepage Usericon dropdown
		WebElement usericon = hp.getUserIconBtn();

		Actions act = new Actions(driver);
		act.moveToElement(usericon).click().perform();

		// logout
		WebElement logout = hp.getLogoutBtn();
		act.moveToElement(logout).click().perform();

		Reporter.log("Logout Application", true);

	}

	@AfterClass
	public void afterClass() {

		driver.close();
		Reporter.log("Close Browser", true);

	}

	@AfterSuite
	public void afterSuite() {

		Reporter.log("DB Close", true);

	}

}
