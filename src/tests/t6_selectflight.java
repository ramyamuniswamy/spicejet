package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.FlightBookingPages;
import pages.homepages;

public class t6_selectflight extends sjb {

	@BeforeTest
	public void setup() {
		sheetname = "sheet3";
		testName = "t6_selectflight";
		testAuthor = "Ramya";
		testDescription = "This test selects a flight from the available options and navigates to the booking page.";
	}
	
	@Test(dataProvider = "readData",priority = 6)
	public void selectFlight(String SLocation ,String ELoation) {
	homepages hpSJ = new homepages(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);

		FlightBookingPages fbSJ = new FlightBookingPages(driver);
		fbSJ.goToBooking();
		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot("t6_selectflight");
		
	}
}

	

