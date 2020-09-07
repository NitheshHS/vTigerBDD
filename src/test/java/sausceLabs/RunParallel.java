package sausceLabs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RunParallel {
	WebDriver driver;
	@Parameters({"platform","browserName","browserVersion"})
	@BeforeClass
	public void configBC(String platform,String browserName,String browserVersion) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platform", platform);
		cap.setBrowserName(browserName);
		cap.setVersion(browserVersion);
		cap.setCapability("name", "My first Test");
		
		driver=new RemoteWebDriver(new URL("https://NitheshHS:5133f7c1-5674-4aab-9f74-a4a20d421043@ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	@Test
	public void RunTest() {
		driver.findElement(By.name("q")).sendKeys("Facebook",Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='Facebook - Log In or Sign Up']")).click();
		System.out.println(driver.getTitle());
	}
	@AfterClass
	public void configAc() {
		driver.quit();
	}

}
