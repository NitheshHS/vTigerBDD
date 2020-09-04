package sausceLabs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExceution {
	@Test(dataProvider="environment variables")
	public void exceuteTest(Platform platform,String browserName,String BrowserVersion) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setPlatform(platform);
		cap.setBrowserName(browserName);
		cap.setVersion(BrowserVersion);
		cap.setCapability("name", "My first cross platform test");
		
		WebDriver driver=new RemoteWebDriver(new URL("https://NitheshHS:5133f7c1-5674-4aab-9f74-a4a20d421043@ondemand.us-west-1.saucelabs.com:443/wd/hub"), 
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
			{Platform.WIN10,"chrome","85"}
		};
		return testdata;
	}
}
