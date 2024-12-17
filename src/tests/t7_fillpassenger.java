package tests;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.FlightBookingPages;
import pages.homepages;

public class t7_fillpassenger extends sjb{

	@BeforeTest
	public void setup() {
		sheetname = "sheet3";
		testName = "t7_fillpassenger";
		testAuthor = "Ramya";
		testDescription = "Fills out the booking form with passenger and payment details using dummy data.";
	}
	
	@Test(dataProvider = "readData",priority = 7)
	public void bookingForm(String SLocation ,String ELoation) {
		homepages hpSJ = new homepages(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);

		FlightBookingPages fbSJ = new FlightBookingPages(driver);
		fbSJ.goToBooking();
		fbSJ.bookingDetail("Ramya", "munis", "9080528795", "muniswamyramya@gmail.com");
		takeScreenshot("t7_fillpassenger");
		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);

	}
}

