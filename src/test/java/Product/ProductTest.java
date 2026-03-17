package Product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BastTest.BaseClass;
import GenericUtilities.ExcelFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;

public class ProductTest extends BaseClass{

	
	@Test
	public void createProduct() throws Throwable {
		
		ExcelFileUtility eutil = new ExcelFileUtility();
		
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
		
			}
	
}
