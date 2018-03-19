package skyware_test.utilities;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBaseClass {
	

	protected WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		driver=Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(ConfigurationSkyware.getProporty("url"));
		
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
