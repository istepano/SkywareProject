package skyware_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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
	public WebElement searchBoxCategories;
	
	@FindBy(id="nameTxt")
	public WebElement searchItem;
	
	@FindBy(xpath="(//input[@class='editButton'])[2]")
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
	
	@FindBy(id="subtabLink")
	public WebElement logoutMessage;
	
	
	public void selectFirstTab(String NameYourTab) {
		driver.findElement(By.linkText(NameYourTab)).click();
	}
	public void selectSubTab(String NameAccountSubTab) {
		driver.findElement(By.linkText(NameAccountSubTab)).click();
	}
	
}
