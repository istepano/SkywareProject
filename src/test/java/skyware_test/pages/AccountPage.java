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
	public WebElement nameField;
	
	@FindBy(id="saveButton")
	public WebElement save;
	
	@FindBy(id="searchTerm")
	public WebElement searchBox;
	
	@FindBy(id="nameTxt")
	public WebElement searchItem;
	
	@FindBy(id="subtabLink")
	public WebElement logoutButton;
	
	@FindBy(id="messages")
	public WebElement logoutMessage;
	
	@FindBy(id="deleteButton")
	public WebElement deleteButton;
	
	@FindBy(id="exitButton")
	public WebElement cancelButton;
	 
	@FindBy(id="newCustomFieldButton")
	public WebElement createCustomFieldButton;
	
	@FindBy(id="transactionType")
	public WebElement transactionDropDown;
	
	@FindBy(id="name")
	public WebElement customFieldName;
	
	@FindBy(id="saveButton")
	public WebElement saveButton1;
	
	@FindBy(id="adjustmentNameTxt")
	public WebElement adjustmentName;
	
	@FindBy(id="newVendorButton")
	public WebElement createVendorButton;
	
	
//	public void edit() {
//		BrowserUtils.waitForClickablility(editButton, 30).click();
//	}	//github.com/istepano/SkywareProject.git
	
	public void selectFirstTab(String NameYourTab) {
		driver.findElement(By.linkText(NameYourTab)).click();
	}
	public void selectSubTab(String NameAccountSubTab) {
		driver.findElement(By.linkText(NameAccountSubTab)).click();
	}
	
}
