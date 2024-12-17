package utils;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
public class sju {
	public static WebDriver driver;
	public String sheetname;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testAuthor;
	
	public void lanchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public static String[][] readExcel(String sheetName) throws IOException {
		
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\RAMYA\\eclipse-workspace\\Spicejetproject\\excelsheet\\spicejet.xlsx");
		
		XSSFSheet sheet = book.getSheet(sheetName);	
		
		int rowCount = sheet.getLastRowNum();
		
		int columnCount = sheet.getRow(0).getLastCellNum();
	
		String[][] data = new String[rowCount][columnCount];
		
		for(int i =1 ; i <= rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j =0 ; j<columnCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				data[i-1][j] = cell.getStringCellValue();
				
			}

		}
	
		book.close();	
		return data;
}

	public void takeScreenshot(String filename) {
	    try {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File("C:\\Users\\RAMYA\\eclipse-workspace\\Spicejetproject\\screenshots\\" + filename + ".png");
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
	    } catch (IOException e) {
	        System.err.println("Error while saving screenshot: " + e.getMessage());
	    }
	}


}
