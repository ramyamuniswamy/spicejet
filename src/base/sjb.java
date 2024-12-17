package base;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.sju;
public class sjb extends sju {
	@BeforeSuite
	public void reportInitilization() {
		String path = "C:\\Users\\RAMYA\\eclipse-workspace\\Spicejetproject\\reports\\SpiceJetReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("SpiceJet Report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);

	}

	@BeforeTest
	public void browserLanch() {
		lanchBrowser();
	}

	@DataProvider(name = "readData")
	public String[][] readData() throws IOException {
		String[][] data = readExcel(sheetname);
		return data;
	}

	@AfterTest
	public void browserClose() {
		closeBrowser();
	}

	@AfterSuite
	public void reportClose() {
		extent.flush();

	}
}
