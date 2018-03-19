package skyware_test.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import skyware_test.pages.AccountPage;
import skyware_test.pages.HomePage;
import skyware_test.pages.LoginPage;
import skyware_test.pages.MyProfilePage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.ConfigurationSkyware;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass{
	


	@Test (priority=1, groups="Smoke test") 
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
		
		assertEquals("You have successfully logged out.", accountPage.logoutMessage.getText());

	}
	
	//@Test
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
	
	//@Test
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
	
	//@Test
	public void TC_03() {
		HomePage homePage = new HomePage();
		homePage.automaticLogin();
		assertEquals(driver.getTitle(), "Skyware Inventory | Dashboard");
		assertEquals(driver.getCurrentUrl(), "https://www.skywareinventory.com/secure/dashboard");
	}
	
	//@Test
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
	
//	@Test
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
	
//	@Test
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
	
//	@Test
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
	
//	@Test 
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
	
}
