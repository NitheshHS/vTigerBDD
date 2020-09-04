package com.vTiger.stepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.vTiger.Constant.Constants;
import com.vTiger.pageObjects.LoginPage;
import com.vTiger.utility.ExtentreportListener;
import com.vTiger.utility.FileLib;
import com.vTiger.utility.ListenerIMP;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef extends ExtentreportListener {
	WebDriver driver=null;
	FileLib fLib=new FileLib();
	LoginPage loginPage=null;
	ExtentTest logInfo=null;
	@Given("^Browser is launched and login page is loaded$")
	public void browser_is_launched_and_login_page_is_loaded() throws Throwable {
		
		try {
			test=extent.createTest(Feature.class,"Login Test");
			test=test.createNode(Scenario.class, "Testing login Feature of vTiger Application");
			logInfo=test.createNode(new GherkinKeyword("Given"), "browser_is_launched_and_login_page_is_loaded");
		if(fLib.getPropertyKeyValue("browser").equals("chrome")) {
			System.setProperty(Constants.chromeDriver, Constants.chromeDriverPath);
			driver=new ChromeDriver();
		}
		else if(fLib.getPropertyKeyValue("browser").equals("firefox")) {
			System.setProperty(Constants.firefoxDriver, Constants.firefoxDriverPath);
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(fLib.getPropertyKeyValue("url"));
		//logInfo.info("Browser launched");
		//logInfo.pass("browser_is_launched_and_login_page_is_loaded");
		
		}
		catch (Exception e) {
			testStepHandler("FAIL", driver, logInfo, e,"Login");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver, "LoginFeature"));
		}
		
	}

	@When("^enter username and password and click on login button$")
	public void enter_username_and_password() throws Throwable {
		
		try {
			logInfo.createNode(new GherkinKeyword("When"), "enter_username_and_password");
			//logInfo.pass("enter username and password and click on login button");
			
	    loginPage=new LoginPage(driver);
		loginPage.login();
		}
		catch (Exception e) {
			testStepHandler("FAIL", driver, logInfo, e,"Login");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver, "enter_username_and_password"));
		}
	}



	

}
