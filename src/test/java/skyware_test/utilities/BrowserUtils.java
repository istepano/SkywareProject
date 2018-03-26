package skyware_test.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import skyware_test.pages.AccountPage;
import skyware_test.pages.HomePage;

public class BrowserUtils {

	// private static WebDriver driver =Driver.getDriver();

	public static List<String> getElementsFromDropdown(List<WebElement> dropdown) {
		List<String> newList = new ArrayList<>();

		for (int i = 1; i < dropdown.size(); i++) {
			if (dropdown.get(i).getText().equals("Great Britain")) {
				dropdown.remove(i);
			} else {
				newList.add(dropdown.get(i).getText());
				
			}
		}
		return newList;
	}
	
	public static boolean checkIfAlphabeticalOrder(List<WebElement> alloptions) {
		List<String> listValues = new ArrayList<>();
		for(int i=1;i<alloptions.size();i++) {
			listValues.add(alloptions.get(i).getText());
		}
		ArrayList<String> sortedList= new ArrayList<>();
		sortedList.addAll(listValues);
		Collections.sort(sortedList);
		if(listValues.equals(sortedList)) {
			return true;
		}
		return false;
	}

	public static List<String> getElementsText(By locator) {
		List<WebElement> elems = Driver.getDriver().findElements(locator);
		List<String> elemTexts = new ArrayList<String>();
		for (WebElement el : elems) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickablility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForClickablility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
				.withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});
		return element;
	}

	public static void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println(
					"Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
		}
	}

	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindow(String targetTitle) {
		String origin = Driver.getDriver().getWindowHandle();
		for (String handle : Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(handle);
			if (Driver.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		Driver.getDriver().switchTo().window(origin);
	}

	public static boolean isClickable(WebElement el, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("window.scrollBy(0,550)", "");
	}

	public static void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("window.scrollBy(250,0)", "");
	}

	public static void removeCategoryABC() {
		AccountPage accountPage = new AccountPage();
		accountPage.searchBox.sendKeys("Category ABC" + Keys.ENTER);
		waitFor(5);
		if (accountPage.searchItem.getText().contains("Category ABC")) {
			accountPage.searchItem.click();
			scrollDown();
			accountPage.deleteButton.click();
		}
	}

	public static void removeVendorABC() {
		AccountPage accountPage = new AccountPage();
		accountPage.searchBox.sendKeys("Vendor ABC" + Keys.ENTER);
		waitFor(3);
		if (accountPage.searchItem.getText().contains("Vendor ABC")) {
			accountPage.searchItem.click();
			scrollDown();
			accountPage.deleteButton.click();
		}
	}

}
