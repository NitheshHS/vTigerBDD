package com.vTiger.runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
import com.vTiger.utility.ListenerIMP;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features="Feature",
glue="com.vTiger.stepDef",
tags= {"@UAT"},
plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
dryRun=false,
monochrome=true)
@Listeners(com.vTiger.utility.ListenerIMP.class)
public class Runner extends ListenerIMP{
	public TestNGCucumberRunner testrun;

	@BeforeClass(alwaysRun=true)
	public void setUp() {
		testrun=new TestNGCucumberRunner(this.getClass());
	}
	@Test(dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testrun.runCucumber(cucumberFeature.getCucumberFeature());
	}


	@DataProvider
	public Object[][] features() {
		return testrun.provideFeatures();		
	}
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		Reporter.loadXMLConfig(new File("H:\\new Eclipse\\vTigerBDD\\XML\\Extent-config.xml"));
	     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.5.2");
		testrun.finish();
	}


}
