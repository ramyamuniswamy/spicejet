package tests;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.sjb;
import pages.homepages;
import pages.signuppages;

public class t2_signup extends sjb {

	@BeforeTest
	public void setup() {
		sheetname = "sheet1";
		testName = "t2_signup";
		testAuthor ="Ramya";
		testDescription = "SignUp Functionality";
	}

	@Test(dataProvider = "readData",priority = 2)
	public void signupSJ(String fname, String lname, String Dob, String phoneNumber, String email, String password,
			String confirmPassord) {
		try {
			homepages hpSJ = new homepages(driver);
			hpSJ.goToSignUp();

			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();

			String parentWindow = iterator.next();
			String signUpWindow = iterator.next();

			driver.switchTo().window(signUpWindow);

			signuppages spSJ = new signuppages(driver);
			spSJ.signuoDetails(fname, lname, Dob, phoneNumber, email, password, confirmPassord);
			takeScreenshot("t2_signup");

			driver.switchTo().window(parentWindow);
		} catch (Exception e) {
			takeScreenshot("t2_signupSJfc");
			e.printStackTrace();
		}

	}

}


	
	



