package skyware_test.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import skyware_test.pages.AccountPage;
import skyware_test.pages.HomePage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass{
	

	@Test (priority=1) //Asma this is a smoke test 
	public void smokeTest() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		AccountPage accountPage = new AccountPage(driver);
		homePage.automaticLogin();
		homePage.isAt();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Categories");
		BrowserUtils.removeCategoryABC();
		BrowserUtils.waitForClickablility(accountPage.createNewCategory, 3).click();
		accountPage.categoryName.sendKeys("Category ABC");
		accountPage.save.click();
		accountPage.searchBoxCategory.sendKeys("Category ABC"+Keys.ENTER);
		
		assertTrue(accountPage.searchItem.isDisplayed());
		accountPage.cancelButton.click();
		// 
		accountPage.selectFirstTab("My Profile");
		BrowserUtils.scroll();
		accountPage.editButton.click();
		accountPage.firstName.sendKeys("Aika");
		accountPage.lastName.sendKeys("Smith");
		accountPage.saveButton.click();
		
		assertTrue(accountPage.savedFirstName.isDisplayed());
		assertTrue(accountPage.savedLastName.isDisplayed());
		
		accountPage.logoutButton.click();
		
		assertEquals("You have successfully logged out.", accountPage.logoutMessage.getText());

	}
	
	//@Test 
	public void TC_01() {//Not a smoke test
		BrowserUtils browserUtils = new BrowserUtils();
		AccountPage accountPage = new AccountPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		browserUtils.waitFor(5);
		
		
	}
}
