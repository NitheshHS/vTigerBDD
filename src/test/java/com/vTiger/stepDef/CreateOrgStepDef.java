package com.vTiger.stepDef;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.vTiger.pageObjects.HomePage;
import com.vTiger.pageObjects.LoginPage;
import com.vTiger.pageObjects.OrganizationInfoPage;
import com.vTiger.pageObjects.OrganizationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateOrgStepDef {
	WebDriver driver;
	LoginPage loginPage;
	HomePage home;
	OrganizationPage orgPage;
	OrganizationInfoPage orgInfo;
	@Given("^user in HomePage and click on organization$")
	public void user_in_HomePage_and_click_on_organization() throws Throwable {
		driver=Hooks.staticDriver;
		loginPage=new LoginPage(driver);
		loginPage.login();
	    home=new HomePage(driver);
	    home.clickOnOrganizationLink();
	}

	@When("^organization page is opened and click on create organization link$")
	public void organization_page_is_opened_and_click_on_create_organization_link() throws Throwable {
	    orgPage=new OrganizationPage(driver);
	    orgPage.createOrganization();
	}

	@When("^user enter organization name \"([^\"]*)\"$")
	public void user_enter_organization_name(String arg1) throws Throwable {
		Random ran=new Random();
		int val=ran.nextInt(100);
	    orgInfo=new OrganizationInfoPage(driver);
	    orgInfo.createOrganization(arg1+val);
	    
	}

	@Then("^organization information page is open$")
	public void organization_information_page_is_open() throws Throwable {
	  boolean validate=driver.getTitle().contains("Organizations");
	  Assert.assertTrue(validate);
	}

	@Then("^user logout from application$")
	public void user_logout_from_application() throws Throwable {
	    home.logout();
	}
	
	@When("^User search for Orgaization \"([^\"]*)\"$")
	public void user_search_for_Orgaization(String arg1) throws Throwable {
	    orgPage.searchOrganization(arg1);
	}

	@Then("^organization name should be there$")
	public void organization_name_should_be_there() throws Throwable {
	   String orgName = orgPage.checkSearchResult(driver);
	   Assert.assertTrue(orgName.contains("Nithesh"));
	   home.logout();
	}

}
