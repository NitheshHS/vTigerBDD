package com.vTiger.pageObjects;
/**
 * 
 * @author Nithesh Gowda
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.utility.FileLib;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTB;
	
	@FindBy(name="user_password")
	private WebElement passwordTB;
	
	@FindBy(id="submitButton")
	private WebElement loginBT;

	public WebElement getUsernameTB() {
		return usernameTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}
	
	public WebElement getLoginBT() {
		return loginBT;
	}
	
	public void login(String username,String password) {
		usernameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		loginBT.click();
	}
	
	public void login() throws Throwable {
		FileLib fLib=new FileLib();
		usernameTB.sendKeys(fLib.getPropertyKeyValue("username"));
		passwordTB.sendKeys(fLib.getPropertyKeyValue("password"));
		loginBT.click();
	}
	

}
