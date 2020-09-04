package com.vTiger.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentreportListener {
	
	public static ExtentHtmlReporter report=null;
	public static ExtentReports extent=null;
	public static ExtentTest test=null;
	
	public static ExtentReports setUpExtent() {
		String reportLocation="./Reports/Extent_report.html";
		report=new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("vTiger");
		report.config().setTheme(Theme.DARK);
		report.config().setReportName("Regression Test");
		report.start();
		extent = new ExtentReports();
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "vTiger");
		extent.setSystemInfo("OS", "Windows");
		return extent;
		
	}
	public static void testStepHandler(String testStatus,WebDriver driver,ExtentTest extentTest,Throwable throwable,String scenarioName) {
		switch (testStatus) {
		case "FAIL":
			extentTest.fail(MarkupHelper.createLabel("test case failed", ExtentColor.RED));
			extentTest.error(throwable.fillInStackTrace());
			
			try {
				extentTest.addScreenCaptureFromPath(captureScreenShot(driver, scenarioName));
			} catch (AssertionError|Exception e) {
				e.printStackTrace();
			}
			if(driver!=null) {
				driver.quit();
			}
			break;
		case "PASS":
			extentTest.fail(MarkupHelper.createLabel("test case Pass", ExtentColor.GREEN));
			break;
		default:
			break;
		}
	}
	
	public static String captureScreenShot(WebDriver driver,String scenario) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String filepath="H:\\new Eclipse\\vTigerBDD\\screenshot\\"+scenario+".PNG";
		File dest=new File(filepath);
		Files.copy(src, dest);
		return filepath;
		
	}

}
