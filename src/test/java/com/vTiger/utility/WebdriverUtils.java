package com.vTiger.utility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import cucumber.api.Scenario;

/**
 * 
 * @author Nithesh Gowda
 *
 */
public class WebdriverUtils {
	/**
	 * used to move mouse cursor to element
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * switch to frame by specifying index
	 * @param driver
	 * @param index
	 */
	public void switchToframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * switch to frame by specifying name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * switch to frame by specifying web element in DOM
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * Accept alert
	 * @param driver
	 */
	public void alertOk(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * Dismiss alert
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * switch to window by specifying page title
	 * @param driver
	 * @param pageTitle
	 */
	public void switchToWindow(WebDriver driver,String pageTitle) {
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext()) {
			String tab = itr.next();
			String title = driver.switchTo().window(tab).getTitle();
			if(title.contains(pageTitle)) {
				break;
			}
			
		}
	}
	/**
	 * custom wait for element to click
	 * @param driver
	 * @param element
	 * @return
	 */
	public boolean waitAndClick(WebDriver driver,WebElement element) {
		boolean flag=false;
		int click=0;
		while(click<30) {
			try
			{
				element.click();
				flag=true;
				break;
			}
			catch (Exception e) {
				click++;
			}
		}
		return flag;
	}
	/**
	 * wait for element in DOM page
	 * @param driver
	 */
	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * select dropdown by index
	 * @param driver
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebDriver driver,WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * select dropdown by value
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebDriver driver,WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * select dropdown by text
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void selectDropDowm(WebDriver driver,WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public String getScreenshot(WebDriver driver,Scenario scenario) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir")+"/Screenshot/"+scenario.getName()+".PNG";
		File dest=new File(filePath);
		Files.copy(src, dest);
		return filePath;
		
	}

}
