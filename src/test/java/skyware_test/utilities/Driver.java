package skyware_test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		
		if (driver == null|| ((RemoteWebDriver) driver).getSessionId() == null){  
			
			switch (ConfigurationSkyware.getProporty("browser")) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			default:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null || ((RemoteWebDriver) driver).getSessionId() == null) {
			driver.quit();
			driver = null;
		}
	}
}
