package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
public class t1_navigatetospicejet extends sjb {

	@BeforeTest
	public void setup() {
		testName = "t1_navigatetospicejet ";
		testAuthor = "Ramya";
		testDescription = "Navigating to the SpiceJet e-commerce website";
	}
	@Test(priority = 1)
	public void navigateToWebSite() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot("t1_navigatetospicejet");
	}
}
