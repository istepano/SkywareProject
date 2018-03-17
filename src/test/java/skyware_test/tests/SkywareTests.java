package skyware_test.tests;





import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import skyware_test.pages.AccountPage;
import skyware_test.pages.HomePage;
import skyware_test.pages.LoginPage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.ConfigurationSkyware;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass{
	
	
	


	//@Test
	public void TC_01(){//Ilya Stepanov - 3 steps are missed
		AccountPage accountPage = new AccountPage(driver);
		HomePage homepage = new HomePage(driver);
		BrowserUtils browserUtils = new BrowserUtils();
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		browserUtils.isClickable(homepage.inviteNewUser, driver);	
		browserUtils.isClickable(accountPage.emailSortField, driver);
		browserUtils.isClickable(accountPage.activeField, driver);
		browserUtils.isClickable(accountPage.registerDateField, driver);
		browserUtils.isClickable(accountPage.lastLoginDateField, driver);
	}
	//@Test
	public void TC_02() {//by Ilya Stepanov // 2 steps are missed 
		AccountPage accountPage = new AccountPage(driver);
		HomePage homepage = new HomePage(driver);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		assertEquals(accountPage.pendingInventation.getText(),"- No Pending Users -");
		accountPage.selectSubTab("Custom Fields");
		accountPage.ticketTitleRow.isDisplayed();
		//Step 5 Why do we need save any Name under Tickets category ?	
	}
	//@Test
	public void TC_03() {
		HomePage homepage = new HomePage(driver);
		homepage.automaticLogin();
		assertEquals(driver.getTitle(), "Skyware Inventory | Dashboard");
		assertEquals(driver.getCurrentUrl(), "https://www.skywareinventory.com/secure/dashboard");
	}
	//@Test
	public void TC_04() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		BrowserUtils browserUtils = new BrowserUtils();
		homepage.isAt();
		homepage.loginHome.click();
		loginPage.userName.sendKeys("BobBiba");
		loginPage.password.sendKeys(ConfigurationSkyware.getProporty("password"));
		loginPage.loginButton.click();
		loginPage.incorrectUsernameMessage.isDisplayed();
		assertEquals(loginPage.incorrectUsernameMessage.getText(), "Incorrect Username or password. Please try again.");	
	}
	@Test
	public void TC_05() {
		AccountPage accountPage = new AccountPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		BrowserUtils browserUtils = new BrowserUtils();
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("General");
		browserUtils.waitFor(3);
		List<WebElement> rowsBoxes=driver.findElements(By.xpath(("//input[@class='setting']")));
		for(int i=0;i<=7;i++) {
			assertTrue(rowsBoxes.get(i).isSelected());
		}	
	}
	
	
	
	
	
}
