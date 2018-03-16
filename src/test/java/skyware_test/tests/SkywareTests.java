package skyware_test.tests;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import skyware_test.pages.DashBoardPage;
import skyware_test.pages.HomePage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass{
	

	//@Test(priority=1) //Asma this is a smoke test 
	public void test() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		Thread.sleep(6000);
		homepage.loginHome.click();
	}
	@Test
	public void TC_01() {//Not a smoke test
		HomePage homepage = new HomePage(driver);
		BrowserUtils browserUtils = new BrowserUtils();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		homepage.automaticLogin();
		dashBoardPage.tabElements("Account");
		dashBoardPage.AcountSubTab("Users");
		browserUtils.isClickable(homepage.inviteNewUser, driver);
		
		
	 
		browserUtils.waitFor(5);
		
		
	}
}
