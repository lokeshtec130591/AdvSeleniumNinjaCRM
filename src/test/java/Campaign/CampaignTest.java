package Campaign;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BastTest.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.javaUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;

@Listeners(ListenerUtility.ListenerImplementation.class)
public class CampaignTest extends BaseClass {

	@Test(priority =0)
	public void CreteCampaignOnlyTest() throws Throwable {
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		
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
		
		
		Assert.assertTrue(msg.contains(campname));
		
		Thread.sleep(3000);

		
	}
	
	
	@Test(priority =1)
	public void CreateCampaignwithStatus() throws Throwable {
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		
		// excel utility
				String campname = eutil.readDataFromExcel("Campaign", 4, 2);
				String size = eutil.readDataFromExcel("Campaign", 4, 3);
				String status = eutil.readDataFromExcel("Campaign", 4, 4);

				// create campaign
				HomePage hp = new HomePage(driver);
				CampaignPage cp = new CampaignPage(driver);

				hp.getCreateCampaignBtn().click();
				cp.getCampaignName().sendKeys(campname);
				cp.getCampaignStatus().sendKeys(status);
				WebElement trgtsize = cp.getTargetSize();
				trgtsize.clear();
				trgtsize.sendKeys(size);
				cp.getCampaignBtn().click();

				// validate
				WebElement toastmsg = cp.getToastmsg();
				webutil.waitForVisibilityOfElement(driver, toastmsg);

				String msg = toastmsg.getText();

				Assert.assertTrue(msg.contains(campname));

				Thread.sleep(3000);

		
		
	}
	
	
	
	
	@Test(priority =2)
	public void CreateCampaignwithExpDateTest() throws Throwable {
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		javaUtility jutil = new javaUtility();
		String datereq = jutil.getExpDate();

		// randodm

		// Random random = new Random();
		// int count = random.nextInt(500);

		// excel utility
		String campname = eutil.readDataFromExcel("Campaign", 7, 2);
		String size = eutil.readDataFromExcel("Campaign", 7, 3);
		String status = eutil.readDataFromExcel("Campaign", 7, 4);

//create campaign

		HomePage hp = new HomePage(driver);
		CampaignPage cp = new CampaignPage(driver);

		hp.getCreateCampaignBtn().click();
		cp.getCampaignName().sendKeys(campname);
		cp.getCampaignStatus().sendKeys(status);
		cp.getExpCloseDate().sendKeys(datereq);

		WebElement trgtsize = cp.getTargetSize();
		trgtsize.clear();
		trgtsize.sendKeys(size);

		cp.getCampaignBtn().click();

//validate Campaign
		WebElement toastmsg = cp.getToastmsg();
		webutil.waitForVisibilityOfElement(driver, toastmsg);

		String msg = toastmsg.getText();

		Assert.assertTrue(msg.contains(campname));

		Thread.sleep(3000);

		
	}
	
	
	
}
