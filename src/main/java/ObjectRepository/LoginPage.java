package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginBtn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	
	
	
	
	
}
