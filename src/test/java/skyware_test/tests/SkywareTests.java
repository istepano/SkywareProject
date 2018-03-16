package skyware_test.tests;



import org.testng.annotations.Test;

import skyware_test.pages.HomePage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass{
	

//	@Test(priority=1)
//	public void test() throws InterruptedException {
//		HomePage homepage = new HomePage(driver);
//		Thread.sleep(6000);
//		homepage.loginHome.click();
//	}
	@Test
	public void TC_01() {
		HomePage homepage = new HomePage(driver);
		BrowserUtils browserUtils = new BrowserUtils();
		homepage.automaticLogin();	
		browserUtils.waitFor(5);
		
		
	}
}
