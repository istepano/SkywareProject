package skyware_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import skyware_test.utilities.Driver;

public class MyProfilePage {
	
	WebDriver driver;
	
	public MyProfilePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='contactSection']//input[@value='Edit']")
	public WebElement editButton;
	
	@FindBy(id="profile_firstName")
	public WebElement firstName;
	
	@FindBy(id="profile_lastName")
	public WebElement lastName;
	
	@FindBy(xpath="(//input[@class='saveButton'])[2]")
	public WebElement saveButton;
	
	@FindBy(xpath="(//span[@class='placeholder'])[4]")
	public WebElement savedFirstName;
	
	@FindBy(xpath="(//span[@class='placeholder'])[5]")
	public WebElement savedLastName;

}
