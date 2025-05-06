package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Organizations']/ancestor::td[@class='tabUnSelected']")
	private WebElement orgLink;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(id="bas_searchfield")
	private WebElement inDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement acountLink;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	
	public WebElement getAcountLink() {
		return acountLink;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getInDD() {
		return inDD;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void clickOnCampaignLink(WebDriver driver)
	{
		Actions a =new Actions(driver);
		a.moveToElement(moreLink).perform();
		campaignLink.click();
		
	}
	
	

}
