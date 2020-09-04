package com.vTiger.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.utility.WebdriverUtils;
/**
 * 
 * @author Nithesh Gowda
 *
 */
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppertunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement AdministratorIMG;
	
	@FindBy(linkText="Sign Out")
	private WebElement sigoutLink;
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOppertunitiesLink() {
		return oppertunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdministratorIMG() {
		return AdministratorIMG;
	}

	public WebElement getSigoutLink() {
		return sigoutLink;
	}
/**
 * Log out from application
 */	
	public void logout() {
		WebdriverUtils wLib=new WebdriverUtils();
		wLib.moveToElement(driver, AdministratorIMG);
		sigoutLink.click();
	}
	/**
	 * click on organization Link
	 */
	public void clickOnOrganizationLink() {
		organizationLink.click();
	}
	/**
	 * click on contact Link
	 */
	public void clickOnContactLink() {
		contactsLink.click();
	}
	/**
	 * click on oppertunity Link
	 */
	public void clickOnOppertunitiesLink() {
		oppertunitiesLink.click();
	}
	/**
	 * click on product link
	 */
	public void clickOnProductsLink() {
		productsLink.click();
	}
	

}
