package skyware_test.pages;

import static org.testng.Assert.assertFalse;

import static org.testng.Assert.assertTrue;

import java.util.List;

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

	@FindBy(xpath="//select[@id='className']")
	public WebElement fieldDropDown;
	
	@FindBy(xpath="//form[@id='editCategory']")
	public WebElement categoryInfo;
	
	@FindBy(xpath="//a[@class='next']")
	public WebElement nextKey;
	
	@FindBy(xpath="//div[@class='close']")
	public WebElement close;

	@FindBy(xpath="(//a[@class='editCategoryLink triggerLoader'])[5]")
	public WebElement newCategoryName;
	
	@FindBy(xpath="//form[@id='editCustomField']")
	public WebElement editCustom;

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
	
	@FindBy(xpath="//input[@id='name']")
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
	@FindBy(xpath="//div[@class='tooltip ui-corner-all pie']")
	public WebElement vendorInfo;
	
	@FindBy(xpath="(//h2)[2]")
	public WebElement vendorInfoText;
	
	@FindBy(xpath="//ul[@id='form_actions']")
	public WebElement verifyButtonsExists;
	
	@FindBy(xpath="//li[@id='recordNo']")
	public List<WebElement> templateRows;
	
	@FindBy(xpath="//li[@id='recordNo']")
	public WebElement choose100;
	
	@FindBy(xpath="//*[@id='listingSection']/div[1]/select")
	public WebElement to100;
	
	@FindBy(xpath="//option[@value='100']")
	public WebElement hundred;
	
	@FindBy(xpath="//div[@class='close']")
	public WebElement closeButton;
	
	@FindBy(xpath="//a[@id='nextPage']")
	public WebElement  nextPage;
	
}
