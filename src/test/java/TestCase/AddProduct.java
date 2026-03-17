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
import org.openqa.selenium.support.ui.Select;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertiesFilesUtility;
import GenericUtilities.WebDriverUtility;
import GenericUtilities.javaUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;

public class AddProduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		
		
		PropertiesFilesUtility putil= new PropertiesFilesUtility();
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

		//FileInputStream fis1 = new FileInputStream("C:/Users/Owner/Downloads/TestScriptData.xls");

		//Workbook wb = WorkbookFactory.create(fis1);
	//	Sheet sh = wb.getSheet("Product");
		//String prodname = sh.getRow(1).getCell(2).getStringCellValue();
		//String totalQuantity = sh.getRow(1).getCell(3).getStringCellValue();
		//String eachPrice = sh.getRow(1).getCell(4).getStringCellValue();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		//login
				LoginPage lp = new LoginPage(driver);
				
				lp.getUsername().sendKeys(USERNAME);
				lp.getPassword().sendKeys(PASSWORD);
				lp.getLoginBtn().click();
				
		// excel utility	
				
				String prodname = eutil.readDataFromExcel("Product", 1, 2);
				String totalQuantity = eutil.readDataFromExcel("Product", 1, 3);
				String eachPrice = eutil.readDataFromExcel("Product", 1, 4);

				
				HomePage hp = new HomePage(driver);
				ProductPage pp = new ProductPage(driver);
				
		// add product
				
				hp.getProduct().click();
				hp.getProductBtn().click();
				pp.getProdNameTF().sendKeys(prodname);

				WebElement category = pp.getProdCategoryDropdown();
				Select sel = new Select(category);
				sel.selectByVisibleText("Furniture");

				WebElement vendor =pp.getVendorTF();
				Select sel1 = new Select(vendor);
				sel1.selectByVisibleText("Vendor_51110 - (Electronics)");

				WebElement quantity = pp.getQuantityTF();
				quantity.clear();
				quantity.sendKeys(totalQuantity);

				WebElement price = pp.getPriceTF();
				price.clear();
				price.sendKeys(eachPrice);

				Thread.sleep(2000);

				pp.getSubmitBtn().click();

				Thread.sleep(2000);

		//Homepage Usericon dropdown 
				WebElement usericon = hp.getUserIconBtn();
						
				Actions act = new Actions(driver);
				act.moveToElement(usericon).click().perform();
				
		//logout
				WebElement logout = hp.getLogoutBtn();
				act.moveToElement(logout).click().perform();

	}

}
