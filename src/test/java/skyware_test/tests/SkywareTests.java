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
	
	AccountPage accountPage = new AccountPage(driver);
	HomePage homepage = new HomePage(driver);
	

	//@Test(priority=1) //Asma this is a smoke test 
	public void test() throws InterruptedException {
		homepage.loginHome.click();
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Categories");
		
		
	}
	@Test
	public void TC_01() {//Not a smoke test
		BrowserUtils browserUtils = new BrowserUtils();
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		
	 
		browserUtils.waitFor(5);
		
		
	}
}
