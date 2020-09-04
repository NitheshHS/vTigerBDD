package sausceLabs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class NormalExecution {
	@Test
	public void exceuteTest() throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setPlatform(Platform.WIN8);
		cap.setBrowserName("chrome");
		cap.setVersion("85");
		cap.setCapability("name", "My first test");
		
		WebDriver driver=new RemoteWebDriver(new URL("https://NitheshHS:5133f7c1-5674-4aab-9f74-a4a20d421043@ondemand.us-west-1.saucelabs.com:443/wd/hub"), 
				cap);
		driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("Facebook");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	}

}
