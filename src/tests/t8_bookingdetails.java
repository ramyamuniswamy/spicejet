package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.FlightBookingPages;
import pages.homepages;

public class t8_bookingdetails extends sjb{

	@BeforeTest
	public void setup() {
		sheetname = "sheet3";
		testName = "t8_bookingdetails";
		testAuthor = "Ramya";
		testDescription = "Fills out the booking form payment details using dummy data.";
	}
	
	@Test(dataProvider = "readData",priority = 8)
	public void bookingDetails(String SLocation ,String ELoation) {
		homepages hpSJ = new homepages(driver);
		hpSJ.oneWayTrip(SLocation, ELoation);

		FlightBookingPages fbsj = new FlightBookingPages(driver);
		fbsj.goToBooking();
		
		fbsj.bookingDetail("Ramya", "munis", "9080528795", "muniswamyramya@gmail.com");
		fbsj.PaymentMethods();
		fbsj.cardNumber("4111111111111111");
		fbsj.cardName("Ramya");
		fbsj.expiryMonth("12");
		fbsj.expiryYear("2030");
		fbsj.secureCode("458");
		takeScreenshot("t8_bookingdetails");
	}
}
