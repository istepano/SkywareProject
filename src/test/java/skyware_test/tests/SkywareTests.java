package skyware_test.tests;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import skyware_test.pages.AccountPage;
import skyware_test.pages.HomePage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass{
	
	
	


	//@Test
	public void TC_01(){//Ilya Stepanov
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
	
	
	
	
}
