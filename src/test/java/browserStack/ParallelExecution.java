package browserStack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExecution {
	


	
	  public static final String USERNAME = "nitheshhs2";
	  public static final String AUTOMATE_KEY = "9ksdZcoktyvM3b2SXZsP";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  @Test(dataProvider="EnvironmentDetails")
	  public static void parallelTest(Platform platform,String browserName,String browserVersion) throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setPlatform(platform);
	    caps.setBrowserName(browserName);
	    caps.setVersion(browserVersion);
	    caps.setCapability("browserstack.debug", "true");
	    
	    caps.setCapability("name", "nitheshhs2's First Test");
	    
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	  }
	  @DataProvider(name="EnvironmentDetails", parallel=true)
	  public Object[][] getData(){
	  Object[][] testData = new Object[][]{
	  {Platform.MAC, "chrome", "81"},
	  {Platform.WIN8, "chrome", "80"},
	  {Platform.WINDOWS, "firefox", "74"},
	  {Platform.MAC,"safari","13"},
	  {Platform.MAC,"chrome","79"}
	  };
	  return testData;
	}
}

