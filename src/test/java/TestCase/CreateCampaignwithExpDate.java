package TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertiesFilesUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.javaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateCampaignwithExpDate {

	public static void main(String[] args) throws InterruptedException, Throwable {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

//login
		LoginPage lp = new LoginPage(driver);

		lp.getUsername().sendKeys(USERNAME);
		lp.getPassword().sendKeys(PASSWORD);
		lp.getLoginBtn().click();

		// jutil.getExpDate("30");

		// date picker
		String datereq = jutil.getExpDate();

		// randodm

		// Random random = new Random();
		// int count = random.nextInt(500);

		// excel utility
		String campname = eutil.readDataFromExcel("Campaign", 1, 2);
		String size = eutil.readDataFromExcel("Campaign", 1, 3);
		String status = eutil.readDataFromExcel("Campaign", 1, 4);

//create campaign

		HomePage hp = new HomePage(driver);
		CampaignPage cp = new CampaignPage(driver);

		hp.getCreateCampaignBtn().click();
		cp.getCampaignName().sendKeys(campname);
		cp.getCampaignStatus().sendKeys(status);
		cp.getExpCloseDate().sendKeys(datereq);
		Thread.sleep(5000);

		WebElement trgtsize = cp.getTargetSize();
		trgtsize.clear();
		trgtsize.sendKeys(size);

		cp.getCampaignBtn().click();

//validate Campaign
		WebElement toastmsg = cp.getToastmsg();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();

		if (msg.contains(campname)) {
			System.out.println("Campaign created");
		} else {
			System.out.println("Not Campaign Created");
		}

		Thread.sleep(2000);

		// Homepage Usericon dropdown
		WebElement usericon = hp.getUserIconBtn();

		Actions act = new Actions(driver);
		act.moveToElement(usericon).click().perform();

		// logout
		WebElement logout = hp.getLogoutBtn();
		act.moveToElement(logout).click().perform();

		driver.close();

	}

}
