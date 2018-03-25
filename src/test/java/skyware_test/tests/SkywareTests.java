package skyware_test.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import skyware_test.pages.AccountPage;
import skyware_test.pages.HomePage;
import skyware_test.pages.LoginPage;
import skyware_test.pages.MyProfilePage;
import skyware_test.utilities.BrowserUtils;
import skyware_test.utilities.ConfigurationSkyware;
import skyware_test.utilities.TestBaseClass;

public class SkywareTests extends TestBaseClass {

	@Test(priority = 0, groups = "Smoke test")
	public void smokeTest() throws InterruptedException {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		MyProfilePage profilePage = new MyProfilePage();
		homePage.automaticLogin();
		homePage.isAt();

		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Categories");
		BrowserUtils.removeCategoryABC();
		BrowserUtils.waitFor(3);
		BrowserUtils.scrollUp();
		BrowserUtils.waitForClickablility(accountPage.createNewCategory, 5).click();
		accountPage.nameField.sendKeys("Category ABC");
		accountPage.save.click();
		accountPage.searchBox.sendKeys(Keys.ENTER);

		assertTrue(accountPage.searchItem.isDisplayed());

		accountPage.selectFirstTab("My Profile");
		BrowserUtils.scrollDown();
		profilePage.editButton.click();
		profilePage.firstName.sendKeys("Aika");
		profilePage.lastName.sendKeys("Smith");
		profilePage.saveButton.click();

		assertTrue(profilePage.savedFirstName.isDisplayed());
		assertTrue(profilePage.savedLastName.isDisplayed());

		accountPage.logoutButton.click();
		BrowserUtils.waitForPageToLoad(2);
		assertEquals("You have successfully logged out.", accountPage.logoutMessage.getText());
		BrowserUtils.waitForPageToLoad(4);

	}

	@Test(priority = 1)
	public void TC_01() {// Ilya Stepanov - 3 steps are missed
		AccountPage accountPage = new AccountPage();
		BrowserUtils browserUtils = new BrowserUtils();
		HomePage homePage = new HomePage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		browserUtils.waitFor(5);

		browserUtils.isClickable(homePage.inviteNewUser, driver);
		browserUtils.isClickable(accountPage.emailSortField, driver);
		browserUtils.isClickable(accountPage.activeField, driver);
		browserUtils.isClickable(accountPage.registerDateField, driver);
		browserUtils.isClickable(accountPage.lastLoginDateField, driver);

	}

	@Test(priority = 2)
	public void TC_02() {// by Ilya Stepanov // 2 steps are missed
		AccountPage accountPage = new AccountPage();
		HomePage homePage = new HomePage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Users");
		assertEquals(accountPage.pendingInventation.getText(), "- No Pending Users -");
		accountPage.selectSubTab("Custom Fields");
		accountPage.ticketTitleRow.isDisplayed();
		// Step 5 Why do we need save any Name under Tickets category ?
	}

@Test(priority = 3)
	public void TC_03() {
		HomePage homePage = new HomePage();
		homePage.automaticLogin();
		assertEquals(driver.getTitle(), "Skyware Inventory | Dashboard");
		assertEquals(driver.getCurrentUrl(), "https://www.skywareinventory.com/secure/dashboard");
	}

@Test(priority = 4)
	public void TC_04() {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		BrowserUtils browserUtils = new BrowserUtils();
		homePage.isAt();
		homePage.loginHome.click();
		loginPage.userName.sendKeys("BobBiba");
		loginPage.password.sendKeys(ConfigurationSkyware.getProporty("password"));
		loginPage.loginButton.click();
		loginPage.incorrectUsernameMessage.isDisplayed();
		assertEquals(loginPage.incorrectUsernameMessage.getText(), "Incorrect Username or password. Please try again.");
	}

	@Test(priority = 5)
	public void TC_05() {
		AccountPage accountPage = new AccountPage();
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		BrowserUtils browserUtils = new BrowserUtils();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("General");
		browserUtils.waitFor(3);
		List<WebElement> rowsBoxes = driver.findElements(By.xpath(("//input[@class='setting']")));
		for (int i = 0; i <= 7; i++) {
			assertTrue(rowsBoxes.get(i).isSelected());
		}
	}

	@Test(priority = 6)
	public void TC_06() {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Custom Fields");
		accountPage.createCustomFieldButton.click();
		Select transactionList = new Select(accountPage.transactionDropDown);
		transactionList.selectByValue("Adjustment");
		accountPage.customFieldName.sendKeys("Tech Ninjas");
		accountPage.saveButton1.click();

		assertTrue(accountPage.adjustmentName.isDisplayed());
	}

	@Test(priority = 7)
	public void TC_07() {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		homePage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Vendors");
		BrowserUtils.removeVendorABC();
		BrowserUtils.waitFor(3);
		BrowserUtils.scrollUp();
		BrowserUtils.waitForVisibility(accountPage.createVendorButton, 5).click();
		accountPage.nameField.sendKeys("Vendor ABC");
		accountPage.saveButton1.click();
		accountPage.searchBox.sendKeys(Keys.ENTER);
		assertTrue(accountPage.searchItem.isDisplayed());

	}
	


@Test(priority = 8)
	public void TC_08() {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		homePage.automaticLogin();
		homePage.isAt();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		assertTrue(accountPage.searchItem.isDisplayed());
		BrowserUtils.waitFor(3);

	}

	


	@Test(priority = 9) // Andy
	public void TC_09() {
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		BrowserUtils.waitFor(2);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		BrowserUtils.waitFor(2);
		accountPage.taxAuthorityButton.click();
		accountPage.createNewSalesTaxButton.click();
		accountPage.createNewSalesTaxButton.sendKeys("MD Sales Tax");
		accountPage.newSalesTaxSaveButton.click();

		BrowserUtils.waitFor(3);
		assertEquals(accountPage.mdTaxSales.getText(),"MD Sales Tax");
		String recordStr=accountPage.recordNum.getText();
		recordStr=recordStr.substring(recordStr.length()-1, recordStr.length());
		int recordNum=Integer.parseInt(recordStr);
		assertEquals(recordNum,2);
		
	}

@Test(priority = 10) // Andy
	public void TC_10() throws InterruptedException {
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		BrowserUtils.waitFor(2);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		BrowserUtils.waitFor(2);
		accountPage.taxAuthorityButton.click();
		accountPage.newSalesTaxDeleteButton.click();
		BrowserUtils.waitFor(5);
		String redStr = accountPage.redColor.getCssValue("color");
		System.out.println(redStr);
		String redColor = "rgba(145, 35, 35, 1)";
		assertEquals(redStr, redColor);

	}

	@Test(priority = 11) // Andy
	public void TC_11() {
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		BrowserUtils.waitFor(4);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Tax Authorities");
		accountPage.mDLink.click();
		accountPage.mdDeleteButton.click();

		String vaSalesTax=accountPage.vAlink.getText();
		assertEquals(vaSalesTax,"VA Sales Tax");
		BrowserUtils.waitFor(4);

		accountPage.tryCatch(accountPage.mDLink);
	}

	@Test(priority = 12) // Andy
	public void TC_12() throws InterruptedException {
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		BrowserUtils.waitFor(2);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectFirstTab("Custom Fields");
		accountPage.createCustomFieldButton.click();
		WebElement dropdown = accountPage.transactionDropDown;
		Select list = new Select(dropdown);
		list.selectByValue("Transfer");
		WebElement input = accountPage.customFieldName;
		input.click();
		input.sendKeys("Transfer Test");
		accountPage.saveButton1.click();
		assertTrue(accountPage.transferTest.isDisplayed());

	}
	@Test(priority=13)
	public void TC_13() throws InterruptedException{
		
		
		HomePage homepage = new HomePage();
		BrowserUtils browserUtils = new BrowserUtils();
		AccountPage accountPage = new AccountPage();
		MyProfilePage myProfilePage = new MyProfilePage();
		browserUtils.waitFor(4);
		homepage.automaticLogin();
		accountPage.selectFirstTab("My Profile");
		
		assertEquals(driver.getTitle(),"Skyware Inventory | My Profile");
		BrowserUtils.scrollDown();
		myProfilePage.editButton.click();
		browserUtils.waitFor(2);
		
		List<WebElement> dropdown= myProfilePage.countrySelectList;
		
		assertFalse(browserUtils.checkIfAlphabeticalOrder(dropdown));
		myProfilePage.changeCountry(6);
		assertEquals(myProfilePage.getState(),"VA");
		
		
	}
	//@Test(priority=14)
	public void TC_14() throws InterruptedException{
		
		
		HomePage homepage = new HomePage();
		BrowserUtils browserUtils = new BrowserUtils();
		AccountPage accountPage = new AccountPage();
		MyProfilePage myProfilePage = new MyProfilePage();
		homepage.automaticLogin();
		accountPage.selectFirstTab("My Profile");
	
		assertEquals(driver.getTitle(),"Skyware Inventory | My Profile");
		browserUtils.waitFor(2);
		BrowserUtils.scrollDown();
		myProfilePage.editButton.click();
		Select select = new Select(myProfilePage.country);
		select.selectByValue("United States");
		browserUtils.waitFor(2);
		myProfilePage.state.isDisplayed();
		List<WebElement> dropdownStates = myProfilePage.stateSelectList;
		assertFalse(browserUtils.checkIfAlphabeticalOrder(dropdownStates));
	
	}

	
	@Test(priority = 16) //Afsheen
	public void TC_16() throws InterruptedException {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		MyProfilePage profilePage = new MyProfilePage();
		homePage.automaticLogin();
		homePage.isAt();
		accountPage.selectFirstTab("My Profile");
		BrowserUtils.scrollDown();
		profilePage.editButtonProfile.click();
		profilePage.saveButton.click();
		profilePage.editButtonProfile.click();
		profilePage.accountName.clear();
		profilePage.accountName.sendKeys("TechNinjas");
		profilePage.firstName.clear();
		profilePage.firstName.sendKeys("Afsheen");
		profilePage.lastName.clear();
		profilePage.lastName.sendKeys("Siddiqui");
		profilePage.countrySelect.sendKeys("Pakistan");
		profilePage.selectOptionByVisibleText(profilePage.countrySelect,"Pakistan");
		profilePage.profileAddress.sendKeys("20733 Neverland");
		profilePage.profileCity.clear();
		profilePage.profileCity.sendKeys("Karachi");
		profilePage.stateSelect.clear();
		profilePage.stateSelect.sendKeys("Sindh");
		profilePage.profileZip.clear();
		profilePage.profileZip.sendKeys("75950");
		profilePage.profilePhone.sendKeys("7387434344");
		profilePage.cancelButton.click();
		List<WebElement>contactinfo=profilePage.contactInfo;
		String contactInfoString = "";
		for(WebElement i : contactinfo) {
			contactInfoString+=i.getText()+" ";
		}
		System.out.println(contactInfoString);
		
	}
//		assertTrue(profilePage.savedFirstName.isDisplayed());
//		assertTrue(profilePage.savedLastName.isDisplayed());
//
//		BrowserUtils.waitForPageToLoad(2);
//		assertEquals("You have successfully logged out.", accountPage.logoutMessage.getText());
//		BrowserUtils.waitForPageToLoad(4);
	

	
	@Test(priority = 17) //Afsheen
	public void TC_17() throws InterruptedException {
		HomePage homePage = new HomePage();
		AccountPage accountPage = new AccountPage();
		MyProfilePage profilePage = new MyProfilePage();
		homePage.automaticLogin();
		homePage.isAt();
		accountPage.selectFirstTab("My Profile");
		BrowserUtils.scrollDown();
		profilePage.editButton.click();
		profilePage.saveButton.click();
	
		
		accountPage.selectFirstTab("Account");
		accountPage.selectSubTab("Categories");
//		BrowserUtils.removeCategoryABC();
//		BrowserUtils.waitFor(3);
//		BrowserUtils.scrollUp();
//		BrowserUtils.waitForClickablility(accountPage.createNewCategory, 5).click();
//		accountPage.nameField.sendKeys("Category ABC");
//		accountPage.save.click();
//		accountPage.searchBox.sendKeys(Keys.ENTER);

	
	
	}
	
	


	@Test(priority = 19)
	public void TC_19() throws InterruptedException {
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BrowserUtils.waitFor(4);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectFirstTab("Vendors");
		accountPage.createVendorButton.click();
		String vendorInfo = driver.findElement(By.xpath("(//h2)[2]")).getText();
		assertEquals(vendorInfo, "Vendor Info");
		assertTrue(accountPage.deleteButton.isDisplayed());
		assertTrue(accountPage.cancelButton.isDisplayed());
		assertTrue(accountPage.saveButton1.isDisplayed());
		// accountPage.customFieldName.sendKeys("Cybert");

		WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
		inputBox.click();
		inputBox.sendKeys("Name");
		driver.findElement(By.id("saveButton")).click();
		try {
			assertTrue(driver.findElement(By.linkText("Name")).isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(false);
		}
	}

	@Test(priority = 20)
	public void TC_20() throws InterruptedException {
		HomePage homepage = new HomePage();
		AccountPage accountPage = new AccountPage();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BrowserUtils.waitFor(4);
		homepage.automaticLogin();
		accountPage.selectFirstTab("Account");
		accountPage.selectFirstTab("Categories");

		List<WebElement> records = driver.findElements(By.xpath((" //tr[@id='templateRow']")));
		for (WebElement record : records) {

		}
		assertTrue(records.size() > 0);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BrowserUtils.waitFor(4);

		accountPage.selectFirstTab("Custom Fields");
		accountPage.selectFirstTab("Vendors");

		accountPage.choose100.click();
		BrowserUtils.waitFor(3);
		accountPage.to100.click();
		BrowserUtils.waitFor(3);
		accountPage.hundred.click();
		BrowserUtils.waitFor(3);

		String fullRecordsText = driver.findElement(By.xpath("//li[@id='recordNo']")).getText();
		String[] recordsArr = fullRecordsText.split(" ");

		int totalNumberOnNavigation = Integer.parseInt(recordsArr[recordsArr.length - 1]); // Records: 31 - 36 of 36
		int totalNumberFromPages = 0;
		int beforeOf = 0;
		BrowserUtils.waitFor(3);

		System.out.println("totalNumberOnNavigation : " + totalNumberOnNavigation);

		do {
			fullRecordsText = driver.findElement(By.xpath("//li[@id='recordNo']")).getText();
			recordsArr = fullRecordsText.split(" ");

			beforeOf = Integer.parseInt(recordsArr[3]);
			System.out.println("Before of: " + beforeOf);
			List<WebElement> vendorRecords = driver.findElements(By.xpath(("//tr[@id='templateRow']")));
			totalNumberFromPages += vendorRecords.size();

			accountPage.nextPage.click();

		} while (beforeOf != totalNumberOnNavigation);

		System.out.println(totalNumberFromPages + "-" + totalNumberOnNavigation);
		assertEquals(totalNumberFromPages, totalNumberOnNavigation);
		BrowserUtils.waitFor(3);

		System.out.println("Compare here");
		accountPage.selectFirstTab("Vendors");
		BrowserUtils.waitFor(3);
		accountPage.createVendorButton.click();
		accountPage.customFieldName.sendKeys("Cyberteks");
		BrowserUtils.waitFor(3);
		accountPage.saveButton1.click();
		accountPage.closeButton.click();

		String[] recordsArr2 = fullRecordsText.split(" ");
		totalNumberFromPages = 0;
		beforeOf = 0;

		System.out.println("totalNumberOnNavigation : " + totalNumberOnNavigation);

		do {
			fullRecordsText = driver.findElement(By.xpath("//li[@id='recordNo']")).getText();
			recordsArr = fullRecordsText.split(" ");

			beforeOf = Integer.parseInt(recordsArr2[3]);
			System.out.println("Before of: " + beforeOf);
			List<WebElement> vendorRecords = driver.findElements(By.xpath(("//tr[@id='templateRow']")));
			BrowserUtils.waitFor(3);
			totalNumberFromPages += vendorRecords.size();

			// accountPage.nextPage.click();

		} while (beforeOf != totalNumberOnNavigation);

		System.out.println(totalNumberFromPages + "-" + totalNumberOnNavigation);
		assertEquals(totalNumberFromPages, totalNumberOnNavigation);
	}


}
