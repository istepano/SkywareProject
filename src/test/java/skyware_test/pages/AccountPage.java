package skyware_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import skyware_test.utilities.BrowserUtils;

public class AccountPage {

	WebDriver driver;
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="ticketTitleRow")
	public WebElement ticketTitleRow;
	
	@FindBy(id="pendingEmptyRow")
	public WebElement pendingInventation;
	
	@FindBy(id="lastLoginDate_sort")
	public WebElement lastLoginDateField;
	
	@FindBy(id="registerDate_sort")
	public WebElement registerDateField;
	
	@FindBy(id="active_sort")
	public WebElement activeField;
	
	@FindBy(id="email_sort")
	public WebElement emailSortField;
	
	@FindBy(id="thirdtabLink")
	public WebElement categoryTab;
	
	@FindBy(id="fourthtabLink")
	public WebElement categorySubTab;
	
	@FindBy(id="newCategoryButton")
	public WebElement createNewCategory;
	
	@FindBy(id="name")
	public WebElement categoryName;
	
	@FindBy(id="saveButton")
	public WebElement save;
	
	@FindBy(id="searchTerm")
	public WebElement searchBoxCategory;
	
	@FindBy(id="nameTxt")
	public WebElement searchItem;
	
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
	
	@FindBy(id="subtabLink")
	public WebElement logoutButton;
	
	@FindBy(id="messages")
	public WebElement logoutMessage;
	
	@FindBy(id="deleteButton")
	public WebElement deleteButton;
	
	@FindBy(id="exitButton")
	public WebElement cancelButton;
	
	
//	public void edit() {
//		BrowserUtils.waitForClickablility(editButton, 30).click();
//	}
	
	public void selectFirstTab(String NameYourTab) {
		driver.findElement(By.linkText(NameYourTab)).click();
	}
	public void selectSubTab(String NameAccountSubTab) {
		driver.findElement(By.linkText(NameAccountSubTab)).click();
	}
	
}
