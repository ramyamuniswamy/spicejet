package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.homepages;

public class t4_onewaytrip extends sjb{

	@BeforeTest
	public void setup() {
		sheetname = "sheet3";
		testName = "t4_onewaytrip";
		testAuthor = "Ramya";
		testDescription = "Validate the booking process for a one-way flight on SpiceJet by entering dummy origin and destination information.";
	}
	
	@Test(dataProvider = "readData",priority = 4)
	public void oneWaytrip(String SLocation ,String ELoation) {
		homepages hpSJ = new homepages(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);
		
		Assert.assertEquals(hpSJ.VerifyFlight(),"Flights");
		
		takeScreenshot("t4_onewaytrip");
	}
}
