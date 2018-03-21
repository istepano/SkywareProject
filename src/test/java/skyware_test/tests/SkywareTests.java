package skyware_test.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import skyware_test.pages.AccountPage;
import skyware_test.pages.HomePage;
import skyware_test.pages.LoginPage;
import skyware_test.pages.MyProfilePage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.ConfigurationSkyware;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass{
	


	@Test (priority=0, groups="Smoke test") 
		public void smokeTest() throws InterruptedException {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		MyProfilePage profilePage=new MyProfilePage();
		homePage.automaticLogin();
		homePage.isAt();
		
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Categories");
		BrowserUtils.removeCategoryABC();
		BrowserUtils.waitFor(3);
		BrowserUtils.scrollUp();
		BrowserUtils.waitForClickablility(accountPage.createNewCategory, 5).click();
		accountPage.nameField.sendKeys("Category ABC");
		accountPage.save.click();
		accountPage.searchBox.sendKeys(Keys.ENTER);
		
		assertTrue(accountPage.searchItem.isDisplayed());

		accountPage.selectFirstTab("My Profile");
		BrowserUtils.scrollDown();
		profilePage.editButton.click();
		profilePage.firstName.sendKeys("Aika");
		profilePage.lastName.sendKeys("Smith");
		profilePage.saveButton.click();
		
		assertTrue(profilePage.savedFirstName.isDisplayed());
		assertTrue(profilePage.savedLastName.isDisplayed());
		
		accountPage.logoutButton.click();
		BrowserUtils.waitForPageToLoad(2);
		assertEquals("You have successfully logged out.", accountPage.logoutMessage.getText());
		BrowserUtils.waitForPageToLoad(4);

	}
	
	@Test(priority=1)
	public void TC_01(){//Ilya Stepanov - 3 steps are missed
		AccountPage accountPage = new AccountPage();
		BrowserUtils browserUtils=new BrowserUtils();
		HomePage homePage = new HomePage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		browserUtils.waitFor(5);
		

		browserUtils.isClickable(homePage.inviteNewUser, driver);	
		browserUtils.isClickable(accountPage.emailSortField, driver);
		browserUtils.isClickable(accountPage.activeField, driver);
		browserUtils.isClickable(accountPage.registerDateField, driver);
		browserUtils.isClickable(accountPage.lastLoginDateField, driver);

	}
	
	@Test(priority=2)
	public void TC_02() {//by Ilya Stepanov // 2 steps are missed 
		AccountPage accountPage = new AccountPage();
		HomePage homePage = new HomePage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		assertEquals(accountPage.pendingInventation.getText(),"- No Pending Users -");
		accountPage.selectSubTab("Custom Fields");
		accountPage.ticketTitleRow.isDisplayed();
		//Step 5 Why do we need save any Name under Tickets category ?	
	}
	
	@Test(priority=3)
	public void TC_03() {
		HomePage homePage = new HomePage();
		homePage.automaticLogin();
		assertEquals(driver.getTitle(), "Skyware Inventory | Dashboard");
		assertEquals(driver.getCurrentUrl(), "https://www.skywareinventory.com/secure/dashboard");
	}
	
	@Test(priority=4)
	public void TC_04() {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		BrowserUtils browserUtils = new BrowserUtils();
		homePage.isAt();
		homePage.loginHome.click();
		loginPage.userName.sendKeys("BobBiba");
		loginPage.password.sendKeys(ConfigurationSkyware.getProporty("password"));
		loginPage.loginButton.click();
		loginPage.incorrectUsernameMessage.isDisplayed();
		assertEquals(loginPage.incorrectUsernameMessage.getText(), "Incorrect Username or password. Please try again.");	
	}
	


	@Test(priority=5)
	public void TC_05() {
		AccountPage accountPage = new AccountPage();
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		BrowserUtils browserUtils = new BrowserUtils();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("General");
		browserUtils.waitFor(3);
		List<WebElement> rowsBoxes=driver.findElements(By.xpath(("//input[@class='setting']")));
		for(int i=0;i<=7;i++) {
			assertTrue(rowsBoxes.get(i).isSelected());
		}	
	}
	


	@Test(priority=6)
	public void TC_06() {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Custom Fields");
		accountPage.createCustomFieldButton.click();
		Select transactionList=new Select(accountPage.transactionDropDown);
		transactionList.selectByValue("Adjustment");
		accountPage.customFieldName.sendKeys("Tech Ninjas");
		accountPage.saveButton1.click();
		
		assertTrue(accountPage.adjustmentName.isDisplayed());
	}
	


	@Test(priority=7)
	public void TC_07() {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Vendors");
		BrowserUtils.removeVendorABC();
		BrowserUtils.waitFor(3);
		BrowserUtils.scrollUp();
		BrowserUtils.waitForVisibility(accountPage.createVendorButton, 5).click();
		accountPage.nameField.sendKeys("Vendor ABC");
		accountPage.saveButton1.click();
		accountPage.searchBox.sendKeys(Keys.ENTER);
		assertTrue(accountPage.searchItem.isDisplayed());

	}
	
	@Test (priority=8)
	public void TC_08() {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		homePage.automaticLogin();
		homePage.isAt();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		assertTrue(accountPage.searchItem.isDisplayed());
		BrowserUtils.waitFor(3);

		
	}
	
	@Test(priority=9)//Andy 
	public void TC_09(){
		BrowserUtils browserUtils = new BrowserUtils();
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		browserUtils.waitFor(2);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		browserUtils.waitFor(2);
		accountPage.taxAuthorityButton.click();
		accountPage.createNewSalesTaxButton.click();
		accountPage.createNewSalesTaxButton.sendKeys("MD Sales Tax");
		accountPage.newSalesTaxSaveButton.click();
		browserUtils.waitFor(3);
		assertEquals(accountPage.mdTaxSales.getText(),"MD Sales Tax");
		String recordStr=accountPage.recordNum.getText();
		recordStr=recordStr.substring(recordStr.length()-1, recordStr.length());
		int recordNum=Integer.parseInt(recordStr);
		assertEquals(recordNum,2);
		
	}
	@Test(priority=10)//Andy 
	public void TC_10() throws InterruptedException{
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		BrowserUtils.waitFor(2);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		BrowserUtils.waitFor(2);
		accountPage.taxAuthorityButton.click();
		accountPage.newSalesTaxDeleteButton.click();
		BrowserUtils.waitFor(5);
		String redStr=accountPage.redColor.getCssValue("color");
		System.out.println(redStr);
		String redColor="rgba(145, 35, 35, 1)";
		assertEquals(redStr,redColor);
		
		
	}
	@Test(priority=11)//Andy 
	public void TC_11(){
		HomePage homepage = new HomePage();
		BrowserUtils browserUtils = new BrowserUtils();
		AccountPage accountPage = new AccountPage();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		browserUtils.waitFor(4);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		accountPage.mDLink.click();
		accountPage.mdDeleteButton.click();
		String vaSalesTax=accountPage.vAlink.getText();
		assertEquals(vaSalesTax,"VA Sales Tax");
		browserUtils.waitFor(4);
		accountPage.tryCatch(accountPage.mDLink);
	}
	@Test(priority=12)//Andy 
	public void TC_12() throws InterruptedException{
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BrowserUtils.waitFor(2);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectFirstTab("Custom Fields");
		accountPage.createCustomFieldButton.click();
		WebElement dropdown=accountPage.transactionDropDown;
		Select list=new Select(dropdown);
		list.selectByValue("Transfer");
		WebElement input=accountPage.customFieldName;
		input.click();
		input.sendKeys("Transfer Test");
		accountPage.saveButton1.click();
		assertTrue(accountPage.transferTest.isDisplayed());
		
		
		
		
	}
	
	
	
}
