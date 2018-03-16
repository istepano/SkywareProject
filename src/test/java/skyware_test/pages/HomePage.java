package skyware_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import skyware_test.utilities.ConfigurationSkyware;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='button login']")
	public WebElement loginHome;

	
	public void automaticLogin() {
		HomePage homepage = new HomePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		homepage.isAt();
		homepage.loginHome.click();
		loginpage.userName.sendKeys(ConfigurationSkyware.getProporty("email"));
		loginpage.password.sendKeys(ConfigurationSkyware.getProporty("password"));
		loginpage.loginButton.click();
		
		
	}
	
	public boolean isAt() {
		return driver.getTitle().equals("Skyware Inventory | Free Web Based Inventory Tracking Software");
	}
	
	
}
