package com.vTiger.stepDef;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.listener.Reporter;
import com.vTiger.Constant.Constants;
import com.vTiger.utility.FileLib;
import com.vTiger.utility.WebdriverUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/**
 * 
 * @author Nithesh Gowda
 *
 */
public class Hooks {
	public WebDriver driver;
	public static WebDriver staticDriver;
	public FileLib flib=new FileLib();
	public WebdriverUtils wLib=new WebdriverUtils();
	@Before
	public void configBefore() throws Throwable {

		if (flib.getPropertyKeyValue("browser").equals("chrome")) {
			System.setProperty(Constants.chromeDriver, Constants.chromeDriverPath);
			driver=new ChromeDriver();
		}
		else if (flib.getPropertyKeyValue("browser").equals("firefox")) {
			System.setProperty(Constants.firefoxDriver, Constants.firefoxDriverPath);
			driver=new FirefoxDriver();
		}
		staticDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(flib.getPropertyKeyValue("url"));
	}

	@After(order=1)
	public void afterScenario(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String imagepath = wLib.getScreenshot(driver, scenario);
			Reporter.addScreenCaptureFromPath(imagepath);
		}
	}

	@After(order=0)
	public void configAfter() {
		driver.close();
	}
}
