package skyware_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement loginButton;
	
	
	
	
	
	
}
