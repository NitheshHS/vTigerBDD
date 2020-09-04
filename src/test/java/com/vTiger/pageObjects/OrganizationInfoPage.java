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
public class OrganizationInfoPage {
WebDriver driver;
	WebdriverUtils wLib=new WebdriverUtils();
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameTF;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTF;
	
	@FindBy(xpath="//input[@id='tickersymbol']")
	private WebElement tickerSymbolTF;
	
	@FindBy(id="employees")
	private WebElement employeesTF;
	
	@FindBy(id="email2")
	private WebElement otherMailTF;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(id="phone")
	private WebElement phoneTF;
	
	@FindBy(id="fax")
	private WebElement faxTF;
	
	@FindBy(id="otherphone")
	private WebElement otherPhoneTF;
	
	@FindBy(id="email1")
	private WebElement emailTF;
	
	@FindBy(id="ownership")
	private WebElement ownershipTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBT;

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getWebsiteTF() {
		return websiteTF;
	}

	public WebElement getTickerSymbolTF() {
		return tickerSymbolTF;
	}

	public WebElement getEmployeesTF() {
		return employeesTF;
	}

	public WebElement getOtherMailTF() {
		return otherMailTF;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getPhoneTF() {
		return phoneTF;
	}

	public WebElement getFaxTF() {
		return faxTF;
	}

	public WebElement getOtherPhoneTF() {
		return otherPhoneTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getOwnershipTF() {
		return ownershipTF;
	}

	public WebElement getSaveBT() {
		return saveBT;
	}
	/**
	 * create organization by providing mandatory fields
	 * @param orgName
	 */
	public void createOrganization(String orgName) {
		orgNameTF.sendKeys(orgName);
		saveBT.click();
	}
	/**
	 * create organization
	 * @param orgName
	 * @param website
	 * @param tickerSymbol
	 * @param noEmployees
	 * @param otherMail
	 * @param industryType
	 * @param type
	 * @param phone
	 * @param fax
	 * @param otherPhone
	 * @param email
	 * @param ownership
	 */
	public void createOrganization(String orgName,String website,String noEmployees
			,String otherMail,String industryType,String type,String phone,
			String otherPhone,String email,String ownership) {
		orgNameTF.sendKeys(orgName);
		websiteTF.sendKeys(website);
		//tickerSymbolTF.sendKeys(tickerSymbol);
		employeesTF.sendKeys(noEmployees);
		otherMailTF.sendKeys(otherMail);
		wLib.selectDropDowm(driver, industryDD, industryType);
		wLib.selectDropDowm(driver, typeDD, type);
		phoneTF.sendKeys(phone);
		//faxTF.sendKeys(fax);
		otherPhoneTF.sendKeys(otherPhone);
		emailTF.sendKeys(email);
		ownershipTF.sendKeys(ownership);
		saveBT.click();
		
	}
}
