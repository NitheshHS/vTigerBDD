package sausceLabs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExceution {
	WebDriver driver;
//	@Parameters({"platform","browserName","browserVersion"})
//	@BeforeMethod
//	public void configBM(String platform,String browserName,String BrowserVersion) throws MalformedURLException {
//		DesiredCapabilities cap=new DesiredCapabilities();
//		cap.setCapability("platform", platform);;
//		cap.setBrowserName(browserName);
//		cap.setVersion(BrowserVersion);
//		cap.setCapability("name", "My first cross platform test");
//		
//		 driver=new RemoteWebDriver(new URL("https://NitheshHS:5133f7c1-5674-4aab-9f74-a4a20d421043@ondemand.us-west-1.saucelabs.com:443/wd/hub"), 
//				cap);
//	}
	@Test(dataProvider="environment variables")
	public void exceuteTest(Platform platform,String browserName,String BrowserVersion) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platform", platform);;
		cap.setBrowserName(browserName);
		cap.setVersion(BrowserVersion);
		cap.setCapability("name", "Cross browser");
		cap.setCapability("extendedDebugging", true);
		cap.setCapability("capturePerformance", true);
		 driver=new RemoteWebDriver(new URL("https://NitheshHS:5133f7c1-5674-4aab-9f74-a4a20d421043@ondemand.us-west-1.saucelabs.com:443/wd/hub"), 
				cap);
		driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("Facebook");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	}
	
	@DataProvider(name="environment variables", parallel=true)
	public Object[][] readData(){
		Object[][] testdata=new Object[][] {
			{Platform.WIN10,"chrome","81"},
			{Platform.WIN8,"chrome","80"},
			{Platform.WIN8,"chrome","85"},
			{Platform.SIERRA,"chrome","80"}
		};
		return testdata;
	}
//	<?xml version="1.0" encoding="UTF-8"?>
//	<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
//	<suite name="Suite">
//	  <test thread-count="5" name="Test">
//	  <parameter name="platform" value="Windows"/>
//	  <parameter name="browserName" value="chrome"/>
//	  <parameter name="browserVersion" value="81"/> 
//	    <classes>
//	      <class name="sausceLabs.ParallelExceution"/>
//	    </classes>
//	  </test> <!-- Test -->
//	</suite> <!-- Suite -->
}
