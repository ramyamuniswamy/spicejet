package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.homepages;

public class t5_roundtrip extends sjb{

	@BeforeTest
	public void setup() {
		sheetname = "sheet3";
		testName = "t5_roundtrip";
		testAuthor = "Ramya";
		testDescription = "Verify the booking flow for a round trip flight on SpiceJet by entering dummy origin and destination details.";
	}
	
	@Test(dataProvider = "readData",priority = 5)
	public void roundTrip(String SLocation ,String ELoation) {
		homepages hpSJ = new homepages(driver);
		hpSJ.roundTripDetail(SLocation, ELoation);

		Assert.assertEquals(hpSJ.VerifyFlight(), "Flights");
		takeScreenshot("t5_roundtrip");

	}
}
