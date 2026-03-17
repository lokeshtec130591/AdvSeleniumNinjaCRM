package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public CampaignPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(name="campaignName")
	private WebElement campaignName;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expCloseDate;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement campaignBtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastmsg;

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpCloseDate() {
		return expCloseDate;
	}

	public WebElement getCampaignBtn() {
		return campaignBtn;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}
	
	
	
	
	
	
}
