package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(linkText="Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText="Products")
	private WebElement product;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement createProductBtn;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement userIconBtn;
	
	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logoutBtn;

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	public WebElement getProductBtn() {
		return createProductBtn;
	}

	public WebElement getUserIconBtn() {
		return userIconBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	
	
	
	
	
	
}
