package com.vTiger.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vTiger.Constant.Constants;

import cucumber.api.Scenario;
/**
 * 
 * @author Nithesh Gowda
 *
 */
public class ListenerIMP extends ExtentreportListener implements ITestListener {
	private static ExtentReports extent;
	

	@Override
	public void onFinish(ITestContext arg0) {
		
		extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		extent=setUpExtent();
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

}
