package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.homepages;
public class t9_validatefield extends sjb {
	@BeforeTest
	public void setup() {
		testName = "t9_flightstatus";
		testAuthor = "Ramya";
		testDescription = "Validate the Flight Status field functionality on the SpiceJet booking page.";
	}

	@Test(dataProvider = "readData",priority = 10)
	public void checkFlightStatus(String SLocation, String ELoation)
	{
		try {
		homepages hPage = new homepages(driver);

		Assert.assertTrue(hPage.goToCheckIn(), "Check-in button is not working correctly");

		Assert.assertTrue(hPage.goToFlightStatus(), "Flight Status button is not working correctly");

		Assert.assertTrue(hPage.goToManageBooking(), "Manage Booking button is not working correctly");
		takeScreenshot("validatefield");
	} catch (Exception e) {
		takeScreenshot("validatefieldfc");
		e.printStackTrace();
	}
	}
}

		
	
