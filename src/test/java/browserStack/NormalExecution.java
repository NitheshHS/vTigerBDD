package browserStack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class NormalExecution {
	 public static final String USERNAME = "nitheshhs2";
	  public static final String AUTOMATE_KEY = "9ksdZcoktyvM3b2SXZsP";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  @Test
	  public static void parallelTest() throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setPlatform(Platform.MAC);
	    caps.setBrowserName("chrome");
	    caps.setVersion("80");
	    caps.setCapability("browserstack.debug", "true");
	    
	    caps.setCapability("name", "This is single browser execution");
	    
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();
	    System.out.println(driver.getTitle());
	    driver.quit();
	  }
}
