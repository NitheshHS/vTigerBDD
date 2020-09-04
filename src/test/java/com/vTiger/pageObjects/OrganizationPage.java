package com.vTiger.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vTiger.utility.WebdriverUtils;

public class OrganizationPage {
	WebDriver driver;

	public  OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationIMG;

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTF;

	@FindBy(id="bas_searchfield")
	private WebElement salutationDD;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBT;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteBT;
	
	@FindBy(xpath="//img[contains(@src,'next.gif')]")
	private WebElement nextBT;
	
	@FindBy(name="selectall")
	private WebElement checkBoxBT;
	
	@FindBy(xpath="//img[contains(@src,'status.gif')]")
	private WebElement status;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement orgName;
	
	public WebElement getCreateOrganizationIMG() {
		return createOrganizationIMG;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSalutationDD() {
		return salutationDD;
	}

	public WebElement getSubmitBT() {
		return submitBT;
	}

	public WebElement getDeleteBT() {
		return deleteBT;
	}
/**
 * Select a organization name 
 * @param orgName
 */
	public void selectOrganization(String orgName) {
		int click=0;
		while(click<5) {
			try {
				driver.findElement(By
						.xpath("//table[@class='lvt small']/tbody/tr[*]/following-sibling::tr[*]/td/a[text()='"+orgName+"']/ancestor::td//input[@name='selected_id']")).click();
			} catch (Exception e) {
				click++;
				nextBT.click();
			}
		}
		
	}
	/**
	 * delete the oraganization atleast single organization must be selected
	 */
	public void deleteOrganization() {
		
		deleteBT.click();
		driver.switchTo().alert().accept();
	}
	/**
	 * click on organization img
	 */
	public void createOrganization() {
		createOrganizationIMG.click();
	}
	/**
	 * search a organization
	 * @param orgName
	 */
	public void searchOrganization(String orgName) {
		searchTF.sendKeys(orgName);
		WebdriverUtils wlib=new WebdriverUtils();
		wlib.selectDropDowm(driver, salutationDD, "Organization Name");
		submitBT.click();
		
	}
	
	public String checkSearchResult(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(orgName));
		return orgName.getText();
		
	}


}
