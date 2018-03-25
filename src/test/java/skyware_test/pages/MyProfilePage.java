package skyware_test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import skyware_test.utilities.Driver;

public class MyProfilePage {
	
	WebDriver driver;
	
	public MyProfilePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='contactSection']//input[@value='Edit']")
	public WebElement editButton;
	
	@FindBy(xpath="(//input[@class='editButton'])[2]")
	public WebElement editButtonProfile;
	
	@FindBy(xpath="//input[@id='profile_accountName']")
	public WebElement accountName;

	@FindBy(xpath="//input[@id='profile_firstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='profile_lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//select[@id='countrySelect']")
	public WebElement countrySelect;
	
	public void selectOptionByVisibleText(WebElement el,String options) {
    	Select select = new Select(el);
    	select.selectByVisibleText(options);
	}
	
	@FindBy(xpath="//input[@id='profile_address1']")
	public WebElement profileAddress;
	
	@FindBy(xpath="//input[@id='profile_city']")
	public WebElement profileCity;
	
	@FindBy(xpath="//input[@id='stateSelect']")
	public WebElement stateSelect;
	
	@FindBy(xpath="//input[@id='profile_zip']")
	public WebElement profileZip;

	@FindBy(xpath="//input[@id='profile_phone']")
	public WebElement profilePhone;
	
	@FindBy(xpath="(//input[@class='saveButton'])[2]")
	public WebElement saveButton;
	
	@FindBy(xpath="(//input[@class='cancelButton'])[2]")
	public WebElement cancelButton;
	
	@FindBy(xpath="(//span[@class='placeholder'])[4]")
	public WebElement savedFirstName;
	
	@FindBy(xpath="(//span[@class='placeholder'])[5]")
	public WebElement savedLastName;
	
	@FindBy(xpath="//span[@class='placeholder']")
	public List<WebElement> contactInfo;
	
}
