package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.homepages;
import pages.loginpages;

public class t3_login extends sjb {

	@BeforeTest
	public void setup() {
		sheetname = "sheet2";
		testName = "t3_login";
		testAuthor = "Ramya";
		testDescription = "Login Functionality";
	}

	@Test(dataProvider = "readData",priority = 3)
	public void navigateLoginDetail(String email, String psword) {
		homepages hpSJ = new homepages(driver);
		hpSJ.goToLogin();

		loginpages lpSJ = new loginpages(driver);
		lpSJ.loginDetails(email, psword);

		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot("t3_login");

	}
}

