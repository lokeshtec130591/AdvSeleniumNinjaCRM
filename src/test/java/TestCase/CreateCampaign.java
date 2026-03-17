package TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		//WebDriver driver = new ChromeDriver();
		
		PropertiesFilesUtility putil= new PropertiesFilesUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		javaUtility jutil = new javaUtility();
		WebDriverUtility webutil = new WebDriverUtility();
		
		
		String BROWSER = putil.readDataFromPropertyFile("Browser");
		String URL = putil.readDataFromPropertyFile("Url");
		String USERNAME = putil.readDataFromPropertyFile("Username");
		String PASSWORD = putil.readDataFromPropertyFile("Password");

		
		WebDriver driver = null;
		
		if(BROWSER.equals("Chrome"))
		{
			//popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		driver= new ChromeDriver(settings);
		}
		else {
			driver = new FirefoxDriver();
			
		}
		
		
		
		driver.manage().window().maximize();
		webutil.waitForPageToLoad(driver);
		driver.get(URL);
		
		//login
		LoginPage lp = new LoginPage(driver);
		
		lp.getUsername().sendKeys(USERNAME);
		lp.getPassword().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		
		// excel utility 
		String campname = eutil.readDataFromExcel("Campaign", 1, 2);
		String size = eutil.readDataFromExcel("Campaign", 1, 3);
		
		
		//create campaign
		
		HomePage hp = new HomePage(driver);
		CampaignPage cp = new CampaignPage(driver);
		
		hp.getCreateCampaignBtn().click();
		cp.getCampaignName().sendKeys(campname);
		WebElement trgtsize = cp.getTargetSize();
		trgtsize.clear();
		trgtsize.sendKeys(size);
		
		cp.getCampaignBtn().click();
		
		Thread.sleep(3000);
		
		
		//validate
		WebElement toastmsg = cp.getToastmsg();
				
		webutil.waitForVisibilityOfElement(driver, toastmsg);
		
		String msg = toastmsg.getText();
		
		if(msg.contains(campname))
		{
			System.out.println("Campaign created");
		}
		else
		{
			System.out.println("Not Campaign Created");
		}
		
		
		
		//Homepage Usericon dropdown 
		WebElement usericon = hp.getUserIconBtn();
				
		Actions act = new Actions(driver);
		act.moveToElement(usericon).click().perform();
		
		//logout
		WebElement logout = hp.getLogoutBtn();
		act.moveToElement(logout).click().perform();
		
		Thread.sleep(3000);

		
		driver.close();

		
	}

}
