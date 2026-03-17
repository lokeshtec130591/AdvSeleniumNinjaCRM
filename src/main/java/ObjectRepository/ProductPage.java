package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	
	public ProductPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(name="productName")
	private WebElement prodNameTF;


	@FindBy(name="productCategory")
	private WebElement prodCategoryDropdown;
	
	
	@FindBy(name="vendorId")
	private WebElement vendorTF;
	
	@FindBy(name="quantity")
	private WebElement quantityTF;
	
	@FindBy(name="price")
	private WebElement priceTF;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	
	

	public WebElement getProdNameTF() {
		return prodNameTF;
	}

	public WebElement getProdCategoryDropdown() {
		return prodCategoryDropdown;
	}

	public WebElement getVendorTF() {
		return vendorTF;
	}

	public WebElement getQuantityTF() {
		return quantityTF;
	}

	public WebElement getPriceTF() {
		return priceTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	
	
	
}
