package skyware_test.pages;

import static org.testng.Assert.assertFalse;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import skyware_test.utilities.Driver;

public class AccountPage {

	WebDriver driver;
	
	public AccountPage() {
		this.driver = Driver.getDriver();
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
	
	@FindBy(id="newTaxAuthorityButton")
	public WebElement taxAuthorityButton;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement createNewSalesTaxButton;
	
	@FindBy(id="saveButton")
	public WebElement newSalesTaxSaveButton;
	

	@FindBy(xpath="(//a[@id='nameTxt'])[1]")
	public WebElement mdTaxSales;
	
	@FindBy(id="recordNo")
	public WebElement recordNum;
	
	@FindBy(id="deleteButton")
	public WebElement newSalesTaxDeleteButton;
	
	@FindBy(xpath="//div[@class='ui-tooltip-content']")
	public WebElement redColor;
	
	@FindBy(linkText="MD Sales Tax")
	public WebElement mDLink;
	
	@FindBy(xpath="//ul//input[@class='delete']")
	public WebElement mdDeleteButton;
	
	@FindBy(linkText="VA Sales Tax")
	public WebElement vAlink;
	
	@FindBy(linkText="Transfer Test")
	public WebElement transferTest;
	
	
	

	public void tryCatch(WebElement element) {
		try {
			assertFalse(element.isDisplayed());
		}catch(NoSuchElementException e) {
			assertTrue(true);
		}
			
	}
	
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
