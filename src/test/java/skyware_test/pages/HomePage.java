package skyware_test.pages;

import javax.management.DescriptorKey;

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
	
	@FindBy(id="inviteButton")
	public WebElement inviteNewUser;

	
	public void automaticLogin() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		homePage.loginHome.click();
		loginPage.userName.sendKeys(ConfigurationSkyware.getProporty("email"));
		loginPage.password.sendKeys(ConfigurationSkyware.getProporty("password"));
		loginPage.loginButton.click();
		
	}
	
	public boolean isAt(){
		return driver.getTitle().equals("Skyware Inventory | Free Web Based Inventory Tracking Software");
	}
	
	
}
