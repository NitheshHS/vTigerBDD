package com.vTiger.stepDef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.vTiger.pageObjects.HomePage;
import com.vTiger.pageObjects.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VtigerLoginStepDef {
	WebDriver driver;
	LoginPage loginpage;
	HomePage homePage;
	@When("^user enter username and password and click on login button$")
	public void user_enter_username_and_password_and_click_on_login_button() throws Throwable {
		
		driver=Hooks.staticDriver;
		loginpage=new LoginPage(driver);
		loginpage.login();
	}
	@Then("^Home page is displayed$")
	public void home_page_is_displayed() throws Throwable {
		
	System.out.println(driver.getTitle());
	}
	@Then("^logout from application$")
	public void logout_from_application() throws Throwable {
		homePage=new HomePage(driver);
	    homePage.logout();
	    
	}

}
