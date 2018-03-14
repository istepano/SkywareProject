package skyware_test.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBaseClass {
	
	protected WebDriver driver;
	
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigurationSkyware.getProporty("url"));
	}
	@AfterMethod
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();;
	}
}
